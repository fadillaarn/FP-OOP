/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sokoban.ui.console;

import java.util.Random;
import sokoban.core.Direction;
import sokoban.core.Level;
import sokoban.interfaces.PlayerInteraction;

/**
 *
 * @author fadillarizky
 */
public class AIPlayerConsole implements PlayerInteraction{

	@Override
	public Direction askDirection() {
		return Direction.getRandomDirection();
	}

	@Override
	public int askLevelToPlay() {
		Random rand = new Random();
		return rand.nextInt(Level.getLevels().length);
	}

	@Override
	public void askToQuit() {
		System.exit(0);
	}

}