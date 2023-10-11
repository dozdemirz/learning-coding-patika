public abstract class Monster {
    private int id;
    private int dmg;
    private int health;
    private String name;
    private int award;
    private int originalhealth;

    public Monster(String name, int id, int dmg, int health, int award) {
        this.name = name;
        this.id = id;
        this.dmg = dmg;
        this.originalhealth = health;
        this.award = award;

    }

    public Monster(int id, int dmg, int health) {
        this.id = id;
        this.dmg = dmg;
        this.health = health;
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

    public int getAward() {
        return award;
    }

    public void setAward(int award) {
        this.award = award;
    }

    public int getOriginalhealth() {
        return originalhealth;
    }

    public void setOriginalhealth(int originalhealth) {
        this.originalhealth = originalhealth;
    }
}
