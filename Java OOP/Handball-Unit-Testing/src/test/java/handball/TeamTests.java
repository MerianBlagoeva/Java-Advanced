package handball;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class TeamTests {
    private Team team;
    private HandballPlayer handballPlayer;

    @Before
    public void setUp() {
        this.team = new Team("Levski", 1);
        this.handballPlayer = new HandballPlayer("Gosho");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCtorThrowsWhenPositionIsNegative() {
        new Team("BG", -1);
    }

    @Test(expected = NullPointerException.class)
    public void testCtorThrowsWhenNameIsNull() {
        new Team(null, 2);
    }

    @Test(expected = NullPointerException.class)
    public void testCtorThrowsWhenNameIsEmpty() {
        new Team("   ", 2);
    }

    @Test
    public void testCtorCreatesTeam() {
        Team bg = new Team("BG", 2);

        assertEquals("BG", bg.getName());
        assertEquals(2, bg.getPosition());
        assertEquals(0, bg.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddThrowsWhenTeamIsFull() {
        team.add(handballPlayer);

        team.add(new HandballPlayer("Nasko"));
    }

    @Test
    public void testAddUpdatesTeamCount() {
        team.add(handballPlayer);

        assertEquals(1, team.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveThrowsWhenPlayerWithSuchNameDoesNotExist() {
        team.add(handballPlayer);

        team.remove("not_added");
    }

    @Test
    public void testRemoveUpdatesTeamCount() {
        team.add(handballPlayer);
        assertEquals(1, team.getCount());

        team.remove("Gosho");
        assertEquals(0, team.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPlayerForAnotherTeamThrowsWhenPlayerDoesNotExist() {
        team.add(handballPlayer);

        team.playerForAnotherTeam("Pesho");
    }

    @Test
    public void testPlayerForAnotherTeamUpdatesIsActive() {
        team.add(handballPlayer);

        HandballPlayer gosho = team.playerForAnotherTeam("Gosho");

        assertFalse(gosho.isActive());
    }

    @Test
    public void testGetStatisticsReturnsTheCorrectMessage() {
        team.add(handballPlayer);

        assertEquals("The player Gosho is in the team Levski.",
                team.getStatistics());
    }
}
