public class Person {
    private final double currentWeight;
    private final double currentBodyFat;
    private final double leanBodyMass;

    public Person(double currentWeight, double currentBodyFat) {
        validateInputs(currentWeight, currentBodyFat);

        this.currentWeight = currentWeight;
        this.currentBodyFat = currentBodyFat / 100.0;
        this.leanBodyMass = calculateLeanBodyMass();
    }

    private void validateInputs(double weight, double bodyFat) {
        if (weight <= 0) {
            throw new IllegalArgumentException("Weight must be positive");
        }
        if (bodyFat < 0 || bodyFat > 100) {
            throw new IllegalArgumentException("Body fat must be between 0 and 100");
        }
    }

    private double calculateLeanBodyMass() {
        return currentWeight * (1 - currentBodyFat);
    }

    public double calculateIdealWeight(double targetBodyFat) {
        validateBodyFat(targetBodyFat);
        return leanBodyMass / (1 - (targetBodyFat / 100.0));
    }

    public double getWeightToLose(double targetBodyFat) {
        return currentWeight - calculateIdealWeight(targetBodyFat);
    }

    private void validateBodyFat(double bodyFat) {
        if (bodyFat < 0 || bodyFat > 100) {
            throw new IllegalArgumentException("Target body fat must be between 0 and 100");
        }
    }

    public double getCurrentWeight() {
        return currentWeight;
    }

    public double getCurrentBodyFat() {
        return currentBodyFat * 100;
    }

    public double getLeanBodyMass() {
        return leanBodyMass;
    }
}