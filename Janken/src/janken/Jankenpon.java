/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package janken;

/**
 *
 * @author maqui
 */
public class Jankenpon {
    
    private int[][] board;
    
    public Jankenpon(){
        this.boardInitialize();
    }
    
    private void boardInitialize(){
        
        
        int[][] b = 
        {
            {0,-1,1},
            {1,0,-1},
            {-1,1,0}
        };
        
        this.board = b;
    }
    
    public int win(Hand g1, Hand g2){
        return this.board[g1.getIndex()][g2.getIndex()];
    }
}
