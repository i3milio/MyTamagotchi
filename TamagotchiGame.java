import java.util.Random;
import java.util.Scanner;

public class TamagotchiGame {
    private static final int MAX_HUNGER_LEVEL = 10;
    private static final int MAX_HAPPINESS_LEVEL = 10;
    private static final int MAX_ENERGY_LEVEL = 10;

    private int hungerLevel;
    private int happinessLevel;
    private int energyLevel;

    Scanner scanner = new Scanner(System.in);

    public TamagotchiGame() {
        hungerLevel = MAX_HUNGER_LEVEL;
        happinessLevel = MAX_HAPPINESS_LEVEL;
        energyLevel = MAX_ENERGY_LEVEL;
    }

    public void play() {
        
        String choice;

        while (true) {
            displayStats();
            System.out.println("Enter an option: ");
            System.out.println("1. Feed");
            System.out.println("2. Pet");
            System.out.println("3. Sleep");
            System.out.println("4. Play mini-game");
            System.out.println("5. Exit");


            choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    feed();
                    break;
                case "2":
                    playWith();
                    break;
                case "3":
                    sleep();
                    break;
                case "4":
                    playMiniGame();
                    return;
                    case "5":
                    exitGame();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            updateStats();
            if (isGameOver()) {
                System.out.println("Game Over!");
                return;
            }
        }
    }

    private void displayStats() {
        System.out.println("Hunger Level: " + hungerLevel);
        System.out.println("Happiness Level: " + happinessLevel);
        System.out.println("Energy Level: " + energyLevel);
        System.out.println();
    }

    private void feed() {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Select the type of food:");
    System.out.println("1. Healthy food (decreases hunger by 2)");
    System.out.println("2. Treat (decreases hunger by 1)");
    System.out.println("3. Junk food (no effect on hunger)");

    String choice = scanner.nextLine();

    switch (choice) {
        case "1":
            decreaseHunger(2);
            System.out.println("Yum! Your Tamagotchi enjoyed the healthy meal.");
            break;
        case "2":
            decreaseHunger(1);
            System.out.println("Your Tamagotchi happily ate the treat.");
            break;
        case "3":
            System.out.println("Your Tamagotchi didn't like the junk food.");
            break;
        default:
            System.out.println("Invalid choice. Please try again.");
    }
}

private void decreaseHunger(int amount) {
    if (hungerLevel >= amount) {
        hungerLevel -= amount;
    } else {
        hungerLevel = 0;
    }
}
    

    private void playWith() {
        if (energyLevel >= 2) {
            happinessLevel++;
            energyLevel -= 2;
            System.out.println("Your Tamagotchi had a great time playing!");
        } else {
            System.out.println("Your Tamagotchi is too tired to play.");
        }
    }

    private void sleep() {
        if (energyLevel < MAX_ENERGY_LEVEL) {
            hungerLevel--;
            happinessLevel--;
            energyLevel = MAX_ENERGY_LEVEL;
            System.out.println("Your Tamagotchi had a good sleep and feels refreshed.");
        } else {
            System.out.println("Your Tamagotchi is not sleepy.");
        }
    }

    private void playMiniGame() {

        System.out.println("Guess what number I'm guessing: ");
        String randomValue = scanner.nextLine();
        int intRandomValue = Integer.parseInt(randomValue);

        Random random = new Random();
        int randomNumber = random.nextInt(5) + 1;

        if (intRandomValue == randomNumber) {
        happinessLevel += 2;
        energyLevel += 2;
        System.out.println("Congratulations, you won! Your Tamagotchi is happier and more energetic.");
    } else 
    {
        happinessLevel -= 1;
        energyLevel -= 1;
        System.out.println("Unfortunately, you didn't win. Your Tamagotchi is slightly less happy and feels a bit tired.");
    }
   
    // Ensure happiness and energy levels don't exceed their maximum
    if (happinessLevel > MAX_HAPPINESS_LEVEL || energyLevel > MAX_ENERGY_LEVEL ) {
        happinessLevel = MAX_HAPPINESS_LEVEL;
        energyLevel = MAX_ENERGY_LEVEL;
    }
    
    play();
    


    }

    private void updateStats() {
        hungerLevel--;
        happinessLevel--;
        energyLevel--;

        if (hungerLevel < 0) {
            hungerLevel = 0;
        }
        if (happinessLevel < 0) {
            happinessLevel = 0;
        }
        if (energyLevel < 0) {
            energyLevel = 0;
        }
    }

    private boolean isGameOver() {
        return hungerLevel == 0 || happinessLevel == 0 || energyLevel == 0;
    }

    private void exitGame() {
        System.out.println("Exiting the game. Goodbye!");
    }

    
}
