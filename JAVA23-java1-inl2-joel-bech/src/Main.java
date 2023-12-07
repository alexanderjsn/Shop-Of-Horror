import com.sun.java.accessibility.util.GUIInitializedListener;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Initiating customer as zero as base value for checkout
        Customer customer = new Customer(0, 0);

        ArrayList<Product> wares = new ArrayList<>();
        //Using my method to name my products and give them values for the shop
        Product mask = new Product("Mask", 149.50, 5);
        Product knife = new Product("Bloody knife", 199.50, 4);
        Productonsale blood = new Productonsale("Fake Blood 1 litre", 319.50, 20, 3);

        wares.add(mask);
        wares.add(knife);
        wares.add(blood);



        //Initiating scanner
        Scanner input = new Scanner(System.in);
        //Hello Message for customer before initiating shop
        System.out.println("Welcome to the horror shop, what would you like today?");
        //Loop for the store
        while (true) {
            // skriver ut listan av varor genom att iterera längden av Arraylistan
            for (int i = 0; i < wares.size(); i++) {
                Product product  = wares.get(i);
                System.out.printf("%s: %.2f SEK - %d wares left\n", product.getName(), product.getPrice(), product.getInventory());
            }


            // La in try/catch ifall annat skrivs in så programmet inte avbryts
            try {
                int customerChoice = input.nextInt() - 1;


                // kollar istället om input matchar ett värde inuti wares arraylistan
                if (customerChoice >= 0 && customerChoice < wares.size()) {
                    // kollar om inventory är högre än 0 på den valda indexen
                    if (wares.get(customerChoice).getInventory() > 0)
                        // skriver ut vald vara
                        System.out.println("You choose " + wares.get(customerChoice).getName());
                    // sätter nytt värde (-1) på vald varas inventory
                    wares.get(customerChoice).setInventory(wares.get(customerChoice).getInventory() - 1);

                }
                //om saldot är 0 på vald vara
                if (wares.get(customerChoice).getInventory() < 0) {
                    // sätter + 1 på varan ( 1 +- 1 = alltid 0 )
                    wares.get(customerChoice).setInventory(wares.get(customerChoice).getInventory() + 1);
                    System.out.println("I´m sorry we are out of: " + wares.get(customerChoice).getName());
                }
                else if (customerChoice == 4) {
                    //Checkout, giving the total sum and number of items while breaking the loop
                    customer.info();
                    break;
                }
            }

            catch (InputMismatchException e) {
                System.out.println("Only numbers allowed!");
                input.next();
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Invalid number!");
                input.next();
            }
        }
    }
}



