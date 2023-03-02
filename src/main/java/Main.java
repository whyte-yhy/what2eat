import entity.Nutrient;
import service.Parse2wcnf;
import service.Parse2wcnfImpl;
import service.RealizeUrNeed;
import service.RealizeUrNeedImpl;

public class Main {

    public static void main(String[] args) {
        // 0. 接收需求
        String words = "";

        // 1. 理解需求，转换为营养成分
        RealizeUrNeed realizer = new RealizeUrNeedImpl(words);
        Nutrient[] nutrients = realizer.checkKeywordsAndGetNeed();

        // 2. 转换为wcnf
        Parse2wcnf parser = new Parse2wcnfImpl(nutrients);
        String targetFilename = parser.pipline();

        // 3. 调用求解器求解

        // 4.

    }


}
