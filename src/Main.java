import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        int  weapon = 0, job = 0, situation = 0, mob = 0;
        Hero player;
        Enemy enemy = null;
        Encounter notFight;
        Fight fight = null;

        System.out.print("Gib den Namen deines Charakters ein");
        String name = scan.nextLine();
        job = chooseJob();

        if (job == 1) {
            player = new Hero(name, 30, 1, 10, 1, 30, 0, 0, false, true);
            player.printCharacter();
        } else {
            player = new Hero(name, 60, 10, 1, 2, 10, 0, 0, true, false);
            player.printCharacter();
        }
        player.lvl = 0;

        while (player.health > player.death && player.lvl < 4) {
            if (player.lvl < 3) {
                situation = chooseEncounter(situation);
                //&& situation <= 0
                if (situation >= 15) {
                    mob = rand.nextInt(5+5)+1;
                    if (mob <= 4) {
                        enemy = new Enemy("Goblin", 20, 2, 1, 0, 0);
                        enemy.enemyPresentation();
                    }
                    if (mob >= 7) {
                        enemy = new Enemy("Ork", 30, 4, 2, 0, 0);
                        enemy.enemyPresentation();
                    }
                    if (mob == 5 || mob == 6) {
                        enemy = new Enemy("Troll", 40, 6, 3, 0, 0);
                        enemy.enemyPresentation();
                    }
                    fight = new Fight(player, enemy);
                } else {
                    notFight = new Encounter();
                    notFight.encounter(weapon, player);
                }
                if (player.mana < 30) {
                    if (player.isMage) {
                        System.out.print("Du hast 1 Mana erhalten!\nDu hast jetzt noch " + player.mana + " Mana\n");
                        ++player.mana;
                    }
                    if (player.isWarrior)
                        if (player.mana < 10) {
                            System.out.print("Du hast 1 Energie erhalten!\nDu hast jetzt noch " + player.mana + " Energie\n");
                            ++player.mana;
                        }
                    System.out.println("press enter!\n");
                    String input = scan.nextLine();
                }
            } else{
             fight.Bossfight(player);
            }
        }
        if (player.health < player.death)
            System.out.print("Du bist tot!");
        else
            System.out.print("Der Ogerboss ist tot!\nDein Genozid abgeschlossen!\nAlle Bergvölker sind tot, obwohl sie niemanden etwas getan haben, du Monster!");
        return;
    }

    public static int chooseJob() {
        int job = 0;
        Scanner scan = new Scanner(System.in);

        while(job == 0 || job > 2) {
            System.out.print("Wähle deine Klasse (Magier = 1, Krieger = 2): \nOder Infos zur Klasse(Magier = 3, Krieger = 4): ");
            job = scan.nextInt();
            if (job == 3) {
                System.out.print("\nDer Magier ist ein Fernkämpfer, ohne viel Gesundheit und Verteidigung\n\n");
            }
            if (job == 4) {
                System.out.print("\nDer Krieger ist ein Nahkämpfer, mit viel Gesundheit und Verteidigung\n\n");
            }
        }
        return job;
    }

    private static int chooseEncounter(int situation) {
        Random rand = new Random();
        situation = rand.nextInt(10+10+10)+1;
        return situation;
    }

}

