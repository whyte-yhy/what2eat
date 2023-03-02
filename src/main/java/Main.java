import Solver.SLSolver;
import entity.Nutrient;
import helper.utils.JudgeUtil;
import service.Parse2wcnf;
import service.Parse2wcnfImpl;
import service.RealizeUrNeed;
import service.RealizeUrNeedImpl;

public class Main {

    // 当前版本只用能量进行计算
    static Nutrient EER;

    public static void main(String[] args) {
        // 0. 接收需求
        String words = "";

        // 1. 理解需求，转换为营养成分
        RealizeUrNeed realizer = new RealizeUrNeedImpl(words);
        Nutrient[] nutrients = realizer.checkKeywordsAndGetNeed();

        // 当前版本只用能量进行计算
        EER = new Nutrient(nutrients[0].getName(), nutrients[0].getAmount(), nutrients[0].getUnit());

        // 2. 转换为wcnf
        Parse2wcnf parser = new Parse2wcnfImpl(nutrients);
        String targetFilename = parser.pipline();

        boolean res = false;
        while (!res) {
            // 3. 调用求解器求解
            SLSolver solver = new SLSolver();
            solver.search();

            // 4. 判断是否接受当前解
            JudgeUtil judge = new JudgeUtil();
            res = judge.judge();
        }

        if (res) {
            // 打印信息
        }
    }
}
