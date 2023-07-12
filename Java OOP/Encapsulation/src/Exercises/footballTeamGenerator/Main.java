package Exercises.footballTeamGenerator;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Map<String, Team> teamsByName = new HashMap<>();

        Scanner sc = new Scanner(System.in);

        String command = sc.nextLine();

        while (!command.equals("END")) {
            String[] commandParts = command.split(";");
            String commandType = commandParts[0];

            switch (commandType) {
                case "Team":
                    handleAddTeam(commandParts[1], teamsByName);
                    break;
                case "Add":
                    handleAddPlayer(commandParts[1], commandParts[2], commandParts[3],
                            commandParts[4], commandParts[5], commandParts[6], commandParts[7], teamsByName);
                    break;
                case "Remove":
                    handleRemovePlayer(commandParts[1], commandParts[2], teamsByName);
                    break;
                case "Rating":
                    handleRating(commandParts[1], teamsByName);
                    break;
                default:
                    throw new IllegalStateException("Unknown command " + commandType);
            }

            command = sc.nextLine();
        }
    }

    private static void handleRating(String teamName, Map<String, Team> teamsByName) {
        Team team = getTeamOrPrintNotFound(teamName, teamsByName);
        if (team == null) return;

        System.out.println(team.getName() + " - " + (int) team.getRating());
    }

    private static void handleRemovePlayer(String teamName, String playerName, Map<String, Team> teamsByName) {
        Team team = getTeamOrPrintNotFound(teamName, teamsByName);
        if (team == null) return;

        try {
            team.removePlayer(playerName);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void handleAddPlayer(String teamName, String playerName, String enduranceStr, String sprintStr, String dribbleStr,
                                        String passingStr, String shootingStr, Map<String, Team> teamsByName) {
        Team team = getTeamOrPrintNotFound(teamName, teamsByName);
        if (team == null) return;

        Player player;
        try {
            player = new Player(playerName,
                    Integer.parseInt(enduranceStr),
                    Integer.parseInt(sprintStr),
                    Integer.parseInt(dribbleStr),
                    Integer.parseInt(passingStr),
                    Integer.parseInt(shootingStr));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        team.addPlayer(player);
    }

    private static void handleAddTeam(String teamName, Map<String, Team> teamsByName) {
        try {
            Team team = new Team(teamName);
            teamsByName.put(team.getName(), team);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static Team getTeamOrPrintNotFound(String teamName, Map<String, Team> teamsByName) {
        Team team = teamsByName.get(teamName);

        if (team == null) {
            System.out.println("Team " + teamName + " does not exist.");
            return null;
        }
        return team;
    }
}
