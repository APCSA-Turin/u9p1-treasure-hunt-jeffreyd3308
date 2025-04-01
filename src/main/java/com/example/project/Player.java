package com.example.project;

//DO NOT DELETE ANY METHODS BELOW
public class Player extends Sprite {
    private int treasureCount;
    private int numLives;
    private boolean win;

    public Player(int x, int y) { //set treasureCount = 0 and numLives = 2 
        super(x, y);
        treasureCount = 0;
        numLives = 2;
        win = false;
    }

    public Player(int x, int y, int numLives) { //custom lives
        super(x, y);
        treasureCount = 0;
        this.numLives = numLives;
        win = false;
    }

    public int getTreasureCount(){return treasureCount;}
    public int getLives(){return numLives;}
    public boolean getWin(){return win;}

    @Override
    //move method should override parent class, sprite
    public void move(String direction) { //move the (x,y) coordinates of the player
        if (direction.equals("w")) {//check if the input is a directional key (WASD)
            super.setY(getY() + 1);
        } else if (direction.equals("s")) {
            super.setY(getY() - 1);
        } else if (direction.equals("a")) {
            super.setX(getX() - 1);
        } else if (direction.equals("d")) {
            super.setX(getX() + 1);
        }
    }


    public void interact(int size, String direction, int numTreasures, Object obj) { // interact with an object in the position you are moving to 
    //numTreasures is the total treasures at the beginning of the game
        if (obj instanceof Treasure && !(obj instanceof Trophy)) {//interact with treasure but not trophy
            treasureCount++;
        } else if (obj instanceof Enemy) {//interact with enemy
            numLives--;
        } else if (obj instanceof Trophy) {//interact with trophy
            if (treasureCount == numTreasures) {//check if surpassed treasure threshold
                win = true;
            }
        }
    }


    public boolean isValid(int size, String direction){ //check grid boundaries
        if (direction.equals("w")) {//check if the input is a directional key (WASD)
            if (super.getY() < size - 1) {//check if Y is on the edge
                return true;
            }
            return false;
        } else if (direction.equals("s")) {
            if (super.getY() > 0) {//check if Y is on the edge
                return true;
            }
            return false;
        } else if (direction.equals("a")) {
            if (super.getX() > 0) {//check if X is on the edge
                return true;
            }
            return false;
        } else if (direction.equals("d")) {

            if (super.getX() < size - 1) {//check if X is on the edge
                return true;
            }
            return false;
        }
        return false;
    }

    @Override
    public String getCoords(){ //returns "Enemy:"+coordinates
        return "Player:" + super.getCoords();
    }

    @Override
    public String getRowCol(int size){ //return "Enemy:"+row col
        return "Player:" + super.getRowCol(size);
    }
   
}



