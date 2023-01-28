package by.it.cherny.calc.entity;

import by.it.cherny.calc.exception.CalcException;

public class Scalar extends Var {
    private final double value;

    public Scalar(double value) {
        this.value = value;
    }
    public Scalar(String strScalar) {
        this.value = Double.parseDouble(strScalar);
    }
    public Scalar(Scalar scalar){
        this.value =scalar.value;
    }

    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar second){
            return new Scalar(this.value + second.value);
        }
        return other.add(this);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar second){
            return new Scalar(this.value - second.value);
        }
        Scalar minus = new Scalar(-1);
        return minus.mul(other.add(this));
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar second){
            return new Scalar(this.value * second.value);
        }
        return other.mul(this);
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar second){
            if (second.value == 0){
                throw new CalcException("division by zero");
            }
            return new Scalar(this.value / second.value);
        }
        // smth wrong
        return super.div(other);
    }

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
