import com.dailyDev.collections.HandleNullValues;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class CollectionsTests {
    @Test
    void givenList_whenNullValueAdded_doesNotFail() {

        Integer[] numbersArray = {null, 0, 1, null, 2, 3, null};
        List<Integer> numbers = Arrays.asList(numbersArray);
        Long count = HandleNullValues.countNulls.apply(numbers);

        assertEquals(3, count);

        // accessing null from a list
        assertNull(numbers.getFirst());
    }
}
