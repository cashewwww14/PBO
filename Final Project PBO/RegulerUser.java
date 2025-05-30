public class RegularUser extends BaseUser {

    public RegularUser(String username, int age, double height, double weight, String gender) {
        super(username, age, height, weight, gender);
    }

    @Override
    public String getHealthAdvice() {
        double bmi = calculateBMI();
        if (bmi < 18.5) {
            return "Underweight: Increase calorie intake with balanced meals.";
        } else if (bmi < 24.9) {
            return "Normal: Maintain your current diet and exercise regularly.";
        } else if (bmi < 29.9) {
            return "Overweight: Focus on a low-carb, high-protein diet.";
        } else {
            return "Obese: Consult a nutritionist for a personalized diet plan.";
        }
    }

    public String getRecommendedNutrition() {
        double bmi = calculateBMI();
        if (bmi < 18.5) {
            return "Protein: 100g/day, Carbohydrates: 250g/day, Fats: 70g/day.";
        } else if (bmi < 24.9) {
            return "Protein: 80g/day, Carbohydrates: 200g/day, Fats: 60g/day.";
        } else if (bmi < 29.9) {
            return "Protein: 120g/day, Carbohydrates: 150g/day, Fats: 50g/day.";
        } else {
            return "Protein: 150g/day, Carbohydrates: 100g/day, Fats: 40g/day.";
        }
    }
}
