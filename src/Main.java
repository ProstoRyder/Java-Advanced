import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        // Initialize scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Request user input for number of entities to exclude (N)
        System.out.print("Введіть кількість сутностей для виключення (N): ");
        final int N = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character

        // Request user input for category of entities to exclude
        System.out.print("Вкажіть категорію сутності для виключення (Цербер, Харон, Мінатор, Ліхі, Титани): ");
        final String category = scanner.nextLine();

        // Request user input for the start year for filtering
        System.out.print("Введіть початковий рік для фільтрації (1500-2000 роки): ");
        final int startYear = scanner.nextInt();

        // Request user input for the end year for filtering
        System.out.print("Введіть кінцевий рік для фільтрації (1500-2000 роки): ");
        final int endYear = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character
        scanner.close();  // Close the scanner

        // Generate a list of chthonic creatures based on the input and filtering criteria
        List<CreatureChthonic> entities = CreatureGeneratorChthonic.generate()
                .gather(new GathererChthonic(category, N, 500))  // Apply the gatherer to filter and collect entities
                .toList();  // Collect the results into a list

        // Print the filtered and grouped entities by category and year
        System.out.println("Фільтровані та згруповані сутності за типом та роком: ");
        Map<String, List<CreatureChthonic>> filteredEntities = entities.stream()
                .filter(entity -> {
                    // Filter by year of first appearance
                    int firstAppearanceYear = entity.getFirstMention().getYear();
                    return (firstAppearanceYear >= startYear) && (firstAppearanceYear <= endYear);
                })
                .collect(Collectors.groupingBy(CreatureChthonic::getCategory));  // Group by category
        System.out.println(filteredEntities + "\n");

        // Create a Statistics object to calculate and print statistics
        Statistics statistics = new Statistics();
        statistics.calculateStatistics(entities);  // Calculate statistics for the entities
        System.out.println("Статистика: " + statistics);

        // Analyze outliers and print the results
        Map<String, Long> outliers = statistics.analyzeOutliers(entities);  // Find outliers in the data
        System.out.println("Outliers: " + outliers);
    }
}
