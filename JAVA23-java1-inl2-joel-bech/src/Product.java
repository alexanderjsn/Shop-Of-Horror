
public class Product {

    String name;

    double price;
    int inventory;

    //Using this method for my products in Main
    Product(String name, double price, int inventory) {
        this.name = name;
        this.price = price;
        this.inventory = inventory;
    }

    // Getter-metoder för att hämta värdena
    public  String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getInventory() {
        return inventory;
    }


    public void setInventory(int inventory) {
        this.inventory = inventory;
    }
}
