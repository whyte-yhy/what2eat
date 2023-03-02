package helper.datastruct;

import entity.Food;

public class Lit {
    Food food;        // 所属变量（食物）
    int polo;               // 当前赋值（极性）
    boolean isPositive;     // 正负文字
    String txt;             // 备注文字用途

    public Lit(Food name, int num, boolean positive) {
        this.food = name;
        this.polo = num;
        isPositive = positive;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }
}
