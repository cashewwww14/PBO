import java.util.List;

public class Fox extends Animal {
    public Fox(Field field, Location location) {
        super(field, location);
    }

    @Override
    public void act(List<Animal> newAnimals) {
        if (isAlive()) {
            Location newLocation = field.freeAdjacentLocation(location);
            if (newLocation != null) {
                setLocation(newLocation);
            } else {
                setDead();
            }
        }
    }
}
