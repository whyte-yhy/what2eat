package sysinfo;

/*
* 保存当前赋值信息
* */
public class Assignment {

    private byte[] assigment;
    private String varName;  // 同foodName，保证变量的赋值和对应的食物顺序一致

    private final static Assignment ASSIGNMENT = new Assignment();

    private Assignment(){}

    public Assignment getInstance(){
        return ASSIGNMENT;
    }

    public void allocateAssignment(int size) {
        assigment = new byte[size];
    }

    public byte[] getAssigment() {
        return assigment;
    }

    public void setAssigment(byte[] assigment) {
        this.assigment = assigment;
    }
}
