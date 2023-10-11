import java.util.Scanner;

public class Player {

    int damage, money, health;
    String name;
    Location currentLocation;
    private Inventory inventory;

    private int originalHealth;

    Scanner input = new Scanner(System.in);

    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory();

    }

    public void selectChar() {
        GameChar[] charList = {new Samuray(), new Okcu(), new Sovalye()};
        System.out.println("------------------------------------------------------");
        for (GameChar gameChar : charList) {
            System.out.println("ID: " + gameChar.getId() + "   İsim: " + gameChar.getName() + "   Hasar: " + gameChar.getDamage() + "   Can: " + gameChar.getHealth() + "   Para: " + gameChar.getMoney());
        }
        System.out.println("------------------------------------------------------");
        int selectChar = input.nextInt();
        switch (selectChar) {
            case 1:
                playerValue(new Samuray());
                break;
            case 2:
                playerValue(new Okcu());
                break;
            case 3:
                playerValue(new Sovalye());
                break;
            default:
                playerValue(new Samuray());

        }
    }

    public void playerValue(GameChar gameChar) {
        this.setDamage(gameChar.getDamage());
        this.setHealth(gameChar.getHealth());
        this.setOriginalHealth(gameChar.getHealth());
        this.setMoney(gameChar.getMoney());
        this.setName(gameChar.getName());
    }

    public void selectLoc() {
        Location[] locList = {new SafeHouse(this), new ToolStore(this), new Cave(this), new Forest(this), new River(this), new Mine(this)};

        boolean select = true;
        while (select) {
            printInfo();
            System.out.println("------ BÖLGELER ------");
            for (Location loc : locList) {
                System.out.println("ID: " + loc.getIdLoc() + "    Konum: " + loc.getName());
            }
            System.out.println("0  -->  Oyundan çıkış yap");

            System.out.println("Lütfen gitmek istediğiniz lokasyonu seçiniz: ");
            int selectLoc = input.nextInt();
            switch (selectLoc) {
                case 0:
                    currentLocation = null;
                    select = false;
                    break;
                case 1:
                    currentLocation = new SafeHouse(this);
                    select = false;
                    break;
                case 2:
                    currentLocation = new ToolStore(this);
                    select = false;
                    break;
                case 3:
                    currentLocation = new Cave(this);
                    break;
                case 4:
                    currentLocation = new Forest(this);
                    break;
                case 5:
                    currentLocation = new River(this);
                    break;
                case 6:
                    currentLocation = new Mine(this);
                    break;

                default:
                    System.out.println("Geçersiz seçim yaptınız.");
                    select = true;
                    break;

            }
            if (currentLocation == null) {
                System.out.println("Oyundan çıktınız.");
                break;
            }
            if (currentLocation.onLocation()) {
            } else {
                System.out.println("Oyunu kaybettiniz.");
                break;
            }
        }

    }

    public void printInfo() {
        System.out.println("------ Oyuncu Değerleri ------");
        System.out.println("Silahınız: " + this.getInventory().getWeapon().getName() + "\nHasarınız: " + this.getTotalDamage() + "\nCanınız: " + this.getHealth() + "\nParanız: " + this.getMoney() + "\nZırhınız: " + this.getInventory().getArmor().getName() + "\nBlokladığınız: " + this.getInventory().getArmor().getBlock());
        System.out.println();
    }

    public int getTotalDamage() {
        return damage + getInventory().getWeapon().getDmg();
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health < 0) {
            health = 0;
        }
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getOriginalHealth() {
        return originalHealth;
    }

    public void setOriginalHealth(int originalHealth) {
        this.originalHealth = originalHealth;
    }
}


