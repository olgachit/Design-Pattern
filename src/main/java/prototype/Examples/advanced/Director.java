package prototype.Examples.advanced;

public class Director {
    public void constructInfantrySoldier(SoldierBuilder builder) {
        builder.addGenericItem("Armor");
        builder.addWeapon("Rifle");
        builder.addGenericItem("Helmet");
    }
}
