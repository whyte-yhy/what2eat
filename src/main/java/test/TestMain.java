package test;

import helper.datastruct.Lit;

import java.util.LinkedList;

public class TestMain {

    public static void main(String[] args) {
        int numVariables = 10;
        int maxSelected = 3;

// 创建 CNF 公式的 StringBuilder
        StringBuilder sb = new StringBuilder();

// 添加数量约束
        for (int i = maxSelected + 1; i <= numVariables; i++) {
            for (int j = 1; j <= i - 1; j++) {
                for (int k = 1; k <= j - 1; k++) {
                    sb.append("-" + i + " -" + j + " -" + k + " 0\n");
                }
            }
        }

// 输出 CNF 公式
        System.out.println(sb.toString());


    }


}
