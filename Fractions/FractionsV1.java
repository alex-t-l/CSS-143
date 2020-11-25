import java.io.*;
import java.util.*;
/**
 * Fraction program that counts how many times a fraction appears. Doubles and ArrayLists were NOT used.
 * FractionsV1
 *
 * Alex Lai
 * January 5, 2020
 */
public class FractionsV1
{
    /**
     * Main method, which prints out the count of the fractions.
     * @param args
     */
    public static void main (String[] args){
        Scanner fileReader = null; 
        Scanner countFractions = null;
        try{
            fileReader = new Scanner (new FileInputStream("fractions.txt"));
        }
        catch (FileNotFoundException e){
            System.out.println("File not found, please move it to the proper spot.");
        }
        //countLines counts how many fractions in the file
        int numOfFractions = countLines(countFractions);
        //Stores the fractions in String format.
        String[] fractions = new String [numOfFractions];
        //theActualFraction stores the numerator and denominator from the file in int format.
        int[][] theActualFraction = new int [2][numOfFractions];
        //The counter array has three rows: numerator, denominator, and count, respectively.
        int[][] counter= new int [3][numOfFractions];
        for(int a = 0; a < 3; a++){
            for(int b = 0; b < numOfFractions; b++){
                counter[a][b] = 0; //Fills up the counter array with zeroes.
            }
        }

        int fracindex = 0; //Will eventually go through all the fractions
        //this while loop will go through all the fractions and simplify them using the GCD finder.
        while(fileReader.hasNextLine()){
            String line = fileReader.nextLine();
            String[] nums = new String [2];
            nums = line.split("/");
            int numer = Integer.parseInt(nums[0]);
            int denom = Integer.parseInt(nums[1]);
            if (denom == 0){
                System.out.println("Cannot divide by zero.");
            }
            int gcd = findGCD(numer, denom);
            theActualFraction[0][fracindex] = numer/= gcd;
            theActualFraction[1][fracindex] = denom/= gcd;

            fractions [fracindex] = line;
            fracindex++;

        }
        fileReader.close();

        counter[0][0] = theActualFraction[0][0];
        counter[1][0] = theActualFraction[1][0];
        counter[2][0] = 1;
        int uf = 1; //unique fractions counter.
        
        //This for loop will increment the counter array, the boolean found will signal if they need to increment or not.
        //If a new fraction is found that has never been encountered before, it will go through counter and add the fraction, with count.
        for(int j = 1; j< numOfFractions; j++){
            boolean found = false;
            for(int h = 0; h < uf; h++){
                if((theActualFraction[0][j]==counter[0][h])&&((theActualFraction[1][j]==counter[1][h]))){
                    counter[2][h]++;
                    found = true;
                }

            }
            if(!found){
                for(int s=0; s < uf; s++){
                    while(counter[1][s]!=0){ 
                        s++;
                    }
                    counter[0][s] = theActualFraction[0][j];
                    counter[1][s] = theActualFraction[1][j];
                    counter[2][s] = 1;
                    uf++;
                }
            }
        }
        
        //Prints out the count of the fractions.
        for(int z = 0; z < uf; z++){
            System.out.print(counter[0][z]+"/"+counter[1][z]+" has a count of "+counter[2][z]);
            System.out.println();
        }

    }

    /**
     * Counts how many lines are in the fractions.txt file.
     * @param countFractions scanner that counts the lines in the file
     * @return how many lines are in the file.
     */

    public static int countLines(Scanner countFractions){
        try{
            countFractions = new Scanner (new FileInputStream("fractions.txt"));
        }
        catch(FileNotFoundException e){
            System.out.println("File not found");
        }
        int count = 0;
        while(countFractions.hasNextLine()){
            count++;
            countFractions.nextLine();
        }
        countFractions.close();
        return count;
    }

    /**
     *  Reference: https://beginnersbook.com/2018/09/java-program-to-find-gcd-of-two-numbers/
     *  Gets the Greatest Common Denominator given two numbers.¨
     *  @param n numerator
     *  @param d denominator
     *  @return greatest common denominator of n and d
     */
    public static int findGCD(int n, int d){
        int n1 = n;
        if(n1 < 0) {
            n1 /= -1;
        }
        int n2 = d;
        if(n2 < 0) {
            n2 /= -1;
        }
        while (n1 != n2) { //Keeps simplifying until they find common denominators
            if(n1 > n2) {
                n1 -= n2;
            }
            else {
                n2 -= n1;
            }
        }
        return n2;
    }

}