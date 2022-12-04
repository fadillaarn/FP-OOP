/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package placethebox;

import java.awt.EventQueue;
import javax.swing.JFrame;

/**
 *
 * @author fadillarizky
 */
public class GobakSodor extends JFrame {
    
    private final int OFFSET = 30;

    public GobakSodor() {

        initUI();
    }

    private void initUI() {
        
        Board board = new Board();
        add(board);

        setTitle("Place The Box");
        
        setSize(board.getBoardWidth() + OFFSET,
                board.getBoardHeight() + 2 * OFFSET);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    
    public static void main(String[] args) {
        
        EventQueue.invokeLater(() -> {
            
            GobakSodor game = new GobakSodor();
            game.setVisible(true);
        });
    }
}
