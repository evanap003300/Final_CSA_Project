import java.util.Scanner;

/**
 * The NPC class represents a non-player character in the game.
 * This specific NPC is a dragon with whom the player can have a dialogue.
 */
public class NPC extends Character {

    /**
     * Default constructor that initializes the NPC with the name "Mighty Dragon".
     */
    public NPC() {
        super("Mighty Dragon");
    }

    /**
     * The dragonDialogue method initiates a dialogue with the dragon NPC.
     * The player can interact with the dragon using various inputs.
     */
    public void dragonDialogue() {
        Scanner scanner = new Scanner(System.in);
        boolean conversation = true;
        System.out.println("You encounter a " + this.getName() + ". It stares at you with piercing eyes.");
        System.out.println();
        System.out.print("-> ");

        while (conversation) {
            String input = scanner.nextLine().toUpperCase();

            // Greeting dialogue
            if (input.contains("HELLO") || input.contains("HI") || input.contains("WHAT'S UP") || input.contains("HEY")) {
                System.out.println("\"Greetings, brave adventurer,\" the dragon responds. \"What brings you to my domain?\"");
                System.out.println();
                System.out.print("-> ");
                input = scanner.nextLine().toUpperCase();

                // Player is lost
                if (input.contains("LOST")) {
                    System.out.println("\"I see. Perhaps you are lost. I can help you find your way.\"");
                    System.out.println("The dragon leads you to a hidden chamber deep within the cave and sets you free.");
                    Game.ending = true;
                    System.exit(0);
                    conversation = false;
                } 
                // Player is stuck
                else if (input.contains("STUCK")) {
                    System.out.println("The dragon looks at you with disdain. \"I can't help you if you are stuck. Maybe if you say the magic word!\"");
                    System.out.println();
                    System.out.print("-> ");
                    input = scanner.nextLine().toUpperCase();

                    // Player says "please"
                    if (input.contains("PLEASE")) {
                        System.out.println("The dragon laughs at you and flies away.");
                        conversation = false;
                    } 
                    // Player says "now"
                    else if (input.contains("NOW")) {
                        System.out.println("\"Watch your tone...\"");
                        System.out.println();
                        System.out.print("-> ");
                    } 
                    // Player says something else
                    else {
                        System.out.println("\"I can't understand you.\"");
                        System.out.println();
                        System.out.print("-> ");
                    }
                } 
                // Player is confused
                else if (input.contains("CONFUSED")) {
                    System.out.println("The dragon looks at you with disappointment. \"Just don't be confused.\"");
                    System.out.println();
                    System.out.print("-> ");
                } 
                // Player says something else
                else {
                    System.out.println("\"What did you say?\"");
                    System.out.println();
                    System.out.print("-> ");
                }
            } 
            // Player attacks the dragon
            else if (input.contains("ATTACK")) {
                System.out.println("You draw your weapon and charge at the dragon.");
                System.out.println("\"Foolish mortal,\" the dragon roars, \"prepare to meet your doom!\" The dragon sends a breath of fire towards you! You feel the heat of a thousand suns and burn to a crisp.");
                System.exit(0);
                conversation = false;
            } 
            // Player asks for help
            else if (input.contains("HELP")) {
                System.out.println("\"Help?\" the dragon snorts. \"And why should I help you?\"");
                System.out.println();
                System.out.print("-> ");
                input = scanner.nextLine().toUpperCase();

                // Player is scared
                if (input.contains("SCARED")) {
                    System.out.println("\"Don't be afraid. I won't eat you yet.\" The dragon chuckles and looks at you curiously.");
                    System.out.println();
                    System.out.print("-> ");
                } 
                // Player compliments the dragon
                else if (input.contains("NICE")) {
                    System.out.println("\"I know I'm nice, but flattery won't get you anywhere.\"");
                    System.out.println();
                    System.out.print("-> ");
                } 
                // Player is begging
                else if (input.contains("BEGGING")) {
                    System.out.println("\"Beg for me?\" the dragon says. \"I didn't know you were that desperate...\"");
                    System.out.println();
                    System.out.print("-> ");
                } 
                // Player says something else
                else {
                    System.out.println("\"What did you say?\"");
                    System.out.println();
                    System.out.print("-> ");
                }
            } 
            // Player says goodbye
            else if (input.contains("BYE") || input.contains("GOODBYE") || input.contains("SEE YOU") || input.contains("LATER")) {
                System.out.println("\"Farewell,\" the dragon bows and flies away deeper into the cave.");
                conversation = false;
            } 
            // Player says something else
            else {
                System.out.println("\"What did you say?\"");
                System.out.println();
                System.out.print("-> ");
            }
        }
    }
}
