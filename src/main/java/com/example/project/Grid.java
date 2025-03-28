package com.example.project;


//DO NOT DELETE ANY METHODS BELOW
public class Grid{
    private Sprite[][] grid;
    private int size;

    public Grid(int size) { //initialize and create a grid with all DOT objects
        grid = new Sprite[size][size];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = new Dot(i, j);
            }
        }
        this.size = size;
    }

 
    public Sprite[][] getGrid(){return grid;}



    public void placeSprite(Sprite s){ //place sprite in new spot
        grid[size-1-s.getY()][s.getX()] = s; //convert cartesian to rowcol
    }

    public void placeSprite(Sprite s, String direction) { //place sprite in a new spot based on direction
        if (s instanceof Player) {
            int x = 0;
            int y = 0;
            if (direction.equals("w")) {//check if the input is a directional key (WASD)
                x = s.getX();
                y = s.getY() - 1;
            } else if (direction.equals("s")) {
                x = s.getX();
                y = s.getY() + 1;
            } else if (direction.equals("a")) {
                x = s.getX() + 1;
                y = s.getY();
            } else if (direction.equals("d")) {
                x = s.getX() - 1;
                y = s.getY();
            }
            Player previousPos = new Player(x, y);
            if (previousPos.isValid(size, direction)) {//check from previous position whether it is valid to move somewhere
                for (int i = 0; i < grid.length; i++) {//remove player from spot
                    for (int j = 0; j < grid[i].length; j++) {
                        if (grid[i][j] instanceof Player) {
                            placeSprite(new Dot(j, size-1-i));
                            break;
                        }
                    }
                }
                placeSprite(s);//update move position
                placeSprite(new Dot(x, y));//prev position becomes dot
            }
        }
    }


    public void display() { //print out the current grid to the screen 
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] instanceof Player) {
                    System.out.print("P ");
                } else if (grid[i][j] instanceof Trophy) {
                    System.out.print("W ");
                } else if (grid[i][j] instanceof Treasure) {
                    System.out.print("T ");
                } else if (grid[i][j] instanceof Enemy) {
                    System.out.print("E ");
                } else {
                    System.out.print("O ");
                }
            }
            System.out.println();
        }
    }
    
    public void gameover(){ //use this method to display a loss
    }

    public void win(){ //use this method to display a win 
    }


}