/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sokoban.ui.graphic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.JFrame;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import sokoban.core.Sokoban;

/**
 *
 * @author fadillarizky
 */
public class MenuWindow extends JFrame implements ActionListener, Runnable{
	
	/**
	 * The level selection panel
	 */
	private LevelSelectionPanel levelSelectionPanel;
	
	private volatile boolean isLevelSelected;
	
	private GameWindow gameWindow;
	
	public MenuWindow() {
		super(Sokoban.APP_NAME);
		this.gameWindow = null;
		this.isLevelSelected = false;
		this.levelSelectionPanel = new LevelSelectionPanel(this);
		this.getContentPane().add(this.levelSelectionPanel);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.pack();
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		JComponent source = (JComponent) event.getSource();
		
		if(source == this.levelSelectionPanel.getValidationButton()){
			this.gameWindow = new GameWindow(this.levelSelectionPanel.getLevelList().getSelectedIndex()) {
                            public void displayLevel(Object level) {
                                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                            }
                        };
			this.isLevelSelected = true;
			
			this.gameWindow.initGui();
			
			this.dispose();
		}
	}

	@Override
	public void run() {
		this.setVisible(true);
	}

	/**
	 * @return the isLevelSelected
	 */
	public boolean isLevelSelected() {
		return this.isLevelSelected;
	}

	/**
	 * @return the gameWindow
	 */
	public GameWindow getGameWindow() {
		return this.gameWindow;
	}
	
}