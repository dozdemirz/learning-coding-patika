public class Phone extends Product {
    private int cam;
    private double battery;
    private String color;

    public Phone(int productID, String productName, double price, int stock, Brand brand, int ram, int storage, double screen, int cam, double battery, String color) {
        super(productID, productName, price, stock, brand, ram, storage, screen);
        this.battery = battery;
        this.cam = cam;
        this.color = color;
    }


}
