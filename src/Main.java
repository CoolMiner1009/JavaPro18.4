import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
class Product {
    private String type;
    private double price;
    private boolean discount;
    private LocalDateTime createDate;

    public Product(String type, double price, boolean discount, LocalDateTime createDate) {
        this.type = type;
        this.price = price;
        this.discount = discount;
        this.createDate = createDate;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public boolean hasDiscount() {
        return discount;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }
}

public class Main {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Book", 200, false, LocalDateTime.of(2022, 1, 1, 0, 0)),
                new Product("Book", 300, true, LocalDateTime.of(2022, 2, 1, 0, 0)),
                new Product("Book", 400, true, LocalDateTime.of(2022, 3, 1, 0, 0)),
                new Product("Toy", 100, false, LocalDateTime.of(2022, 4, 1, 0, 0))
        );

        List<Product> latestProducts = products.stream()
                .sorted(Comparator.comparing(Product::getCreateDate).reversed())
                .limit(3)
                .collect(Collectors.toList());

        latestProducts.forEach(p -> System.out.println("Type: " + p.getType() + ", Price: " + p.getPrice() + ", Create Date: " + p.getCreateDate()));
    }
}

