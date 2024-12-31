import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;
import java.util.stream.Gatherer;

public class GathererChthonic implements Gatherer<CreatureChthonic, AtomicInteger, CreatureChthonic> {

    // The category of creatures to skip while gathering
    private final String categoryToSkip;
    // The number of creatures to skip from the specified category
    private final int skipCount;
    // The current count of gathered creatures
    private int count;
    // The total number of creatures to gather
    private final int total;

    /**
     * Initializes a new GathererChthonic with the given parameters.
     *
     * @param categoryToSkip The category of creatures to skip
     * @param skipCount The number of creatures to skip from the specified category
     * @param total The total number of creatures to gather
     */
    public GathererChthonic(String categoryToSkip, int skipCount, int total) {
        this.categoryToSkip = categoryToSkip;
        this.skipCount = skipCount;
        this.count = 0;
        this.total = total;
    }

    /**
     * Provides the initial state of the gatherer, which is an AtomicInteger (counter).
     *
     * @return A supplier that provides a new AtomicInteger instance
     */
    @Override
    public Supplier<AtomicInteger> initializer() {
        return AtomicInteger::new;
    }

    /**
     * The integration function that defines how elements are accumulated in the state.
     * It checks if the current creature belongs to the category to skip and whether
     * it should be skipped or gathered.
     *
     * @return The integrator function that integrates elements into the state
     */
    @Override
    public Integrator<AtomicInteger, CreatureChthonic, CreatureChthonic> integrator() {
        return (state, element, downstream) -> {
            // Skip creatures from the specified category until the skipCount is reached
            if (element.getCategory().equalsIgnoreCase(categoryToSkip) && state.get() < skipCount) {
                state.incrementAndGet();
                return true;
            } else if (count < total) { // Gather the creature if the total count is not reached
                count += 1;
                return downstream.push(element);
            }
            return false; // Stop processing if the total count is reached
        };
    }

    /**
     * Combines the states of two gatherers.
     *
     * @return A binary operator that combines two AtomicInteger states
     */
    @Override
    public BinaryOperator<AtomicInteger> combiner() {
        return Gatherer.super.combiner();
    }

    /**
     * Finishes the gathering process by processing the final state.
     *
     * @return A BiConsumer that consumes the final state and downstream collector
     */
    @Override
    public BiConsumer<AtomicInteger, Downstream<? super CreatureChthonic>> finisher() {
        return Gatherer.super.finisher();
    }

    /**
     * Creates a new gatherer that performs additional operations after this one.
     *
     * @param that The next gatherer to chain with
     * @return A new gatherer that applies both this and the provided gatherer
     */
    @Override
    public <RR> Gatherer<CreatureChthonic, ?, RR> andThen(Gatherer<? super CreatureChthonic, ?, ? extends RR> that) {
        return Gatherer.super.andThen(that);
    }
}
