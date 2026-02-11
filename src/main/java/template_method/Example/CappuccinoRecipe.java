package template_method.Example;

public class CappuccinoRecipe extends CoffeeRecipe {
    @Override
    public void addIngredients() {
        System.out.println("Add milk foam to prepare a cappuccino");
    }

    @Override
    public void pourInCup() {
        // Cappuccino is served in a medium cup
        System.out.println("Prepared cappuccino is poured into a medium cup");
    }
}