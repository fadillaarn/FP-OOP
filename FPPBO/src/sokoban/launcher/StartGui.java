/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sokoban.launcher;

import javax.swing.SwingUtilities;
import sokoban.core.Sokoban;
import sokoban.ui.graphic.GameWindow;
import sokoban.ui.graphic.MenuWindow;

/**
 *
 * @author fadillarizky
 */
public class StartGui {
    public StartGui(){
		MenuWindow sokobanMenu = new MenuWindow();
		SwingUtilities.invokeLater((Runnable) sokobanMenu);
		
		while(true){
			if(sokobanMenu.isLevelSelected())
				break;
		}

		GameWindow game = sokobanMenu.getGameWindow();
		new Sokoban(game, game).play();
	}
}
