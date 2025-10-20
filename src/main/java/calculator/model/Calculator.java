package calculator.model;

import java.util.Arrays;

public class Calculator {

    public int add(String inputString) {

        String[] number = inputString.split("[,:]");

        return Arrays.stream(number).mapToInt(Integer::parseInt).sum();
    }
}
