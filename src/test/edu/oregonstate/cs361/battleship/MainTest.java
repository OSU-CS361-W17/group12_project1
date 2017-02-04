package edu.oregonstate.cs361.battleship;

import com.google.gson.Gson;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import spark.Spark;
import spark.utils.IOUtils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static spark.Spark.awaitInitialization;


/**
 * Created by michaelhilton on 1/26/17.
 */
class MainTest {

    @BeforeAll
    public static void beforeClass() {
        Main.main(null);
        awaitInitialization();
    }
    @Test
    public void testsinkcheck(){
        BattleshipModel bsm = new BattleshipModel();
        bsm.destroyer.setHits(2);
        assertEquals(bsm.sinkcheck(bsm.destroyer()),1);
        assertEquals(bsm.sinkcheck(bsm.cruiser()),0);
    }
    @Test
    public void testcheckWin(){
        BattleshipModel bsm = new BattleshipModel();
        assertEquals(bsm.checkWin(),0);//no winner

        bsm.destroyer.setHits(5);
        bsm.cruiser.setHits(5);
        bsm.submarine.setHits(5);
        bsm.aircraftCarrier.setHits(5);
        bsm.battleship.setHits(5);
        assertEquals(bsm.checkWin(),1);//computer should win

        bsm.battleship.setHits(0);
        bsm.computer_destroyer.setHits(5);
        bsm.computer_cruiser.setHits(5);
        bsm.computer_submarine.setHits(5);
        bsm.computer_aircraftCarrier.setHits(5);
        bsm.computer_battleship.setHits(5);
        assertEquals(bsm.checkWin(),2)//player should win

    }
    @AfterAll
    public static void afterClass() {
        Spark.stop();
    }

    @Test
    public void testGetModel() {
        TestResponse res = request("GET", "/model");
        assertEquals(200, res.status);
        assertEquals("MODEL",res.body);
    }

    @Test
    public void testPlaceShip() {
        TestResponse res = request("POST", "/placeShip/aircraftCarrier/1/1/horizontal");
        assertEquals(200, res.status);
        assertEquals("SHIP",res.body);
    }

    private TestResponse request(String method, String path) {
        try {
            URL url = new URL("http://localhost:4567" + path);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(method);
            connection.setDoOutput(true);
            connection.connect();
            String body = IOUtils.toString(connection.getInputStream());
            return new TestResponse(connection.getResponseCode(), body);
        } catch (IOException e) {
            e.printStackTrace();
            fail("Sending request failed: " + e.getMessage());
            return null;
        }
    }

    private static class TestResponse {

        public final String body;
        public final int status;

        public TestResponse(int status, String body) {
            this.status = status;
            this.body = body;
        }

        public Map<String,String> json() {
            return new Gson().fromJson(body, HashMap.class);
        }
    }
    @test
    public void testOnBoard(){
        BattleshipModel bsm = new Battlesraftcarrier, 7, 7, "across"),0);
        assertEquals(onBoard(bsm.battleship, 8, 8, "down"),0);
        assertEquals(onBoard(bsm.battlhipModel();

        assertEquals(onBoard(bsm.battlship, 1, 1, "down"),1);
        assertEquals(onBoard(bsm.aircraftcarrier, 7, 7, "down"),0);
        assertEquals(onBoard(bsm.aircraftcarrier, 8, 8, "across"),0);
        assertEquals(onBoard(bsm.crusier, 9, 9, "down"),0);
        assertEquals(onBoard(bsm.crusier, 9, 9, "across"),0);
        assertEquals(onBoard(bsm.submarine, 9, 9, "down"),0);
        assertEquals(onBoard(bsm.submarine, 9, 9, "across"),0);
        assertEquals(onBoard(bsm.destroyer, 10, 10, "down"),0);
        assertEquals(onBoard(bsm.destroyer, 10, 10, "across"),0);

    }
	
	@test
	
	pubic void testIsShipPlaced(){
		
		//create a new battlehsip model
		BattleshipModel bsm = new BattleshipModel();
		
		
		//these tests will see if when a ship is not placed if the function returns 0
		//each test is for a different ship type
        assertEquals(bsm.isShipPlaced(aircraftCarrier),0);
		assertEquals(bsm.isShipPlaced(battleship),0);
		assertEquals(bsm.isShipPlaced(crusier),0);
		assertEquals(bsm.isShipPlaced(submarine),0);
		assertEquals(bsm.isShipPlaced(destroyer),0);
		
		//now that the ships have been placed the boolean "placed" should be updated to true
		
		assertEquals(bsm.isShipPlaced(aircraftCarrier),1);
		assertEquals(bsm.isShipPlaced(battleship),1);
		assertEquals(bsm.isShipPlaced(crusier),1);
		assertEquals(bsm.isShipPlaced(submarine),1);
		assertEquals(bsm.isShipPlaced(destroyer),1);
		
		
		
		
	}

}
