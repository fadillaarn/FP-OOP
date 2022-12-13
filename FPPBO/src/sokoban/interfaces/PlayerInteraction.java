/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sokoban.interfaces;

import sokoban.core.Direction;

/**
 *
 * @author fadillarizky
 */
public interface PlayerInteraction{

	/**
	 * Asks to the player a direction to move
	 * @return The direction given by the player
	 */
	public Direction askDirection();
	
	/**
	 * Asks to the player a level to play
	 * @return The selected level number
	 */
	public int askLevelToPlay();
	
	/**
	 * Asks to leave the game
	 */
	public void askToQuit();
	
}
