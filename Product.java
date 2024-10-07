//this class is to represent a product in the supermarket
public class Product
{
    private String name;
    private double price;
    private static int totalProducts=0;

    //constructor
    public Product(String name,double price )
    {
        this.name=name;
        this.price=price;
        totalProducts++;
    }

    public String getName()
    {
        return name;
    }

    public double getPrice()
    {
        return price;
    }

    public static int getTotalProducts()
    {
        return totalProducts;
    }

}
