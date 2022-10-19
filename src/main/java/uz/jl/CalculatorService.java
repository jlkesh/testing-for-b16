package uz.jl;

public class CalculatorService {

    public int add(int a, int b) {
        System.out.println("Add method called");
        return a + b;
    }

    public double div(int a, int b) {
        System.out.println("dfglkfdngjkfdb");
        if (b != 0) {
            return (double) a / b;
        }
        throw new RuntimeException("Divider can not be zero");
    }
}
