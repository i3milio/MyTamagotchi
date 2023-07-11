import java.util.Scanner;

public class TamagotchiGame {
    private static final int MAX_HUNGER_LEVEL = 10;
    private static final int MAX_HAPPINESS_LEVEL = 10;
    private static final int MAX_ENERGY_LEVEL = 10;

    private int hungerLevel;
    private int happinessLevel;
    private int energyLevel;

    public TamagotchiGame() {
        hungerLevel = MAX_HUNGER_LEVEL;
        happinessLevel = MAX_HAPPINESS_LEVEL;
        energyLevel = MAX_ENERGY_LEVEL;
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        String choice;

        while (true) {
            displayStats();
            System.out.println("Enter an option: ");
            System.out.println("1. Feed");
            System.out.println("2. Play");
            System.out.println("3. Sleep");
            System.out.println("4. Exit");

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
        if (hungerLevel < MAX_HUNGER_LEVEL) {
            hungerLevel++;
            System.out.println("Yum! Your Tamagotchi enjoyed the meal.");
        } else {
            System.out.println("Your Tamagotchi is already full.");
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
