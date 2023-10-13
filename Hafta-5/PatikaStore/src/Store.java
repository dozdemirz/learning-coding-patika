import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Store {
    Scanner input = new Scanner(System.in);
    private List<Brand> brandList;
    private List<Product> phoneList;
    private List<Product> notebookList;


    public Store() {
        brandList = new ArrayList<>();
        phoneList = new ArrayList<>();
        notebookList = new ArrayList<>();

        brandList.add(new Brand("Samsung", 1));
        brandList.add(new Brand("Lenovo", 2));
        brandList.add(new Brand("Apple", 3));
        brandList.add(new Brand("Huawei", 4));
        brandList.add(new Brand("Casper", 5));
        brandList.add(new Brand("Asus", 6));
        brandList.add(new Brand("HP", 7));
        brandList.add(new Brand("Xiaomi", 8));
        brandList.add(new Brand("Monster", 9));


        phoneList.add(new Phone(1, "Samsung Galaxy A51", 3199.0, 22, brandList.get(0), 6, 128, 6.5, 32, 4000.0, "Siyah"));
        phoneList.add(new Phone(2, "Apple iPhone 11", 7379.0, 13, brandList.get(2), 6, 64, 6.1, 5, 3046.0, "Mavi"));
        phoneList.add(new Phone(3, "Redmi Note 10 Pro", 4012.0, 38, brandList.get(7), 12, 128, 6.5, 35, 4000.0, "Beyaz"));
        phoneList.add(new Phone(4, "Apple iPhone 15", 30379.0, 19, brandList.get(2), 6, 64, 6.1, 5, 4088.0, "Pembe"));

        notebookList.add(new Notebook(1, "Huawei Matebook 14", 7000.0, 9, brandList.get(3), 16, 512, 14.0));
        notebookList.add(new Notebook(2, "LENOVO V14 IGL", 3699.0, 16, brandList.get(1), 8, 1024, 14.0));
        notebookList.add(new Notebook(3, "ASUS Tuf Gaming", 8199.0, 22, brandList.get(5), 32, 2048, 15.6));
    }

    public void menu() {
        System.out.println("PatikaStore Ürün Yönetim Paneli !");
        System.out.println("1 - Notebook İşlemleri");
        System.out.println("2 - Cep Telefonu İşlemleri");
        System.out.println("3 - Markalar");
        System.out.println("4 - Ürün ekleme");
        System.out.println("5 - Ürün silme");
        System.out.println("6 - Ürünleri markaya göre listeleme");
        System.out.println("0 - Çıkış Yap");
        System.out.print("Seçiminizi yapın: ");
        int choice = input.nextInt();

        switch (choice) {
            case 1:
                printNotebook();
                menu();
                break;
            case 2:
                printPhone();
                menu();
                break;
            case 3:
                printBrand();
                menu();
                break;
            case 4:
                createProduct();
                break;
            case 5:
                deleteProduct();
                break;
            case 6:
                printBrand();
                System.out.println("Listelenecek markayı yazınız: ");
                String brandName = input.next();
                listProductsByBrand(brandName);
                menu();
                break;
            case 0:
                System.out.println("Çıkış yapıldı");
                break;

            default:
                System.out.println("Yanlış bir değer girdiniz.");
                menu();
                break;
        }
    }

    public void printNotebook() {
        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.format("| %-2s | %-30s | %-10s | %-10s | %-10s | %-10s | %-10s |%n", "ID", "Ürün Adı", "Fiyat", "Marka", "Depolama", "Ekran", "RAM");
        System.out.println("----------------------------------------------------------------------------------------------------");


        for (Product product : notebookList) {
            System.out.format("| %-2d | %-30s | %-10.2f TL | %-10s | %-10d | %-10.1f | %-10d |%n",
                    product.getProductID(), product.getProductName(), product.getPrice(), product.getBrand(), product.getStorage(), product.getScreen(), product.getRam());
        }

        System.out.println("----------------------------------------------------------------------------------------------------");


    }

    public void printPhone() {
        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.format("| %-2s | %-30s | %-10s | %-10s | %-10s | %-10s | %-10s |%n", "ID", "Ürün Adı", "Fiyat", "Marka", "Depolama", "Ekran", "RAM");
        System.out.println("----------------------------------------------------------------------------------------------------");


        for (Product product : phoneList) {
            System.out.format("| %-2d | %-30s | %-10.2f TL | %-10s | %-10d | %-10.1f | %-10d |%n",
                    product.getProductID(), product.getProductName(), product.getPrice(), product.getBrand(), product.getStorage(), product.getScreen(), product.getRam());
        }

        System.out.println("----------------------------------------------------------------------------------------------------");


    }

    public void printBrand() {
        Collections.sort(brandList, new OrderBrandComparable());
        for (Brand brand : brandList) {
            System.out.println(brand);
        }
    }

    public void createProduct() {

        System.out.println("Lütfen eklemek istediğiniz ürünü giriniz: \n 1. Phone \n 2. Notebook");
        int choice = input.nextInt();

        switch (choice) {
            case 1:
                addPhone();
                printPhone();
                menu();
                break;
            case 2:
                addNotebook();
                printNotebook();
                menu();
                break;

            default:
                System.out.println("Yanlış bir değer girdiniz.");
                createProduct();

        }

    }

    private void addPhone() {
        System.out.println("Ürün adını giriniz: ");
        String addedName = input.next();

        System.out.println("Ürün fiyatını giriniz: ");
        double addedPrice = input.nextDouble();

        System.out.println("Ürün stoğunu giriniz: ");
        int addedStock = input.nextInt();

        System.out.println("Ürünün markasını giriniz: ");
        String addedBrand = input.next();
        addedBrand = addedBrand.substring(0, 1).toUpperCase() + addedBrand.substring(1).toLowerCase();
        Brand brand = findBrand(addedBrand);
        if (brand == null) {
            brand = new Brand(addedBrand, generateUniqueBrandID());
            brandList.add(brand);
        }

        System.out.println("Ürünün RAM'ini giriniz: ");
        int addedRam = input.nextInt();

        System.out.println("Ürünün depolamasını giriniz: ");
        int addedStorage = input.nextInt();

        System.out.println("Ürünün ekranını giriniz: ");
        double addedScreen = input.nextInt();

        System.out.println("Ürünün kamerasını giriniz: ");
        int addedCam = input.nextInt();

        System.out.println("Ürünün bataryasını giriniz: ");
        double addedBattery = input.nextInt();

        System.out.println("Ürünün rengini giriniz: ");
        String addedColor = input.next();

        phoneList.add(new Phone(maxIDP(), addedName, addedPrice, addedStock, brand, addedRam, addedStorage, addedScreen, addedCam, addedBattery, addedColor));
    }

    private void addNotebook() {
        System.out.println("Ürün adını giriniz: ");
        String addedName = input.next();

        System.out.println("Ürün fiyatını giriniz: ");
        double addedPrice = input.nextDouble();

        System.out.println("Ürün stoğunu giriniz: ");
        int addedStock = input.nextInt();

        System.out.println("Ürünün markasını giriniz: ");
        String addedBrand = input.next();
        addedBrand = addedBrand.substring(0, 1).toUpperCase() + addedBrand.substring(1).toLowerCase();
        Brand brand = findBrand(addedBrand);
        if (brand == null) {
            brand = new Brand(addedBrand, generateUniqueBrandID());
            brandList.add(brand);
        }

        System.out.println("Ürünün RAM'ini giriniz: ");
        int addedRam = input.nextInt();

        System.out.println("Ürünün depolamasını giriniz: ");
        int addedStorage = input.nextInt();

        System.out.println("Ürünün ekranını giriniz: ");
        int addedScreen = input.nextInt();

        notebookList.add(new Notebook(maxIDN(), addedName, addedPrice, addedStock, brand, addedRam, addedStorage, addedScreen));


    }

    public Brand findBrand(String brandName) {
        for (Brand brand : brandList) {
            if (brand.getName().equals(brandName)) {
                return brand;
            }
        }
        return null;
    }

    public int generateUniqueBrandID() {
        int maxID = 0;

        for (Brand brand : brandList) {
            if (brand.getId() > maxID) {
                maxID = brand.getId();
            }
        }
        return maxID + 1;
    }

    public int maxIDP() {
        int maxID = 0;

        for (Product product : phoneList) {
            if (product.getProductID() > maxID) {
                maxID = product.getProductID();
            }
        }
        return maxID + 1;
    }

    public int maxIDN() {
        int maxID = 0;

        for (Product product : notebookList) {
            if (product.getProductID() > maxID) {
                maxID = product.getProductID();
            }
        }
        return maxID + 1;
    }


    public void deleteProduct() {
        System.out.println("Silmek istediğiniz ürünün türünü seçiniz: ");
        System.out.println("1 - Telefon");
        System.out.println("2 - Notebook");
        System.out.println("3 - Menüye geri dön");
        int choice = input.nextInt();

        switch (choice) {
            case 1:
                deletePhone();
            case 2:
                deleteNotebook();
            case 3:
                menu();
                break;
            default:
                System.out.println("Yanlış bir değer girdiniz.");
                deletePhone();
        }


    }

    public void deletePhone() {
        boolean isContains = false;
        printPhone();
        System.out.println("Silmek istediğiniz ürünün id'sini seçiniz :");
        System.out.println("Menüye dönmek için 0 tuşlayınız :");
        int removeID = input.nextInt();
        if (removeID == 0) {
            menu();
        }
        Product productToRemove = null;
        for (Product p : phoneList) {
            if (p.getProductID() == removeID) {
                productToRemove = p;
                isContains = true;

            }
        }
        if (productToRemove != null) {
            phoneList.remove(productToRemove);
            System.out.println("Ürün silindi.");
        }
        if (!isContains) {
            System.out.println("Belirttiğiniz ID'de ürün yoktur.");
            deletePhone();
        }

    }

    public void deleteNotebook() {
        boolean isContains = false;
        printNotebook();
        System.out.println("Silmek istediğiniz ürünün id'sini seçiniz :");
        System.out.println("Menüye dönmek için 0 tuşlayınız :");
        int removeID = input.nextInt();
        if (removeID == 0) {
            menu();
        }
        Product productToRemove = null;
        for (Product p : notebookList) {
            if (p.getProductID() == removeID) {
                productToRemove = p;
                isContains = true;

            }
        }
        if (productToRemove != null) {
            notebookList.remove(productToRemove);
            System.out.println("Ürün silindi.");
        }
        if (!isContains) {
            System.out.println("Belirttiğiniz ID'de ürün yoktur.");
            deleteNotebook();
        }


    }

    public void listProductsByBrand(String brandName) {
        String standardBrandName = brandName.toUpperCase();
        System.out.println("Marka: " + standardBrandName);
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.format("| %-2s | %-30s | %-10s | %-10s | %-10s | %-10s | %-10s |%n", "ID", "Ürün Adı", "Fiyat", "Marka", "Depolama", "Ekran", "RAM");
        System.out.println("--------------------------------------------------------------------------------------------");

        for (Product product : notebookList) {
            if (product.getBrand().getName().toUpperCase().equals(standardBrandName)) {
                System.out.format("| %-2d | %-30s | %-10.2f TL | %-10s | %-10d | %-10.1f | %-10d |%n",
                        product.getProductID(), product.getProductName(), product.getPrice(), product.getBrand().getName(), product.getStorage(), product.getScreen(), product.getRam());
            }
        }

        for (Product product : phoneList) {
            if (product.getBrand().getName().toUpperCase().equals(standardBrandName)) {
                System.out.format("| %-2d | %-30s | %-10.2f TL | %-10s | %-10d | %-10.1f | %-10d |%n",
                        product.getProductID(), product.getProductName(), product.getPrice(), product.getBrand().getName(), product.getStorage(), product.getScreen(), product.getRam());
            }
        }

        System.out.println("--------------------------------------------------------------------------------------------");
    }


}





