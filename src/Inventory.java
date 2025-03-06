import java.util.*;

public class Inventory {
    private List<Item> items;

    public Inventory() {
        this.items = new ArrayList<>();
    }

    public void addItem(Item newItem) {
        for (Item item : items) {
            if (item.getId().equals(newItem.getId())) { // Vergleich anhand der ID
                if (item.isStackable()) {
                    item.increaseAmount(newItem.getAmount());
                    System.out.println(newItem.getName() + " Menge erhöht auf " + item.getAmount());
                    return;
                } else {
                    System.out.println(newItem.getName() + " kann nicht hinzugefügt werden, da es nicht stapelbar ist.");
                    return;
                }
            }
        }
        items.add(newItem);
        System.out.println(newItem.getName() + " wurde dem Inventar hinzugefügt.");
    }

    public void removeItem(String itemId, int amount) {
        for (Item item : items) {
            if (item.getId().equals(itemId)) {
                item.decreaseAmount(amount);
                if (item.getAmount() == 0) {
                    items.remove(item);
                    System.out.println("[" + itemId + "] wurde aus dem Inventar entfernt.");
                } else {
                    System.out.println("[" + itemId + "] Menge reduziert auf " + item.getAmount());
                }
                return;
            }
        }
        System.out.println("Item mit ID [" + itemId + "] nicht gefunden.");
    }

    public void listItems() {
        if (items.isEmpty()) {
            System.out.println("Inventar ist leer.");
        } else {
            items.forEach(System.out::println);
        }
    }
}

