import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        int weapon = 0, situation;
        Hero player = createCharacter();
        //player.lvl = 2;

        while (player.health > player.death && player.lvl < 4) {
            if (player.lvl < 3) {
                situation = chooseEncounter();
                if (situation >= 15) {
                    Enemy enemy = generateEnemy(rand);
                    enemy.enemyPresentation();
                    new Fight(player, enemy);
                } else {
                    new Encounter().encounter(weapon, player);
                }
                regenerateMana(player);
            } else {
                new Fight(player, new Enemy("Ogerboss", 150, 8, 300, 0, 0)).Bossfight(player);
            }
        }
        printGameResult(player);
    }

    private static Hero createCharacter() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Gib den Namen deines Charakters ein: ");
        String name = scan.nextLine();
        int job = chooseJob();
        Hero player = (job == 1)
                ? new Hero(name, 30, 1, 10, 1, 30, 0, 0,
                            0, 30,90,false, true)
                : new Hero(name, 60, 10, 1, 2, 10, 0, 0,
                            0, 10,90,true, false);
        player.printCharacter();
        return player;
    }

    public static int chooseJob() {
        Scanner scan = new Scanner(System.in);
        int job = 0;
        while (job < 1 || job > 2) {
            System.out.print("Wähle deine Klasse (Magier = 1, Krieger = 2):" +
                    "\nOder Infos zur Klasse(Magier = 3, Krieger = 4): ");
            job = scan.nextInt();
            if (job == 3) System.out.print("\nDer Magier ist ein Fernkämpfer, ohne viel Gesundheit und Verteidigung\n\n");
            if (job == 4) System.out.print("\nDer Krieger ist ein Nahkämpfer, mit viel Gesundheit und Verteidigung\n\n");
        }
        return job;
    }

    private static int chooseEncounter() {
        return new Random().nextInt(10+10+10) + 1;
    }

    private static Enemy generateEnemy(Random rand) {
        int mob = rand.nextInt(10) + 1;
        if (mob <= 4) return new Enemy("Goblin", 20, 2, 1, 0, 0);
        if (mob >= 7) return new Enemy("Ork", 30, 4, 2, 0, 0);
        return new Enemy("Troll", 40, 6, 3, 0, 0);
    }

    private static void regenerateMana(Hero player) {
        if (player.manadrain > 0) {
            --player.manadrain;
            String resource = player.isMage ? "Mana" : "Energie";
            System.out.print("Du hast 1 " + resource + " erhalten!\nDu hast jetzt noch " + (player.mana - player.manadrain) + " " + resource + "\n");
            System.out.println("Drücke Enter!\n");
            new Scanner(System.in).nextLine();
        }
    }

    private static void printGameResult(Hero player) {
        if (player.health < player.death) {
            System.out.print("Du bist tot!");
        } else {
            System.out.print("Der Ogerboss ist tot!\nDein Genozid abgeschlossen!\nAlle Bergvölker sind tot, obwohl sie niemandem etwas getan haben, du Monster!");
        }
    }
}
