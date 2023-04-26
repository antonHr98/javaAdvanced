package workout;

import java.util.ArrayList;
import java.util.List;


public class Workout {
    public List<Exercise> exercises;
    public String type;
    public int exerciseCount;

    public Workout(String type, int exerciseCount) {
        this.exercises = new ArrayList<>();
        this.type = type;
        this.exerciseCount = exerciseCount;
    }

    public List<Exercise> getExercises() {
        return exercises;
    }

    public String getType() {
        return type;
    }

    public int getExerciseCount() {
        return exerciseCount;
    }

    public void addExercise(Exercise exercise) {
        if (this.exercises.size() < this.exerciseCount) {
            this.exercises.add(exercise);
        }
    }

    public boolean removeExercise(String name, String muscle) {
        Exercise exerciseToRemove = getExercise(name, muscle);
        if (exercises.contains(exerciseToRemove)) {
            exercises.remove(exerciseToRemove);
            return true;
        }
        return false;

    }

    public Exercise getExercise(String name, String muscle) {
        Exercise searchedExercise = null;
        for (Exercise exercise : exercises) {
            if (exercise.getName().equals(name) && exercise.getMuscle().equals(muscle)) {
                searchedExercise = exercise;
            }
        }
        return searchedExercise;
    }

    public Exercise getMostBurnedCaloriesExercise() {
        Exercise bestExercise = exercises.get(0);
        for (Exercise exercise : exercises) {
            if (bestExercise.getBurnedCalories() < exercise.getBurnedCalories()) {
                bestExercise = exercise;
            }
        }
        return bestExercise;
    }

    public String getStatistics() {
        StringBuilder output = new StringBuilder("Workout type: " + getType() + "\n");
        for (Exercise exercise : exercises) {
            String secondHalf = "Exercise: " + exercise + "\n";
            output.append(secondHalf);
        }
        return output.toString();
    }

    public String getStatisticsAuthorSolution() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Workout type: %s", this.type));
        builder.append(System.lineSeparator());

        for (Exercise exercise : this.exercises) {
            builder.append(exercise);
            builder.append(System.lineSeparator());
        }

        return builder.toString().trim();
    }
}
