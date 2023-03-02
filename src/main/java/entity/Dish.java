package entity;

import enumutil.UnitEnum;

public class Dish {
    String dishName;
    Food[] foods;

    public Dish(String dishName, Food[] foods, int[] amount, UnitEnum unit) {
        this.dishName = dishName;
        this.foods = foods;
    }
}
