package uz.jl;

public class FizzBuzz {
    public String fizzBuzz(int n) {
        String response = "";
        if (n % 3 == 0) {
            response += "Fizz";
        }
        if (n % 5 == 0)
            response += "Buzz";
        return response.length() == 0 ? n + "" : response;
    }
}
