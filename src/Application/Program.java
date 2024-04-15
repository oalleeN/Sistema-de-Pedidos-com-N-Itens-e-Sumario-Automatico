package Application;

import Entities.Client;
import Entities.Order;
import Entities.OrderItem;
import Entities.Product;
import Entities_enums.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {

        SimpleDateFormat patternOne = new SimpleDateFormat("dd/MM/yyyy");

        Locale.setDefault(Locale.US);
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter client data:");
        System.out.print("Name: ");
        String clientName = scan.nextLine();
        System.out.print("Email: ");
        String clientEmail = scan.next();
        System.out.print("Birth Date (DD/MM/YYYY): ");
        Date birthDate = patternOne.parse(scan.next());

        Client client = new Client(clientName, clientEmail, birthDate);

        System.out.println("Enter order data: ");
        System.out.print("Status: ");
        String status = scan.next();

        Order order = new Order(new Date(), OrderStatus.valueOf(status), client);

        System.out.print("How many items to this order? ");
        int numOrders = scan.nextInt();
        scan.nextLine();
        for (int i=1 ; i<=numOrders ; i++) {
            System.out.println("Enter #" + i + " item data: ");
            System.out.print("Product name: ");
            String productName = scan.next();
            System.out.print("Product price: ");
            double productPrice = scan.nextDouble();

            Product product = new Product(productName, productPrice);

            System.out.print("Quantity: ");
            int quantityItem = scan.nextInt();

            OrderItem orderItem = new OrderItem(quantityItem, productPrice, product);
            order.addItem(orderItem);
        }
        System.out.println();
        System.out.println("ORDER SUMMARY:");
        System.out.println(order);
        scan.close();
    }
}
