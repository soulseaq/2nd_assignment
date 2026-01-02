import java.util.*;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static List<WorkoutPlan> dataPool = new ArrayList<>();

    public static void main(String[] args) {

        User user = new User("Student");

        boolean run = true;

        while (run) {
            System.out.println("\n1. Add workout");
            System.out.println("2. Show workouts");
            System.out.println("3. Search workout");
            System.out.println("4. Filter by type");
            System.out.println("5. Sort by duration");
            System.out.println("0. Exit");
            System.out.print("Choose: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addWorkout(user);
                case 2 -> showWorkouts();
                case 3 -> searchWorkout();
                case 4 -> filterWorkout();
                case 5 -> sortWorkout();
                case 0 -> run = false;
            }
        }
    }

    private static void addWorkout(User user) {
        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Duration: ");
        int duration = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Type: ");
        String type = scanner.nextLine();

        WorkoutPlan w = new WorkoutPlan(name, duration, type);
        dataPool.add(w);
        user.addWorkout(w);
    }

    private static void showWorkouts() {
        for (WorkoutPlan w : dataPool) {
            System.out.println(w);
        }
    }

    private static void searchWorkout() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        for (WorkoutPlan w : dataPool) {
            if (w.getName().equalsIgnoreCase(name)) {
                System.out.println(w);
                return;
            }
        }
        System.out.println("Not found");
    }

    private static void filterWorkout() {
        System.out.print("Type: ");
        String type = scanner.nextLine();

        for (WorkoutPlan w : dataPool) {
            if (w.getType().equalsIgnoreCase(type)) {
                System.out.println(w);
            }
        }
    }

    private static void sortWorkout() {
        dataPool.sort(Comparator.comparingInt(WorkoutPlan::getDuration));
        System.out.println("Sorted by duration.");
    }
}
