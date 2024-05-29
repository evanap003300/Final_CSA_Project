import java.util.ArrayList;

/**
 * The Player class represents a player character in the game.
 * It extends the Character class and includes an inventory system.
 */
public class Player extends Character {
    // Static inventory list shared by all Player instances
    private static ArrayList<String> inventory;

    /**
     * Default constructor that initializes the player and the inventory.
     */
    public Player() {
        super();
        inventory = new ArrayList<String>();
    }

    /**
     * Constructor that initializes the player with a given name and the inventory.
     * @param name The name of the player.
     */
    public Player(String name) {
        super(name);
        inventory = new ArrayList<String>();
    }

    /**
     * Adds an item to the player's inventory, sorts the inventory,
     * and prints a message indicating the item has been added.
     * @param item The item to be added to the inventory.
     */
    public static void addItem(String item) {
        inventory.add(item);
        selectionSort(); // Ensure the inventory is sorted
        System.out.println("Item " + item + " added to inventory.");
    }

    /**
     * Removes an item from the player's inventory if it exists,
     * and prints a message indicating the result.
     * @param item The item to be removed from the inventory.
     * @return True if the item was found and removed, false otherwise.
     */
    public static boolean removeItem(String item) {
        if (hasItem(item)) {
            inventory.remove(item);
            System.out.println("Item " + item + " removed from inventory.");
            return true;
        } else {
            System.out.println("Item " + item + " not found in inventory.");
            return false;
        }
    }

    /**
     * Checks if the player's inventory contains a specific item.
     * @param item The item to be checked.
     * @return True if the item is found, false otherwise.
     */
    public static boolean hasItem(String item) {
        selectionSort(); // Ensure the inventory is sorted before searching
        return binarySearch(item) != -1;
    }

    /**
     * Displays the contents of the player's inventory.
     */
    public static void displayInventory() {
        selectionSort(); // Ensure the inventory is sorted before displaying
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            System.out.println("Inventory contents: " + inventory);
        }
    }

    /**
     * Returns the number of items in the player's inventory.
     * @return The size of the inventory.
     */
    public static int getInventorySize() {
        return inventory.size();
    }

    /**
     * Returns the inventory list.
     * @return The inventory list.
     */
    public static ArrayList<String> getInventory() {
        return inventory;
    }

    /**
     * Sorts the player's inventory using the selection sort algorithm.
     */
    public static void selectionSort() {
        int n = inventory.size();
        // Traverse through all items in the inventory
        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element in the unsorted portion
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (inventory.get(j).compareTo(inventory.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }
            // Swap the found minimum element with the first element
            String temp = inventory.get(minIndex);
            inventory.set(minIndex, inventory.get(i));
            inventory.set(i, temp);
        }
    }

    /**
     * Performs a binary search to find an item in the sorted inventory.
     * @param item The item to be searched for.
     * @return The index of the item if found, -1 otherwise.
     */
    public static int binarySearch(String item) {
        selectionSort(); // Ensure the inventory is sorted before searching
        int left = 0;
        int right = inventory.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = inventory.get(mid).compareTo(item);

            if (comparison == 0) {
                return mid; // Item found
            }

            if (comparison < 0) {
                left = mid + 1; // Search in the right half
            } else {
                right = mid - 1; // Search in the left half
            }
        }

        return -1; // Item not found
    }
}
