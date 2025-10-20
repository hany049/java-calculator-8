package calculator.controller;

import calculator.model.Calculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {
    private final Calculator calculator = new Calculator();

    public void start() {
        String string = InputView.getInput();
        int result = calculator.add(string);
        OutputView.printResult(result);
    }
}
