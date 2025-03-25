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


    public int getTreasureCount(){return treasureCount;}
    public int getLives(){return numLives;}
    public boolean getWin(){return win;}

  
    //move method should override parent class, sprite
    public void move(String direction) { //move the (x,y) coordinates of the player
        switch (direction) {//check if the input is a directional key (WASD)
            case "w"://up
                setY(getY() + 1);
                break;
            case "s"://down
                setY(getY() - 1);
                break;
            case "a"://left
                setX(getX() - 1);
                break;
            case "d"://right
                setX(getX() + 1);
                break;
        }
    }


    public void interact(int size, String direction, int numTreasures, Object obj) { // interact with an object in the position you are moving to 
    //numTreasures is the total treasures at the beginning of the game
        if (isValid(size, direction)) {
            move(direction);
            if (obj instanceof Treasure && ((Treasure)obj).getCoords().equals(super.getCoords()) && !(obj instanceof Trophy)) {//interact with treasure but not trophy
                treasureCount++;
            } else if (obj instanceof Enemy && ((Enemy)obj).getCoords().equals("Enemy:" + super.getCoords())) {//interact with enemy
                numLives--;
                if (numLives == 0) {
                    //death gameover
                }
            } else if (obj instanceof Trophy && ((Trophy)obj).getCoords().equals(super.getCoords())) {//interact with trophy
                if (treasureCount >= numTreasures) {//check if surpassed treasure threshold
                    win = true;
                }
            }
        }
    }


    public boolean isValid(int size, String direction){ //check grid boundaries
        switch (direction) {//check if the input is wasd
            case "w":
                if (getY() < size - 1) {//check if Y is on the edge
                    return true;
                }
                return false;
            case "s":
                if (getY() > 0) {//check if X is on the edge
                    return true;
                }
                return false;
            case "d":
                if (getX() < size - 1) {//check if Y is on the edge
                    return true;
                }
                return false;
            case "a":
                if (getX() > 0) {//check if X is on the edge
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



