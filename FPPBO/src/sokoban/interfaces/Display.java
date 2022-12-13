/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sokoban.interfaces;

import sokoban.core.Level;

/**
 *
 * @author fadillarizky
 */
public interface Display {

	/**
	 * Displays a message
	 * @param msg The message to display
	 */
	public void displayMessage(String msg);
	
	/**
	 * Displays the starting message
	 */
	public void displayStartingMessage();
	
	/**
	 * Displays the level
	 * @param level The level
	 */
	public void displayLevel(Level level);
	
//	/**
//	 * Resets the level display
//	 * @param level The level to reset
//	 */
//	public void resetLevelDisplay(Level level);
	
}
