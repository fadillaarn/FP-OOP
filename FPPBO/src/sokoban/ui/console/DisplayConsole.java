/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sokoban.ui.console;

import sokoban.core.Level;
import sokoban.interfaces.Display;

/**
 *
 * @author fadillarizky
 */
public class DisplayConsole implements Display{

	@Override
	public void displayMessage(String msg) {
		System.out.println(msg);
	}

	@Override
	public void displayStartingMessage() {
		this.displayMessage("Sokoban Game\n");
		this.displayMessage("\t '@': CHARACTER     - '$': BOX");
		this.displayMessage("\t '*': BOX on TARGET - '+': CHARACTER on TARGET");
		this.displayMessage("\t '#': WALL          - '.': TARGET\n");
		this.displayMessage("------------");
	}

	public void displayLevel(Level level) {
		System.out.println(level.toString());
	}

    public void displayLevel(Object level) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}