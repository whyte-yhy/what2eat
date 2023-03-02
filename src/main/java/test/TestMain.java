package test;

import helper.datastruct.Lit;

import java.util.LinkedList;

public class TestMain {

    public static void main(String[] args) {

        // 食材列表
        LinkedList<String> grain = new LinkedList<>();
        LinkedList<String> vegetable = new LinkedList<>();
        LinkedList<String> soy = new LinkedList<>();
        LinkedList<String> dairy = new LinkedList<>();
        LinkedList<String> meat = new LinkedList<>();
        LinkedList<String> oil = new LinkedList<>();

        LinkedList<LinkedList<String>> categories = new LinkedList<>();

        // CNF公式
        LinkedList<LinkedList<Lit>> cnf = new LinkedList<>();

        // 每餐至少10种食材
        int meal_size = 10;

        // 初始化食材列表
        grain.add("面粉");
        grain.add("大米");
        grain.add("红薯");
        grain.add("马铃薯");
        vegetable.add("甜菜");
        vegetable.add("菠菜");
        vegetable.add("油菜");
        soy.add("黄豆");
        soy.add("豆浆");
        soy.add("豆干");
        dairy.add("牛奶");
        dairy.add("奶粉");
        meat.add("鸡蛋");
        meat.add("翅根");
        oil.add("松子");
        oil.add("花生油");

        categories.add(grain);
        categories.add(vegetable);
        categories.add(soy);
        categories.add(dairy);
        categories.add(meat);
        categories.add(oil);

        // 食材至少meal_size种，把不行的情况全部否定
        for (int i=1; i<meal_size; i++) {

        }   // 主食和副食都限定常吃的，随机在主食和副食中不放回地采样就行了

        // 食物种类10种，先算，至少一种主食一种副食

        // 主食x份，组合

        // 副食10份，组合


    }


}
