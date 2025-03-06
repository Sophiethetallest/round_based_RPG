import java.util.Random;

class Item {
    private static int idCounter = 1;
    private final String id;
    private String name;
    private int amount;
    private int heal;
    private boolean healItem;
    private boolean equipment;
    private boolean stackable;

    public Item(String name, int amount, int heal, boolean healItem, boolean equipment, boolean stackable) {
        this.id = String.format("%03d", idCounter++); // 3-stellige ID mit führenden Nullen
        this.name = name;
        this.amount = amount;
        this.heal = heal;
        this.healItem = healItem;
        this.equipment = equipment;
        this.stackable = stackable;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public int getAmount() { return amount; }
    public void increaseAmount(int value) { this.amount += value; }
    public void decreaseAmount(int value) { this.amount = Math.max(0, this.amount - value); }
    public boolean isStackable() { return stackable; }

    public void HealUsage(Hero player, int heal) {
        Random rand = new Random();
        heal = ((rand.nextInt(heal) + 1) + (rand.nextInt(heal) + 1) + (rand.nextInt(heal) + 1));
        player.death += rand.nextInt(heal)+1;
    }


    /*private void Show() {
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
        return new Item("schwacher Heiltrank", 1, 3,
                0, true, false, false);
    }
    public static Item createNewNormalHealing(){
        return new Item("schwacher Heiltrank", 1, 5,
                1, true, false, false);
    }*/
}
