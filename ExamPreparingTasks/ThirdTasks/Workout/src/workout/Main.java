package workout;

public class Main {
    public static void main(String[] args) {

        Workout workout = new Workout("strength", 3);

       Exercise exercise = new Exercise("Bench Press", "chest", 30);

       System.out.println(exercise);

       workout.addExercise(exercise);

       System.out.println(workout.removeExercise("Bench Press", "arms"));
       System.out.println(workout.removeExercise("Bench Press", "chest"));

        System.out.println(workout.getExercise("Bench Press", "chest"));

        Exercise secondExercise = new Exercise("Deadlift", "back", 50);
       Exercise thirdExercise = new Exercise("Barbell Curl", "biceps", 25);
        Exercise fourthExercise = new Exercise("Squats", "legs", 60);
        Exercise fifthExercise = new Exercise("Deadlift", "legs", 55);

        workout.addExercise(secondExercise);
        workout.addExercise(thirdExercise);
        workout.addExercise(fourthExercise);
        workout.addExercise(fifthExercise);


        Exercise mostBurnedCaloriesExercise = workout.getMostBurnedCaloriesExercise();
       System.out.println(mostBurnedCaloriesExercise);

       Exercise exerciseByNameAndMuscle = workout.getExercise("Deadlift", "back");
       System.out.println(exerciseByNameAndMuscle);

        System.out.println(workout.getExerciseCount());
        System.out.println(workout.removeExercise("Barbell Curl", "biceps"));

        System.out.println(workout.getStatistics());

    }

}
