/**
 * The Character class represents a generic character in the game.
 * It contains basic attributes and methods for character manipulation.
 */
public class Character {
    // The name of the character
    private String name;

    /**
     * Default constructor for the Character class.
     * Initializes a character without a name.
     */
    public Character() {}

    /**
     * Constructor for the Character class with a specified name.
     * 
     * @param name The name to be assigned to the character.
     */
    public Character(String name) {
        this.name = name;
    }

    /**
     * Gets the name of the character.
     * 
     * @return The name of the character.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the character.
     * 
     * @param name The new name to be assigned to the character.
     */
    public void setName(String name) {
        this.name = name;
    }
}
