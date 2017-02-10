/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nl.tue.s2id90.group66.draughts.raters;

import nl.tue.s2id90.draughts.DraughtsState;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Wim Reddingius
 */
public class DraughtsRaterTest {
    
    public DraughtsRaterTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testWhiteMine() {
        testWhiteMineValues(true);
        testWhiteMineValues(false);
    }
    
    public void testWhiteMineValues(boolean value) {
        DraughtsRater rater = new DefaultDraughtsRater();
        testWhiteMineValue(rater, value);
        testWhiteMineValue(rater, !value);
    }
    
    public void testWhiteMineValue(DraughtsRater instance, boolean value) {
        instance.setWhiteMine(value);
        assertEquals(instance.isWhiteMine(), value);
    }
    
    /**
     * Test of isPieceMine method, of class DraughtsRater.
     */
    @Test
    public void testIsPieceMine() {
        DraughtsRater raterWhiteMine = new WhiteMineDraughtsRater();
        DraughtsRater raterBlackMine = new BlackMineDraughtsRater();
        for (int pieceType = -1; pieceType <= 6; pieceType++) {
            switch (pieceType) {
                case DraughtsState.WHITEPIECE:
                case DraughtsState.WHITEKING:
                    assertTrue(raterWhiteMine.isPieceMine(pieceType));
                    assertFalse(raterBlackMine.isPieceMine(pieceType));
                    break;
                case DraughtsState.BLACKKING:
                case DraughtsState.BLACKPIECE:
                    assertTrue(raterBlackMine.isPieceMine(pieceType));
                    assertFalse(raterWhiteMine.isPieceMine(pieceType));
                    break;
                default:
                    assertFalse(raterBlackMine.isPieceMine(pieceType));
                    assertFalse(raterWhiteMine.isPieceMine(pieceType));
            }
        }
    }

    /**
     * Test of isEmpty method, of class DraughtsRater.
     */
    @Test
    public void testIsEmpty() {
        for (int pieceType = -1; pieceType <= 6; pieceType++) {
            switch (pieceType) {
                case DraughtsState.WHITEPIECE:
                case DraughtsState.WHITEKING:
                case DraughtsState.BLACKKING:
                case DraughtsState.BLACKPIECE:
                    assertFalse(DraughtsRater.isEmpty(pieceType));
                    break;
                default:
                    assertTrue(DraughtsRater.isEmpty(pieceType));
            }
        }
    }

    /**
     * Test of isPiece method, of class DraughtsRater.
     */
    @Test
    public void testIsPiece() {
        for (int pieceType = -1; pieceType <= 6; pieceType++) {
            switch (pieceType) {
                case DraughtsState.WHITEPIECE:
                case DraughtsState.WHITEKING:
                case DraughtsState.BLACKKING:
                case DraughtsState.BLACKPIECE:
                    assertTrue(DraughtsRater.isPiece(pieceType));
                    break;
                default:
                    assertFalse(DraughtsRater.isPiece(pieceType));
            }
        }
    }

    /**
     * Test of isKing method, of class DraughtsRater.
     */
    @Test
    public void testIsKing() {
        for (int pieceType = -1; pieceType <= 6; pieceType++) {
            switch (pieceType) {
                case DraughtsState.WHITEKING:
                case DraughtsState.BLACKKING:
                    assertTrue(DraughtsRater.isKing(pieceType));
                    break;
                default:
                    assertFalse(DraughtsRater.isKing(pieceType));
            }
        }
    }

    /**
     * Test of isPawn method, of class DraughtsRater.
     */
    @Test
    public void testIsPawn() {
        for (int pieceType = -1; pieceType <= 6; pieceType++) {
            switch (pieceType) {
                case DraughtsState.WHITEPIECE:
                case DraughtsState.BLACKPIECE:
                    assertTrue(DraughtsRater.isPawn(pieceType));
                    break;
                default:
                    assertFalse(DraughtsRater.isPawn(pieceType));
            }
        }
    }

    /**
     * Test of getRow method, of class DraughtsRater.
     */
    @Test
    public void testGetRow() {
        for (int position = 1; position <= 50; position++) {
            if (position <= 5) {
                assertEquals(DraughtsRater.getRow(position), 0);
            } else if (position <= 10) {
                assertEquals(DraughtsRater.getRow(position), 1);
            } else if (position <= 15) {
                assertEquals(DraughtsRater.getRow(position), 2);
            } else if (position <= 20) {
                assertEquals(DraughtsRater.getRow(position), 3);
            } else if (position <= 25) {
                assertEquals(DraughtsRater.getRow(position), 4);
            } else if (position <= 30) {
                assertEquals(DraughtsRater.getRow(position), 5);
            } else if (position <= 35) {
                assertEquals(DraughtsRater.getRow(position), 6);
            } else if (position <= 40) {
                assertEquals(DraughtsRater.getRow(position), 7);
            } else if (position <= 45) {
                assertEquals(DraughtsRater.getRow(position), 8);
            } else if (position <= 50) {
                assertEquals(DraughtsRater.getRow(position), 9);
            }
        }
    }

    /**
     * Test of getMyBaseRow method, of class DraughtsRater.
     */
    @Test
    public void testGetBaseRows() {
        DraughtsRater raterWhiteMine = new WhiteMineDraughtsRater();
        DraughtsRater raterBlackMine = new BlackMineDraughtsRater();
        int baseRowWhite = 9;
        int baseRowBlack = 0;
        assertEquals(raterWhiteMine.getMyBaseRow(), baseRowWhite);
        assertEquals(raterWhiteMine.getOpponentsBaseRow(), baseRowBlack);
        assertEquals(raterBlackMine.getMyBaseRow(), baseRowBlack);
        assertEquals(raterBlackMine.getOpponentsBaseRow(), baseRowWhite);
    }

    /**
     * Test of isPieceAdjacentToEdge method, of class DraughtsRater.
     */
    @Test
    public void testIsPieceAdjacentToEdge() {
        for (int position = 1; position <= 50; position++) {
            if (position <= 5 || position >= 46 || position % 10 == 5 || position % 10 == 6) {
                assertTrue("DraughtsRater.isPieceAdjacentToEdge(" + position + ") == false", DraughtsRater.isPieceAdjacentToEdge(position));
            } else {
                assertFalse("DraughtsRater.isPieceAdjacentToEdge(" + position + ") == true", DraughtsRater.isPieceAdjacentToEdge(position));
            }
        }
    }

    /**
     * Test of isAtMyPromotionLine method, of class DraughtsRater.
     */
    @Test
    public void testIsAtMyPromotionLine() {
        DraughtsRater[] raters = new DraughtsRater[] { new WhiteMineDraughtsRater(), new BlackMineDraughtsRater() };
        for (DraughtsRater rater : raters) {
            for (int position = 1; position <= 50; position++) {
                if (DraughtsRater.getRow(position) == rater.getOpponentsBaseRow()) {
                    assertTrue("Color: " + rater + ", isAtMyPromotionLine(" + position + ") must return true", rater.isAtMyPromotionLine(position));
                } else {
                    assertFalse("Color: " + rater + ", isAtMyPromotionLine(" + position + ") must return false", rater.isAtMyPromotionLine(position));
                }
            }
        }
    }

    private static class DefaultDraughtsRater extends DraughtsRater {

        public DefaultDraughtsRater() {
        }

        @Override
        public int rate(DraughtsState state) {
            throw new UnsupportedOperationException();
        }
    }

    private static class WhiteMineDraughtsRater extends DefaultDraughtsRater {

        public WhiteMineDraughtsRater() {
            setWhiteMine(true);
        }

        @Override
        public String toString() {
            return "white";
        }

    }

    private static class BlackMineDraughtsRater extends DefaultDraughtsRater {

        public BlackMineDraughtsRater() {
            setWhiteMine(false);
        }
        
        @Override
        public String toString() {
            return "black";
        }

    }

}
