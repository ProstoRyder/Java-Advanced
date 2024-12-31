import java.time.LocalDate;

/**
 * Represents a chthonic creature with specific attributes like name, category, first mention date, and attack power.
 * A chthonic creature typically refers to mythical beings associated with the underworld or dark forces.
 */
public class CreatureChthonic {

    private String name;  // The name of the chthonic creature
    private String category;  // The category/type of the chthonic creature
    private LocalDate firstMention;  // The date when the creature was first mentioned in history or mythology
    private int attackPower;  // The attack power of the creature (a numerical representation of its strength)

    /**
     * Retrieves the name of the chthonic creature.
     *
     * @return the name of the creature
     */
    public String getName() {
        return name;
    }

    /**
     * Retrieves the category of the chthonic creature.
     *
     * @return the category of the creature
     */
    public String getCategory() {
        return category;
    }

    /**
     * Retrieves the first mention date of the chthonic creature.
     *
     * @return the date when the creature was first mentioned
     */
    public LocalDate getFirstMention() {
        return firstMention;
    }

    /**
     * Retrieves the attack power of the chthonic creature.
     *
     * @return the attack power of the creature
     */
    public int getAttackPower() {
        return attackPower;
    }

    /**
     * Constructs a new chthonic creature with the specified name, category, first mention date, and attack power.
     *
     * @param name the name of the creature
     * @param category the category of the creature (e.g., Demon, Vampire)
     * @param firstMention the first mention date of the creature in history or mythology
     * @param attackPower the attack power of the creature
     */
    public CreatureChthonic(String name, String category, LocalDate firstMention, int attackPower) {
        this.name = name;
        this.category = category;
        this.firstMention = firstMention;
        this.attackPower = attackPower;
    }

    /**
     * Returns a string representation of the chthonic creature, including its name, category, first mention date,
     * and attack power in a formatted manner.
     *
     * @return a formatted string representing the chthonic creature
     */
    @Override
    public String toString() {
        return String.format(
                " Chthonic Creature { name='%s', category='%s', first mention=%s, attack power=%d}",
                name, category, firstMention, attackPower
        );
    }
}
