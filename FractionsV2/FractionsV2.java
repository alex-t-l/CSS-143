import java.io.*;
import java.util.*;
/**
 * Fraction program that counts how many times a fraction appears. Object Oriented Version, no arrayLists or doubles used.
 * FractionsV2
 *
 * Alex Lai
 * January 20, 2020
 */
public class FractionsV2 {
    static ObjectList fractions = new ObjectList(); //An object list of fraction objects.
    static ObjectList fractionCounters = new ObjectList(); //An object list of fraction Counters.
    /**
     * Main method, which runs the methods.
     * @param args
     */
    public static void main (String[] args) {
        readFractions();
        calculateCounts();
        printCounts();
    }

    /**
     * Reads the Fractions from a file.
     */
    public static void readFractions (){
        Scanner fileReader = null;
        try{
            fileReader = new Scanner (new FileInputStream("fractions.txt"));
        }
        catch (FileNotFoundException e){
            System.out.println("File not found, please move it to the proper spot.");
        }

        while(fileReader.hasNextLine()){
            String line = fileReader.nextLine();
            String[] nums = new String [2];
            nums = line.split("/");
            if((nums[0].charAt(0)== '-') && (nums[1].charAt(0) == '-')){ //Checks for double negatives
                String temp1 = nums[0];
                String temp2 = nums[1];
                nums[0].replace(temp1, "");
                nums[1].replace(temp2, "");
            }
            int numer = Integer.parseInt(nums[0]);
            int denom = Integer.parseInt(nums[1]);
            if (denom == 0){ //Detects if the denominator is zero.
                System.out.println(nums[0]+"/"+nums[1]+": Cannot divide by zero.");
                continue;
            }
            Fraction f = new Fraction (numer, denom);
            f.findGCD(); //Simplifies the fraction by the GCD.
            fractions.add(f);
        }
        fileReader.close();
    }

    /**
     * Calculates the counts of the fractions.
     */
    public static void calculateCounts (){
        for(int a = 0; a < fractions.size(); a++){
            boolean found = false;
            for(int i = 0; i < fractionCounters.size(); i++){
                found = found || ((FractionCounter)fractionCounters.get(i)).compareAndIncrement((Fraction)fractions.get(a));
            }
            //If the fraction is already found, it will move on from the fraction after it is incremented.
            //But if the fraction is new, it will create a new FractionCounter object with a count of one.
            if(!found){
                FractionCounter fc = new FractionCounter((Fraction)fractions.get(a));
                fractionCounters.add(fc);
            }
        }
    }

    /**
     * Prints out all the fractionCounters from the ObjectList, which outputs the fraction and its count.
     */
    public static void printCounts(){
        for(int i = 0; i < fractionCounters.size(); i++){
            System.out.println((fractionCounters.get(i).toString()));
        }
    }
}
