package michaelryan.string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringsTest {

    @Test
    void shouldSortCorrectly(){
        String expected = "abc";
        assertEquals(expected, Strings.sort("bca"));
    }

    @Test
    void shouldReturnCharacterInGivenStringWhenRandomCharacterRequested(){
        String source = "abcdefg";
        String randomChar = new String(new char[]{Strings.randomCharacter(source)});
        assertTrue(source.contains(randomChar));
    }

    @Test
    void shouldRecognisePalindrome(){
        assertTrue(Strings.isPalindrome("abba"));
    }

    @Test
    void shouldRecogniseNotPalindrome(){
        assertFalse(Strings.isPalindrome("not a palindrome"));
    }

    @Test
    void shouldShuffleStringCorrectly(){
        String source = "abc";
        String result = Strings.shuffle(source);

        if(!result.equals("abc") && !result.equals("acb") && !result.equals("bac") && !result.equals("bca") &&
                !result.equals("cab") && !result.equals("cba")){
            fail("Shuffled string is returning non expected data: " + result + " from " + source);
        }
    }
}