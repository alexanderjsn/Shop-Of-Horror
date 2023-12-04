public class Productonsale extends Product {
    //Subclass to product for putting a product on sale
    double discount;
    Productonsale(String name, double price, double discount, int inventory){
        super(name, price, inventory);
        //A weird way to figure out the new price of the product
        this.price=(discount/100)*-price+price;
    }
}