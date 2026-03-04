package apcsa.githubtrack;

public class ShoppingCart //the shopper's shopping container, of all his ShoppingItems, and his ShoppingList
{
    private boolean mission; //whether or not the shopping trip was a success: all the items on the corresponding ShoppingList were bought
    private String name; //the shopper's name
    private ShoppingList list; //the corresponding ShoppingList
    private int ShoppingCartReturn; //the number of Shopping Carts that have been returned
    private boolean trip = true; //marks whether the shopping trip is over in order to make sure that one cart cannot be returned twice; if trip is true, then the cart is still "shopping"

    public ShoppingCart(boolean m, String n, ShoppingList l, int cartreturn) //constructor with an inputted ShoppingList
    {
        mission = m;
        name = n;
        list = l;
        ShoppingCartReturn = cartreturn;
    }
    public ShoppingCart(boolean m, String n, int cartreturn)//constructor without an inputted ShoppingList
    {
        mission = m;
        name = n;
        ShoppingCartReturn = cartreturn;
        list = new ShoppingList(); //assigns list to an empty ShoppingList if none is inputted in the constructor arguments
    }

    public boolean isCompleted() //determines whether the shopping mission was a success, and all items on list were bought
    {    
        mission = list.completedShopping(); //references a ShoppingList method that checks whether all items on list were bought
        return mission;
    }

    public void returnCart() //returns current ShoppingCart, and makes sure it can only be returned once. Also adjusts the total number of returned ShoppingCarts
    {
        
        if (isCompleted() && trip == true) //if the mission is completed, and the person is still shopping...
        {
            ShoppingCartReturn++; //return the cart and adjust the number of returned carts, and
            trip = false; //end the shopping trip
        }

    }

    public String getName() //returns the name of the shopper
    {
        return name;
    }
    public boolean getCompletion() //returns whether the shopping mission is complete, i.e., all the items on the corresponding ShoppingList have been bought
    {
        return mission;
    }
    public ShoppingList getList() //returns the corresponding ShoppingList related to this cart and shopper: returns ShoppingItems included in its ShoppingItem array
    {
        return list;
    }
    public boolean isTheTripOver() //returns whether the shopping trip is over
    {
        return trip;
    }
    public int getShoppingCartReturnedNumber()//returns the number of shopping carts that have been returned
    {
        return ShoppingCartReturn;
    }

}// Implement your ShoppingCart class here
