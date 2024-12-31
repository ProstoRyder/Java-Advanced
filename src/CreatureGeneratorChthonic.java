import java.time.LocalDate;
import java.util.Random;
import java.util.stream.Stream;

/**
 * This class generates random instances of chthonic creatures with various attributes.
 * It uses predefined categories and random values for the creature's name, first mention date, and attack power.
 */
public class CreatureGeneratorChthonic {

    // Random instance used for generating random values
    private static final Random RANDOM = new Random();

    // Array of predefined chthonic creature categories
    private static final String[] CATEGORYS = {"Цербер", "Харон", "Мінатор", "Ліхі", "Титани"};

    /**
     * Generates a stream of random chthonic creatures.
     * Each creature is created with a random name, category, first mention date, and attack power.
     *
     * @return a Stream of randomly generated CreatureChthonic instances
     */
    public static Stream<CreatureChthonic> generate() {
        return Stream.generate(() -> new CreatureChthonic(
                // Random name generation with a unique identifier
                "Xтонічнa істотa" + RANDOM.nextInt(1000),

                // Randomly selecting a category from the predefined list
                CATEGORYS[RANDOM.nextInt(CATEGORYS.length)],

                // Randomly generating a first mention date between 1500 and 2000
                LocalDate.of(
                        1500 + RANDOM.nextInt(500), // Year between 1500 and 2000
                        1 + RANDOM.nextInt(12), // Month between 1 and 12
                        1 + RANDOM.nextInt(28)  // Day between 1 and 28 (to avoid invalid dates)
                ),

                // Random attack power between 1 and 100
                1 + RANDOM.nextInt(100)
        ));
    }
}
