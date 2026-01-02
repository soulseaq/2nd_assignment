import java.util.Objects;

public class WorkoutPlan {

    private String name;
    private int duration;
    private String type;

    public WorkoutPlan(String name, int duration, String type) {
        this.name = name;
        this.duration = duration;
        this.type = type;
    }

    // Encapsulation
    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return name + " | " + type + " | " + duration + " minutes";
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof WorkoutPlan)) return false;
        WorkoutPlan w = (WorkoutPlan) o;
        return name.equals(w.name) && duration == w.duration && type.equals(w.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, duration, type);
    }
}
