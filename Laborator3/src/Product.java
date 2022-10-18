
public class Product {

    public Product(double price, int numberOfDays) {
        this.setPrice(price);
        this.setNumberOfDays(numberOfDays);
    }
    private double price;
    private int numberOfDays;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = Math.round(price * 20.0) / 20.0;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public String toString()
    {
        return "Product("+this.price+","+this.numberOfDays+")";
    }
}
