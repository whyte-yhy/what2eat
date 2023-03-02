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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public UnitEnum getUnit() {
        return unit;
    }

    public void setUnit(UnitEnum unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return name+amount+unit;
    }
}
