import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {
        var allProducts = new ArrayList<Product>();
        allProducts.add(new Product(89.5, 20));
        allProducts.add(new Product(102.3, 10));
        allProducts.add(new Product(76.25, 5));
        allProducts.add(new Product(50.0, 7));
        allProducts.add(new Product(67.03, 25));
        allProducts.add(new Product(49.97, 25));

        System.out.println(getProductsWithHigherPriceThan100(allProducts));
        sortAfterDiscountPrice(allProducts);
        System.out.println(allProducts);
        printMinAndMaxProducts(allProducts);
        System.out.println("Sum Value: " + getSumOfProducts(allProducts));
    }

    public static double getSumOfProducts(List<Product> products) {
        double sumOfProducts = 0;

        for (var product : products)
        {
            sumOfProducts +=  getDiscountedProductPrice(product);
        }

        return sumOfProducts;
    }

    public static double getDiscountedProductPrice(Product product) {
        var price = product.getPrice();
        var numberOfDays = product.getNumberOfDays();

        if (numberOfDays < 10) {
            return price;
        } else if (numberOfDays < 20) {
            return applyDiscount(price, 10);
        } else {
            return applyDiscount(price, 20);
        }
    }

    public static double applyDiscount (double value , int discountAmount) {
        var resultPrice =  value * (100-discountAmount) / 100;
        return Math.round(resultPrice * 20.0) / 20.0;
    }

    public static List<Product> getProductsWithHigherPriceThan100(List<Product> allProducts) {
        return allProducts.stream().filter(singleProduct -> singleProduct.getPrice() > 100).toList();
    }

    public static void sortAfterDiscountPrice(List<Product> allProducts){
        allProducts.sort((o1, o2) -> (int) (getDiscountedProductPrice(o2) - getDiscountedProductPrice(o1)));
    }

    public static Product findCheapestProduct(List<Product> allProducts) {
        return allProducts.stream().min(Comparator.comparing(Product::getPrice)).orElseThrow(NoSuchElementException::new);
    }

    public static Product findMostExpensiveProduct(List<Product> allProducts){
        return allProducts.stream().max(Comparator.comparing(Product::getPrice)).orElseThrow(NoSuchElementException::new);
    }
    public static void printMinAndMaxProducts(List<Product> allProducts){
        Product cheapestProduct = findCheapestProduct(allProducts);
        Product expensiveProduct = findMostExpensiveProduct(allProducts);

        System.out.println("Cheapest Product: " + cheapestProduct.getPrice() + "\nMost Expensive Product: " + expensiveProduct.getPrice());
    }
}