package by.it.yaroshevich.jd01_09;

public class ConsoleOutput implements Output{

    @Override
    public void showResult(Var var) {
        System.out.println(var);

    }
}