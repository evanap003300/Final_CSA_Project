import java.util.ArrayList;
import java.util.Scanner;

public class Game {  
  private static String response;
  private static Player player = new Player();
  private static Map map = new Map();
  public static boolean ending = false;

  public static void playGame() {
    Map.startingCavern();
    while (!ending) {
      if (map.getRow() == 0) {
        if (map.getCol() == 1) {
          Map.goblinCamp();
          if (ending) {
            break;
          }
        }
        else {
          Map.trollHorde();
          if (ending) {
            break;
          }
        }
      }
      else if (map.getRow() == 1) {
        if (map.getCol() == 0) {
          Map.undergroundAquifer();
          if (ending) {
            break;
          }
        }
        else if (map.getCol() == 1) {
          Map.largeCavern();
          if (ending) {
            break;
          }
        }
        else {
          Map.goblinMerchant();
          if (ending) {
            break;
          }
        }
      }
      else {
        if (map.getCol() == 0) {
          Map.dragonLair();
          if (ending) {
            break;
          }

        }
        else if (map.getCol() == 1) {
          Map.abandonedMineshaft();
          if (ending) {
            break;
          }
        }
        else {
          Map.exit();
          if (ending) {
            break;
          }
        }
      }
      ending();
    }
  }

  public static void GO(String direction) {
    int prevCol = map.getCol();
    int prevRow = map.getRow();

    if (direction.toUpperCase().equals("GO NORTH")) {
      if (map.getRow() == 0 || map.hasBeenTraveled(map.getRow() - 1, map.getCol())) {
        System.out.println("You can't go that way. Type HELP for a list of possible commands.");
      }
      else {
        map.setRow(map.getRow() - 1);
        System.out.println("You have moved North.");
        map.leavingRoom(prevRow, prevCol);
      }
    }
    else if (direction.toUpperCase().equals("GO SOUTH")) {
      if (map.getRow() == 2 || map.hasBeenTraveled(map.getRow() + 1, map.getCol())) {
        System.out.println("You can't go that way. Type HELP for a list of possible commands.");
      }
      else {
        map.setRow(map.getRow() + 1);
        System.out.println("You have moved South.");
        map.leavingRoom(prevRow, prevCol);
      }
    }
    else if (direction.toUpperCase().equals("GO EAST")) {
      if (map.getCol() == 2 || map.hasBeenTraveled(map.getRow(), map.getCol() + 1)) {
        System.out.println("You can't go that way. Type HELP for a list of possible commands.");
      }
      else {
        map.setCol(map.getCol() + 1);
        System.out.println("You have moved East.");
        map.leavingRoom(prevRow, prevCol);
      }
    }
    else if (direction.toUpperCase().equals("GO WEST")) {
      if (map.getCol() == 0 || map.hasBeenTraveled(map.getRow(), map.getCol() - 1)) {
        System.out.println("You can't go that way. Type HELP for a list of possible commands.");
      }
      else {
        map.setCol(map.getCol() - 1);
        System.out.println("You have moved West.");
        map.leavingRoom(prevRow, prevCol);
      }
    }
    else {
      System.out.println("Invalid direction. Type HELP for a list of possible commands.");
    }
  }

  public static void respond(String in) {
      in = in.toUpperCase();
      if (in.indexOf("GO") == 0) {
        GO(in);
      }
      else if (in.indexOf("LOOK")  == 0) {
        LOOK(in.substring(5));
      }
      else if (in.indexOf("TAKE") == 0) {
        TAKE(in.substring(5));
      }
      else if (in.indexOf("DROP") == 0) {
        DROP(in.substring(5));
      }
      else if (in.indexOf("USE") == 0) {
        USE(in.substring(4));
      }
      else if (in.indexOf("TALK") == 0) {
        TALK(in.substring(in.indexOf(" ") + 1));
      }
      else if (in.indexOf("INVENTORY") == 0) {
        INVENTORY();
      }
      else if (in.indexOf("HELP") == 0) {
        HELP();
      }
      else {
        System.out.println("I don't understand what you're trying to do. Please try again");
      }
    }

  public static void DROP(String item) {
    item = item.toUpperCase();
    if (player.hasItem(item)) {
      player.removeItem(item);
      System.out.println("You have dropped " + item + ".");
    }
    else {
      System.out.println("You don't have " + item + " in your inventory.");
    }
  }

  public static void INVENTORY() {
    player.displayInventory();
  }


  public static void HELP() {
    System.out.println("Available Commands:\n" +
                          "GO NORTH - Move to the north\n" +
                          "GO SOUTH - Move to the south\n" +
                          "GO EAST - Move to the east\n" +
                          "GO WEST - Move to the west\n" +
                          "LOOK <item> - Look at an item in the current room\n" +
                          "TAKE <item> - Take an item from the current room\n" +
                          "DROP <item> - Drop an item from your inventory\n" +
                          "USE <item> - Use an item from your inventory\n" +
                          "TALK - Talk to a character in the room\n" +
                          "INVENTORY - Check your inventory\n" +
                          "HELP - Display this help message\n" +
                          "Type commands as shown above. For example, to move north, type 'GO NORTH'.");
  }

  public static void LOOK(String item) {
    ArrayList<String> object = new ArrayList<String>();
    if (map.getRow() == 0) {
      if (map.getCol() == 0) {
        object.add("Bioluminescent Moss: Soft to the touch, emitting a faint glow, illuminating the cavern with its otherworldly light.");
        object.add("Climbing Rope: A sturdy rope, essential for scaling cliffs and navigating steep terrain.");
        object.add("Lockpick Set: A collection of tools used for manipulating locks, potentially unlocking hidden passages and treasures.");
      }
      else if (map.getCol() == 1) {
        object.add("Rusty Sword: A basic weapon, yet sturdy enough for self-defense, with intricate carvings along its blade hinting at its previous owner's identity.");
        object.add("Crude Wooden Chest: Locked, but potentially containing valuable loot, such as gold coins or ancient relics.");
      }
      else {
        object.add("Pickaxe: A versatile tool with a pointed end and a flat blade, useful for breaking rocks and clearing debris.");
        object.add("Fireproof Cloak: A cloak woven from fire-resistant materials, offering protection against flames and extreme heat.");
      }
    }
    else if (map.getRow() == 1) {
      if (map.getCol() == 0) {
        object.add("Shallow River: A shallow river that looks like it goes on forever. It winds and bends several times. You would'nt want to get lost in the river.");
        object.add("Unique Blind Fish: Swimming gracefully, adapted to their lightless environment, their movements mesmerizing as they navigate the clear waters.");
      }
      else if (map.getCol() == 1) {
        object.add("Compass: A navigational instrument used for determining direction, guiding the way through unknown territories.");
        object.add("Ancient Artifacts: Relics of a bygone era, hinting at the cave's storied past and the civilizations that once inhabited it.");
      }
      else {
        object.add("Merchant's Shop: Filled with various supplies and treasures, offering a glimpse into the goblin's world and their unique trade goods.");
        object.add("Grappling Hook Launcher: A device that propels a grappling hook, allowing for swift ascent or descent in vertical environments.");
      }
    }
    else {
      if (map.getCol() == 0) {
        object.add("Dragon's Hoard: Glittering piles of treasure, tempting yet dangerous, guarded fiercely by the dragon.");
        object.add("Golden Amulet: Approaching the Dragon Lair, you spot a golden amulet this will fetch you a fortune back home.");
        object.add("Secret Door: You can see behind the dragon, a huge stone door with strange inscriptions on it. You wonder what is behind it.");
      }
      else if (map.getCol() == 1) {
        object.add("Rotting Wooden Supports: Fragile remnants of the mineshaft's infrastructure, creaking and groaning under the weight of the earth above.");
        object.add("Hidden Treasures: Forgotten caches of minerals and gems, waiting to be discovered amidst the rubble and debris of the abandoned mineshaft.");
        object.add("Long Tunnel: Fragile remnants of the mineshaft's infrastructure, creaking and groaning under the weight of the earth above. The tunnel continues far into the cave but is high up and unreachable without some help.");
      }
      else {
        object.add("Faint Light: A glimmer of hope leading you towards the surface, symbolizing the end of your perilous journey and the beginning of a new chapter.");
        object.add("Emergency Beacon: A signaling device that emits a bright light or distress signal, alerting rescuers to your location.");
        object.add("Quick Way Out: Just escape now, either barter your way with the goblins or use a tool to escape  now.");
      }
    }
    item = item.toUpperCase();
    String object1 = object.get(0).substring(0, object.get(0).indexOf(":")).toUpperCase();
    String object2 = "";
    String object3 = "";
    if (object.size() > 1) {
      object2 = object.get(1).substring(0, object.get(1).indexOf(":")).toUpperCase();
    }
    if (object.size() > 2) {
      object3 = object.get(2).substring(0, object.get(2).indexOf(":")).toUpperCase();
    }
    if (item.indexOf(object1) != -1) {
      System.out.println(object.get(0).substring(object.get(0).indexOf(':') + 2));
    }
    else if (item.indexOf(object2) != -1) {
      System.out.println(object.get(1).substring(object.get(1).indexOf(':') + 2));
    }
    else if (item.indexOf(object3) != -1) {
      System.out.println(object.get(2).substring(object.get(2).indexOf(':') + 2));
      }
    else {
      System.out.println("You can't look at this object!");
    }
  }

  public static void TAKE(String item) {
    ArrayList<String> interactions = new ArrayList<String>();
    if (player.hasItem(item)) {
      System.out.println("You already have this item.");
    }
    else {
      if (map.getRow() == 0) {
        if (map.getCol() == 0) {
          interactions.add("Bioluminescent Moss");
          interactions.add("Lockpick Set");
          interactions.add("Climbing Rope");
        }
        else if (map.getCol() == 1) {
          interactions.add("Rusty Sword");
          interactions.add("Crude Wooden Chest");
          interactions.add("Health Potion");
        }
        else {
          interactions.add("Pickaxe");
          interactions.add("Fireproof Cloak");
        }
      }
      else if (map.getRow() == 1) {
        if (map.getCol() == 0) {
          interactions.add("Shallow River"); // if you have the compass you can escape
          interactions.add("Unique Blind Fish");
        }
        else if (map.getCol() == 1) {
          interactions.add("Compass");
          interactions.add("Ancient Artifacts");
        }
        else {
          interactions.add("Merchant's Shop"); // if you have the bioluminesenc moss and the fish you can buy the Grappling Hook Launcher
          interactions.add("Grappling Hook Launcher");
        }
      }
      else {
        if (map.getCol() == 0) {
          interactions.add("Dragon's Hoard");
          interactions.add("Golden Amulet"); // if you have the sword you slay the dragon an you can collect this. When you exit you will get a special ending where you are rich.
          interactions.add("Secret Door");
        }
        else if (map.getCol() == 1) {
          interactions.add("Long Tunnel"); // if you have the grappling  hook you can escape
          interactions.add("Hidden Treasures");
        }
        else {
          interactions.add("Faint Light");
          interactions.add("Emergency Beacon");
          interactions.add("Quick Way Out"); // if you have hidden treasures or grappling hook launcher then you can do this
        }
      }
      String object1 = interactions.get(0).toUpperCase();
      String object2 = "";
      if (interactions.size() > 1) {
        object2 = interactions.get(1).toUpperCase();
      }
      String object3 = "";
      if (interactions.size() > 2) {
        object3 = interactions.get(2).toUpperCase();
      }
      if (item.equals(object1)) {
        player.addItem(object1);
        System.out.println("You have taken " + object1 + ".");
      }
      else if (item.equals(object2)) {
        player.addItem(object2);
        System.out.println("You have taken " + object2 + ".");
      }
        else if (item.equals(object3)) {
          player.addItem(object3);
          System.out.println("You have taken " + object3 + ".");
        }
      else {
        System.out.println("You can't take this object!");
      }
    }
  }

  public static void ending() {
    if(!canMove()) {
      System.out.println("You trapped yourself in the caves for the rest of your life, and you died of old age! :(");
      ending = true;
    }
  }

  private static boolean canMove() {
      int col = map.getCol();
      int row = map.getRow();

      boolean canMoveNorth = row > 0 && !map.hasBeenTraveled(row - 1, col);
      boolean canMoveSouth = row < 2 && !map.hasBeenTraveled(row + 1, col);
      boolean canMoveEast = col < 2 && !map.hasBeenTraveled(row, col + 1);
      boolean canMoveWest = col > 0 && !map.hasBeenTraveled(row, col - 1);

      return canMoveNorth || canMoveSouth || canMoveEast || canMoveWest || 
        (row == 2 && col == 0);
  }

  public static void USE(String item) {
    if (player.hasItem(item) && item.equals("COMPASS")) {
      if (map.getRow() == 1 && map.getCol() == 0) {
        System.out.println("You use the compass to navigate the cave and find your way out.");
        player.removeItem(item);
        ending = true;
      }
      else {
        System.out.println("You can't use this item!");
      }
    }
    else if (player.hasItem(item) && (item.equals("UNIQUE BLIND FISH") || item.equals("BIOLUMINESCENT MOSS"))) {
        if (map.getRow() == 1 && map.getCol() == 2) {
          System.out.println("You Exchange " + item + " for a grappling hook launcher, a device that propels a grappling hook, allowing for swift ascent or descent in vertical environments.");
          player.removeItem(item);
          player.addItem("GRAPPLING HOOK LAUNCHER");
        }
      else {
        System.out.println("You can't use this item!");
      }
    }
    else if (player.hasItem(item) && item.equals("RUSTY SWORD")) {
      if (map.getRow() == 2 && map.getCol() == 0) {
        player.removeItem(item);
        player.addItem("GOLDEN AMULET");
      }
      else {
        System.out.println("You can't use this item!");
      }
    }
    else if (player.hasItem(item) && item.equals("GRAPPLING HOOK LAUNCHER")) {
      if (map.getRow() == 2 && map.getCol() == 1) {
        System.out.println("You used the Grappling Hook Launcher to escape the tunnel.");
        player.removeItem(item);
        ending = true;
      }
      else {
        System.out.println("You can't use this item!");
      }
    }
    else if (player.hasItem(item) && (item.equals("GRAPPLING HOOK LAUNCHER") ||                                         item.equals("HIDDEN TREASURES"))) {
      if (map.getRow() == 2 && map.getCol() == 2) {
        System.out.println("You used the " + item + " for a quick escape.");
        player.removeItem(item);
        ending = true;
      }
      else {
        System.out.println("You can't use this item!");
      }
    }
    else {
      System.out.println("You can't use this item!");
    } 
  }

  public static void TALK(String item) {
    item = item.toUpperCase();
    if (map.getRow() == 2) {
      if (map.getCol() == 0) {
        if (item.equals("DRAGON")) {
          NPC npc = new NPC();
          npc.dragonDialogue();
        }
        else {
          System.out.println("You can't talk to " + item + "!");
        }
      } 
      else {
        System.out.println("You can't talk to " + item + "!");
      }
    }
    else {
      System.out.println("You can't talk to " + item + "!");
    }
  }
}