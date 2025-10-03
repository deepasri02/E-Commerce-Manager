import java.util.*;

class Product {
    private int id;
    private String name;
    private double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return id + ". " + name + " - Rs." + price;
    }
}

class Cart {
    private List<Product> items = new ArrayList<Product>();

    public void addProduct(Product p) {
        items.add(p);
        System.out.println(p.getName() + " added to cart.");
    }

    public void viewCart() {
        if (items.isEmpty()) {
            System.out.println("🛒 Your cart is empty.");
        } else {
            System.out.println("\n🛍️ Items in your cart:");
            double total = 0;
            for (int i = 0; i < items.size(); i++) {
                Product p = items.get(i);
                System.out.println((i + 1) + ". " + p.getName() + " - Rs." + p.getPrice());
                total += p.getPrice();
            }
            System.out.println("Total: Rs." + total + "\n");
        }
    }

    public void removeProduct(int index) {
        if (index >= 0 && index < items.size()) {
            Product removed = items.remove(index);
            System.out.println(removed.getName() + " removed from cart.");
        } else {
            System.out.println("Invalid index! Try again.");
        }
    }

    public void checkout() {
        if (items.isEmpty()) {
            System.out.println("Your cart is empty. Add items before checkout!");
        } else {
            viewCart();
            System.out.println("✅ Checkout complete. Thank you for shopping!");
            items.clear();
        }
    }
}

public class ECommerceApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Sample Products
        List<Product> products = new ArrayList<Product>();
        products.add(new Product(1, "Laptop", 50000));
        products.add(new Product(2, "Smartphone", 20000));
        products.add(new Product(3, "Headphones", 1500));
        products.add(new Product(4, "Shoes", 2500));

        Cart cart = new Cart();

        int choice;
        do {
            System.out.println("\n==== E-Commerce Menu ====");
            System.out.println("1. View Products");
            System.out.println("2. Add to Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Remove from Cart");
            System.out.println("5. Checkout");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\nAvailable Products:");
                    for (Product p : products) {
                        System.out.println(p);
                    }
                    break;

                case 2:
                    System.out.print("Enter Product ID to add: ");
                    int id = sc.nextInt();
                    boolean found = false;
                    for (Product p : products) {
                        if (p.getId() == id) {
                            cart.addProduct(p);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Product not found!");
                    }
                    break;

                case 3:
                    cart.viewCart();
                    break;

                case 4:
                    cart.viewCart();
                    System.out.print("Enter item number to remove: ");
                    int removeIndex = sc.nextInt() - 1;
                    cart.removeProduct(removeIndex);
                    break;

                case 5:
                    cart.checkout();
                    break;

                case 6:
                    System.out.println("Exiting... Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 6);

        sc.close();
    }
}
