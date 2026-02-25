package builder.Example;

public interface BurgerBuilder {
    void addBun();
    void addPatty();
    void addCheese();
    void addSauce();
    void addVegetables();
    Burger getBurger();
}
