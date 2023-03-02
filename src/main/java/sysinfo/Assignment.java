package sysinfo;

import java.util.HashMap;
import java.util.Map;

/*
* 保存当前赋值信息
* */
public class Assignment {

//    private byte[] assigment;
//    private String varName;  // 同foodName，保证变量的赋值和对应的食物顺序一致
    private Map<String, Byte> assignment;

    private final static Assignment ASSIGNMENT = new Assignment();

    private Assignment(){}

    public static Assignment getInstance(){
        return ASSIGNMENT;
    }

    public void allocateAssignment(int size) {
        assignment = new HashMap<>(size);
    }

    public void setFood(String foodName, Byte value) {  // 翻转用 1-val 就可以了
        assignment.put(foodName, value);
    }

    public Map<String, Byte> getAssignment() {
        return assignment;
    }
}
