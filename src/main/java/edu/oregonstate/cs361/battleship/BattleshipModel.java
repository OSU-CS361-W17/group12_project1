package edu.oregonstate.cs361.battleship;

/**
 * Created by michaelhilton on 1/26/17.
 */
public class BattleshipModel {
    public class ship {//ship class
        String name;
        int length;
        int hits = 0;
        int start[];
        int end[];

        public ship(int l, String n) {//constructor, initializes name and length from arguments
            length = l;
            name = n;
        }

        public void setStart(int x, int y) {//mutator for ship's start position
            start[0] = x;
            start[1] = y;
        }

        public void setEnd(int x, int y) {//mutator for ship's end position
            end[0] = x;
            end[1] = y;
        }

        public void setHits(int n) {//mutator for hits
            hits = n;
        }

        ship aircraftCarrier = new ship(5, "AircraftCarrier");
        ship battleship = new ship(4, "Battleship");
        ship cruiser = new ship(3, "Cruiser");
        ship destroyer = new ship(2, "Destroyer");
        ship submarine=new ship(3,"Submarine");
        ship computer_aircraftCarrier=new ship(5,"Computer_AircraftCarrier");
        ship computer_battleship=new ship(4,"Computer_Battleship");
        ship computer_cruiser=new ship(3,"Computer_Cruiser");
        ship computer_destroyer=new ship(2,"Computer_Destroyer");
        ship computer_submarine=new ship(3,"Computer_Submarine");





    }
    public int onBoard(ship sp, int x, int y, String dir) {//checks that ship is on the board
        if (dir == "across" && x + sp.length > 10) {//if x value of start location plus ship length is greater than 10 the ship is off the board
            return 0;
        } else if (dir == "down" && y + sp.length > 10) {//if y value of start location plus ship length is greater than 10 the ship is off the board
            return 0;
        } else {//ship should be on board
            return 1;
        }

    }

    public int dontCross(BattleshipModel bsm, ship sp, int x, int y, String dir){//checks that ships don't cross eachother
        int[] spaces = new int[5];
        if(dir == "across") {//records all x values that ship occupies
            for (int i = 0; i <= sp.length - 1;i++) {
                spaces[i] = x+i;
            }
        }

        else{
            for (int i = 0; i <= sp.length - 1; i++) {//records all y values that ship occupies
                spaces[i] = y+i;
            }
        }

        //
        return 0;
    }
}
