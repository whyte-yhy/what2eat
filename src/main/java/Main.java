import Solver.SLSolver;
import entity.Nutrient;
import helper.utils.JudgeUtil;
import service.Parse2wcnf;
import service.Parse2wcnfImpl;
import service.RealizeUrNeed;
import service.RealizeUrNeedImpl;
import sysinfo.Assignment;
import sysinfo.NutrientDiff;

import java.util.Scanner;

public class Main {

    // 当前版本只用能量进行计算
    //static Nutrient EER;

    public static void main(String[] args) throws Exception {
        // 0. 接收需求
        String words = "";

        // 1. 理解需求，转换为营养成分
        RealizeUrNeed realizer = new RealizeUrNeedImpl(words);
        Nutrient[] nutrients = realizer.checkKeywordsAndGetNeed();

        // 1.1 初始化需求营养集合
        for (Nutrient nu : nutrients) {
            NutrientDiff.getInstance().addNutrientsNeed(nu);
        }
        // 当前版本只用能量进行计算
        //EER = new Nutrient(nutrients[0].getName(), nutrients[0].getAmount(), nutrients[0].getUnit());

        // 2. 转换为wcnf
        Parse2wcnf parser = new Parse2wcnfImpl(nutrients);
        String targetFilename = parser.pipline();

        // 初始化赋值
        Assignment.getInstance().allocateAssignment(parser.getVar_num() + 1);  // var下标从1开始

        boolean res = false;
        while (!res) {
            // 3. 调用求解器求解
            SLSolver solver = new SLSolver();
            solver.search();

            // 4. 判断是否接受当前解
            JudgeUtil judge = new JudgeUtil();
            res = judge.judge();

            // 5. 输入额外请求或用户确定接受
            if (res) {
                Scanner sc = new Scanner(System.in);
                String txt = sc.next();
                if ("yes".equals(txt)) break;
                else {
                    // 写入额外规则

                    res = false;
                }
            }
        }

        if (res) {
            // 打印信息
        }
    }
}
