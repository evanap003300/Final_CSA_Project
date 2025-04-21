# Cave Adventure

A Java-based text adventure game where players navigate through a network of caves, collect items, interact with characters, and find their way to escape.

## Overview

Cave Adventure is an interactive text-based game where players explore a mysterious underground cave system. Navigate through different locations, collect useful items, interact with creatures (including a dragon!), and find your way out before you become trapped forever.

## Features

- **Grid-Based Navigation System**: Move between 9 unique cave locations using compass directions
- **Interactive Environment**: Look at, take, and use items in each location
- **Inventory Management**: Collect and manage items to help you escape
- **Character Interactions**: Talk to non-player characters like the dragon
- **Multiple Escape Routes**: Several different ways to escape the caves
- **Special Endings**: Different outcomes based on your collected items and choices

## Game Map

The game world consists of a 3x3 grid of locations:

```
+----------------+----------------+----------------+
| Troll Horde    | Goblin Camp    |                |
| [0,0]          | [0,1]          | [0,2]          |
+----------------+----------------+----------------+
| Underground    | Large Cavern   | Goblin         |
| Aquifer [1,0]  | [1,1]          | Merchant [1,2] |
+----------------+----------------+----------------+
| Dragon Lair    | Abandoned      | Exit           |
| [2,0]          | Mineshaft [2,1]| [2,2]          |
+----------------+----------------+----------------+
```

## Commands

- `GO NORTH/SOUTH/EAST/WEST` - Move in the specified direction
- `LOOK <item>` - Examine an item in the current location
- `TAKE <item>` - Add an item to your inventory
- `DROP <item>` - Remove an item from your inventory
- `USE <item>` - Use an item from your inventory
- `TALK <character>` - Talk to a character in the room
- `INVENTORY` - Check what items you're carrying
- `HELP` - Display available commands

## Special Items

- **Compass**: Can be used to navigate the Underground Aquifer
- **Bioluminescent Moss** and **Unique Blind Fish**: Can be traded with the Goblin Merchant
- **Rusty Sword**: Can be used against the dragon to obtain the Golden Amulet
- **Grappling Hook Launcher**: Can be used to escape through the Abandoned Mineshaft
- **Hidden Treasures**: Can be used for a quick escape

## Project Structure

The game is built with the following Java classes:

- `Game.java`: Main game logic and command processing
- `Map.java`: Manages room navigation and descriptions
- `Player.java`: Handles player inventory and actions
- `NPC.java`: Contains dialogue and interactions for non-player characters
- `Character.java`: Base class for character entities

## How to Play

1. Compile the Java files:
   ```
   javac *.java
   ```

2. Run the game:
   ```
   java Main
   ```

3. Follow the in-game instructions and use the commands listed above to navigate and interact with the world.

4. Try to find a way to escape the caves before you run out of navigation options!

## Tips for Success

- Explore thoroughly before making permanent moves
- Collect items that might be useful later
- Pay attention to item descriptions for clues
- Talk to NPCs for valuable information
- Remember that some items can be traded or used in specific locations

## Development Information

This project demonstrates object-oriented programming concepts including:
- Class inheritance
- Object composition
- State management
- Command processing
- User interaction

## Authors

Developed by Evan Phillips, and Patrick Li
