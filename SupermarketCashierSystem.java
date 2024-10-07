import java.util.Scanner;
public class SupermarketCashierSystem 
{
    public static void main(String[] args) 
    {
    Scanner in = new Scanner (System.in);
    
    System.out.println("Menu: Enter number of products: ");
    int menuProducts = in.nextInt();
    Product []menu = new Product[menuProducts];

    for(int i=0; i<menuProducts; i++)
    {
        System.out.println(" Enter product " +(i+1)+  " name: ");
        String n = in.next();

        System.out.println(" Enter product " + (i+1)+ " price: ");
        double p = in.nextDouble();

        Product prod = new Product(n, p);
        menu[i]= prod;   
    }
    System.out.println();

    

    for (int i=0; i<menu.length; i++ )
    {
        System.out.println("Product "+ (i+1) +" "+ menu[i].getName() + " -  $"+ menu[i].getPrice());
    }
    System.out.println();

    int wrongInput=0;
    while (true) {
        System.out.println("Enter number of products (Enter 0 to exit): ");
        int num= in.nextInt();
        
        if(num != 0)
        {
            Cashier cashier = new Cashier(num);
      
            for(int i=0; i< num; i++)
            {
                System.out.println("Enter the name of product "+ (i+1) + " : ");
                String n = in.next();

                System.out.println("Enter the price of product "+ (i+1) + " : ");
                double p = in.nextDouble();

                Product product = new Product(n, p);
                boolean check= false ;

                for(int j =0; j < menu.length; j++)
                {
                    if ((menu[j].getName().equals(product.getName() )&& (menu[j].getPrice()== product.getPrice()))) 
                    {
                        cashier.addProduct(product);
                        check=true;
                    }

                }
                if (check == false)
                {
                    wrongInput -=1;
                    System.out.println(" Product not available! Enter another product: ");
                    System.out.println("Enter the name of product "+ (i+1) + " : ");
                    n = in.next();
    
                    System.out.println("Enter the price of product "+ (i+1) + " : ");
                    p = in.nextDouble();
    
                    product = new Product(n, p);
                    check= false ;
    
                    for(int j =0; j < menu.length; j++)
                    {
                        if ((menu[j].getName().equals(product.getName() )&& (menu[j].getPrice()== product.getPrice())))
                        {
                            cashier.addProduct(product);
                            check=true;
                        }

                    }
                }
                

            }

            cashier.printReceipt();
            System.out.println();

        }

        else
            break;
        
      }

        int itemsPurchased=Product.getTotalProducts()+ wrongInput;
        System.out.println("Items Purchased per day : " +(itemsPurchased-menuProducts));
        in.close();
    }
}
