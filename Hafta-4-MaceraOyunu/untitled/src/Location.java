public abstract class Location {
    public Player player;
    private String name;
    private int idLoc;

    public Location(int idLoc, Player player, String name) {
        this.idLoc = idLoc;
        this.player = player;
        this.name = name;

    }

    public int getIdLoc() {
        return idLoc;
    }

    public void setIdLoc(int idLoc) {
        this.idLoc = idLoc;
    }

    public abstract boolean onLocation();

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
