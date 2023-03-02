package entity;


import enumutil.UnitEnum;

public class Nutrient {
    // 成分名，[数量, 单位]
    String name;
    int amount;
    UnitEnum unit;

    public Nutrient(String name, int amount, UnitEnum unit) {
        this.name = name;
        this.amount = amount;
        this.unit = unit;
    }

    @Override
    public String toString() {
        return name+amount+unit;
    }
}
