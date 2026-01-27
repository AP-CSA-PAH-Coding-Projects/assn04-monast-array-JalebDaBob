package apcsa.githubtrack;
public class ShoppingItem //contains one ShoppingItem
{
    private String name; //name of the item
    private int price; //price of the item, in cents
    private boolean sold; //has the item been bought yet?

    public ShoppingItem(String n, int p, boolean s) //initializes the item's attributes
    {
        name = n;
        price = p;
        sold = s;    
    }
    public ShoppingItem(String n, int p)
    {
        name = n;
        price = p;
        sold = false; //default value of sold is false
    }

    public String getName() //retrieves the items name
    {
        return name;
    }
    public double getPrice() //retrieves the items price, in dollars
    {
        double newPriceDollars = (double) price/100;
        return newPriceDollars;
    }
    public boolean isItSold() //checks whether the item has been bought yet
    {
        return sold;
    }
    public void buy() //buys an item
    {
       sold = true; //assigns the items sold value to true, to signify that this particular item has been bought
    }
    public boolean equals(ShoppingItem other) //checks whether an item is equivalent to another item
    {
        return(other.getName().equals(this.name) && other.getPrice() == (this.price/100.0)); // checks if the items' prices and names are equal
    }

    public void compareTo(ShoppingItem other) //checks whether the items are equal; if they have the same names, but different prices, it checks which item is cheaper/more expensive
    {
        if (other.getName().equals(this.name) == false) //different items
        {
            System.out.println("Error: Different items!"); //Error Message!
        }
        else 
        {
            System.out.println(other.getPrice() - this.getPrice()); //returns difference between prices if the two items are equal in name: if they are equal in price, then it will return 0
        }
        /*
        If the second item is more expensive than the first item, then the result is positive
        If it's cheaper, then the result is negative
        */
    }
    

    
}

// Implement your ShoppingItem class here
