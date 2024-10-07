// this class manages the transaction process, includind adding products and printing receipts.
public class Cashier
{
    //this array is created to store products.
    private Product []products;
    private int productCount;
   
    //constructor to initialize the products array with a specified size.
    public Cashier(int numOfProducts)
    {
        products= new Product[numOfProducts];
        productCount=0;
    }

    // Method to add a product to the products array, checking the limits.
    public void addProduct(Product product)
    {
        if(productCount < products.length)
        {
            products[productCount]= product;
            productCount++;
        }
        else
            System.out.println("No more products can be added !");
    }

    //method to print a receipt showing each product, its price, and the total cost. 
    public void printReceipt()
    {
        double totalCost= 0;
        for (int i =0; i < products.length; i++)
        {
            totalCost += products[i].getPrice();
            System.out.println( products[i].getName() + " - $" + products[i].getPrice());    
        }
        System.out.println("Total : $" +totalCost );
    }
}