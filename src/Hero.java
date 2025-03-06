public class Hero {
    int health, str, intel, def, mana, lvl, death, exp;
    String name;
    boolean isMage, isWarrior;
    Inventory inventory;

    public Hero(String name, int health, int str, int intel, int def, int mana, int lvl, int death, boolean isWarrior, boolean isMage) {
        this.name = name;
        this.health = health;
        this.str = str;
        this.intel = intel;
        this.def = def;
        this.mana = mana;
        this.lvl = lvl;
        this.death = death;
        this.isWarrior = isWarrior;
        this.isMage = isMage;
        this.inventory = new Inventory();
    }
    public void printCharacter() {
        System.out.println("\nDeine Klasse ist: Magier\nDein Name ist: " + this.name + "\nGesundheit: " + this.health + "\nStärke: "
                + this.str + "\nIntelligenz: " + this.intel + "\nVerteidigung: " + this.def + "\nMana: " + this.mana + "\n\n");
    }
    public static void lvl(Hero player){

        ++player.lvl;
        player.health += 10;
        player.death -= 10;
        if(player.isMage)
            ++player.intel;
        if(player.isWarrior)
            ++player.str;
        System.out.print("Stufe gestiegen!");
        System.out.print("\nGesundheit: " + player.health + "\nStärke: " + player.str + "\nIntelligenz: " + player.intel + "\nDu wurdest um 10 Gesundheit geheilt\n");
        player.exp -= 10;
    }
}
