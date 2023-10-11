public class SafeHouse extends NormalLoc {

    public SafeHouse(Player player) {
        super(1, player, "Güvenli Ev --> Düşman bulunmayan güvenli bir ev.");
    }

    @Override
    public boolean onLocation() {
        System.out.println("Güvenli evdesiniz. Canınız yenilendi.");
        this.getPlayer().setHealth(this.getPlayer().getOriginalHealth());
        return true;
    }


}
