package exercise;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AppTest {
    List<Integer> numbers;

    @BeforeEach
    void initNumbersList() {
        this.numbers = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            this.numbers.add(i);
        }
    }

    @Test
    void testTake() {
        // BEGIN
        assertThat(App.take(numbers, 3))
                .isNotEmpty()
                .hasSize(3)
                .contains(1, 2, 3);
        // END
    }

    @Test
    void testTakeWithEmptyList() {
        List<Integer> emptyList = new ArrayList<>();

        assertThat(App.take(emptyList, 5))
                .isEmpty();
    }

    @Test
    void testTakeWithGreaterCount() {
        int count = 20;
        assertThat(App.take(numbers, count))
                .isNotEmpty()
                .hasSizeLessThan(count)
                .hasSize(numbers.size())
                .containsAll(numbers);
    }
}
