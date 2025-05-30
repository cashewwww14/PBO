public abstract class BaseUser {
    protected String username;
    protected int age;
    protected double height; // in cm
    protected double weight; // in kg
    protected String gender; // "Laki-laki" or "Perempuan"

    public BaseUser(String username, int age, double height, double weight, String gender) {
        this.username = username;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.gender = gender;
    }

    public abstract String getHealthAdvice();

    public String getUsername() {
        return username;
    }

    public double calculateBMI() {
        double heightInMeters = height / 100.0;
        return weight / (heightInMeters * heightInMeters);
    }

    public String getIdealWeightRange() {
        double minWeight = 18.5 * Math.pow(height / 100.0, 2);
        double maxWeight = 24.9 * Math.pow(height / 100.0, 2);
        return String.format("%.1f - %.1f kg", minWeight, maxWeight);
    }

    public double calculateCalorieIntake() {
        if (gender.equals("Laki-laki")) {
            return weight * 30; // Simplified calculation for males
        } else {
            return weight * 25; // Simplified calculation for females
        }
    }
}
