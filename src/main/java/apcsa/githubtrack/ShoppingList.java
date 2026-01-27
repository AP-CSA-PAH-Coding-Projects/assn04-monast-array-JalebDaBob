package apcsa.githubtrack;

// Implement the ShoppingList class here

public class ShoppingList implements MyList //ShoppingList class, which is like an ArrayList for ShoppingItems
{
    private int capacity = 8; //capacity of the current ShoppingItem array
    private int size = 0; //number of ShoppingItems in the ShoppingItem array
    private ShoppingItem[] storage = new ShoppingItem[8]; //a ShoppingItem array, storage, which has a capacity of 8

    
    //Array storage editing methods

    public void addToEnd(ShoppingItem item) //adds a ShoppingItem to the end of the storage array
    {
        int i = 0;
        if (size == capacity) //if the capacity is full
                {
                    makeCapacity(2*capacity); //implement makeCapacity method (see below), to double capacity of the storage array
                }
        while (i < storage.length)
        {
            if (storage[i] == null) //adds item to the first "empty" index of storage
            {
                storage[i] = item; //assigns the item to that index
                size++; //adjusts size as another item has been added
                i = storage.length; //ends the loop
            }
            else
            {
                i++; //increase index, to continue looking for null "space"
            }
        }

    }
    public void insertAt(int index, ShoppingItem item) //inserts an item at a specified index
    {
        if (index < 0 || index>size) //if the index is less than 0, or the index exceeds the number of non-null items in the storage array
        {
            System.out.println("Invalid Index!"); //then print an error message
        }
        else if (size == capacity) //if capacity is reached in the array
        {
            makeCapacity(capacity + 1); //adds an extra space using makeCapacity
        }
        if (index >= 0 && index <= size) //if the index is "within bounds"
        {
            for (int i = storage.length-2; i>=index; i++) //loop backwards through the storage array
            {
                storage[i+1] = storage[i]; //shifts items to the right, one by one, to make room for the incoming item
            }
            storage[index] = item; //insert item at required, now basically "empty" (values are safely copied "upwards") index
        }

    }
    public void removeAt(int index)//removes item at specified index
    {
        if (index >= 0 && index <= size) //if index is "within bounds"
        {
            for (int i = index; i < storage.length-2; i++) //loops through storage, in the "upwards" direction
            {
                storage[i] = storage[i+1]; //shifts items to the left, one by one
            }
            storage[storage.length-1] = null; //assigns last value (already saved) to null
        }
        if (index < 0 || index>size) //if index isn't within bounds, print an error message
        {
            System.out.println("Invalid Index!");
        }

    }
    public ShoppingItem getAt(int index) //retrieves item at a certain index
    {
        if (index < 0 || index > size) //error mesage
        {
            System.out.println("Invalid Index!");
        }
        return storage[index]; //retrieves item

    }
 

    //Capacity Management Methods

    public void makeCapacity(int minCapacity) //adjusts capacity to minCapacity or higher
    {
        if(minCapacity > size && minCapacity != capacity) //this checks whether minCapacity is lower than size or if it equals capacity; If it does, then there's no need to increase the capacity, as the capacity is larger than minCapacity
        {
            if (minCapacity > 8) //if minCapactiy is > size and doesn't equal capacity, then if it is greater than 8, then capacity is set to minCapacity
            {
                capacity = minCapacity;
            }
            else //otherwise, capacity is set to 8, which is >= minCapacity
            {
                capacity = 8;
            }
            ShoppingItem[] newStorage = new ShoppingItem[capacity]; //this creates a new ShoppingItem array, newStorage, with the new capacity to replace the old ShoppingItem array, storage
            for (int i = 0; i<storage.length; i++) //for all values in storage, this code copies them into the corresponding index in newStorage
            {
                newStorage[i] = storage[i];
            }
            storage = newStorage; //now storage is replaced by newStorage, which features a larger capacity
        }

    }

    public void trimExcess() //this method trims the excess empty space from the storage array, by setting the capacity equal to the number of items in the storage array
    {
        makeCapacity(size);
    }

    //Shopping Methods

    public void goShopping() //this buys all items in the storage array, implementing the ShoppingItem method buy()
    {
        for (ShoppingItem i : storage) //this loops through all items in the storage array
        {
            i.buy(); //this buys each item
        }
    }
    public void goShopping(ShoppingList toBuy) //for every item in toBuy that matches an item, this method buys that item
    {
        for (ShoppingItem i : storage) //this loops through the items in storage
        {
            for(ShoppingItem j : toBuy.storage ) //this loops through the items in toBuy 
            {
                if (i.equals(j)) //if the items match in name and price 
                {
                    i.buy(); //then buy that item
                }
            }
        }
    }
    public double totalPrice() //finds the total price of all items in storage
    {
        double sum = 0.0; //sum variable to hold future values/prices of items
        for (ShoppingItem j : storage) //enhanced for loop that loops through all of the ShoppingItems in storage
        
            sum+=j.getPrice(); //retrieves that item's price, and adds it to the sum; for every non-null item in storage
        
        return sum;
    }
    public boolean isIdentical(ShoppingList other) //checks if two ShoppingLists are equal, by reason of their ShoppingItem storage array and size
    {
        return (this.size == other.size && this.storage == other.storage); //if their storage arrays and their sizes are equal, then return true; otherwise, return false 
       
        
    }

    //accessors
    public int getCapacity() //retrieves capacity of the storage array
    {
        return capacity;
    }
    public int getSize() //retrieves the size of the storage array
    {
        return size;
    }
    public ShoppingItem[] getShoppingItems() //returns all of the items in the storage array
    {
        return storage;
    }

    //checkers

    public boolean completedShopping() //checks if the shopping is completed
    {
        boolean truth = false; //boolean variable truth, initialized to false
        for (ShoppingItem i : storage) //for every item in storage
        {
            truth = i.isItSold();//if the item is bought/sold (method from ShoppingItem), then return true; otherwise return false
            
            if (i.isItSold() == false)
            {
                return false;
            } 
            /*
            if a single item in storage has not been bought/sold yet, then the method returns false
            */
        }
        return truth; //otherwise, it returns true
    }
}
