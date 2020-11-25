/**
 * FractionCounter keeps track of how many times a fraction appears.
 *
 * Alex Lai
 * January 20, 2020
 */
public class FractionCounter {
    private int counter = 1; //Counter starts at 1 because if it exists, it will start at 1.
    private Fraction fraction; //the Fraction itself.

    /**
     * Sets the fraction to a fraction.
     * @param theFraction the fraction where the counter is kept track.
     */
    public FractionCounter(Fraction theFraction) {
        fraction = theFraction;
    }

    /**
     * Compares two fractions and returns if they are the same.
     * @param newFraction another Fraction, which you compare this one to.
     * @return True if the two fractions match, false if the fractions differ.
     */
    public boolean compareAndIncrement(Fraction newFraction){

        if(fraction.equals(newFraction)){
            counter++;
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Prints out the count of a fraction in a String.
     * @return the count of a fraction in a String.
     */
    @Override
    public String toString() {
        return this.fraction.getNumerator()+"/"+this.fraction.getDenominator()+" has a count of " + this.counter;
    }
}
