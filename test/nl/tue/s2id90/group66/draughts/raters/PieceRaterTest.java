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
public class PieceRaterTest {
    
    public PieceRaterTest() {
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
     * Test of ratePosition method, of class PieceRater.
     */
    @Test
    public void testRatePiece() {
        for (int score = -10; score <= 10; score++) {
                PieceRater instance = new DefaultRater(score);
                for (int position = 1; position <= 50; position++) {
                    for (int pieceType = 0; pieceType <= 5; pieceType++) {
                        if (PieceRater.isPiece(pieceType)) {
                            assertEquals(instance.ratePosition(position, pieceType), score);
                        } else {
                            assertEquals(instance.ratePosition(position, pieceType), 0);
                        }
                    }
                }
            }
        }

    private static class DefaultRater extends PieceRater {

        private final int score;
        
        public DefaultRater(int score) {
            this.score = score;
        }
        
        @Override
        protected int ratePiece(int position, int pieceType) {
            return score;
        }
    
    }

}
