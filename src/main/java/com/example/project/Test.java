package com.example.project;

public class Test {
    public static void main(String[] args) {
        Player player = new Player(1, 1);
        player.move("w");
        System.out.println(player.getX());
        System.out.println(player.getY());
    }
}