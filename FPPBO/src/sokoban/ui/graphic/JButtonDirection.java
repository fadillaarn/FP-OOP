/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sokoban.ui.graphic;

import javax.swing.JButton;
import sokoban.core.Direction;


/**
 *
 * @author fadillarizky
 */
public class JButtonDirection extends JButton{

	/**
	 * Serial version UID
	 */
	private static final long serialVersionUID = 2505227624068099054L;
	
	/**
	 * The direction linked with the button
	 */
	private Direction direction;

	/**
	 * Creates a new direction button
	 * @param representation The text representation of the button
	 * @param direction The direction to link with the button
	 */
	public JButtonDirection(String representation, Direction direction) {
		super(representation);
		this.direction = direction;
		this.setFocusable(false);
	}

	/**
	 * @return the direction
	 */
	public Direction getDirection() {
		return this.direction;
	}

}