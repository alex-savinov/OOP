package model;


import presenter.ICalculableFactory;

public class CalculableFactory implements ICalculableFactory {
    public Calculable create(double primaryArg) {
        return new Calculator(primaryArg);
    }
}