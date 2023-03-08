package entity;

import enumutil.UnitEnum;

public class Dish {
    public String dishName;
    public Food[] foods;

    public Dish(String dishName, Food[] foods, int[] amount, UnitEnum unit) {
        this.dishName = dishName;
        this.foods = foods;
    }
}
