package presenter;

import model.Calculable;

public interface ICalculableFactory {
    Calculable create(double primaryArg);
}