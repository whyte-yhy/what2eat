package helper.utils;

import entity.Dish;
import entity.Food;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class CNFGenerator {
    LinkedList<Dish> dishes;

    Map<String, Integer> reserve_amount;
    Map<String, Integer> support_amount = new LinkedHashMap<>();
    int[] softWeights;

    LinkedList<LinkedList<String>> cnf = new LinkedList<>();

    int soft_c_num = 0;
    int hard_c_num = 0;
    int var_num = 0;
    int c_num = 0;
    long topWeight = 0;

    public CNFGenerator(@NotNull LinkedList<Dish> dishes, int[] softWeights, @NotNull Map<String, Integer> reserve_amount) {
        this.dishes = dishes;
        this.softWeights = softWeights;
        this.reserve_amount = reserve_amount;
        soft_c_num = dishes.size();
        var_num = reserve_amount.size();
    }

    private void generateSoftClauses() {
        long sumSoftWeight = 0;
        for (int curX = 0; curX < dishes.size(); curX++) {
            LinkedList<String> clause = new LinkedList<>();  // 初始化子句
            clause.add("" + softWeights[curX]); //权重
            clause.add("" + (curX+1)); //文字
            clause.add("0");  //结尾
            cnf.add(clause); //加入公式
            sumSoftWeight += softWeights[curX];  // 加权重
        }

        topWeight = sumSoftWeight + 1;
    }

    private void generateHardClauses() {
        for (int curX=0; curX<dishes.size(); curX++) {
            // 初始化
            initSupport();  // 已消耗的食材清零
            LinkedList<String> clause = new LinkedList<>();  // 初始化子句
            clause.add(topWeight + "");

            // 当前子句是否能加入
            Dish dish = dishes.get(curX);
            boolean flag1 = true;
            for (Food food: dish.foods) {
                if (reserve_amount.get(food.foodName) < food.amount) {
                    flag1 = false;
                    break;
                }
            }
            if (flag1) {  // 能加入
                // 加入第一层dish
                clause.add((curX+1) + "");
                add_support(dish);

                // 其它dish能不能加入
                for (int curY=curX+1; curY<dishes.size(); curY++) {
                    Dish nextDish = dishes.get(curY);
                    boolean flag2 = true;
                    for (Food nextFood : nextDish.foods) {
                        if (reserve_amount.get(nextFood.foodName) < (nextFood.amount + support_amount.get(nextFood.foodName))) {
                            flag2 = false;
                            break;
                        }
                    }
                    if (flag2) {  // 能加入
                        add_support(nextDish);
                        clause.add((curY+1) + "");
                    } else {  // 不能加入
                        clause.add("-" + (curY+1));
                        clause.add("0");
                        cnf.add(clause);
                        hard_c_num += 1;
                        break;
                    }
                }

            } else {  // 不能加入
                clause.add("-" + (curX+1));
                clause.add("0");
                cnf.add(clause);
                hard_c_num += 1;
            }
        }
        c_num += hard_c_num;
    }

    private void add_support(@org.jetbrains.annotations.NotNull Dish dish) {
        for (Food food : dish.foods) {
            support_amount.put(food.foodName, support_amount.get(food.foodName) + food.amount);
        }
    }

    private void initSupport() {
        // 保证顺序一致
        for (Map.Entry<String, Integer> entry : reserve_amount.entrySet()) {
            support_amount.put(entry.getKey(), 0);
        }
    }

    public LinkedList<LinkedList<String>> generate() {
        generateSoftClauses();
        generateHardClauses();
        return cnf;
    }

}
