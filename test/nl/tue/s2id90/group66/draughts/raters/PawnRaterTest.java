/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nl.tue.s2id90.group66.draughts.raters;

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
public class PawnRaterTest {
    
    public PawnRaterTest() {
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

    /**
     * Test of ratePiece method, of class PawnRater.
     */
    @Test
    public void testRatePiece() {
        for (int myScore = -10; myScore <= 10; myScore++) {
            for (int opponentsScore = -10; opponentsScore <= 10; opponentsScore++) {
                PawnRater instance = new DefaultRater(myScore, opponentsScore);
                for (int position = 1; position <= 50; position++) {
                    for (int pieceType = 0; pieceType <= 5; pieceType++) {
                        if (PawnRater.isPawn(pieceType)) {
                            if (instance.isPieceMine(pieceType)) {
                                assertEquals(instance.ratePiece(position, pieceType), myScore);
                            } else {
                                assertEquals(instance.ratePiece(position, pieceType), opponentsScore);
                            }
                        } else {
                            assertEquals(instance.ratePiece(position, pieceType), 0);
                        }
                    }
                }
            }
        }
    }

    public static class DefaultRater extends PawnRater {
        
        private final int myScore;
        private final int opponentsScore;
        
        public DefaultRater(int myScore, int opponentsScore) {
            this.myScore = myScore;
            this.opponentsScore = opponentsScore;
        }
        
        @Override
        protected int ratePawn(int position, boolean isMine) {
            if (isMine) {
                return myScore;
            } else {
                return opponentsScore;
            }
        }

    }
    
}
