package Exercises.militaryElite;

import java.util.Collection;
import java.util.Set;

public class CommandoImpl {
    private Set<Mission> missionSet;

    public void addMission(Mission mission) {
        this.missionSet.add(mission);
    }

    public Collection<Mission> getMissions() {
        return missionSet;
    }
}
