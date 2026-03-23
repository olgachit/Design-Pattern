package adapter.Example.class_adaptor;

public interface PizzaCalculator {
    double calculatePricePerSquareMeter(double firstSideLengthInCm, double secondSideLengthInCm, double priceInEuros);
    double calculatePricePerSquareMeter(double diameterInCm, double priceInEuros);
}
