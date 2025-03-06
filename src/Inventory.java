import java.util.*;

public class Inventory {
    private List<Item> items;

    public Inventory() {
        this.items = new ArrayList<>();
    }

    public void addItem(Item newItem) {
        for (Item item : items) {
            if (item.getName().equals(newItem.getName())) {
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

    /*public void removeItem(String itemName, int amount) {
        for (Item item : items) {
            if (item.getName().equals(itemName)) {
                item.decreaseAmount(amount);
                if (item.getAmount() == 0) {
                    items.remove(item);
                    System.out.println(itemName + " wurde aus dem Inventar entfernt.");
                } else {
                    System.out.println("Menge von " + itemName + " reduziert auf " + item.getAmount());
                }
                return;
            }
        }
        System.out.println("Item " + itemName + " nicht gefunden.");
    }*/

    public void listItems() {
        if (items.isEmpty()) {
            System.out.println("Inventar ist leer.");
        } else {
            System.out.println("Dein Inventar:");
            int index = 1;
            for (Item item : items) {
                System.out.println(index + ". " + item.getName() + " | Menge: " + item.getAmount());
                index++;
            }
        }
    }
    public void useItemByIndex(int index, Hero player) {
        if (index > 0 && index <= items.size()) {
            Item item = items.get(index - 1);

            if (item.healItem) {
                item.HealUsage(player, item.heal);
                System.out.println(item.getName() + " benutzt!");

                item.decreaseAmount(1);
                if (item.getAmount() == 0) {
                    items.remove(item);
                    System.out.println("Das war dein letzter " + item.getName());
                }
            } else {
                System.out.println("Dieses Item kann nicht verwendet werden.");
            }
        } else {
            System.out.println("Ungültige Auswahl!");
        }
    }
}

