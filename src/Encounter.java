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
        int situation = rand.nextInt(8) + 1;

        switch (situation) {
            case 1:
                if (player.isMage) {
                    System.out.println("Du hast einen besseren Stab gefunden!\nIntelligenz +1");
                    player.intel++;
                }
                if (player.isWarrior) {
                    System.out.println("Du hast ein besseres Schwert gefunden!\nStärke +1");
                    player.str++;
                }
                break;

            case 2:
                if (player.isMage) {
                    System.out.println("Du hast eine bessere Robe gefunden!\nIntelligenz +1\nRüstung +1");
                    player.intel++;
                    player.def++;
                }
                if (player.isWarrior) {
                    System.out.println("Du hast eine bessere Rüstung gefunden!\nStärke +1\nRüstung +2");
                    player.str++;
                    player.def += 2;
                }
                break;

            case 3:
                player.death = Math.max(0, player.death - 10);
                System.out.println("Du findest einen heiligen Brunnen und trinkst daraus!\n" +
                        "Du wurdest um 10 geheilt!\nDeine Gesundheit beträgt jetzt: " + (player.health - player.death));
                break;

            case 4:
                player.death += rand.nextInt(5) + 1;
                System.out.println("Du bist in eine Falle geraten!\nDu hast Schaden erlitten und jetzt noch " +
                        (player.health - player.death) + " Gesundheit!");
                break;

            case 5:
                weapon++;
                System.out.println("Du begegnest dem Goblin Slayer, der gerade in Goblinärsche tritt.\n" +
                        "Der Anblick motiviert dich, darum machst du jetzt jedes Mal einen extra Schadenspunkt!");
                break;

            case 6:
                player.death = Math.max(0, player.death - 10);
                System.out.println("Du begegnest 13 Zwergen, die einen genervten Hobbit hinter sich her schleifen.\n" +
                        "Sie laden dich ein, mit ihnen zu rasten und zu speisen.\n" +
                        "Du wurdest um 10 geheilt!\nDeine Gesundheit beträgt jetzt: " + (player.health - player.death));
                break;

            case 7:
                player.death += rand.nextInt(5) + 1;
                System.out.println("Du trittst auf einen fürchterlich spitzen Stein!\n" +
                        "Du hast Schaden erlitten und hast jetzt noch " + (player.health - player.death) + " Gesundheit!");
                break;

            case 8:
                if (player.lvl <= 1) {
                    player.inventory.addItem(smallHeal);
                } else if (player.lvl == 2) {
                    player.inventory.addItem(midHeal);
                } else {
                    player.inventory.addItem(bigHeal);
                }
                break;
        }

        next();
    }

    public void next() {
        System.out.println("press enter!\n");
        input = scan.nextLine();
    }
}
