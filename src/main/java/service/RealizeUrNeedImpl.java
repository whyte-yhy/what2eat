package service;

import entity.Nutrient;

import java.util.LinkedList;
import java.util.List;

public class RealizeUrNeedImpl implements RealizeUrNeed {

    String words = "";

    public RealizeUrNeedImpl(String words) {
        buildRuleTree();
        this.words = words;
    }

    @Override
    public void buildRuleTree() {

    }

    @Override
    public Nutrient[] checkKeywordsAndGetNeed() {
        List<Nutrient> result = new LinkedList<>();

        return (Nutrient[]) result.toArray();
    }
}
