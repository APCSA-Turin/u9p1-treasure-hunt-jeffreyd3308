package com.example.project;
import java.util.Scanner;

public class Game{
    private Grid grid;
    private Player player;
    private Enemy[] enemies;
    private Treasure[] treasures;
    private Trophy trophy;
    private int size; 

    public Game(int size){ //the constructor should call initialize() and play()
        this.size = size;
        initialize();
        play();
    }

    public static void clearScreen() { //do not modify
        try {
            final String os = System.getProperty("os.name").toLowerCase();
            if (os.contains("win")) {
                // Windows
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // Unix-based (Linux, macOS)
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void play(){ //write your game logic here
        Scanner scanner = new Scanner(System.in);
        boolean end = false;
        String direction = "";
        while (!end) {
            grid.display();
            System.out.println("Input a movement key (WASD)");
            direction = scanner.next();
            scanner.nextLine();
            if (direction.equals("w") || direction.equals("s") || direction.equals("a") || direction.equals("d")) {
                if (player.isValid(size, direction)) {
                    for (int i = 0; i < enemies.length; i++) {
                        player.interact(size, direction, treasures.length, enemies[i]);
                    }
                    for (int i = 0; i < treasures.length; i++) {
                        player.interact(size, direction, treasures.length, treasures[i]);
                    }
                    player.interact(size, direction, treasures.length, trophy);
                    player.move(direction);
                    grid.placeSprite(player, direction);
                    if (player.getWin()) {
                        grid.win();
                        end = true;
                    }
                    if (player.getLives() == 0) {
                        grid.gameover();
                        end = true;
                    }
                }
            } else {
                System.out.println("invalid movement key");
            }
        }

        while(true){
            try {
                Thread.sleep(100); // Wait for 1/10 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clearScreen(); // Clear the screen at the beggining of the while loop

     
            }
            
     
    }

    public void initialize(){

        //to test, create a player, trophy, grid, treasure, and enemies. Then call placeSprite() to put them on the grid
        grid = new Grid(size);
        player = new Player(0, 0);
        Enemy enemy = new Enemy(5, 5);
        Enemy enemy2 = new Enemy(7,8);
        Treasure treasure = new Treasure(2, 2);
        Treasure treasure2 = new Treasure(1,7);
        trophy = new Trophy(9, 9);
        enemies = new Enemy[2];
        enemies[0] = enemy;
        enemies[1] = enemy2;
        treasures = new Treasure[2];
        treasures[0] = treasure;
        treasures[1] = treasure2;
        grid.placeSprite(player);
        grid.placeSprite(enemy);
        grid.placeSprite(enemy2);
        grid.placeSprite(treasure);
        grid.placeSprite(treasure2);
        grid.placeSprite(trophy);
    }

    public static void main(String[] args) {
        Game game = new Game(10);
    }
}