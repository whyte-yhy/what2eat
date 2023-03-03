package sysinfo;

import entity.Food;
import entity.Nutrient;

import java.util.LinkedList;

/*
* 负责营养得分的计算
* */
public class NutrientDiff {

    LinkedList<Nutrient> nutrientsNeed = new LinkedList<>();

    private final static NutrientDiff NUTRIENT_DIFF = new NutrientDiff();

    private NutrientDiff(){}

    public static NutrientDiff getInstance() {
        return NUTRIENT_DIFF;
    }

    public LinkedList<Nutrient> getNutrientsNeed() {
        return nutrientsNeed;
    }

    public LinkedList<Nutrient> addNutrientsNeed(Nutrient nutrientNeed) {
        this.nutrientsNeed.add(nutrientNeed);
        return this.nutrientsNeed;
    }

    //TODO: 完成得分的计算
    public float computeNutrientDiffAndReturnScore(Food food) {
        float score = 0f;

        return score;
    }


}
