package football.core;


import football.entities.field.ArtificialTurf;
import football.entities.field.Field;
import football.entities.field.NaturalGrass;
import football.entities.player.Men;
import football.entities.player.Player;
import football.entities.player.Women;
import football.entities.supplement.Liquid;
import football.entities.supplement.Powdered;
import football.entities.supplement.Supplement;
import football.repositories.SupplementRepository;
import football.repositories.SupplementRepositoryImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import static football.common.ConstantMessages.*;
import static football.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private SupplementRepository supplement;
    private Collection<Field> fields;

    public ControllerImpl() {
        this.supplement = new SupplementRepositoryImpl();
        this.fields = new ArrayList<>();
    }

    @Override
    public String addField(String fieldType, String fieldName) {
        Field field;

        if (fieldType.equals("ArtificialTurf")) {
            field = new ArtificialTurf(fieldName);
        } else if (fieldType.equals("NaturalGrass")) {
            field = new NaturalGrass(fieldName);
        } else {
            throw new NullPointerException(INVALID_FIELD_TYPE);
        }

        fields.add(field);
        return String.format(SUCCESSFULLY_ADDED_FIELD_TYPE, fieldType);
    }

    @Override
    public String deliverySupplement(String type) {
        Supplement s;

        if (type.equals("Liquid")) {
            s = new Liquid();
        } else if (type.equals("Powdered")) {
            s = new Powdered();
        } else {
            throw new IllegalArgumentException(INVALID_SUPPLEMENT_TYPE);
        }

        supplement.add(s);
        return String.format(SUCCESSFULLY_ADDED_SUPPLEMENT_TYPE, type);
    }

    @Override
    public String supplementForField(String fieldName, String supplementType) {
        Supplement s = supplement.findByType(supplementType);

        if (s == null) {
            throw new IllegalArgumentException(String.format(NO_SUPPLEMENT_FOUND, supplementType));
        }

        fields
                .stream()
                .filter(f -> f.getName().equals(fieldName))
                .findFirst().ifPresent(field -> field.addSupplement(s));

        return String.format(SUCCESSFULLY_ADDED_SUPPLEMENT_IN_FIELD, supplementType, fieldName);
    }

    @Override
    public String addPlayer(String fieldName, String playerType, String playerName, String nationality, int strength) {
        Player p;

        if (playerType.equals("Women")) {
            p = new Women(playerName, nationality, strength);
        } else if (playerType.equals("Men")) {
            p = new Men(playerName, nationality, strength);
        } else {
            throw new IllegalArgumentException(INVALID_PLAYER_TYPE);
        }

        Field field = getFieldByName(fieldName);

        String output;
        if (!playerCanPlayOnFieldType(playerType, field)) {
            output = FIELD_NOT_SUITABLE;
        } else {
            field.addPlayer(p);
            output = String.format(SUCCESSFULLY_ADDED_PLAYER_IN_FIELD, playerType, field.getName());
        }

        return output;
    }

    private boolean playerCanPlayOnFieldType(String playerType, Field field) {
        boolean canPlay = false;
        String fieldSurface = field.getClass().getSimpleName();

        if (playerType.equals("Women") && fieldSurface.equals("ArtificialTurf")) {
            canPlay = true;
        } else if (playerType.equals("Men") && fieldSurface.equals("NaturalGrass")) {
            canPlay = true;
        }

        return canPlay;
    }

    @Override
    public String dragPlayer(String fieldName) {
        Field field = getFieldByName(fieldName);

        field.drag();

        return String.format(PLAYER_DRAG, field.getPlayers().size());
    }

    private Field getFieldByName(String fieldName) {
        return fields.stream()
                .filter(f -> f.getName().equals(fieldName))
                .findFirst().orElse(null);
    }

    @Override
    public String calculateStrength(String fieldName) {

        Field field = getFieldByName(fieldName);

        int sum = field.getPlayers()
                .stream().mapToInt(Player::getStrength)
                .sum();

        return String.format(STRENGTH_FIELD, fieldName, sum);
    }

    @Override
    public String getStatistics() {
        return fields
                .stream()
                .map(Field::getInfo)
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
