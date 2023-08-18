package handball.core;

import handball.entities.equipment.ElbowPad;
import handball.entities.equipment.Equipment;
import handball.entities.equipment.Kneepad;
import handball.entities.gameplay.Gameplay;
import handball.entities.gameplay.Indoor;
import handball.entities.gameplay.Outdoor;
import handball.entities.team.Bulgaria;
import handball.entities.team.Germany;
import handball.entities.team.Team;
import handball.repositories.EquipmentRepository;
import handball.repositories.Repository;

import java.util.ArrayList;
import java.util.Collection;

import static handball.common.ConstantMessages.*;
import static handball.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private Repository equipment;
    private Collection<Gameplay> gameplays;

    public ControllerImpl() {
        this.equipment = new EquipmentRepository();
        this.gameplays = new ArrayList<>();
    }

    @Override
    public String addGameplay(String gameplayType, String gameplayName) {
        Gameplay gameplay;
        switch (gameplayType) {
            case "Outdoor":
                gameplay = new Outdoor(gameplayName);
                break;
            case "Indoor":
                gameplay = new Indoor(gameplayName);
                break;
            default:
                throw new NullPointerException(INVALID_GAMEPLAY_TYPE);
        }

        gameplays.add(gameplay);
        return String.format(SUCCESSFULLY_ADDED_GAMEPLAY_TYPE, gameplayType);
    }

    @Override
    public String addEquipment(String equipmentType) {
        Equipment eqip;
        switch (equipmentType) {
            case "Kneepad":
                eqip = new Kneepad();
                break;
            case "ElbowPad":
                eqip = new ElbowPad();
                break;
            default:
                throw new IllegalArgumentException(INVALID_EQUIPMENT_TYPE);
        }

        equipment.add(eqip);
        return String.format(SUCCESSFULLY_ADDED_EQUIPMENT_TYPE, equipmentType);
    }

    @Override
    public String equipmentRequirement(String gameplayName, String equipmentType) {
        Equipment e = equipment.findByType(equipmentType);

        if (e == null) {
            throw new IllegalArgumentException(String.format(NO_EQUIPMENT_FOUND, equipmentType));
        }

        gameplays.stream()
                .filter(g -> g.getName().equals(gameplayName))
                .findFirst().ifPresent(gameplay -> gameplay.addEquipment(e));

        return String.format(SUCCESSFULLY_ADDED_EQUIPMENT_IN_GAMEPLAY, equipmentType, gameplayName);
    }

    @Override
    public String addTeam(String gameplayName, String teamType, String teamName, String country, int advantage) {
        Team team;
        switch (teamType) {
            case "Bulgaria":
                team = new Bulgaria(teamName, country, advantage);
                break;
            case "Germany":
                team = new Germany(teamName, country, advantage);
                break;
            default:
                throw new IllegalArgumentException(INVALID_TEAM_TYPE);
        }

        Gameplay gameplay = getGameplay(gameplayName);

        String gamePlayType = gameplay.getClass().getSimpleName();
        if ((teamType.equals("Bulgaria") && !gamePlayType.equals("Outdoor"))
                || teamType.equals("Germany") && !gamePlayType.equals("Indoor")) {
            return GAMEPLAY_NOT_SUITABLE;
        } else {
            gameplay.addTeam(team);
            return String.format(SUCCESSFULLY_ADDED_TEAM_IN_GAMEPLAY, teamType, gameplayName);
        }
    }

    @Override
    public String playInGameplay(String gameplayName) {
        Gameplay gameplay = getGameplay(gameplayName);

        if (gameplay != null) {
            gameplay.teamsInGameplay();
        }

        return String.format(TEAMS_PLAYED, gameplay.getTeam().size());
    }

    private Gameplay getGameplay(String gameplayName) {
        Gameplay gameplay = gameplays
                .stream()
                .filter(g -> g.getName().equals(gameplayName))
                .findFirst()
                .orElse(null);
        return gameplay;
    }

    @Override
    public String percentAdvantage(String gameplayName) {
        Gameplay gameplay = getGameplay(gameplayName);

        int sum = gameplay.getTeam().stream()
                .mapToInt(Team::getAdvantage)
                .sum();

        return String.format(ADVANTAGE_GAMEPLAY, gameplayName, sum);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();

        gameplays
                .forEach(gameplay -> sb.append(gameplay.toString()));

        return sb.toString().trim();
    }
}
