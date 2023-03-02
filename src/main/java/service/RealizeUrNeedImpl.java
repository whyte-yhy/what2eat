package service;

import entity.Nutrient;
import helper.utils.GiveAdvice;
import helper.utils.LoadRealizerUtil;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;

public class RealizeUrNeedImpl implements RealizeUrNeed {

    String words = "";
    private static LinkedList<String> rules = new LinkedList<>();

    public RealizeUrNeedImpl(String words) throws Exception {
        buildRuleTree();
        this.words = words;
    }

    @Override
    public void buildRuleTree() throws Exception {
        String filePath = "implyNutrient.txt";
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

        GiveAdvice giveAdvice = new GiveAdvice();
        String advice = giveAdvice.getAdvice(this.words);
        System.out.print("建议：\n" + advice);

        //TODO: 这里将需要的Nutrient加入营养列表中，当前版本只加入需要的热量就行了

        return (Nutrient[]) result.toArray();
    }
}
