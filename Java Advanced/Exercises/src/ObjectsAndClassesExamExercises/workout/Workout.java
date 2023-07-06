package ObjectsAndClassesExamExercises.workout;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Workout {
    private List<Exercise> exercises;
    private String type;
    private int exerciseCount;

    public Workout(String type, int exerciseCount) {
        this.type = type;
        this.exerciseCount = exerciseCount;
        this.exercises = new ArrayList<>();
    }

    public void addExercise(Exercise exercise) {
        if (exercises.size() < exerciseCount) {
            exercises.add(exercise);
        }
    }

    public boolean removeExercise(String name, String muscle) {
        Exercise toReturn = exercises.stream()
                .filter(exercise -> exercise.getName().equals(name) && exercise.getMuscle().equals(muscle))
                .findFirst().orElse(null);
        exercises.remove(toReturn);
        return toReturn != null;
    }


//    public boolean removeExercise(String name, String muscle) {
//        return exercises.removeIf(exercise -> exercise.getName().equals(name) && exercise.getMuscle().equals(muscle));
//    }


    public Exercise getExercise(String name, String muscle) {
        return exercises.stream().filter(e -> e.getName().equals(name))
                .filter(e -> e.getMuscle().equals(muscle))
                .findFirst().orElse(null);
    }

    public Exercise getMostBurnedCaloriesExercise() {
        return exercises.stream().max(Comparator.comparingInt(Exercise::getBurnedCalories)).orElse(null);
    }

    public int getExerciseCount() {
        return exercises.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder("Workout type: " + type + System.lineSeparator());
        exercises.forEach(e -> sb.append(e).append(System.lineSeparator()));
        return sb.toString().trim();
    }
}
