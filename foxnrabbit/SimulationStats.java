public class SimulationStats {
    private int foxCount;
    private int rabbitCount;

    public void resetCounts() {
        foxCount = 0;
        rabbitCount = 0;
    }

    public void incrementCount(Class<?> animalClass) {
        if (animalClass == Fox.class) {
            foxCount++;
        } else if (animalClass == Rabbit.class) {
            rabbitCount++;
        }
    }

    public void printStatistics(Field field) {
        resetCounts();
        for (int row = 0; row < field.getDepth(); row++) {
            for (int col = 0; col < field.getWidth(); col++) {
                Object animal = field.getObjectAt(row, col);
                if (animal != null) {
                    incrementCount(animal.getClass());
                }
            }
        }
        System.out.println("Foxes: " + foxCount + " Rabbits: " + rabbitCount);
    }
}
