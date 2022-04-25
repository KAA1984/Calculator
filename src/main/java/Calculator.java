import java.text.DecimalFormat;
import java.util.InputMismatchException;

public class Calculator {

    //private String operation;

    public String calculate(int first, int second , String operation) {

        //String result = String.valueOf(calculationStep(first, second,operation));

        //return String.valueOf(result);
        double result = calculationStep(first, second,operation);

        return new DecimalFormat("#,##0.00").format(result);
    }

    public double calculationStep(int first, int second, String operation) throws InputMismatchException {

        return performOperation( first, second, operation);
    }


    private double performOperation(int firstNumber, int secondNumber,String operation) {
        double result;
        switch (operation){
            case "+":
                result = plus(firstNumber, secondNumber);
                break;
            case "-":
                result = minus(firstNumber, secondNumber);
                break;
            case "*":
                result = multiply(firstNumber, secondNumber);
                break;
            case "/":
                result = division(firstNumber, secondNumber);
                break;
            default:
                result = 0;
                break;
        }
        return result;
    }
    private int plus(int numberOne, int numberTwo){
        return numberOne + numberTwo;
    }
    private int minus(int numberOne, int numberTwo){
        return numberOne - numberTwo;
    }
    private double multiply(int numberOne, double numberTwo){
        return numberOne * numberTwo;
    }
    private double division(int numberOne, double numberTwo){
        if (numberTwo == 0) {
            throw new IllegalArgumentException("I can not divide by 0.");
        }
        return numberOne / numberTwo;
    }
}
