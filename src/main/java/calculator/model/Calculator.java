package calculator.model;

import java.util.Arrays;

public class Calculator {

    public int add(String inputString) {
        checkBlank(inputString);

        if (inputString.startsWith("//")) {
            int customIndex = inputString.indexOf("\\n");
            if (customIndex != -1) {
                String CustomSeparator = inputString.substring(2, customIndex);
                verifyCustomSeparator(CustomSeparator);
                String remainString = inputString.substring(customIndex + 2);

                String CustomRegex = "[,:" + CustomSeparator + "]";

                String[] number = remainString.split(CustomRegex);
                return Arrays.stream(number)
                        .mapToInt(this::checkNumber)
                        .peek(this::validateNumber)
                        .sum();
            }
        }

        String[] number = inputString.split("[,:]");

        return Arrays.stream(number)
                .mapToInt(this::checkNumber)
                .peek(this::validateNumber)
                .sum();
    }

    private int checkNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력해주세요!!!");
        }
    }

    private void validateNumber(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("양수만 입력해주세요!!!");
        }
    }

    private void checkBlank(String string) {
        if (string.isBlank()) {
            throw new IllegalArgumentException("문자열을 입력해 주세요!!!");
        }
    }

    private void verifyCustomSeparator(String custom) {
        if (custom.matches(".*\\d.*")) {
            throw  new IllegalArgumentException("커스텀 구분자로 숫자를 사용할 수 없어요!!!");
        }
    }
}
