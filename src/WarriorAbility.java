import java.util.Random;

public class WarriorAbility {
    Random rand = new Random();
    int dmg, hit;
    String oom = "Du hast zu wenig Energie, andere Wahl treffen";
    public WarriorAbility() {

    }

    public void abilityWarrior(int abilityNr, Hero player, Enemy enemy, int weapon) {
        if (abilityNr == 1) {
            if (player.mana > 1) {
                System.out.println("Du blockst den nächsten Angriff");
                enemy.mobBlock ++;
                player.mana -= 1;
                System.out.println("Du hast jetzt noch " + player.mana + " Energie!");

            } else {
                System.out.println(oom);
            }
        }
        if (abilityNr == 2) {
            if (player.mana > 1) {
                dmg = rand.nextInt(5) + 10 + player.str * 2 + weapon;
                System.out.println("Dein harter Schlag hat " + dmg + " Schaden gemacht!");
                enemy.mobLife -= dmg;
                System.out.println("Der Gegner hat noch " + enemy.mobLife + " Gesundheit!");
                player.mana -= 2;
                System.out.println("Du hast jetzt noch " + player.mana + " Energie!");

            } else {
                System.out.print(oom);
            }
        }
        if (abilityNr == 3) {
            if (player.mana > 1) {
                dmg = rand.nextInt(3 + 3) + player.str * 2 + weapon;
                System.out.println("Deine Tritt in die Eier hat " + dmg + " Schaden gemacht und der " + enemy.name + "krümmt sich am Boden vor Schmerz!");
                enemy.mobLife -= dmg;
                System.out.println("Der Gegner hat noch " + enemy.mobLife + " Gesundheit und ist für eine Runde betäubt!");
                enemy.mobStun++;
                player.mana -= 3;
                System.out.println("Du hast jetzt noch " + player.mana + " Energie!");

            } else {
                System.out.print(oom);
            }
        }
        if (abilityNr == 4) {
            if (player.mana > 1) {
                hit = rand.nextInt(3) + 1;
                dmg = rand.nextInt(3) + 10 + player.str * 2 + weapon;
                dmg = dmg * hit;
                System.out.println("Deine schnelle Hiebe haben " + hit + " getroffen und " + dmg + " Schaden gemacht!");
                enemy.mobLife -= dmg;
                System.out.println("Der Gegner hat noch " + enemy.mobLife + " Gesundheit!");
                player.mana -= 4;
                System.out.println("Du hast jetzt noch " + player.mana + " Energie!");

            } else {
                System.out.print(oom);
            }
        }
    }
}
