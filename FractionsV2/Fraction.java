/**
 * Represents a fraction.
 *
 * Alex Lai
 * January 20, 2020
 */
public class Fraction {
    private int n; //'n' stands for numerator
    private int d; //'d' stands for denominator
    public Fraction() {  //The default no-argument constructor
    }

    /**
     * Sets the numerator and denominator.
     * @param num numerator from the file
     * @param den denominator from the file
     */
    public Fraction(int num, int den) {
        this.n = num;
        this.d = den;
    }

    /**
     *  Reference: https://beginnersbook.com/2018/09/java-program-to-find-gcd-of-two-numbers/
     *  Divides the object's numerator and denominator by the Greatest Common Denominator given two numbers.
     */
    public void findGCD() {
        int n1= this.n;
        if(n1 < 0) {
            n1 /= -1;
        }
        int n2 = this.d;
        if(n2 < 0) {
            n2 /= -1;
        }
        while (n1 != n2) {
            if(n1 > n2) {
                n1 -= n2;
            }
            else {
                n2 -= n1;
            }
        }
        this.n /= n2;
        this.d /= n2;
    }

    /**
     * Checks if the current fraction equals another fraction.
     * @param other Another fraction object.
     * @return if this fraction equals that fraction.
     */
    public boolean equals(Fraction other) {
        if((this.n == other.getNumerator())&&(this.d == other.getDenominator())){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Gets the numerator from a fraction.
     * @return the fraction's Numerator
     */
    public int getNumerator() {
        return this.n;
    }
    /**
     * Sets the numerator of a fraction.
     * @param num inputted Fraction Numerator
     */
    public void setNumerator(int num) {
        this.n = num;
    }
    /**
     * Gets the denominator from a fraction.
     * @return the fraction's Denominator
     */
    public int getDenominator() {
        return this.d;
    }
    /**
     * Sets the denominator of a fraction.
     * @param den inputted Fraction Denominator
     */
    public void setDenominator(int den) {
        this.d = den;
    }

    @Override
    /**
     * @return the numerator and denominator of a fraction in a String.
     */
    public String toString() {
        return getNumerator()+"/"+getDenominator();
    }
}
