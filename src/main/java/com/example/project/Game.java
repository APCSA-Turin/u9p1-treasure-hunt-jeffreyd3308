package com.example.project;
import java.util.Scanner;

public class Game{
    private Grid grid;
    private Player player;
    private Enemy[] enemies;
    private Treasure[] treasures;
    private Trophy trophy;
    private int size; 

    public Game(int difficulty){ //the constructor should call initialize() and play()
        if (difficulty == 3) {
            size = 20;
            initialize(3);
        } else if (difficulty == 2) {
            size = 15;
            initialize(2);
        } else if (difficulty == 1) {
            size = 10;
            initialize(1);
        }
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
        int amountTreasure = treasures.length;
        while(!end){
            try {
                Thread.sleep(100); // Wait for 1/10 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clearScreen(); // Clear the screen at the beggining of the while loop

            grid.display();
            System.out.println("Input a movement key (WASD)");
            direction = scanner.next();
            scanner.nextLine();
            if (direction.equals("w") || direction.equals("s") || direction.equals("a") || direction.equals("d")) {//check if input is valid
                if (player.isValid(size, direction)) {//check if movement is valid
                    Player movedPlayer = new Player(player.getX(), player.getY());//get new player movements to use interact
                    movedPlayer.move(direction);
                    for (int i = 0; i < enemies.length; i++) {
                        if (enemies[i] != null && movedPlayer.getX() == enemies[i].getX() && movedPlayer.getY() == enemies[i].getY()){//check if new position overlaps with enemy position
                            player.interact(size, direction, treasures.length, enemies[i]);
                            enemies[i] = null;
                        }
                    }
                    for (int i = 0; i < treasures.length; i++) {
                        if (treasures[i] != null && movedPlayer.getX() == treasures[i].getX() && movedPlayer.getY() == treasures[i].getY()){//check if new position overlaps with treasure position
                            player.interact(size, direction, treasures.length, treasures[i]);
                            treasures[i] = null;
                        }
                    }
                    if (movedPlayer.getX() == trophy.getX() && movedPlayer.getY() == trophy.getY()){//check if new position overlaps with trophy position
                        player.interact(size, direction, treasures.length, trophy);
                    }
                    player.move(direction);//move player visually
                    grid.placeSprite(player, direction);
                    if (player.getWin()) {//check if there is win conditions
                        clearScreen();
                        grid.display();
                        grid.win();
                        end = true;//stop loop and win
                    }
                    if (player.getLives() == 0) {
                        clearScreen();
                        grid.display();
                        grid.gameover();
                        end = true;//stop loop and lose
                    }
                }
            } else {
                System.out.println("invalid movement key");
            }
            
        }
        scanner.close();
    }

    public void initialize(int diff){

        //to test, create a player, trophy, grid, treasure, and enemies. Then call placeSprite() to put them on the grid
        if (diff == 1) {
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
        } else if (diff == 2) {
            grid = new Grid(size);
            player = new Player(0, 0);
            Enemy enemy = new Enemy(5, 5);
            Enemy enemy2 = new Enemy(7,8);
            Enemy enemy3 = new Enemy(14, 3);
            Enemy enemy4 = new Enemy(12, 13);
            Treasure treasure = new Treasure(4, 2);
            Treasure treasure2 = new Treasure(12,6);
            Treasure treasure3 = new Treasure(13, 2);
            trophy = new Trophy(14, 14);
            enemies = new Enemy[4];
            enemies[0] = enemy;
            enemies[1] = enemy2;
            enemies[2] = enemy3;
            enemies[3] = enemy4;
            treasures = new Treasure[3];
            treasures[0] = treasure;
            treasures[1] = treasure2;
            treasures[2] = treasure3;
            grid.placeSprite(player);
            grid.placeSprite(enemy);
            grid.placeSprite(enemy2);
            grid.placeSprite(enemy3);
            grid.placeSprite(enemy4);
            grid.placeSprite(treasure);
            grid.placeSprite(treasure2);
            grid.placeSprite(treasure3);
            grid.placeSprite(trophy);
        } else if (diff == 3) {
            grid = new Grid(size);
            player = new Player(0, 0, 1);
            Enemy enemy = new Enemy(5, 5);
            Enemy enemy2 = new Enemy(7,8);
            Enemy enemy3 = new Enemy(14, 3);
            Enemy enemy4 = new Enemy(12, 13);
            Enemy enemy5 = new Enemy(17, 14);
            Enemy enemy6 = new Enemy(19, 3);
            Treasure treasure = new Treasure(17, 2);
            Treasure treasure2 = new Treasure(19,7);
            Treasure treasure3 = new Treasure(15, 17);
            trophy = new Trophy(19, 19);
            enemies = new Enemy[6];
            enemies[0] = enemy;
            enemies[1] = enemy2;
            enemies[2] = enemy3;
            enemies[3] = enemy4;
            enemies[4] = enemy5;
            enemies[5] = enemy6;
            treasures = new Treasure[3];
            treasures[0] = treasure;
            treasures[1] = treasure2;
            treasures[2] = treasure3;
            grid.placeSprite(player);
            grid.placeSprite(enemy);
            grid.placeSprite(enemy2);
            grid.placeSprite(enemy3);
            grid.placeSprite(enemy4);
            grid.placeSprite(enemy5);
            grid.placeSprite(enemy6);
            grid.placeSprite(treasure);
            grid.placeSprite(treasure2);
            grid.placeSprite(treasure3);
            grid.placeSprite(trophy);
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Choose your difficulty, 1/2/3");
        int diff = scan.nextInt();
        if (diff == 1 || diff == 2 || diff == 3) {
            Game game = new Game(diff);
        } else {
            System.out.println("invalid difficulty");
        }
    }
}