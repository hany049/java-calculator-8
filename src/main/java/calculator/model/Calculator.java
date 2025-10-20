package calculator.model;

import java.util.Arrays;

public class Calculator {

    public int add(String inputString) {

        if (inputString.startsWith("//")) {
            int customIndex = inputString.indexOf("\\n");
            if (customIndex != -1) {
                String CustomSeparator = inputString.substring(2, customIndex);
                String remainString = inputString.substring(customIndex + 2);

                String CustomRegex = "[,:" + CustomSeparator + "]";

                String[] number = remainString.split(CustomRegex);
                return Arrays.stream(number).mapToInt(Integer::parseInt).sum();
            }
        }

        String[] number = inputString.split("[,:]");

        return Arrays.stream(number).mapToInt(Integer::parseInt).sum();
    }
}
