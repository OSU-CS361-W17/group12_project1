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
		boolean placed = false; //checks if this ship type has been placed already 

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

    }
    

    //ships instantiated as elements of the model class
    ship aircraftCarrier=new ship(5,"AircraftCarrier");
    ship battleship=new ship(4,"Battleship");
    ship cruiser=new ship(3,"Cruiser");
    ship destroyer=new ship(2,"Destroyer");
    ship submarine=new ship(3,"Submarine");
    ship computer_aircraftCarrier=new ship(5,"Computer_AircraftCarrier");
    ship computer_battleship=new ship(4,"Computer_Battleship");
    ship computer_cruiser=new ship(3,"Computer_Cruiser");
    ship computer_destroyer=new ship(2,"Computer_Destroyer");
    ship computer_submarine=new ship(3,"Computer_Submarine");

    public BattleshipModel(){//model constructor, initializes computer ship positions
        computer_aircraftCarrier.setStart(2, 2);
        computer_aircraftCarrier.setEnd(2,7);
        computer_battleship.setStart(2,8);
        computer_battleship.setEnd(6,8);
        computer_cruiser.setStart(4,1);
        computer_cruiser.setEnd(4,4);
        computer_destroyer.setStart(7,3);
        computer_destroyer.setEnd(7,5);
        computer_submarine.setStart(9,6);
        computer_submarine.setEnd(9,9);
    }

    public int sinkcheck(ship bs){ //takes in a ship object from the model class, returns 1 if the ship has sunk, zero if not
        if (bs.hits>=bs.length){
            return 1;
        }
        else{
            return 0;
        }
    }

    public int checkWin(){ //checks for a winner, returns zero if the game should continue, one if the computer has won, and two if the player has won
        int p=0;
        int c=0;
        p=sinkcheck(aircraftCarrier)+sinkcheck(battleship)+sinkcheck(cruiser)+sinkcheck(destroyer)+sinkcheck(submarine);
        c=sinkcheck(computer_aircraftCarrier)+sinkcheck(computer_battleship)+sinkcheck(computer_cruiser)+sinkcheck(computer_destroyer)+sinkcheck(computer_submarine);
        if (p==5 && c==5){//this should never happen
            return -4;
        }
        else if(p==5) {//computer wins
            return 1;
        }
        else if(c==5){//player wins
            return 2;
        }
        else{
            return 0;
        }
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
	
	/*************************************
		This function takes in a ship type to be placed on the board
		and checks if it has already been placed. 
		
		If the ship has been placed the function will return 1.
		If the ship has not been placed the function will return 0.
		
		As a result of this function if the ship was not previously placed it's
		boolean placed will be updated to true because this function is a check
		on placing a ship on the board. 
	
	**************************************/
	public boolean isShipPlaced(ship type){ 
	
	if(type.placed == true){ //if the ship has been placed return true, yes the ship has been placed
			return 1;
		}
		
		else{ //if the ship has not been placed update the boolean to show it has been placed
			type.placed = true; //the ship will be placed after this function check
			return 0; //the ship was not previously placed
		}
		
		
	}

}
