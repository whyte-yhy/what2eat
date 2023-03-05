package service;

import entity.Nutrient;
import test.CNF;

import java.util.LinkedList;
import java.util.List;

public class Parse2wcnfImpl extends Parse2wcnf {

    //Nutrient[] nutrients;
    //List<LinkedList<>>

    public Parse2wcnfImpl() {
        CNF cnf = new CNF();
        cnf.generateCNF();
    }

    @Override
    public void parse() {

    }

    @Override
    public String write2file() {
        String targetFilename = "";

        return targetFilename;
    }
}
