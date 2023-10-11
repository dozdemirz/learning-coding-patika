import com.sun.security.jgss.GSSUtil;

import java.util.Random;
import java.util.Scanner;

public class BattleLoc extends Location {
    private Monster monster;
    private String award;
    private int monsterNum;
    Scanner input = new Scanner(System.in);

    public BattleLoc(int idLoc, Player player, String name, Monster monster, String award, int monsterNum) {
        super(idLoc, player, name);
        this.monster = monster;
        this.award = award;
        this.monsterNum = monsterNum;
    }

    @Override
    public boolean onLocation() {
        int monNum = this.randomMonsterNum();
        System.out.println("Şu an buradasınız :" + this.getName());
        System.out.println("Dikkatli ol! Burada " + monNum + " tane " + this.getMonster().getName() + " var!");
        System.out.println("Lütfen ne yapacağınızı seçiniz: \n 1. Savaş \n 2. Kaç");
        int select = input.nextInt();

        if (select == 1) {
            System.out.println("Savaş başlayacak.");
            if (combat(monNum)) {
                System.out.println(this.getName() + " tüm düşmanları yendiniz!");
                return true;
            }
        }
        if (this.getPlayer().getHealth() <= 0) {
            System.out.println("Öldünüz!");
            return false;
        }
        return true;
    }

    public boolean combat(int monNum) {
        for (int i = 1; i <= monNum; i++) {
            player.printInfo();
            monsterStats(i);
            this.getMonster().setHealth(this.getMonster().getOriginalhealth());
            while (this.getPlayer().getHealth() > 0 && this.getMonster().getHealth() > 0) {
                System.out.println("Ne yapacağınızı seçiniz: \n 1. Vur \n 2. Kaç");
                int selectCombat = input.nextInt();

                if (selectCombat == 1) {
                    System.out.println("Siz vurdunuz!");
                    this.getMonster().setHealth(this.monster.getHealth() - this.getPlayer().getTotalDamage());
                    afterHit();
                    if (this.getMonster().getHealth() > 0) {
                        System.out.println();
                        System.out.println(this.getMonster().getName() + " size vurdu!");
                        int monsterDmg = this.getMonster().getDmg() - this.player.getInventory().getArmor().getBlock();
                        if (monsterDmg < 0) {
                            monsterDmg = 0;
                        }
                        this.getPlayer().setHealth(this.player.getHealth() - monsterDmg);
                        afterHit();
                    }
                } else {
                    return false;
                }
            }
            if (this.getMonster().getHealth() < this.getPlayer().getHealth()) {
                System.out.println("Düşmanı yendiniz!");
                System.out.println("Ödülünüz: " + this.getMonster().getAward());
                this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getMonster().getAward());
                System.out.println("Güncel paranız: " + this.getPlayer().getMoney());
            } else {
                return false;
            }
        }

        return true;
    }

    public void afterHit() {
        System.out.println("Canınız : " + this.getPlayer().getHealth());
        System.out.println(this.getMonster().getName() + " canı: " + this.getMonster().getHealth());
        System.out.println();
    }

    public void monsterStats(int i) {
        System.out.println(i + ". " + this.getMonster().getName() + " düşmanının değerleri: " + "\n Sağlık: " + this.getMonster().getOriginalhealth() + "\n Hasar: " + this.getMonster().getDmg() + "\n Ödül: " + this.getMonster().getAward());
    }

    public int randomMonsterNum() {
        Random r = new Random();
        return r.nextInt(this.getMonsterNum()) + 1;
    }

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMonsterNum() {
        return monsterNum;
    }

    public void setMonsterNum(int monsterNum) {
        this.monsterNum = monsterNum;
    }

}
