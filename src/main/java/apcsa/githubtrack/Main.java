package apcsa.githubtrack;

public class Main
{
public static void main(String[] args)
{
    ShoppingList breakfastEssentials = new ShoppingList(); //new ShoppingList
    ShoppingItem eggs = new ShoppingItem("eggs", 350, false); //various shopping items
    ShoppingItem zucchini = new ShoppingItem("zucchini", 275, false);
    ShoppingItem frozenBerries = new ShoppingItem("frozen berries", 515, false);
    ShoppingItem smokedSalmon = new ShoppingItem("smoked salmon", 999, false);
    breakfastEssentials.addToEnd(eggs); //adding these shopping items into breakfastEssentials
    breakfastEssentials.addToEnd(zucchini);
    breakfastEssentials.addToEnd(frozenBerries);
    breakfastEssentials.addToEnd(smokedSalmon);
    ShoppingItem tissues = new ShoppingItem("tissues", 100, false); //some more items
    ShoppingList dormRun = new ShoppingList(); //new ShoppingList
    dormRun.addToEnd(eggs); //adding items into dormRun
    dormRun.addToEnd(zucchini);
    dormRun.addToEnd(frozenBerries);
    dormRun.addToEnd(smokedSalmon);
    ShoppingItem KPDHsoundtrack = new ShoppingItem("KPOP Demon Hunters CD", 2100, false);
    dormRun.insertAt(1, tissues); //insert item
    dormRun.insertAt(0, KPDHsoundtrack);
    dormRun.removeAt(0); //remove item
    
    if (dormRun.isIdentical(breakfastEssentials) == false) //are they identical?
    {
        System.out.println("No, these lists are not equivalent."); //if not, print this message
    }
    dormRun.removeAt(4);
    dormRun.removeAt(1);
    dormRun.getAt(0).buy();
    dormRun.addToEnd(smokedSalmon);
    dormRun.getAt(3).buy();
    if (dormRun.completedShopping() == true)
    {
        System.out.println("DormRun Shopping is complete!");
    }
    else
    {
        System.out.println("DormRun Shopping is incomplete!");
    }
    breakfastEssentials.goShopping();
    ShoppingCart cart1 = new ShoppingCart(false, "Joe", breakfastEssentials, 0);
    ShoppingCart cart2 = new ShoppingCart(false, "Bob", dormRun, 0);
    cart1.getShoppingCartReturnedNumber();
    cart2.getShoppingCartReturnedNumber();
    cart1.returnCart();
    cart2.returnCart();
    breakfastEssentials.getAt(0).compareTo(dormRun.getAt(2));
    System.out.println("BreakfastEssential's shopping trip is over! Breakfast essentials included: " + breakfastEssentials.toString() + "for a total of " + "$" + breakfastEssentials.totalPrice() + "!");







}
}
// Implement your Main class (with the main method) here
