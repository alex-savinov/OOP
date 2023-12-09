package presenter;

import model.Calculable;

public class LogCalculator implements Calculable {

    private Calculable calculable;
    private Logger logger;

    public LogCalculator(Calculable calculable, Logger logger) {
        this.calculable = calculable;
        this.logger = logger;
        logger.writeLog("Первый аргумент: " + calculable.getResult());
    }

    @Override
    public Calculable sum(double arg) {
        logger.writeLog("Слагаемое: " + arg);
        return calculable.sum(arg);
    }

    @Override
    public Calculable difference(double arg) {
        logger.writeLog("Вычитаемое: " + arg);
        return calculable.difference(arg);
    }

    @Override
    public Calculable multiplication(double arg) {
        logger.writeLog("Множитель: " + arg);
        return calculable.multiplication(arg);
    }

    @Override
    public Calculable division(double arg) {
        logger.writeLog("Делитель: " + arg);
        return calculable.division(arg);
    }

    @Override
    public double getResult() {
        double result = calculable.getResult();
        double roundedResult = Math.round(result * 1000.0) / 1000.0;
        logger.writeLog("Результат выражения: " + roundedResult);
        return result;
    }
}