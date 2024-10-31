package converter;

public class CurrencyConverter {

        private double bynToEur;
        private double bynToUsd;
        private double bynToPl;
        private double bynToRub;

    public CurrencyConverter(double bynToEur, double bynToUsd, double bynToPl, double bynToRub) {
        this.bynToEur = bynToEur;
        this.bynToUsd = bynToUsd;
        this.bynToPl = bynToPl;
        this.bynToRub = bynToRub;
    }

    public double convertBynToEur(double amount) {
            return amount * bynToEur;
        }

        public double convertBynToUsd(double amount) {
            return amount * bynToUsd;
        }

        public double convertBynToPl(double amount) {
            return amount * bynToPl;
        }

        public double convertBynToRub(double amount) {
            return amount * bynToRub;
        }
    }

