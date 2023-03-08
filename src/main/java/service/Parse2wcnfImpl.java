package service;

import entity.Nutrient;
import test.CNF;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Parse2wcnfImpl extends Parse2wcnf {

    //Nutrient[] nutrients;
    //List<LinkedList<>>

    public Parse2wcnfImpl() {

    }

    @Override
    public void parse() throws IOException {
        String targetFilename = "src/main/resources/what2eatParsedFormula.wcnf";
        CNF cnf = new CNF();
        cnf.generateCNF(targetFilename);
    }

    @Override
    public String write2file() {
        String targetFilename = "src/main/resources/what2eatParsedFormula.wcnf";

        return targetFilename;
    }
}
