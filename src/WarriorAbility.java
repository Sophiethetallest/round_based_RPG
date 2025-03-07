import java.util.Random;

public class WarriorAbility {
    Random rand = new Random();
    int dmg, hit;
    String oom = "Du hast zu wenig Energie, andere Wahl treffen";
    public WarriorAbility() {

    }

    public void abilityWarrior(int abilityNr, Hero player, Enemy enemy, int weapon) {
        if (abilityNr == 1) {
            if ((player.mana - player.manadrain) > 1) {
                System.out.println("Du blockst den nächsten Angriff");
                enemy.mobBlock ++;
                ++player.manadrain;
                mana(player);
            } else {
                System.out.println(oom);
            }
        }
        if (abilityNr == 2) {
            if ((player.mana - player.manadrain) > 1) {
                dmg = rand.nextInt(5) + 10 + player.str * 2 + weapon;
                System.out.println("Dein harter Schlag hat " + dmg + " Schaden gemacht!");
                enemy.mobLife -= dmg;
                moblife(enemy);
                player.manadrain += 2;
                mana(player);
            } else {
                System.out.print(oom);
            }
        }
        if (abilityNr == 3 && player.lvl > 1) {
            if ((player.mana - player.manadrain) > 1) {
                dmg = rand.nextInt(3 + 3) + player.str * 2 + weapon;
                System.out.println("Deine Tritt in die Eier hat " + dmg + " Schaden gemacht und der " + enemy.name + "krümmt sich am Boden vor Schmerz!");
                enemy.mobLife -= dmg;
                moblife(enemy);
                System.out.println("Der Gegner ist außerdem für eine Runde betäubt!");
                enemy.mobStun++;
                player.manadrain += 3;
                mana(player);
            } else {
                System.out.print(oom);
            }
        }
        if (abilityNr == 4 && player.lvl >= 2) {
            if ((player.mana - player.manadrain) > 1) {
                hit = rand.nextInt(3) + 1;
                dmg = rand.nextInt(3) + 10 + player.str * 2 + weapon;
                dmg = dmg * hit;
                System.out.println("Deine schnelle Hiebe haben " + hit + " getroffen und " + dmg + " Schaden gemacht!");
                enemy.mobLife -= dmg;
                moblife(enemy);
                player.manadrain += 4;
                mana(player);
            } else {
                System.out.print(oom);
            }
        }
    }

    public void mana(Hero player) {
        System.out.println("Du hast jetzt noch " + (player.mana - player.manadrain) + " Energie!");
    }

    public void moblife(Enemy enemy) {
        if (enemy.mobLife > 0) {
            System.out.println("Der Gegner hat noch " + enemy.mobLife + " Gesundheit!");
        }
    }
}
