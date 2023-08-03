package Exercises.militaryElite;

public class Mission {
    private String codeName;
    private enum State {
        inProgress,
        finished
    }

    public State completeMission() {
         return State.finished;
    }

}
