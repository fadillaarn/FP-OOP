/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sokoban.ui.graphic;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import sokoban.core.Level;

/**
 *
 * @author fadillarizky
 */
public class LevelSelectionPanel extends JPanel{

	/**
	 * Serial version UID
	 */
	private static final long serialVersionUID = 4640854857338587932L;

	/**
	 * The level combo list
	 */
	private JComboBox<String> levelList;
	
	/**
	 * The validation button
	 */
	private JButton validationButton;
	
	/**
	 * Creates a new level selection panel
	 */
	public LevelSelectionPanel(ActionListener listener){
		
		this.levelList = new JComboBox<String>(Level.getLevels());
		this.validationButton = new JButton("Validate");
		
		this.add(this.levelList);
		this.add(this.validationButton);
		
		this.validationButton.addActionListener(listener);
	}

	/**
	 * @return the validationButton
	 */
	public JButton getValidationButton() {
		return this.validationButton;
	}

	/**
	 * @return the levelList
	 */
	public JComboBox<String> getLevelList() {
		return this.levelList;
	}
	
}
