package service;

public interface Parse2wcnf {
    void parse();
    String write2file();

    default String pipline() {
        parse();
        return write2file();
    }
}
