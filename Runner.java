import com.softserve.example.enums.Animal;
import com.softserve.example.enums.Planet;
import com.softserve.example.innerclass.Robot;
import com.softserve.example.trywithresources.SomeResource;

public class Runner {
    public static void main(String... args) {
        // Try With Resources
        try (SomeResource resource = new SomeResource()) {
            // Do Something here
        } catch (Exception e) {
            e.printStackTrace();
        }


        // Nested and Inner classes sample
        Robot robot = new Robot(7);
        robot.start();
        // Creating instance of inner class
        Robot.Brain brain = robot.new Brain();
        brain.think();
        // Creating instance of static nested class
        Robot.Battery battery = new Robot.Battery();
        battery.charge();

        // Enums
        Animal animal = Animal.CAT;
        switch (animal) {
            case CAT:
                System.out.println("Cat");
                break;
            case DOG:
                System.out.println("Dog");
                break;
            case MOUSE:
                System.out.println("MOUSE");
                break;
            default:
                break;
        }

        System.out.println(Animal.DOG);
        System.out.println("Enum constant as a string: " + Animal.DOG.name());


        System.out.println(Animal.DOG.getClass());
        System.out.println(Animal.DOG instanceof Animal);

        System.out.println(Animal.MOUSE.getName());

        // Dynamically create enum
        Animal animal2 = Animal.valueOf("DOG");
        System.out.println(animal2);

        // Planets
        double earthWeight = 100;

        double mass = earthWeight /Planet.EARTH.surfaceGravity();
        for (Planet p : Planet.values())
            System.out.printf("Your weight on %s is %f%n", p, p.surfaceWeight(mass));

    }
}
