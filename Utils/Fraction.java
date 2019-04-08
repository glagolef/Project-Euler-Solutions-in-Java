package Project_Euler_Solutions_in_Java.Utils;

import java.math.BigDecimal;

public class Fraction{
    public int getWhole() {
        return whole;
    }

    public void setWhole(int whole) {
        this.whole = whole;
    }

    int whole;

    public BigDecimal getNumerator() {
        return numerator;
    }

    public void setNumerator(BigDecimal numerator) {
        this.numerator = numerator;
    }

    public BigDecimal getDenominator() {
        return denominator;
    }

    public void setDenominator(BigDecimal denominator) {
        this.denominator = denominator;
    }

    BigDecimal numerator, denominator;
    public Fraction (BigDecimal numerator, BigDecimal denominator){
        this.numerator = numerator;
        this.denominator = denominator;
        reduceToGCD();
    }
    public Fraction (int whole, BigDecimal numerator, BigDecimal denominator){
        this(numerator.add(denominator.multiply(new BigDecimal( whole))), denominator);
    }
    void reduceToGCD(){
        BigDecimal gcd = Util.getGCD(numerator, denominator);
        numerator = numerator.divide( gcd);
        denominator = denominator.divide( gcd);
    }
    public String toString(){
        return whole == 0 ? numerator.toString() + "/" + denominator.toString() : whole + " " + numerator.toString() + "/" + denominator.toString() ;
    }
    public Fraction clone(){
        return new Fraction(this.numerator, this.denominator);
    }
}
