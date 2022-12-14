/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sokoban.core;

import sokoban.exception.PlayerNotPlacedException;
import sokoban.interfaces.Display;
import sokoban.interfaces.PlayerInteraction;
import sokoban.interfaces.Resettable;

/**
 *
 * @author fadillarizky
 */
public class Sokoban implements Resettable{

	public static final String APP_NAME = "Sokoban";
	
	/**
	 * The game level
	 */
	private Level level;
	
	/**
	 * The copy of the level at its creation
	 */
	private Level levelCopy;

	/**
	 * The player
	 */
	private PlayerInteraction player;
	
	/**
	 * The display
	 */
	private Display display;
	
	/**
	 * Create a new Sokoban
	 * @param player The player
	 * @param display The display
	 */
	public Sokoban(PlayerInteraction player, Display display){
		this.player = player;
		this.display = display;
		this.level = null;
		this.levelCopy = null;
	}

	/**
	 * Checks if the game is finished.
	 * A game is finished if all boxes are placed on targets
	 * @return <tt>true</tt> if the game is finished, i.e. all the boxes are on targets,
	 *         <tt>false</tt> if not.
	 */
	public boolean isGameFinished(){
		
		for (Position boxPos : this.level.getBoxPositions()) {
			if(!this.isThisElementAt(FixedMapElement.TARGET, boxPos))
				return false;
		}

		return true;
	}

	/**
	 * Moves a box from a given position to a given direction.
	 * @param boxPosition The position of the box to moved
	 * @param dir The direction to moved
	 * @return <tt>true</tt> if the box has been moved, 
	 *          <tt>false</tt> if the box could not be moved because 
	 *          there is a blocking WALL or BOX.
	 */
	private boolean moveBox(Position boxPosition, Direction dir){

		Position finalPos = boxPosition.nextPosition(dir);
		if(!this.canMoveTheBoxTo(finalPos))
			return false;

		this.level.moveBox(boxPosition, finalPos);

		return true;
	}

	/**
	 * Checks if the BOX can move to a given position.
	 * @param pos The position check the move
	 * @return <tt>true</tt> if the movable element can move to the given position,
	 *         <tt>false</tt> if the movable element is blocked by WALL or BOX
	 */
	private boolean canMoveTheBoxTo(Position pos) {
		if(this.isThisElementAt(FixedMapElement.WALL, pos))
			return false;
		
		for (Position boxPos : this.level.getBoxPositions()) {
			if(boxPos.equals(pos))
				return false;
		}
		return true;
	}

	/**
	 * Moves the character to a given direction.
	 * @param dir The direction to move
	 * @return <tt>true</tt> if the character can move to the given direction,
	 *         <tt>false</tt> if the character is blocked by WALL or BOX
	 */
	private boolean moveCharacter(Direction dir){
		
		Position finalCharacterPos = this.level.getCharacterPosition().nextPosition(dir);
		
		for (Position boxPos : this.level.getBoxPositions()) {
			// There is a box at the next position of the character
			if(boxPos.equals(finalCharacterPos)){
				if(!this.moveBox(boxPos, dir))
					return false;
			}
			else{
				if(this.isThisElementAt(FixedMapElement.WALL, finalCharacterPos))
					return false;
			}
		}
		this.level.moveCharacter(finalCharacterPos);
		return true;
	}

	/**
	 * Checks if an element is at the given position
	 * @param elem The element to test
	 * @param pos The position to test
	 * @return <tt>true</tt> if there is the element at the given position,
	 *         <tt>false</tt> if not.
	 */
	private boolean isThisElementAt(FixedMapElement elem, Position pos){
		return (this.level.getFixedMapElement(pos) == elem);
	}


	/**
	 * Run the game.
	 * Displays the board level and asks the player to move.
	 * If the game is won, it exits the Sokoban game.
	 */
	public void play() {
		this.display.displayStartingMessage();
		
		int levelNumber = this.player.askLevelToPlay();
		
		int turn = 0;
		
		try {
			this.level = new MapLoader(Level.getLevels()[levelNumber], levelNumber).load();
			this.levelCopy = this.level.clone();
		} catch (PlayerNotPlacedException e) {
			e.printStackTrace();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		this.display.displayMessage("You are playing the level " + levelNumber);

		while (true)
		{
			this.display.displayLevel(this.level);
			
			if(this.isGameFinished()){
				this.display.displayMessage("You have won the level " + levelNumber + " in " + turn + " turns");
				this.player.askToQuit();
			}
			
			Direction dirToMove = (Direction) this.player.askDirection();
			
			if(dirToMove == null){
				this.resetLevel();
				turn = 0;
			}
			else{
				this.moveCharacter(dirToMove);
				turn++;
			}
		}
	}

	/**
	 * @param level The level to set
	 */
	private void setLevel(Level level) {
		this.level = level;
	}

	@Override
	public void resetLevel() {
		try {
			this.setLevel(this.levelCopy.clone());
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}
	
}