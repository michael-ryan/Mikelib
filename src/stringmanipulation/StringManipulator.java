package stringmanipulation;

import java.util.*;

/**
 * Static class for manipulating strings
 */
@SuppressWarnings("unused")
public final class StringManipulator {

    /**
     * Don't let anyone instantiate this class
     */
    private StringManipulator(){
    }

    /**
     * Sorts a string by its constituent char values
     *
     * @param string the string to sort
     * @return the sorted string
     */
    public static String sort(String string){
        char[] chars = string.toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars);
    }

    public static void main(String[] args){
        StringManipulator.shuffle("abc");
    }

    /**
     * Randomises the order of characters in a given string.
     *
     * @param string the string to randomise the order of
     * @return the given string, with its characters in a random order
     */
    public static String shuffle(String string){
        char[] chars = string.toCharArray();
        List<Integer> freePlaces = new ArrayList<>();
        for(int i = 0; i < chars.length; i++){
            freePlaces.add(i);
        }

        Random random = new Random(new Date().getTime());

        char[] newChars = new char[chars.length];

        for(char c : chars){
            int randomIndex = freePlaces.remove(random.nextInt(freePlaces.size()));
            newChars[randomIndex] = c;
        }

        return String.valueOf(newChars);
    }
}
