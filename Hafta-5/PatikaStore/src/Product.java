public abstract class Product {
    private int productID;
    private String productName;
    private double price;
    private int stock;
    private Brand brand;
    private int ram;
    private int storage;
    private double screen;

    public Product(int productID, String productName, double price, int stock, Brand brand, int ram, int storage, double screen) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.stock = stock;
        this.brand = brand;
        this.ram = ram;
        this.storage = storage;
        this.screen = screen;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }


    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public double getScreen() {
        return screen;
    }

    public void setScreen(double screen) {
        this.screen = screen;
    }

    public Brand getBrand() {
        return brand;
    }
    public void setBrand(Brand brand) {
        this.brand = brand;
    }


}
