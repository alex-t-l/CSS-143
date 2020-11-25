
/**
 * Performs binary search on our array to find our object.
 *
 * Alex Lai
 * February 20, 2020
 */
public class BinarySearch extends SearchAlgorithm{ 
    @Override
    /**
     * Searches for the word from the beginning to end of the array using binary search.
     * @param w Array of words.
     * @param t target word to find.
     * @return the index where the word is in the array.
     */
    public int search(String[] words, String wordToFind) throws ItemNotFoundException{ 
        super.resetCount();
        int lowIndex = 0, highIndex = words.length - 1, midIndex;
        while(lowIndex <= highIndex){
            super.incrementCount();
            midIndex = (lowIndex + highIndex) / 2;
            if(words[midIndex].equals(wordToFind))
                return midIndex;
            if(wordToFind.compareTo(words[midIndex]) < 0) //If negative, remove right side of array.
                highIndex = midIndex - 1;
            if(wordToFind.compareTo(words[midIndex]) > 0) //If positive, remove left side of array.
                lowIndex = midIndex + 1;
        }
        throw new ItemNotFoundException("Word not found.");
    }

    @Override
    /**
     * Recursive search version for Binary search.
     * @param w Array of words.
     * @param t target word to find.
     * @return the index where the word is in the array.
     */
    public int recSearch(String[] words, String wordToFind) throws ItemNotFoundException{
        return recSearch(words, 0, words.length-1, wordToFind);
    }

    /**
     * Method where the binary searching happens recursively.
     * @param words array of words
     * @param lowIndex left index.
     * @param highIndex right index.
     * @param wordtoFind target word.
     * @return the index where the word is in the array.
     */
    private int recSearch(String[] words, int lowIndex, int highIndex, String wordToFind) throws ItemNotFoundException{
        int midIndex = (lowIndex + highIndex) / 2;
        if(lowIndex <= highIndex){
            super.incrementCount();
            if(words[midIndex].equals(wordToFind))
                return midIndex;
            if(wordToFind.compareTo(words[midIndex]) < 0) //If negative, remove right side of array.
                return recSearch(words, lowIndex, midIndex - 1, wordToFind);
            if(wordToFind.compareTo(words[midIndex]) > 0) //If positive, remove left side of array.
                return recSearch(words, midIndex + 1, highIndex, wordToFind);
        }
        else{
        throw new ItemNotFoundException("Word not found.");
    }
    return -1;
    }
}
