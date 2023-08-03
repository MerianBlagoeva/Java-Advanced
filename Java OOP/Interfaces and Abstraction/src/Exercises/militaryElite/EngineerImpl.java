package Exercises.militaryElite;

import java.util.Collection;
import java.util.Set;

public class EngineerImpl {
    private Set<Repair> repairSet;

    public void addRepair(Repair repair) {
        repairSet.add(repair);
    }

    public Collection<Repair> getRepairs() {
        return repairSet;
    }

}
