package test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class CNF {

    // 主食食材数目
    private static final int MAIN_FOODS = 10;
    // 副食食材数目
    private static final int SIDE_FOODS = 30;
    // 每种食材最多选择的份数
    private static final int MAX_QUANTITY = 3;
    // 主食食材可选择的份数
    private static final int MAIN_FOODS_QUANTITY = 10;
    // 副食食材可选择的份数
    private static final int SIDE_FOODS_QUANTITY = 17;

    public static void main(String[] args) throws IOException {
        new CNF().generateCNF("1.wcnf");
    }

    public void generateCNF(String targetFilename) throws IOException {

        // 创建变量列表
        List<String> variables = new ArrayList<>();
        for (int i = 0; i < MAIN_FOODS + SIDE_FOODS; i++) {
            for (int j = 0; j < MAX_QUANTITY; j++) {
                variables.add(getVariable(i, j));
            }
        }

        // 创建 CNF 公式
        List<List<String>> clauses = new ArrayList<>();

        for (int i=0; i<MAIN_FOODS*MAX_QUANTITY; i++) {

        }




        // 输出 CNF 公式
//        for (List<String> clause : clauses) {
//            for (String variable : clause) {
//                System.out.print(variable + " ");
//            }
//            System.out.println("0");
//        }
        File file = new File(targetFilename);
        // 创建文件
        boolean create_res = file.createNewFile();
        //if (!create_res) System.out.println("文件创建失败");
        // creates a FileWriter Object
        FileWriter writer = new FileWriter(file);
        // 向文件写入内容
        writer.write("p wcnf " + variables.size() + " " + clauses.size() + " 50\n");
        for (List<String> clause : clauses) {
            writer.write("50 ");
            for (String variable : clause) {
                writer.write(variable + " ");
            }
            writer.write(0 + "\n");
        }
        writer.flush();
        writer.close();
    }

    // 获取变量名
    private static String getVariable(int index, int quantity) {
        //return "x" + (index * MAX_QUANTITY + quantity + 1);
        return "" + (index * MAX_QUANTITY + quantity + 1);
    }

    // 取反变量名
    private static String negate(String variable) {
        return "-" + variable;
    }
}
