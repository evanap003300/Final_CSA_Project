  import java.util.*;

  // Map class to manage the game's map and player's location within it
  public class Map {
    private static String[][] map;
    private static int row;
    private static int col;
    private static boolean[][] traveled;

    // Constructor to initialize the map, traveled array, and starting position
    public Map() {
      map = new String[][] {
        {"Starting Cavern", "Goblin Camp 1", "Troll Horde"},
        {"Underground Aquifer", "Large Cavern", "Friendly Goblin Merchant"},
        {"Dragon Lair", "Abandoned Mineshaft", "Exit"}
      };
      traveled = new boolean[][] {
        {false, false, false},
        {false, false, false},
        {false, false, false}
      };
      row = 0;
      col = 0;
    }

    /**
     * @return The current state of the game map.
     */
    public static String[][] getMap() {
      return map;
    }

    /**
     * @return The current row position of the player on the map.
     */
    public static int getRow() {
      return row;
    }

    /**
     * @return The current column position of the player on the map.
     */
    public static int getCol() {
      return col;
    }

    /**
     * Sets the player's row position on the map.
     * @param r The new row position.
     */
    public static void setRow(int r) {
      row = r;
    }

    /**
     * Sets the player's column position on the map.
     * @param c The new column position.
     */
    public static void setCol(int c) {
      col = c;
    }

    /**
     * @return The name of the current location on the map.
     */
    public static String getLocation() {
      return map[row][col];
    }

    /**
     * Marks a specific room as traveled.
     * @param row The row of the room to mark.
     * @param col The column of the room to mark.
     */
    public static void leavingRoom(int row, int col) {
      traveled[row][col] = true;
    }

    /**
     * Checks if a specific room has been traveled to.
     * @param row The row of the room to check.
     * @param col The column of the room to check.
     * @return True if the room has been traveled to, false otherwise.
     */
    public static boolean hasBeenTraveled(int row, int col) {
      return traveled[row][col];
    }

    /**
     * Describes the Starting Cavern location and handles player actions in this location.
     */
    public static void startingCavern() {
      if (row == 0 && col == 0) {
        System.out.println();
        System.out.println("- - - - - Starting Cavern - - - - -");
        System.out.println("Entering the Starting Cavern, you are immediately captivated by the bioluminescent moss casting an ethereal glow. The cave is vast, filled with strange flora and fauna. Suddenly, an earthquake strikes, sealing the entrance behind you. Trapped, you regain consciousness amidst scattered human bones. Fear and determination drive you forward, seeking a way out and deeper understanding of this uncharted world. You notice the soft touch of the bioluminescent moss under your fingers, emitting a faint glow, and you cautiously inspect the nearby scattered human bones, hoping they hold clues to your predicament. Nearby, you find a lockpick set, possibly left by previous explorers, and a sturdy climbing rope, essential for navigating the cave's vertical terrain.");
        Scanner scanner = new Scanner(System.in);
        while (row == 0 && col == 0) {
          System.out.println();
          System.out.print("-> ");
          String action = scanner.nextLine();
          Game.respond(action);
        }
      }
    }

    /**
     * Describes the Goblin Camp location and handles the Rock Paper Scissors puzzle with the goblins.
     */
  public static void goblinCamp() {
      if (row == 0 && col == 1) {
        System.out.println();
        System.out.println("- - - - - Goblin Camp - - - - -");
        System.out.println("You navigate through a narrow passage and stumble upon the Goblin Camp. The goblins, small and mischievous, are led by a larger, more menacing leader. They guard a crude wooden chest filled with unknown treasure.");
        System.out.println();
        System.out.println("- - - - - Goblin Rock Paper Scissors - - - - -");
        System.out.println("The goblin stalks towards you with a wide grin on his face. \"If you want to survive, you must prove your worth. You must win 3 games of rock-paper-scissors before I do to move on!\"");
        System.out.println();
        String outcome = Puzzle.rockPaperScissors();
        System.out.println();
        if (outcome.equals("You win!")) {
          System.out.println("\"You have won. You may have my treasures.\" The goblins vanish from your sight. Among the goblin loot, you find a locked crude wooden chest. Using the lockpick set you found earlier, you manage to open it and discover a healing potion alongside the rusty sword with intricate carvings hinting at its previous owner's identity.");
          Scanner scanner = new Scanner(System.in);
            while (row == 0 && col == 1) {
              System.out.println();
              System.out.print("-> ");
            String action = scanner.nextLine();
            Game.respond(action);
          }
        }
        else {
          System.out.println("\"You have lost! You must die.\" The goblins swarm at you. Your screams are lost to their attacks, and you are never seen again.");
          Game.ending = true;
        }
      }
  }

    /**
     * Describes the Troll Horde location and handles player actions in this location.
     */
  public static void trollHorde() {
    if (row == 0 && col == 2) {
      System.out.println();
      System.out.println("- - - - - Troll Horde - - - - -");
      System.out.println("Continuing deeper, you enter the domain of the Troll Horde. This dark, dank chamber reeks of decay, and the guttural growls of the trolls echo ominously. The trolls, massive and warty, are fiercely protective of their territory. The chamber is littered with the bones of their victims. You must use stealth and agility to navigate through this dangerous area, narrowly escaping the trolls' grasp. Behind the trolls you can spot a pickaxe and what looks to be a fireproof cloak. The ominous guttural growls warn of nearby trolls, urging caution, while the bones of victims serve as evidence of the trolls' ferocity and the dangers lurking in the chamber.");
      Scanner scanner = new Scanner(System.in);
        while (row == 0 && col == 2) {
          System.out.println();
        System.out.print("-> ");
        String action = scanner.nextLine();
        Game.respond(action);
      }
    }
  }

    /**
     * Describes the Underground Aquifer location and handles the Rock Paper Scissors puzzle with the spirit.
     */
  public static void undergroundAquifer() {
    if (row == 1 && col == 0) {
      System.out.println();
      System.out.println("- - - - - Underground Aquifer - - - - -");
      System.out.println("Exhausted and in need of respite, you find the Underground Aquifer, a serene and crystal-clear pool."); 
      System.out.println();
      System.out.println("- - - - - Underground Aquifer Rock Paper Scissors - - - - -");
      System.out.println("A spirit appears out of the pool. \"In order to survive and move on, you must beat me in rock-paper-scissors 3 times before I win 3 times.\"");
      System.out.println();
      String outcome = Puzzle.rockPaperScissors();
      if (outcome.equals("You win!")) {
        System.out.println("\"You have won, \" says the spirit before disappearing back into the pool. The rest of the room is revealed to you.");
        System.out.println();
        System.out.println("The bioluminescent moss provides a tranquil light, and the water is home to unique blind fish and other fascinating aquatic life. You take this opportunity to refill your water supply and rest, marveling at the delicate ecosystem that thrives here. This moment of peace strengthens your resolve to discover more about the cave's hidden secrets. You notice the fauna living in the river, as a biologist, your interest peaks and notice the unique blind fish living in the shallow river. You dip your hands into the inviting crystal-clear pool, feeling its refreshing coolness, and observe the graceful movements of the unique blind fish swimming in the water, adapted to their lightless environment. Down the river there appears to be another network of caves. It looks easy to get lost in. However you know if you can navigate it you can leave the cave.");
      Scanner scanner = new Scanner(System.in);
        while (row == 1 && col == 0) {
        System.out.println();
        System.out.print("-> ");
        String action = scanner.nextLine();
        Game.respond(action);
        }
      }
      else {
        System.out.println("\"You have lost!\" The spirit drags you down in the pool, and you are never heard from again.");
        Game.ending = true;
      }
    }
  }

    /**
     * Describes the Large Cavern location and handles player actions in this location.
     */
  public static void largeCavern() {
    if (row == 1 && col == 1) {
      System.out.println();
      System.out.println("- - - - - Large Cavern - - - - -");
      System.out.println("Refreshed, you venture into the Large Cavern, a vast and echoing chamber. Stalagmites rise like ancient sentinels, and the far walls are lost in darkness. This cavern seems to be a central hub, with passages leading in multiple directions. Here, you sense the weight of the cave's history and the many secrets it holds from its ancient artifacts. In the cave you see a shiny object. You take a closer look and notice it is a compass. Your journey feels more significant, as if you are uncovering the very essence of the earth itself. You marvel at the towering stalagmites, dripping with minerals, and consider the mysteries hidden within the cavern's depths.");
      Scanner scanner = new Scanner(System.in);
        while (row == 1 && col == 1) {
        System.out.println();
        System.out.print("-> ");
        String action = scanner.nextLine();
        Game.respond(action);
      }
    }
  }

    /**
     * Describes the Goblin Merchant location and handles the puzzle with the merchant.
     */
  public static void goblinMerchant() {
    if (row == 1 && col == 2) {
      System.out.println();
      System.out.println("- - - - - Goblin Merchant - - - - -");
      System.out.println("In a small alcove off the large cavern, you find a Goblin Merchant. He scowls as you walk in.");
      System.out.println();
      System.out.println("- - - - - - Goblin Merchant Number Guesser - - - - -");
      System.out.println("\"If you wish to pass, you must beat me in this game of wits. Guess the number I am thinking of in 11 tries. As a hint, I'll tell you it is between 1 and 1000!\"");
      System.out.println();
      String outcome = Puzzle.guessTheNumber();
      if (outcome.equals("You win!")) {
        System.out.println("The Goblin Merchant smiles widely. \"You have won! I have been waiting for a person to win. Come take a look at my shop!\"");
        System.out.println("His makeshift shop is filled with trinkets, potions, and weapons. You may barter with him. //(if they barter print further) exchanging some of your findings for better gear and useful items. Notably, you trade the bioluminescent moss or the unique blind fish for a grappling hook launcher, a device that propels a grappling hook, allowing for swift ascent or descent in vertical environments.");
        Scanner scanner = new Scanner(System.in);
          while (row == 1 && col == 2) {
          System.out.println();
          System.out.print("-> ");
          String action = scanner.nextLine();
          Game.respond(action);
        }
      }
      else {
        System.out.println("The Goblin Merchant smiles menacingly. \"You have lost!\" He drags you behind his shop, takes you by the arms, and straps you down to a medical gurney. \"Your body parts shall look good next to the rest of my goods!\" Your screams echo off the walls as you are never seen living again.");
      }
    }
  }

    /**
     * Describes the Dragon Lair location and handles player actions in this location.
     */
  public static void dragonLair() {
    if (row == 2 && col == 0) {
      System.out.println();
      System.out.println("- - - - - Dragon Lair - - - - -");
      System.out.println("The air grows hotter as you approach the Dragon Lair. This massive chamber is filled with the dragon's hoard—piles of gold, jewels, and ancient artifacts. The dragon itself is a fearsome beast, its scales shimmering in the dim light. Its eyes glow with a fierce intelligence, watching your every move. This lair holds rare and powerful weapons, perhaps even one capable of slaying the dragon. You must use all your cunning and courage to face this ultimate challenge, drawing on the strength and wisdom gained from your journey. Among the glittering piles of treasure, you spot a golden amulet that could fetch a fortune back home. If you have the sword, you can slay the dragon and claim the amulet. Behind the dragon, you also notice a secret door with strange inscriptions on it, hinting at further mysteries.");
      Scanner scanner = new Scanner(System.in);
        while (row == 2 && col == 0) {
        System.out.println();
        System.out.print("-> ");
        String action = scanner.nextLine();
        Game.respond(action);
      }
    }
  }

    /**
     * Describes the Abandoned Mineshaft location and handles player actions in this location.
     */
  public static void abandonedMineshaft() {
    if (row == 2 && col == 1) {
      System.out.println();
      System.out.println("- - - - - Abandoned Mineshaft - - - - -");
      System.out.println("You delve into the Abandoned Mineshaft, an old and unstable tunnel. The wooden supports are rotting, and the air is thick with mildew. The threat of cave-ins is constant, but the mineshaft also promises valuable minerals and forgotten treasures. An old man stands guard, his eyes fixed on you. He offers to guide you through the tunnel, but you must first prove your worth by defeating him in a game of his choosing.");
      System.out.println();
      System.out.println("- - - - - Abandoned Mineshaft Number Guesser- - - - -");
      System.out.println("\"To move on, you must guess the number that I am thinking of in 11 tries. As a hint, I'll tell you that it is between 1 and 1000!\"");
      System.out.println();
      String outcome = Puzzle.guessTheNumber();
      if (outcome.equals("You win!")) {
        System.out.println();
        System.out.println("\"You have won! Follow me, I'll show you the way through these tunnels.\"");
        System.out.println();
        System.out.println("Carefully, the old man helps you navigate the hazardous tunnels, uncovering remnants of a long-lost mining operation. This area tests your perseverance and resourcefulness, pushing you to your limits. You find hidden treasures amidst the rubble and debris, and as you continue, you reach a long tunnel. The tunnel continues far into the cave but is high up and unreachable without some help. //(if they use the grappling hook then print and escape) Using the grappling hook launcher, you manage to escape this treacherous area.");
        Scanner scanner = new Scanner(System.in);
          while (row == 2 && col == 1) {
          System.out.println();
          System.out.print("-> ");
          String action = scanner.nextLine();
          Game.respond(action);
        }
      }
      else {
        System.out.println("\"You have lost!\" The old man pulls at one of the loose supports. The mineshaft crumbles, and you are buried, forever lost in the caves.");
        Game.ending = true;
      }
    }
  }
  /**
   * Describes the Exit location and handles the game's conclusion.
   */
  public static void exit() {
    if (row == 2 && col == 2) {
      System.out.println();
      System.out.println("- - - - - Exit - - - - -");
      System.out.println("At last, you find the Exit, a tunnel leading back to the surface. The air is fresher here, and a faint light beckons you forward. The journey has been long and treacherous, filled with dangers and discoveries. As you step into the daylight, a reflection of yourself appears before your eyes.");
      System.out.println("\"You are almost free! You must face one more challenge to escape.\" The doppelganger beckons you closer, and you spot a tic-tac-toe grid on the ground. \"To move on, you have 5 tries and must beat me, or rather yourself, 3 times in this game of intelligence. As a bonus, ties do count as a win!\"");
      String outcome = Puzzle.runTicTacToe();
      if (outcome.equals("You win!")) {
        System.out.println("\"Congratulations! You have won! You are finally free!\" Your mirror vanishes in front of your eyes, and you are ready to leave. You carry with you the knowledge and treasures of the cave, ready to share your findings with the world. You realize that your quest was not just about discovering a new species, but about uncovering the hidden depths of nature and your own resilience. Near the exit, you find an emergency beacon, a signaling device that emits a bright light or distress signal, alerting rescuers to your location. With a final glance back at the cave entrance, you take a moment to pocket a glowing crystal shard, a small memento of your extraordinary journey, and the ancient cave map, a testament to the secrets you've unearthed.");
        Game.ending = true;
        /*Scanner scanner = new Scanner(System.in);
        while (row == 2 && col == 2) {
          System.out.println();
          System.out.print("-> ");
          String action = scanner.nextLine();
          Game.respond(action);
        }*/
      }
      else {
        System.out.println("\"I'm sorry, but you have lost!\" The ground right in front of you rises up, and the exit is blocked off forever. You wander the caves for the rest of your life, though you die a few days later from hunger and thirst.");
        Game.ending = true;
      }
    }
  }
}
