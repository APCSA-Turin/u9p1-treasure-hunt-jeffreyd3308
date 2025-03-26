package com.example.project;

public class Test {
    public static void main(String[] args) {
        int size = 10;
        Grid grid = new Grid(size);
        Player player = new Player(0, 0);
        Treasure treasure = new Treasure(2, 2);
        player.setX(9);
        player.setY(9);
        grid.placeSprite(player);
        grid.placeSprite(treasure);
        player.move("d"); //move right
        player.move("w");//[8][0]
        player.move("w");//[7][0]
        player.move("d");//[7][1]   

        player.interact(10, "d", 2, treasure);
        player.move("d");//[7][2] // treasure 
        grid.placeSprite(player, "d");
        grid.display();
        System.out.println("--------------------");

        player.move("w"); //[6][2]
        grid.placeSprite(player,"w");
        grid.display();
        System.out.println(player.getRowCol(size));

    }
}