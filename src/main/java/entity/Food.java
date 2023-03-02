package entity;

import enumutil.UnitEnum;

public class Food {

    Nutrient[] nutrients;

    String foodName;

    // 暂时用不到
    int[] amount;
    UnitEnum unit;

    public Food(Nutrient[] nutrients, String foodName, int[] amount, UnitEnum unit) {
        this.nutrients = nutrients;
        this.foodName = foodName;
        this.amount = amount;
        this.unit = unit;
    }
}
