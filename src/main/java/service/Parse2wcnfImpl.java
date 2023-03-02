package service;

import entity.Nutrient;

import java.util.LinkedList;
import java.util.List;

public class Parse2wcnfImpl extends Parse2wcnf {

    Nutrient[] nutrients;
    //List<LinkedList<>>

    public Parse2wcnfImpl(Nutrient[] nutrients) {
        this.nutrients = nutrients;
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
