package adapter.Example.object_adaptor;

public class PizzaAdapter implements PizzaCalculator {
    private adapter.Example.calculator.PizzaCalculator calculator;

    public PizzaAdapter(adapter.Example.calculator.PizzaCalculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public double calculatePricePerSquareMeter(double firstSideLengthInCm, double secondSideLengthInCm, double priceInEuros) {
        double radiusEquivalent = Math.sqrt(firstSideLengthInCm * secondSideLengthInCm / Math.PI);
        double diameterEquivalent = 2 * radiusEquivalent;
        return calculator.calculatePricePerSquareMeter(diameterEquivalent, priceInEuros);
    }

    @Override
    public double calculatePricePerSquareMeter(double diameterInCm, double priceInEuros) {
        return calculator.calculatePricePerSquareMeter(diameterInCm, priceInEuros);
    }
}
