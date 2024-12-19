import com.dailyDev.collections.HandleNullValues;
import org.junit.jupiter.api.Test;

import java.util.*;

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

    @Test
    void givenTreeSet_whenNullValueAdded_mightFail(){
        Integer[] numberArray = { null, 0, 1, null, 2, 3, null };
        assertThrows(NullPointerException.class, ()-> new TreeSet<>(Arrays.asList(numberArray)));
    }

    @Test
    void givenHashMap_whenNullKeyValueAdded_doesNotFail(){
        Integer[] numberArray = { null, 0, 1, null, 2, 3, null };
        Map<Integer,Integer> numbers = new HashMap<>();
        Arrays.stream(numberArray).forEach(integer -> numbers.put(integer,integer));

        assertTrue(numbers.containsKey(null));
        assertTrue(numbers.containsValue(null));
        assertNull(numbers.get(null));

        assertThrows(NullPointerException.class, () -> numbers.get(null).toString());
    }
}
