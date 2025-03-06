import java.util.Random;
import java.util.Scanner;

public class Encounter {
    Scanner scan = new Scanner(System.in);
    Random rand = new Random();
    String input;
    Item items;
    public Encounter(){

    }
    public void encounter(int weapon, Hero player) {
        int situation = rand.nextInt(8)+1;
        if (situation == 1) {
            if (player.isMage) {
                System.out.println("Du hast einen besseren Stab gefunden!\nIntelligenz +1");
                ++player.intel;
                System.out.println("press enter!\n");
                input = scan.nextLine();
            }
            if (player.isWarrior) {
                System.out.println("Du hast ein besseres Schwert gefunden!\nStärke +1");
                ++player.str;
                System.out.println("press enter!\n");
                input = scan.nextLine();
            }
        }

        if (situation == 2) {
            if (player.isMage) {
                System.out.println("Du hast eine bessere Robe gefunden!\nIntelligenz +1\nRüstung +1");
                ++player.def;
                ++player.intel;
                System.out.println("press enter!\n");
                input = scan.nextLine();
            }
            if (player.isWarrior) {
                System.out.println("Du hast eine bessere Rüstung gefunden!\nStärke +1\nRüstung +2");
                ++player.str;
                ++player.def;
                System.out.println("press enter!\n");
                input = scan.nextLine();
            }
        }

        if (situation == 3) {
            player.death -= 10;
            if (player.death< 0) {
                player.death = 0;
            }
            System.out.println("Du findest einen heiligen Brunnen und trinkst daraus!\nDu wurdest um 10 geheilt!\n"
                    + "Deine Gesundheit beträgt jetzt: " + (player.health - player.death));
            System.out.println("press enter!\n");
            input = scan.nextLine();
        }

        if (situation == 4) {
            player.death = player.death + rand.nextInt(5) + 1;
            System.out.println("Du bist in eine Falle geraten!\nDu hast Schaden erlitten und jetzt noch "
                    + (player.health - player.death) + "Gesundheit!");
            System.out.println("press enter!\n");
            input = scan.nextLine();
        }

        if (situation == 5) {
            ++weapon;
            System.out.println("Du begegnest dem Goblin Slayer, der gerade in Goblinärsche tritt.\n" +
                    "Der Anblick motiviert dich, darum machst du jetzt jedesmal einen extra Schadenspunkt!");
            System.out.println("press enter!\n");
            input = scan.nextLine();
        }

        if (situation == 6) {
            player.death -= 10;
            if (player.death < 0) {
                player.death = 0;
            }

            System.out.println("Du begegnest 13 Zwerge, die einen genervten Hobbit hinter sich her schleifen.\n" +
                    "Sie laden dazu ein, mit ihnen zu rasten und zu speisen.\nDu wurdest um 10 geheilt!\n" +
                    "Deine Gesundheit beträgt jetzt: "
                    + (player.health - player.death));
            System.out.println("press enter!\n");
            input = scan.nextLine();
        }

        if (situation == 7) {
            player.death = player.death + rand.nextInt(5) + 1;
            System.out.println("Du trittst auf einen fürchterlich spitzen Stein!\nDu hast Schaden erlitten " +
                    "und jetzt noch " + (player.health - player.death) + "Gesundheit!");
            System.out.println("press enter!\n");
            input = scan.nextLine();
        }

        if (situation == 8) {
            items = Item.createNewWeakHealing();
            player.inventory.addItem(items, player);
            System.out.println("Du findest einen schwachen Heiltrank und steckst ihn in deine Tasche!");
            System.out.println("name: " + items.name + "\nAnzahl: " + items.amount);
            System.out.println(player.inventory.itemList.get(0).amount);
            input = scan.nextLine();
            items = Item.createNewNormalHealing();
            player.inventory.addItem(items, player);
            System.out.println(player.inventory.itemList.get(1).amount);
            input = scan.nextLine();
        }

    }
}
