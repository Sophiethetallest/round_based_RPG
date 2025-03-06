import java.util.Random;
import java.util.Scanner;

public class Encounter {
    Scanner scan = new Scanner(System.in);
    Random rand = new Random();
    String input;
    Item smallHeal = new Item("kleiner Heiltrank",1,5,true,false,true);
    Item midHeal = new Item("mittlerer Heiltrank",1,10,true,false,true);
    Item bigHeal = new Item("großer Heiltrank",1,20,true,false,true);

    public Encounter(){

    }
    public void encounter(int weapon, Hero player) {
        //int situation = rand.nextInt(8)+1;
        int situation = 8;
        if (situation == 1) {
            if (player.isMage) {
                System.out.println("Du hast einen besseren Stab gefunden!\nIntelligenz +1");
                ++player.intel;
                next();
            }
            if (player.isWarrior) {
                System.out.println("Du hast ein besseres Schwert gefunden!\nStärke +1");
                ++player.str;
                next();
            }
        }

        if (situation == 2) {
            if (player.isMage) {
                System.out.println("Du hast eine bessere Robe gefunden!\nIntelligenz +1\nRüstung +1");
                ++player.def;
                ++player.intel;
                next();
            }
            if (player.isWarrior) {
                System.out.println("Du hast eine bessere Rüstung gefunden!\nStärke +1\nRüstung +2");
                ++player.str;
                ++player.def;
                next();
            }
        }

        if (situation == 3) {
            player.death -= 10;
            if (player.death< 0) {
                player.death = 0;
            }
            System.out.println("Du findest einen heiligen Brunnen und trinkst daraus!\nDu wurdest um 10 geheilt!\n"
                    + "Deine Gesundheit beträgt jetzt: " + (player.health - player.death));
            next();
        }

        if (situation == 4) {
            player.death = player.death + rand.nextInt(5) + 1;
            System.out.println("Du bist in eine Falle geraten!\nDu hast Schaden erlitten und jetzt noch "
                    + (player.health - player.death) + "Gesundheit!");
            next();
        }

        if (situation == 5) {
            ++weapon;
            System.out.println("Du begegnest dem Goblin Slayer, der gerade in Goblinärsche tritt.\n" +
                    "Der Anblick motiviert dich, darum machst du jetzt jedesmal einen extra Schadenspunkt!");
            next();
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
            next();
        }

        if (situation == 7) {
            player.death = player.death + rand.nextInt(5) + 1;
            System.out.println("Du trittst auf einen fürchterlich spitzen Stein!\nDu hast Schaden erlitten " +
                    "und jetzt noch " + (player.health - player.death) + "Gesundheit!");
            next();
        }

        if (situation == 8) {
            if (player.lvl <=1) {
                player.inventory.addItem(smallHeal);
            } else if (player.lvl == 2) {
                player.inventory.addItem(midHeal);
            } else {
                player.inventory.addItem(bigHeal);
            }
            next();
        }
    }

    public void next() {
        System.out.println("press enter!\n");
        input = scan.nextLine();
    }
}
