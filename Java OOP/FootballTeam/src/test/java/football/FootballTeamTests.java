package football;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FootballTeamTests {
    private static final int VACANT_POSITIONS = 12;
    public static final String PLAYER_NAME = "Pesho";
    public static final String TEAM_NAME = "Pesho's team";

    private Footballer footballer;

    private FootballTeam footballTeam;

    @Before
    public void setUp() {
        this.footballer = new Footballer(PLAYER_NAME);

        this.footballTeam = new FootballTeam(TEAM_NAME, VACANT_POSITIONS);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreatingTeamWithNoVacations() {
        new FootballTeam("test_name", -1);
    }

    @Test
    public void testCreatingTeamWithActualVacationsSetCorrectVacationsCount() {
        assertEquals(VACANT_POSITIONS, footballTeam.getVacantPositions());
    }

    @Test(expected = NullPointerException.class)
    public void testCreatingTeamWithNullNameShouldFail() {
        new FootballTeam(null, 1);
    }

    @Test(expected = NullPointerException.class)
    public void testCreatingTeamWithEmptyNameShouldFail() {
        new FootballTeam("     ", 1);
    }

    @Test
    public void testCreatingTeamWithNameShouldCreateTeam() {
        assertEquals(TEAM_NAME, footballTeam.getName());
    }

    @Test
    public void testAddPlayerIncreasesTeamMembersCount() {
        footballTeam.addFootballer(footballer);
        assertEquals(1, footballTeam.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddPlayerThrowsWhenTeamIsFull() {
        FootballTeam team = new FootballTeam(TEAM_NAME, 0);
        team.addFootballer(footballer);
    }

    @Test
    public void testRemovePlayerReducesTeamCount() {
        footballTeam.addFootballer(footballer);
        assertEquals(1, footballTeam.getCount());

        footballTeam.removeFootballer(footballer.getName());
        assertEquals(0, footballTeam.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemovePlayerThrowsWhenPlayerNameIsMissing() {
        footballTeam.removeFootballer("Gosho");
    }

    @Test
    public void testFootballerForSaleShouldDeactivatePlayer() {
        footballTeam.addFootballer(footballer);

        footballTeam.footballerForSale(footballer.getName());

        assertFalse(footballer.isActive());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFootballerForSaleThrowsIfPlayerIsMissing() {
        footballTeam.addFootballer(footballer);
        footballTeam.footballerForSale("not_added");
    }

}
