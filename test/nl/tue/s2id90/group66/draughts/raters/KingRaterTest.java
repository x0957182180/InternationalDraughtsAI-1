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
public class KingRaterTest {
    
    public KingRaterTest() {
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
     * Test of ratePiece method, of class KingRater.
     */
    @Test
    public void testRatePiece() {
        for (int myKingScore = -10; myKingScore <= 10; myKingScore++) {
            for (int opponentsKingScore = -10; opponentsKingScore <= 10; opponentsKingScore++) {
                KingRater instance = new DefaultKingRater(myKingScore, opponentsKingScore);
                for (int position = 1; position <= 50; position++) {
                    for (int pieceType = 0; pieceType <= 5; pieceType++) {
                        if (KingRater.isKing(pieceType)) {
                            if (instance.isPieceMine(pieceType)) {
                                assertEquals(instance.ratePiece(position, pieceType), myKingScore);
                            } else {
                                assertEquals(instance.ratePiece(position, pieceType), opponentsKingScore);
                            }
                        } else {
                            assertEquals(instance.ratePiece(position, pieceType), 0);
                        }
                    }
                }
            }
        }
    }

    public static class DefaultKingRater extends KingRater {
        
        private final int myKingScore;
        private final int opponentsKingScore;
        
        public DefaultKingRater(int myKingScore, int opponentsKingScore) {
            this.myKingScore = myKingScore;
            this.opponentsKingScore = opponentsKingScore;
        }
        
        @Override
        protected int rateKing(int position, boolean isMine) {
            if (isMine) {
                return myKingScore;
            } else {
                return opponentsKingScore;
            }
        }

    }
    
}
