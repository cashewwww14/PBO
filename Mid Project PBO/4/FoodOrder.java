import java.util.ArrayList;

public class FoodOrder {
    protected ArrayList<MenuItem> menuItems;

    public FoodOrder() {
        menuItems = new ArrayList<>();
    }

    public void addMenuItem(MenuItem item) {
        menuItems.add(item);
    }

    public void displayOrder() {
        System.out.println("Order Details:");
        int index = 1;
        for (MenuItem item : menuItems) {
            System.out.println(index + ". " + item);
            index++;
        }
    }

    public double calculateTotalPrice(ArrayList<Integer> selectedItems, ArrayList<Integer> quantities) {
        double total = 0;
        for (int i = 0; i < selectedItems.size(); i++) {
            int itemIndex = selectedItems.get(i) - 1;  // Menyesuaikan ke index ArrayList
            int quantity = quantities.get(i);
            if (itemIndex >= 0 && itemIndex < menuItems.size()) {
                total += menuItems.get(itemIndex).getPrice() * quantity;
            }
        }
        return total;
    }
}
