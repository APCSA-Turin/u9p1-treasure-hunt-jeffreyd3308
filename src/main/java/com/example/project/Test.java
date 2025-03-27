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
        player.move("w");//[8][0]
        player.move("w");//[7][0]
        player.move("d");//[7][1]   

        player.interact(10, "d", 2, treasure);
        player.move("d");//[7][2] // treasure 
        grid.placeSprite(player, "d");

        player.move("w"); //[6][2]
        grid.placeSprite(player,"w");
        grid.display();
        System.out.println();
        for(int i=0;i<4;i++){
            player.move("w");//[2][2]
        }

        player.interact(10,"a",2,treasure2);
        player.move("a");//[2][1] treasure collected 
        grid.placeSprite(player,"a");

        player.move("a");
        grid.placeSprite(player,"a");//[2][0]
        grid.display();
        System.out.println();
    }
}