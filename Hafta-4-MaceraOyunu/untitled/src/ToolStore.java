
import java.util.Scanner;

public class ToolStore extends NormalLoc {
    public ToolStore(Player player) {
        super(2, player, "Mağaza --> Silah veya zırh satın alabilirsiniz.");
    }
    Scanner input = new Scanner(System.in);

    @Override
    public boolean onLocation() {
        System.out.println("---- Mağazaya Hoşgeldiniz. ----");

        boolean showMenu = true;
        while (showMenu) {
            System.out.println("1 - Silahlar \n2 - Zırhlar \n3 - Çıkış yap");
            int selectCase = input.nextInt();


            switch (selectCase) {
                case 1:
                    printWeapon();
                    buyWeapon();
                case 2:
                    printArmor();
                    buyArmor();
                case 3:
                    System.out.println("Bir daha bekleriz.");
                    showMenu = false;
                    player.selectLoc();
                    break;

            }

        }
        return true;
    }


    public void printWeapon() {
        System.out.println("----- Silahlar -----");
        for (Weapon w : Weapon.weapons()) {
            System.out.println(w.getId() + "    " + w.getName() + "    Para : " + w.getPrice() + "    Hasar : " + w.getDmg());
        }
        System.out.println("0 --> Çıkış Yap");

    }

    public void buyWeapon() {
        System.out.println("Bir silah seçiniz: ");
        int selectWeaponID = input.nextInt();

        while (selectWeaponID < 0 || selectWeaponID > Weapon.weapons().length) {
            System.out.println("Geçersiz değer, lütfen tekrar giriniz : ");
            selectWeaponID = input.nextInt();
        }

        if (selectWeaponID != 0) {
            Weapon selectedWeapon = Weapon.getWeapon(selectWeaponID);
            if (selectedWeapon != null) {
                if (selectedWeapon.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("Yeterli paranız bulunmamaktadır.");
                    System.out.println("--------------------------------------");
                    onLocation();
                } else {
                    System.out.println(selectedWeapon.getName() + " silahını satın aldınız.");
                    int newMoney = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                    this.getPlayer().setMoney(newMoney);
                    System.out.println("Kalan paranız: " + this.getPlayer().getMoney());
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);
                    player.selectLoc();


                }
            }
        } else {
            onLocation();

        }
    }

    public void printArmor() {
        System.out.println("---- Zırhlar ----");
        for (Armor ar : Armor.armors()) {
            System.out.println(ar.getId() + "    " + ar.getName() + "    Para : " + ar.getPrice() + "    Blok : " + ar.getBlock());
        }

    }

    public void buyArmor() {
        System.out.println("Bir zırh seçiniz: ");
        int selectedArmor = input.nextInt();

        while (selectedArmor < 1 || selectedArmor > Weapon.weapons().length) {
            System.out.println("Geçersiz değer, lütfen tekrar giriniz : ");
            selectedArmor = input.nextInt();
        }

        Armor selectArmor = Armor.getArmor(selectedArmor);
        if (selectArmor != null) {
            if (selectArmor.getPrice() > this.getPlayer().getMoney()) {
                System.out.println("Yeterli paranız bulunmamaktadır.");
                System.out.println("--------------------------------------");
                onLocation();
            } else {
                System.out.println(selectArmor.getName() + " satın aldınız.");
                int newMoney = this.getPlayer().getMoney() - selectArmor.getPrice();
                this.getPlayer().setMoney(newMoney);
                System.out.println("Kalan paranız: " + this.getPlayer().getMoney());
                this.getPlayer().getInventory().setArmor(selectArmor);
                player.selectLoc();
            }
        }


    }


}
