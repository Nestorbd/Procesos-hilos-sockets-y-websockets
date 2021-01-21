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
public enum Hand {
    stone(0),
    paper(1),
    scissors(2);
    
    private int index;

    private Hand(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
    
    
}
