package Exercises.footballTeamGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Team {
    private String name;
    private List<Player> players;

    public Team(String name) {
        setName(name);
        this.players = new ArrayList<>();
    }

    private void setName(String name) {
        Validators.validateName(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void removePlayer(String playerName) {
        Optional<Player> playerToRemove = players.stream().filter(p -> p.getName().equals(playerName)).findFirst();

        if (!playerToRemove.isPresent()) {
            throw new IllegalArgumentException("Player " + playerName + " is not in " + name + " team.");
        }

        players.remove(playerToRemove.get());
    }

    public double getRating() {
        return Math.round(players.stream().mapToDouble(Player::overallSkillLevel).average().orElse(0));
    }
}
