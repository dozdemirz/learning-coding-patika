public abstract class NormalLoc extends Location {
    public NormalLoc(int idLoc, Player player, String name) {
        super(idLoc, player, name);
    }

    @Override
    public boolean onLocation() {
        return true;
    }

}
