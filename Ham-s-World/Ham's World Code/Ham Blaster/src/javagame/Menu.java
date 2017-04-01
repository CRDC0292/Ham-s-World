package javagame;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.lwjgl.input.*;

public class Menu extends BasicGameState{

	Image playNow;
	Image exitGame;
	Image ham;
	Image bg;
	
	public Menu(int state){
		
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
		playNow = new Image("res/playNow.png");
		exitGame = new Image("res/exitGame.png");
		ham = new Image("res/hamfront.png");
		bg = new Image("res/backgroundHamWorld.jpg");
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
		g.drawImage(bg, 0, 0);
		g.drawString("Welcome to Ham's Land", 250, 50);
		g.drawImage(playNow, 250, 100);
		g.drawImage(exitGame, 250, 150);
		g.drawImage(ham, 330, 200);
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
		int posX = Mouse.getX();
		int posY = Mouse.getY();
		
		if((posX>250 && posX<411) && (posY>209 && posY<260)){
			if(Mouse.isButtonDown(0)){
				sbg.enterState(1);
			}
		}
		if((posX>250 && posX<411) && (posY>159 && posY<210)){
			if(Mouse.isButtonDown(0)){
				System.exit(0);
			}
		}
	}
	
	public int getID(){
		return 0;
	}
}
