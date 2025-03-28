package com.example.project;

public class Test {
    public static void main(String[] args) {
        int size = 10;
        Grid grid = new Grid(size);
        Player player = new Player(0, 0);
        Treasure treasure = new Treasure(2, 2);
        Enemy enemy = new Enemy(5, 5);
        Enemy enemy2 = new Enemy(7,8);
        Treasure treasure2 = new Treasure(1,7);
        Trophy trophy = new Trophy(9, 9);
        grid.placeSprite(player);
        grid.placeSprite(enemy);
        grid.placeSprite(enemy2);
        grid.placeSprite(treasure);
        grid.placeSprite(treasure2);
        grid.placeSprite(trophy);
        grid.display();
        System.out.println();
        // Move the player to the enemy's position [4][5]
        for(int i=0;i<5;i++){
            player.move("w"); //[9-5][0]
            grid.placeSprite(player, "w");
        }

        for(int i=0;i<4;i++){
            player.move("d");//[5][4]
            grid.placeSprite(player, "d");
        }

         // Interact with the enemy
        player.interact(10, "d", 1, enemy);
        player.move("d");//[4][5]
        grid.placeSprite(player, "d");
        //go to  [2][7] enemy from [4][5]
        player.move("w");//[3][5]
        player.move("w");//[2][5]
        player.move("d");//[2][6]

        player.interact(10,"d",1,enemy2);
        player.move("d");//[2][7]
        grid.placeSprite(player,"d");
        grid.display();
        System.out.println(player.getCoords());
        System.out.println(player.getRowCol(size));
    }
}