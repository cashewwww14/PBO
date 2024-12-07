import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Field {
    private Object[][] field;

    public Field(int depth, int width) {
        field = new Object[depth][width];
    }

    public int getDepth() {
        return field.length;
    }

    public int getWidth() {
        return field[0].length;
    }

    public void clear() {
        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field[row].length; col++) {
                field[row][col] = null;
            }
        }
    }

    public void place(Object animal, Location location) {
        field[location.getRow()][location.getCol()] = animal;
    }

    public Object getObjectAt(Location location) {
        return getObjectAt(location.getRow(), location.getCol());
    }

    public Object getObjectAt(int row, int col) {
        return field[row][col];
    }

    public void clear(Location location) {
        field[location.getRow()][location.getCol()] = null;
    }

    public Location freeAdjacentLocation(Location location) {
        List<Location> adjacent = adjacentLocations(location);
        for (Location loc : adjacent) {
            if (getObjectAt(loc) == null) {
                return loc;
            }
        }
        return null;
    }

    private List<Location> adjacentLocations(Location location) {
        List<Location> locations = new ArrayList<>();
        int row = location.getRow();
        int col = location.getCol();

        for (int r = row - 1; r <= row + 1; r++) {
            for (int c = col - 1; c <= col + 1; c++) {
                if (r >= 0 && r < getDepth() && c >= 0 && c < getWidth() && (r != row || c != col)) {
                    locations.add(new Location(r, c));
                }
            }
        }
        Collections.shuffle(locations);
        return locations;
    }
}
