package view;

import model.Calculable;
import presenter.ICalculableFactory;

public class ViewCalculator {
    private ICalculableFactory calculableFactory;
    private InputReader inputReader;
    private OutputWriter outputWriter;

    public ViewCalculator(ICalculableFactory calculableFactory, InputReader inputReader, OutputWriter outputWriter) {
        this.calculableFactory = calculableFactory;
        this.inputReader = inputReader;
        this.outputWriter = outputWriter;
    }

    public void run() {
        while (true) {
            double primaryArg = inputReader.readDouble("Введите аргумент: ");
            Calculable calculator = calculableFactory.create(primaryArg);
            while (true) {
                String cmd = inputReader.readInput("Выберети операцию(+, -, *, /, =) : ");
                if (cmd.equals("+")) {
                    double arg = inputReader.readDouble("Введите следующий аргумент: ");
                    calculator.sum(arg);
                    continue;
                }
                if (cmd.equals("-")) {
                    double arg = inputReader.readDouble("Введите следующий аргумент: ");
                    calculator.difference(arg);
                    continue;
                }
                if (cmd.equals("*")) {
                    double arg = inputReader.readDouble("Введите следующий аргумент: ");
                    calculator.multiplication(arg);
                    continue;
                }
                if (cmd.equals("/")) {
                    double arg = inputReader.readDouble("Введите следующий аргумент: ");
                    calculator.division(arg);
                    continue;
                }
                if (cmd.equals("=")) {
                    double result = calculator.getResult();
                    double roundedResult = Math.round(result * 1000.0) / 1000.0;
                    outputWriter.writeOutput("Результат выражения: " + roundedResult);
                    break;
                }
            }
            String cmd = inputReader.readInput("Новый расчёт (Y/N)?");
            if (cmd.equalsIgnoreCase("Y")) {
                continue;
            }
            break;
        }
    }
}