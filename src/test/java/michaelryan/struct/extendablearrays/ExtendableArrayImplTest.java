package michaelryan.struct.extendablearrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExtendableArrayImplTest {

    private ExtendableArray<String> extendableArray;

    @BeforeEach
    void setUp(){
        extendableArray = new ExtendableArrayImpl<>();
    }

    @Test
    void shouldReturnSameItemWhenSingleItemStored(){
        extendableArray.add("test string");
        assertEquals("test string", extendableArray.get(0));
    }

    @Test
    void shouldReturnSameItemsWhenManyItemsStored(){
        String[] testStrings = new String[]{"one", "two", "three"};
        for(String testString : testStrings){
            extendableArray.add(testString);
        }

        String[] returnedStrings = new String[testStrings.length];

        for(int i = 0; i < testStrings.length; i++){
            returnedStrings[i] = extendableArray.get(i);
        }

        assertArrayEquals(testStrings, returnedStrings);
    }

    @Test
    void shouldReplaceItem(){
        extendableArray.add("test string one");
        extendableArray.add("test string two");
        extendableArray.replace(1, "test string three");
        assertEquals("test string three", extendableArray.get(1));
    }

    @Test
    void shouldThrowWhenRetrievingWithNegativeIndex(){
        populate(5);
        assertThrows(IndexOutOfBoundsException.class, () -> extendableArray.get(-1));
    }

    private void populate(int itemCount){
        for(int i = 1; i <= itemCount; i++){
            extendableArray.add("test string " + i);
        }
    }

    @Test
    void shouldThrowWhenRetrievingWithIndexTooLarge(){
        int itemCount = 10;
        populate(itemCount);
        assertThrows(IndexOutOfBoundsException.class, () -> extendableArray.get(itemCount));
        assertThrows(IndexOutOfBoundsException.class, () -> extendableArray.get(itemCount + 1));
    }

    @Test
    void shouldAddAtIndex(){
        int itemCount = 2; // don't change
        populate(itemCount);
        extendableArray.add(1, "different string");
        String[] expectedStrings = new String[]{"test string 1", "different string", "test string 2"};
        String[] actualStrings = new String[itemCount + 1];

        for(int i = 0; i < itemCount + 1; i++){
            actualStrings[i] = extendableArray.get(i);
        }

        assertArrayEquals(expectedStrings, actualStrings);
    }

    @Test
    void shouldRemoveItem(){
        populate(3);
        extendableArray.remove(1);
        String[] expectedStrings = new String[]{"test string 1", "test string 3"};
        assertArrayEquals(expectedStrings, extendableArray.toArray());
    }

    @Test
    void shouldReturnItemCountOfZeroWhenNew(){
        assertEquals(0, extendableArray.itemCount());
    }

    @Test
    void shouldReturnCorrectItemCountWhenItemsAdded(){
        int expectedItemCount = 5;
        populate(expectedItemCount);
        assertEquals(expectedItemCount, extendableArray.itemCount());
    }

    @Test
    void shouldBeEmptyWhenNew(){
        assertTrue(extendableArray.isEmpty());
    }

    @Test
    void shouldNotBeEmptyWhenItemsAdded(){
        populate(5);
        assertFalse(extendableArray.isEmpty());
    }

    @Test
    void shouldBeEmptyWhenItemsAddedThenRemoved(){
        populate(2);
        extendableArray.remove(1);
        extendableArray.remove(0);
        assertTrue(extendableArray.isEmpty());
    }

    @Test
    void shouldBeEqualToArrayRepresentation(){
        populate(3);
        String[] expectedStrings = new String[]{"test string 1", "test string 2", "test string 3"};
        assertArrayEquals(expectedStrings, extendableArray.toArray());
    }

    @Test
    void shouldNotChangeWhenArrayRepresentationEdited(){
        populate(2);
        Object[] returnedArray = extendableArray.toArray();
        String[] data = new String[returnedArray.length];
        for(int i = 0; i < returnedArray.length; i++){
            data[i] = (String) returnedArray[i];
        }
        data[0] = "some new string";
        assertEquals("test string 1", extendableArray.get(0));
    }
}