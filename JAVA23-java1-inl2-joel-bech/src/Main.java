import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Initiating customer as zero as base value for checkout
        Customer customer = new Customer(0, 0);

        //Using my method to name my products and give them values for the shop
        Product mask = new Product("Mask", 149.50, 5);
        Product knife = new Product("Bloody knife", 199.50, 4);
        Productonsale blood = new Productonsale("Fake Blood 1 litre", 319.50, 20, 3);

        //Initiating scanner
        Scanner input = new Scanner(System.in);
        //Hello Message for customer before initiating shop
        System.out.println("Welcome to the horror shop, what would you like today?");
        //Loop for the store
        while (true) {
            System.out.printf("1. %s, %.2fkr, we got %d in stock.\n", mask.name, mask.price, mask.inventory);
            System.out.printf("2. %s, %.2fkr, we got %d in stock.\n", knife.name, knife.price, knife.inventory);
            System.out.printf("3. %s, %.2fkr, we got %d in stock.\n", blood.name, blood.price, blood.inventory);
            System.out.println("4. Quit");
            //Scanner used for picking up customer action in store
            int customerChoice = input.nextInt();

            //If statements to look for the users input
            if (customerChoice == 1) {
                //Adding price to the total cost to customer
                customer.setProductsTotal(customer.getProductsTotal() + mask.price);

                //Adding number of products to the customer
                customer.setProductsBought(customer.getProductsBought() + 1);

                //Taking 1 item from the inventory of method
                mask.inventory -= 1;

                //Checking if we are out of inventory
                if (mask.inventory < 0) {

                    //Making sure we don´t hit minus on inventory
                    mask.inventory += 1;

                    //Making sure the total and number of items is correct even if customer tries to buy something we are out of
                    customer.setProductsTotal(customer.getProductsTotal() - mask.price);
                    customer.setProductsBought(customer.getProductsBought() - 1);
                    System.out.println("I´m sorry we are out of masks.\n");
                }
            } else if (customerChoice == 2) {
                customer.setProductsTotal(customer.getProductsTotal() + knife.price);
                customer.setProductsBought(customer.getProductsBought() + 1);
                knife.inventory -= 1;
                if (knife.inventory < 0) {
                    knife.inventory += 1;
                    customer.setProductsTotal(customer.getProductsTotal() - knife.price);
                    customer.setProductsBought(customer.getProductsBought() - 1);
                    System.out.println("I´m sorry we are out of bloody knives.\n");
                }
            } else if (customerChoice == 3) {
                customer.setProductsTotal(customer.getProductsTotal() + blood.price);
                customer.setProductsBought(customer.getProductsBought() + 1);
                blood.inventory -= 1;
                if (blood.inventory < 0) {
                    blood.inventory += 1;
                    customer.setProductsTotal(customer.getProductsTotal() - blood.price);
                    customer.setProductsBought(customer.getProductsBought() - 1);
                    System.out.println("I´m sorry we are out of fake blood.\n");
                }
            } else if (customerChoice == 4) {
                //Checkout, giving the total sum and number of items while breaking the loop
                customer.info();
                break;
            } else {
                System.out.println("Invalid input, try again.");
            }
        }
    }
}