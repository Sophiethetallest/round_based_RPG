import java.util.Random;

public class MageAbility {
    Random rand = new Random();
    int heal, dmg, hit;
    String oom = "Du hast zu wenig Mana, andere Wahl treffen";
    public MageAbility() {

    }

    public void abilityMage(int abilityNr, Hero player, Enemy enemy, int weapon) {
        if (abilityNr == 1) {
            if ((player.mana - player.manadrain) >= 1) {
                heal = rand.nextInt(5) + 5 + player.intel / 2;
                System.out.println("Du hast dich um " + heal + " Gesundheit geheilt!");
                player.death = Math.max(0, player.death - heal);
                ++player.manadrain;
                System.out.println("Du hast jetzt noch " + (player.health - player.death) + "Gesundheit!\n");
                mana(player);
            } else {
                System.out.print(oom);
            }
        }
        if (abilityNr == 2) {
            if ((player.mana - player.manadrain) >= 2) {
                dmg = rand.nextInt(5 + 5 + 5) + 10 + player.intel * 2 + weapon;
                System.out.println("Dein Feuerball hat " + dmg + " Schaden gemacht!");
                enemy.mobLife -= dmg;
                moblife(enemy);
                player.manadrain += 2;
                mana(player);
            } else {
                System.out.print(oom);
            }
        }
        if (abilityNr == 3 && player.lvl > 1) {
            if ((player.mana - player.manadrain) >= 3) {
                dmg = rand.nextInt(3 + 3) + player.intel * 2 + weapon;
                System.out.println("Deine eisige Berührung hat " + dmg + " Schaden gemacht!");
                enemy.mobLife -= dmg;
                moblife(enemy);
                System.out.println("Der Gegner ist für eine Runde eingefroren!\n");
                enemy.mobStun++;
                player.manadrain += 3;
                mana(player);
            } else {
                System.out.print(oom);
            }
        }
        if (abilityNr == 4 && player.lvl >= 2) {
            if ((player.mana - player.manadrain) >= 4) {
                hit = rand.nextInt(3) + 1;
                dmg = rand.nextInt(3) + 10 + player.intel * 2 + weapon;
                dmg = dmg * hit;
                System.out.println("Deine arkane Geschosse haben " + hit + " getroffen und " + dmg + " Schaden gemacht!");
                enemy.mobLife -= dmg;
                moblife(enemy);
                player.manadrain += 4;
                mana(player);
            } else {
                System.out.print(oom);
            }
        }
        if (abilityNr == 5 && player.lvl > 2) {
        	 if ((player.mana - player.manadrain) >= 4) {
                 System.out.println("Du schaffst ein mächtiges Eisschild, das den nächsten Angriff blockiert");
                 enemy.mobBlock ++;
                 player.manadrain += 4;
                 mana(player);
             } else {
                 System.out.println(oom);
             }
        }
    }

    public void mana(Hero player) {
        System.out.println("Du hast jetzt noch " + (player.mana - player.manadrain) + " Mana!");
    }

    public void moblife(Enemy enemy) {
        if (enemy.mobLife > 0) {
            System.out.println("Der Gegner hat noch " + enemy.mobLife + " Gesundheit!");
        }
    }
}
