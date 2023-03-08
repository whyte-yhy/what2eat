package service;

import java.io.IOException;

public class Parse2wcnf {

    int var_num;
    int hard_var_num;
    int soft_var_num;
    int clause_num;
    int hard_clause_num;
    int soft_clause_num;
    long hard_weight;

    void parse() throws IOException {}
    String write2file(){
        return "";
    }

    public String pipline() throws IOException {
        parse();
        return write2file();
    }


    public int getVar_num() {
        return var_num;
    }

    public int getHard_var_num() {
        return hard_var_num;
    }

    public int getSoft_var_num() {
        return soft_var_num;
    }

    public int getClause_num() {
        return clause_num;
    }

    public int getHard_clause_num() {
        return hard_clause_num;
    }

    public int getSoft_clause_num() {
        return soft_clause_num;
    }

    public long getHard_weight() {
        return hard_weight;
    }
}
