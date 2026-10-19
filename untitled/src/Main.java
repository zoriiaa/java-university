import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Category electronics = new Category(1, "Електроніка");
        Category smartphones = new Category(2, "Смартфони");
        Category accessories = new Category(3, "Аксесуари");

        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Ноутбук", 19999.99, "Високопродуктивний ноутбук для роботи та ігор", electronics));
        products.add(new Product(2, "Смартфон", 12999.50, "Смартфон з великим екраном та високою автономністю", smartphones));
        products.add(new Product(3, "Навушники", 2499.00, "Бездротові навушники з шумозаглушенням", accessories));

        Cart cart = new Cart();
        List<Order> orderHistory = new ArrayList<>();

        while (true) {
            System.out.println("\nВиберіть опцію:");
            System.out.println("1 - Переглянути список товарів");
            System.out.println("2 - Додати товар до кошика");
            System.out.println("3 - Переглянути кошик");
            System.out.println("4 - Видалити товар з кошика");
            System.out.println("5 - Зробити замовлення");
            System.out.println("6 - Історія замовлень");
            System.out.println("7 - Пошук товарів");
            System.out.println("0 - Вийти");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    for (Product product : products) {
                        System.out.println(product);
                    }
                    break;
                case 2:
                    System.out.println("Введіть ID товару для додавання до кошика:");
                    int addId = scanner.nextInt();
                    scanner.nextLine();
                    boolean found = false;
                    for (Product product : products) {
                        if (product.getId() == addId) {
                            cart.addProduct(product);
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("Товар з таким ID не знайдено");
                    }
                    break;
                case 3:
                    System.out.println(cart);
                    break;
                case 4:
                    System.out.println("Введіть ID товару для видалення з кошика:");
                    int removeId = scanner.nextInt();
                    scanner.nextLine();
                    if (cart.removeProductById(removeId)) {
                        System.out.println("Товар видалено з кошика");
                    } else {
                        System.out.println("Такого товару немає в кошику");
                    }
                    break;
                case 5:
                    if (cart.getProducts().isEmpty()) {
                        System.out.println("Кошик порожній. Додайте товари перед оформленням замовлення.");
                    } else {
                        Order order = new Order(cart);
                        orderHistory.add(order);
                        System.out.println("Замовлення оформлено:");
                        System.out.println(order);
                        cart.clear();
                    }
                    break;
                case 6:
                    if (orderHistory.isEmpty()) {
                        System.out.println("Історія замовлень порожня");
                    } else {
                        for (int i = 0; i < orderHistory.size(); i++) {
                            System.out.println("\nЗамовлення №" + (i + 1));
                            System.out.println(orderHistory.get(i));
                        }
                    }
                    break;
                case 7:
                    System.out.println("Введіть назву товару або категорії:");
                    String query = scanner.nextLine().toLowerCase();
                    boolean anyFound = false;
                    for (Product product : products) {
                        String name = product.getName().toLowerCase();
                        String categoryName = product.getCategory().getName().toLowerCase();
                        if (name.contains(query) || categoryName.contains(query)) {
                            System.out.println(product);
                            anyFound = true;
                        }
                    }
                    if (!anyFound) {
                        System.out.println("Нічого не знайдено");
                    }
                    break;
                case 0:
                    System.out.println("Дякуємо, що використовували наш магазин!");
                    return;
                default:
                    System.out.println("Невідома опція. Спробуйте ще раз.");
                    break;
            }
        }
    }
}