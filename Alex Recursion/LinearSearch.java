import java.util.*;
/**
 * The linear search class loops through the word array from beginning to end.
 *
 * Alex Lai
 * February 20, 2020
 */
public class LinearSearch extends SearchAlgorithm{ 
    @Override
    /**
     * Searches for the word from the beginning to end of the array until found.
     * @param w Array of words.
     * @param t target word to find.
     * @return the index where the word is in the array.
     */
    public int search(String[] words, String wordToFind) throws ItemNotFoundException{ 
        if(words.length == 0)
            throw new ItemNotFoundException("Array length of 0");
        for(int i = 0; i < words.length; i++){
            super.incrementCount();
            if(words[i].equals(wordToFind))
                return i;
        }
        throw new ItemNotFoundException("Word not found.");
    }
    @Override
     /**
     * Recursive search version for Linear search.
     * @param w Array of words.
     * @param t target word to find.
     * @return the index where the word is in the array.
     */
    public int recSearch(String[] words, String wordToFind) throws ItemNotFoundException{
        super.resetCount();
        return recSearch(0, words, wordToFind); 
    }
    
    /**
     * Method where the searching happens.
     * @param index of array
     * @param words array of words
     * @param wordToFind target word.
     * @return the index where the word is in the array.
     */
    private int recSearch(int index, String[] words,String wordToFind) throws ItemNotFoundException{
        super.incrementCount();
        if(words[index].equals(wordToFind))
        return index;
        else if (words.length == index)
        throw new ItemNotFoundException("Word not found.");
        else
        return recSearch(index++, words, wordToFind); 
        
    }
    
}

