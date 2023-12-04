public class Customer {

    private int productsBought;
    private double productsTotal;

    //For use in checkout
    Customer(int productsBought, double productsTotal) {
        this.productsBought = productsBought;
        this.productsTotal = productsTotal;
    }

    //Making my getters and setters
    public int getProductsBought() {
        return productsBought;
    }

    public void setProductsBought(int productsBought) {
        this.productsBought = productsBought;
    }

    public double getProductsTotal() {
        return productsTotal;
    }

    public void setProductsTotal(double productsTotal) {
        this.productsTotal = productsTotal;
    }

    //Printing the goodbye message in checkout
    void info() {
        System.out.printf("Thank you for shopping with us! Your total is %.2f and you bought %d items."
                , getProductsTotal(), getProductsBought());
    }
}
