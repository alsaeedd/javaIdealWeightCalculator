import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter your current weight: ");
        double currentWeight = scanner.nextDouble();
        System.out.print("Please enter your current body fat: ");
        double currentBodyFat = scanner.nextDouble();
        System.out.print("Please enter your target body fat: ");
        double targetBodyFat = scanner.nextDouble();
        System.out.println();

        try {
            Person person = new Person(currentWeight, currentBodyFat);
            double idealWeight = person.calculateIdealWeight(targetBodyFat);
            double weightToLose = person.getWeightToLose(targetBodyFat);

            System.out.printf("Current weight: %.2f kg%n", person.getCurrentWeight());
            System.out.printf("Ideal weight for %.1f%% body fat: %.2f kg%n", 15.0, idealWeight);
            System.out.printf("Weight to lose: %.2f kg%n", weightToLose);
        } catch (IllegalArgumentException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
