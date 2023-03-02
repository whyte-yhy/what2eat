package service;

import entity.Nutrient;

import java.io.FileNotFoundException;

public interface RealizeUrNeed {
    // 构建前缀树
    void buildRuleTree() throws FileNotFoundException, Exception;
    // 根据前缀树检索到需要的食物份数需求
    Nutrient[] checkKeywordsAndGetNeed();
}
