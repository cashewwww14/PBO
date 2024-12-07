import java.util.List;

public class Rabbit extends Animal {
    public Rabbit(Field field, Location location) {
        super(field, location);
    }

    @Override
    public void act(List<Animal> newAnimals) {
        if (isAlive()) {
            Location newLocation = field.freeAdjacentLocation(location);
            if (newLocation != null) {
                setLocation(newLocation);
            }
        }
    }
}
