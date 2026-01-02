import java.util.ArrayList;
import java.util.List;

public class User {

    private String name;
    private List<WorkoutPlan> workouts;

    public User(String name) {
        this.name = name;
        this.workouts = new ArrayList<>();
    }

    public void addWorkout(WorkoutPlan workout) {
        workouts.add(workout);
    }

    public List<WorkoutPlan> getWorkouts() {
        return workouts;
    }

    // Polymorphism (can be overridden if needed)
    public String getRole() {
        return "User";
    }

    @Override
    public String toString() {
        return name + " (" + getRole() + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof User)) return false;
        User u = (User) o;
        return name.equals(u.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
