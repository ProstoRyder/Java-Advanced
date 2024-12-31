import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Statistics {

    // The minimum attack power in the list of creatures
    private double min;
    // The maximum attack power in the list of creatures
    private double max;
    // The average attack power of the creatures
    private double average;
    // The standard deviation of the attack power values
    private double standardDeviation;

    /**
     * Calculates the basic statistics (min, max, average, and standard deviation) for the given list of creatures.
     *
     * @param creatures The list of creatures whose statistics will be calculated
     */
    public void calculateStatistics(List<CreatureChthonic> creatures) {
        // Summarize the attack powers of the creatures to calculate min, max, and average
        DoubleSummaryStatistics stats = creatures.stream()
                .collect(Collectors.summarizingDouble(CreatureChthonic::getAttackPower));

        this.min = stats.getMin();
        this.max = stats.getMax();
        this.average = stats.getAverage();

        // Calculate the standard deviation manually by computing variance first
        double variance = creatures.stream()
                .mapToDouble(c -> Math.pow(c.getAttackPower() - average, 2))
                .average()
                .orElse(0.0);
        this.standardDeviation = Math.sqrt(variance);
    }

    /**
     * Analyzes the attack powers of the creatures to identify outliers based on the Interquartile Range (IQR).
     *
     * @param creatures The list of creatures to analyze
     * @return A map containing the count of inliers ("data") and outliers ("outliers")
     */
    public Map<String, Long> analyzeOutliers(List<CreatureChthonic> creatures) {
        // Sort the attack powers and calculate Q1, Q3, and IQR (Interquartile Range)
        List<Integer> sortedAttackPowers = creatures.stream()
                .map(CreatureChthonic::getAttackPower)
                .sorted()
                .collect(Collectors.toList());

        // Calculate the first quartile (Q1) and third quartile (Q3)
        int q1 = sortedAttackPowers.get(sortedAttackPowers.size() / 4);
        int q3 = sortedAttackPowers.get(3 * sortedAttackPowers.size() / 4);
        int iqr = q3 - q1;

        // Calculate the lower and upper bounds for outlier detection
        int lowerBound = q1 - (int) (1.5 * iqr);
        int upperBound = q3 + (int) (1.5 * iqr);

        // Partition the creatures into inliers and outliers based on the bounds
        Map<Boolean, Long> grouped = creatures.stream()
                .collect(Collectors.partitioningBy(
                        c -> c.getAttackPower() >= lowerBound && c.getAttackPower() <= upperBound,
                        Collectors.counting()
                ));

        // Return the counts of inliers and outliers
        return Map.of(
                "data", grouped.get(true),
                "outliers", grouped.get(false)
        );
    }

    /**
     * Creates a custom collector to calculate statistics for a list of creatures.
     *
     * @return A custom collector that collects statistics for a list of creatures
     */
    public static Collector<CreatureChthonic, ?, Statistics> collector() {
        return Collector.of(
                Statistics::new, // Supplier: Create a new Statistics object
                (stats, creature) -> stats.calculateStatistics(List.of(creature)), // Accumulator: Accumulate statistics for each creature
                (left, right) -> {
                    left.calculateStatistics(List.of()); // Combine the statistics of two collectors (this needs further improvement)
                    return left;
                }
        );
    }

    /**
     * Returns a string representation of the calculated statistics.
     *
     * @return A string containing the min, max, average, and standard deviation of attack powers
     */
    @Override
    public String toString() {
        return String.format("Мін: %.2f, Макс: %.2f, Середнє: %.2f, Стан відх: %.2f",
                min, max, average, standardDeviation);
    }
}
