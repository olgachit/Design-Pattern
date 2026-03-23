package adapter.Example.object_adaptor;

public interface PizzaCalculator {
    double calculatePricePerSquareMeter(double firstSideLengthInCm, double secondSideLengthInCm, double priceInEuros);
    double calculatePricePerSquareMeter(double diameterInCm, double priceInEuros);
}
