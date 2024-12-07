import java.util.List;

public abstract class Animal {
    protected boolean alive;
    protected Field field;
    protected Location location;

    public Animal(Field field, Location location) {
        this.field = field;
        this.location = location;
        alive = true;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setDead() {
        alive = false;
        location = null;
    }

    public void setLocation(Location newLocation) {
        if (location != null) {
            field.clear(location);
        }
        location = newLocation;
        field.place(this, newLocation);
    }

    public abstract void act(List<Animal> newAnimals);
}
