package service;

import entity.Nutrient;
import entity.Person;
import enumutil.UnitEnum;
import helper.utils.GiveAdvice;
import helper.utils.LoadRealizerUtil;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class RealizeUrNeedImpl implements RealizeUrNeed {

    String words = "";
    private static LinkedList<String> rules = new LinkedList<>();

    public RealizeUrNeedImpl(String words) throws Exception {
        this.words = words;
        //rewrite(words);
        buildRuleTree();
    }

//    private void rewrite(String words) {
//        String newwords;
//
//        this.words = newwords;
//    }

    @Override
    public void buildRuleTree() throws Exception {
        String filePath = "src/main/resources/implyNutrient.txt";
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String str;
        while ( (str = reader.readLine() ) != null){
            rules.add(str);
        }
        reader.close();
        LoadRealizerUtil.convert2tree(rules);
        //System.out.println(LoadRealizerUtil.tree);
    }

    @Override
    public Nutrient[] checkKeywordsAndGetNeed() {
        List<Nutrient> result = new LinkedList<>();

        GiveAdvice giveAdvice = new GiveAdvice();  // TODO: 为了交差，暂时这里的建议是判断劳动强度；最终版本这里需要推断特殊人群给出适当建议
        Map<String, String> advice = giveAdvice.getAdvice(this.words);

        int carry = 0;
        for (Map.Entry<String, String> entry : advice.entrySet()) {
            carry += Integer.parseInt(entry.getValue());
        }
        if (carry < 5) {
            Person.getInstance().setLaborIntensity("轻");
        } else if (carry < 10) {
            Person.getInstance().setLaborIntensity("中");
        } else {
            Person.getInstance().setLaborIntensity("重");
        }

        Person.getInstance().computeBodyType();
        //TODO: 这里将需要的Nutrient加入营养列表中，当前版本只加入需要的热量就行了
        result.add(new Nutrient("热量", computeKal(), UnitEnum.kcal));

        System.out.print("您的情况为" + "【" + Person.getInstance().getLaborIntensity() + "】体力劳动；体型为【" + Person.getInstance().getBodyType() + "】；每天需要补充【" + computeKal() + " kcal 能量】。");

        //return (Nutrient[]) result.toArray();
        return new Nutrient[1];
    }

    private int computeKal() {
        return 2401;
    }

}
