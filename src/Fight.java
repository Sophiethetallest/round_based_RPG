import java.util.Random;
import java.util.Scanner;

public class Fight {
    Scanner scan = new Scanner(System.in);
    Random rand = new Random();
    int abilityNr, dmg, weapon, mobDmg;
    String input;
    Abilities ability = new Abilities();
    MageAbility mageAbility = new MageAbility();
    WarriorAbility warriorAbility = new WarriorAbility();

    public Fight(Hero player, Enemy enemy) {
        while (enemy.mobLife > 0 && player.health > player.death) {
            System.out.print("\nAngreifen(1)?\nFähigkeit(2)?\nInventory(3)?\n");
            abilityNr = scan.nextInt();
            int restart = 0; 
            if (abilityNr == 1) {
                dmg = rand.nextInt(11) + 1 + player.str * 2 + weapon;
                System.out.print("Du hast " + dmg + " Schaden gemacht!\n");
                enemy.mobLife -= dmg;
                System.out.print("Der Gegner hat noch " + enemy.mobLife + " Gesundheit!\n");
            } else if (abilityNr == 2){
                ability.abilityName(player);
                if (player.isMage){
                    abilityNr = scan.nextInt();
                    if ((abilityNr -2) > player.lvl) {
                    	System.out.print("Fähigkeit noch nicht freigeschalten\n");
                    	restart ++;
                    } else {
                     mageAbility.abilityMage(abilityNr, player, enemy, weapon);
                    }
                }
                if (player.isWarrior){
                    abilityNr = scan.nextInt();
                    if ((abilityNr -2) > player.lvl) {
                    	System.out.print("Fähigkeit noch nicht freigeschalten\n");
                    	restart ++;
                    } else {
                     warriorAbility.abilityWarrior(abilityNr, player, enemy, weapon);
                    }
                }
            } else if (abilityNr == 3) {
                player.inventory.listItems();
            }
            if (restart < 0) {
	            if (enemy.mobLife > 0 && enemy.mobStun == 0) {
	                mobDmg = (rand.nextInt(3) + 1 + enemy.mobStrength) - player.def;
	                if (enemy.mobBlock > 0){
	                    System.out.print("Du hast keinen Schaden erlitten!\n");
	                } else {
	                    System.out.print("Du hast " + mobDmg + " Schaden erlitten!\n");
	                    player.death += mobDmg;
	                }
	                System.out.print("Du hast noch " + (player.health - player.death) + " Gesundheit!\n");
	            } else {
	                enemy.mobStun -= 1;
	            }
	            if (enemy.mobLife < 0) {
	                enemy.enemyDeath();
	                player.exp += enemy.mobExp;
	            }
	            if (player.exp >= 10) {
	                Hero.lvl(player);
	                System.out.print("Stufe: " + player.lvl + "\n");
	                System.out.print("press Enter!\n\n");
	                input = scan.nextLine();
	                input = scan.nextLine();
	            }
	        restart = 0;    
            }
        }
    }

    int hardhit = 0;
    public void Bossfight(Hero player){
        Enemy enemy = new Enemy("Ogerboss", 150, 8, 300, 0, 0);
        System.out.print("Der Ogerboss erscheint");
        while (enemy.mobLife > 0 && player.health > player.death) {
            System.out.print("\nAngreifen(1)?\nFähigkeit(2)?\nInventar(3)");
            abilityNr = scan.nextInt();
            if (abilityNr == 1) {
                dmg = rand.nextInt(11) + 1 + player.intel * 2 + weapon;
                System.out.print("Du hast " + dmg + " Schaden gemacht!\n");
                enemy.mobLife -= dmg;
                System.out.print("Der Gegner hat noch " + enemy.mobLife + " Gesundheit!\n");
            }
            if (abilityNr == 2){
                ability.abilityName(player);
                if (player.isMage){
                    abilityNr = scan.nextInt();
                    mageAbility.abilityMage(abilityNr, player, enemy, weapon);
                }
                if (player.isWarrior){
                    abilityNr = scan.nextInt();
                    warriorAbility.abilityWarrior(abilityNr, player, enemy, weapon);
                }
            }
            if (abilityNr == 3){

            }

            if (enemy.mobLife > 0 && enemy.mobStun == 0) {
            	if (hardhit == 0) {
            		int bossability = 0;
            		//= rand.nextInt(10)+1;
            		if (bossability < 3) {
            			mobDmg = rand.nextInt(10) + 1 + enemy.mobStrength - player.def;
            			if (enemy.mobBlock > 0)
            				mobDmg = mobDmg/2;
            			System.out.print("Du hast " + mobDmg + " Schaden erlitten!\n");
            			player.death += mobDmg;
            			System.out.print("Du hast noch " + (player.health - player.death) + " Gesundheit!\n");
                        ++bossability;
            		} else {
            			System.out.print("Der Ogerboss schwingt wild seine fette Keule und wird in der nächsten Runde hart zuschlagen");
            			hardhit = 1;
            		}
            	} else {
            		if (enemy.mobBlock >0) {
            			System.out.print("Du hast den harten Schlag blockiert");
            			enemy.mobBlock = 0;
            			hardhit = 0;
            		} else {
            			mobDmg = rand.nextInt(30+30) + 1 + enemy.mobStrength - player.def;
            			System.out.print("Du hast den Angriff nicht blockiert und bekommst den vollen Schaden von" + mobDmg);
            			hardhit = 0;
            		}
            	}
            	
            } else {
                enemy.mobStun -= 1;
            }
        }
        player.lvl ++;
    }
}
