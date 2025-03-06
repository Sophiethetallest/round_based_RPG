import java.util.*;

public class Inventory {
    Item item;
    List<Item> itemList;
    Hero owner;
    public Inventory(Hero owner) {
        this.itemList = new ArrayList<>();
        this.owner = owner;
    }

    private void Show(Item item) {


        if (item.amount == 1) {
            System.out.println("Du hast noch 1 " + item.name);
        }
        if (item.amount > 1) {
            System.out.println("Du hast noch " + item.amount + " " + item.nameMulti);
        }
    }

    public void addItem (Item item, Hero player)
    {
        if (! item.stackable) {
            itemList.add(item);
        }
        else {
                if (itemList.contains(item.type) == true)
                player.inventory.itemList.get(0).amount++;
                else itemList.add(item);

        }
    }
}
