public class Weapon {
    private String name;
    private int id;
    private int dmg;
    private int price;

    public Weapon(String name, int id, int dmg, int price) {
        this.name = name;
        this.id = id;
        this.dmg = dmg;
        this.price = price;
    }

    public static Weapon[] weapons() {
        Weapon[] weaponList = new Weapon[3];
        weaponList[0] = new Weapon("Tabanca", 1, 2, 20);
        weaponList[1] = new Weapon("Kılıç", 2, 3, 35);
        weaponList[2] = new Weapon("Tüfek", 3, 7, 45);
        return weaponList;
    }

    public static Weapon getWeapon(int id){
      for (Weapon w : Weapon.weapons()) {
          if (w.getId() == id) {
              return w;
          }
      }
      return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDmg() {
        return dmg;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
