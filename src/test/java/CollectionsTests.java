import com.dailyDev.collections.HandleNullValues;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class CollectionsTests {
    @Test
    void givenList_whenNullValueAdded_doesNotFail() {

        Integer[] numbersArray = {null, 0, 1, null, 2, 3, null};
        List<Integer> numbers = Arrays.asList(numbersArray);
        Long count = HandleNullValues.countNulls.apply(numbers);

        assertEquals(3, count);

        // accessing null from a list
        assertNull(numbers.getFirst());

        // performing actions on a null values, should return NullPointerException
        assertThrows(NullPointerException.class,() -> numbers.getFirst().toString());
    }

    @Test
    void givenHashSet_whenNullValueAdded_doesNotFail(){
        Integer[] numberArray = { null, 0, 1, null, 2, 3, null };
        Set<Integer> numbers = new HashSet<>(Arrays.asList(numberArray));
        assertEquals(1,HandleNullValues.countNulls.apply(numbers));

        // accessing null values from HashSet
        assertTrue(numbers.contains(null));

        // performing actions on a null values, should return NullPointerException
        assertThrows(NullPointerException.class, () -> numbers.forEach(Object::toString));
    }
}
