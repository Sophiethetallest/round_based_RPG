import java.util.Random;

public class Item {
    int amount, heal, type;
    boolean healItem, equipment;
    String name, nameMulti;
    Random rand = new Random();
    boolean stackable;
    public Item(String name, String nameMulti, int amount, int heal, int type, boolean healItem, boolean equipment, boolean stackable) {
        this.name = name;
        this.nameMulti= nameMulti;
        this.amount = amount;
        this.heal = heal;
        this.type = type;
        this.healItem = healItem;
        this.equipment = equipment;
        this.stackable = stackable;
    }

    public void HealUsage(Hero player, int heal) {
        Random rand = new Random();
        heal = ((rand.nextInt(heal) + 1) + (rand.nextInt(heal) + 1) + (rand.nextInt(heal) + 1));
        player.death += rand.nextInt(heal)+1;
    }


    private void Show() {
        int items = 0;
        while (items <= 10) {
            if (type == items) {
                if (amount == 1) {
                    System.out.println("Du hast noch 1 " + name);
                }
                if (amount > 1) {
                    System.out.println("Du hast noch " + amount + " " + nameMulti);
                }
            }
        }
    }

    public static Item createNewWeakHealing(){
        return new Item("schwacher Heiltrank", "schwache Heiltränke", 1, 3,
                0, true, false, false);
    }
    public static Item createNewNormalHealing(){
        return new Item("schwacher Heiltrank", "schwache Heiltränke", 1, 5,
                1, true, false, false);
    }
}
