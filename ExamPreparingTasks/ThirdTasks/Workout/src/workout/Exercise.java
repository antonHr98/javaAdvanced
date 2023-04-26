package workout;

public class Exercise {

    public String name;
    public String muscle;
    public int burnedCalories;

    public Exercise(String name, String muscle, int burnedCalories) {
        this.name = name;
        this.muscle = muscle;
        this.burnedCalories = burnedCalories;
    }

    public String getName() {
        return name;
    }

    public String getMuscle() {
        return muscle;
    }

    public int getBurnedCalories() {
        return burnedCalories;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMuscle(String muscle) {
        this.muscle = muscle;
    }

    public void setBurnedCalories(int burnedCalories) {
        this.burnedCalories = burnedCalories;
    }

    @Override
    public String toString(){
        return String.format("Exercise: %s, %s, %d",this.name,this.muscle,this.burnedCalories);
    }

}
