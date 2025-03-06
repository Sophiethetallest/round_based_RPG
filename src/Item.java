import java.util.Random;

class Item {
    private String name;
    private int amount;
    public int heal;
    public boolean healItem;
    private boolean equipment;
    private boolean stackable;

    public Item(String name, int amount, int heal, boolean healItem, boolean equipment, boolean stackable) {
        this.name = name;
        this.amount = amount;
        this.heal = heal;
        this.healItem = healItem;
        this.equipment = equipment;
        this.stackable = stackable;
    }

    public String getName() { return name; }
    public int getAmount() { return amount; }
    public void increaseAmount(int value) { this.amount += value; }
    public void decreaseAmount(int value) { this.amount = Math.max(0, this.amount - value); }
    public boolean isStackable() { return stackable; }

    public void HealUsage(Hero player, int heal) {
        Random rand = new Random();
        heal = ((rand.nextInt(heal) + 1) + (rand.nextInt(heal) + 1) + (rand.nextInt(heal) + 1));
        player.death -= heal;
        System.out.print("Du wurdest um " + heal + " geheilt\n");
        if (player.death < 0) {
            player.death = 0;
        }
    }
}
