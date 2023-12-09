package presenter;

import model.Calculable;
import model.Calculator;

public class LogCalculableFactory implements ICalculableFactory {

    private Logger logger;

    public LogCalculableFactory(Logger logger) {
        this.logger = logger;
    }

    @Override
    public Calculable create(double primaryArg) {
        return new LogCalculator(new Calculator(primaryArg), logger);
    }
}