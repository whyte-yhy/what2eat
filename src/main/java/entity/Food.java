package entity;

import enumutil.UnitEnum;

public class Food {

    Nutrient[] nutrients;

    public String foodName;
    public int amount;
    public UnitEnum unit;

    public Food(Nutrient[] nutrients, String foodName, int amount, UnitEnum unit) {
        this.nutrients = nutrients;
        this.foodName = foodName;
        this.amount = amount;
        this.unit = unit;
    }
}
