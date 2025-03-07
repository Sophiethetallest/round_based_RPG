import java.util.Random;

public class MageAbility {
    Random rand = new Random();
    int heal, dmg, hit;
    String oom = "Du hast zu wenig Mana, andere Wahl treffen";
    public MageAbility() {

    }

    public void abilityMage(int abilityNr, Hero player, Enemy enemy, int weapon) {
        if (abilityNr == 1) {
            if (player.mana > 0) {
                heal = rand.nextInt(5) + 5 + player.intel / 2;
                System.out.println("Du hast dich um " + heal + " Gesundheit geheilt!");
                player.death = Math.max(0, player.death - heal);
                --player.mana;
                System.out.println("Du hast jetzt noch " + (player.health - player.death) + "Gesundheit!\n" +
                        "Du hast jetzt noch " + player.mana + " Mana");
            } else {
                System.out.print(oom);
            }
        }
        if (abilityNr == 2) {
            if (player.mana > 1) {
                dmg = rand.nextInt(5 + 5 + 5) + 10 + player.intel * 2 + weapon;
                System.out.println("Dein Feuerball hat " + dmg + " Schaden gemacht!");
                enemy.mobLife -= dmg;
                System.out.println("Der Gegner hat noch " + enemy.mobLife + " Gesundheit!");
                player.mana -= 2;
                System.out.println("Du hast jetzt noch " + player.mana + " Mana");

            } else {
                System.out.print(oom);
            }
        }
        if (abilityNr == 3 && player.lvl >= 1) {
            if (player.mana > 1) {
                dmg = rand.nextInt(3 + 3) + player.intel * 2 + weapon;
                System.out.println("Deine eisige Berührung hat " + dmg + " Schaden gemacht!");
                enemy.mobLife -= dmg;
                System.out.println("Der Gegner hat noch " + enemy.mobLife + " Gesundheit und ist für eine Runde eingefroren!\n");
                enemy.mobStun++;
                player.mana -= 3;
                System.out.println("Du hast jetzt noch " + player.mana + " Mana");

            } else {
                System.out.print(oom);
            }
        }
        if (abilityNr == 4) {
            if (player.mana > 1) {
                hit = rand.nextInt(3) + 1;
                dmg = rand.nextInt(3) + 10 + player.intel * 2 + weapon;
                dmg = dmg * hit;
                System.out.println("Deine arkane Geschosse haben " + hit + " getroffen und " + dmg + " Schaden gemacht!");
                enemy.mobLife -= dmg;
                System.out.println("Der Gegner hat noch " + enemy.mobLife + " Gesundheit!");
                player.mana -= 4;
                System.out.println("Du hast jetzt noch " + player.mana + " Mana");

            } else {
                System.out.print(oom);
            }
        }
        if (abilityNr == 5) {
        	 if (player.mana > 1) {
                 System.out.println("Du schaffst ein mächtiges Eisschild, das den nächsten Angriff blockiert");
                 enemy.mobBlock ++;
                 player.mana -= 1;
                 System.out.println("Du hast jetzt noch " + player.mana + " Mana");

             } else {
                 System.out.println(oom);
             }
        }
    }
}
