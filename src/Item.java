import java.util.Random;

class Item {
    private final String name;
    private int amount;
    public int heal;
    public final boolean healItem;
    public final boolean resourceHeal;
    private final boolean stackable;

    public Item(String name, int amount, int heal, boolean healItem, boolean resourceHeal, boolean stackable) {
        this.name = name;
        this.amount = amount;
        this.heal = heal;
        this.healItem = healItem;
        this.resourceHeal = resourceHeal;
        this.stackable = stackable;
    }

    public String getName() { return name; }
    public int getAmount() { return amount; }
    public void increaseAmount(int value) { this.amount += value; }
    public void decreaseAmount(int value) { this.amount = Math.max(0, this.amount - value); }
    public boolean isStackable() { return stackable; }

    public void HealUsage(Hero player, int heal) {
        Random rand = new Random();
        int endHeal = ((rand.nextInt(heal) + 1) + (rand.nextInt(heal) + 1) + (rand.nextInt(heal) + 1));
        if (this.healItem) {
            player.death = Math.max(0, player.death - endHeal);
            System.out.print("Du wurdest um " + endHeal + " geheilt\n");
        } else {
            player.manadrain = Math.max(0, player.manadrain - endHeal);
            System.out.print("Deine Resource wurde um " + endHeal + " geheilt\n");
        }
    }


}
