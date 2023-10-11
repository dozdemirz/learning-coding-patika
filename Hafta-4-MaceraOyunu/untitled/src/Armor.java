public class Armor {
    private String name;
    private int id;
    private int block;
    private int price;

    public Armor(String name, int id, int block, int price) {
        this.name = name;
        this.id = id;
        this.block = block;
        this.price = price;
    }

    public static Armor[] armors() {
        Armor[] armorList = new Armor[3];
        armorList[0] = new Armor("Hafif Zırh", 1, 1, 15);
        armorList[1] = new Armor("Orta Zırh", 2, 3, 25);
        armorList[2] = new Armor("Ağır Zırh", 3, 5, 40);
        return armorList;
    }

    public static Armor getArmor(int id){
        for (Armor ar : Armor.armors()) {
            if (ar.getId() == id) {
                return ar;
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

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
