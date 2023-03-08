package sysinfo;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/*
* 保存当前赋值信息
* */
public class Assignment {

//    private byte[] assigment;
//    private String varName;  // 同foodName，保证变量的赋值和对应的食物顺序一致
    private Map<String, Byte> assignment = new LinkedHashMap<>();

    private final static Assignment ASSIGNMENT = new Assignment();

    private Assignment(){}

    public static Assignment getInstance(){
        return ASSIGNMENT;
    }

//    public void allocateAssignment(int size) {
//        assignment = new LinkedHashMap<>(size);
//    }

    public void loadFoods(String filepath) throws IOException {
        File fin = new File(filepath);

        FileInputStream fis = new FileInputStream(fin);
        //Construct BufferedReader from InputStreamReader
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));

        String line = null;
        while ((line = br.readLine()) != null) {
            assignment.put(line, (byte) 0);
        }
        br.close();
    }

    public void flipFood(String foodName, Byte value) {  // 翻转用 1-val 就可以了
        assignment.put(foodName, (byte) (1 - value));
    }

    public Map<String, Byte> getAssignment() {
        return assignment;
    }
}
