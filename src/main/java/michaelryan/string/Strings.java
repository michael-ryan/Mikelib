package michaelryan.string;

import java.util.*;

/**
 * Static class for manipulating strings
 */
@SuppressWarnings("unused")
public final class Strings {

    /**
     * Don't let anyone instantiate this class
     */
    private Strings(){
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

    /**
     * Returns a random character contained by the given string. If there are duplicate characters, a roulette
     * selection is performed, where selection probability is directly proportional to frequency.
     *
     * @param string the string to retrieve a random character from
     * @return a random character contained by the given string
     */
    public static char randomCharacter(String string){
        return string.toCharArray()[new Random(new Date().getTime()).nextInt(string.toCharArray().length)];
    }

    public static boolean isPalindrome(String string){
        int length = string.length();

        for(int i = 0; i < Math.floorDiv(length, 2); i++){
            if(string.charAt(i) != string.charAt(length - i - 1)){
                return false;
            }
        }

        return true;
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
