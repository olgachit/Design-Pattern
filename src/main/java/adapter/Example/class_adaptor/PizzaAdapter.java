package adapter.Example.class_adaptor;

public class PizzaAdapter extends adapter.Example.calculator.PizzaCalculator implements PizzaCalculator {
    @Override
    public double calculatePricePerSquareMeter(double firstSideLengthInCm, double secondSideLengthInCm, double priceInEuros) {
        double radiusEquivalent = Math.sqrt(firstSideLengthInCm * secondSideLengthInCm / Math.PI);
        double diameterEquivalent = 2 * radiusEquivalent;
        return super.calculatePricePerSquareMeter(diameterEquivalent, priceInEuros);
    }

    // no need to override round pizza method
}
