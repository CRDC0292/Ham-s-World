package javagame;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Play extends BasicGameState {
	Random rand = new Random();

	Animation ham, movingUp, movingDown, movingLeft, movingRight;
	Image worldMap;
	boolean quit = false;
	int[] duration = { 200, 200 };
	float hamPositionX = 0;
	float hamPositionY = 0;
	float shiftX = hamPositionX + 320;
	float shiftY = hamPositionY + 160;

	Animation pig, pigUp, pigDown, pigLeft, pigRight;
	float randX = rand.nextInt(521);
	float randY = rand.nextInt(438);
	float pigPositionX = randX + shiftX;
	float pigPositionY = randY + shiftY;
	int pigMove;

	public Play(int state) {

	}

	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		worldMap = new Image("res/world.png");
		Image[] walkUp = { new Image("res/hamback.png"), new Image("res/hamback.png") };
		Image[] walkDown = { new Image("res/hamfront.png"), new Image("res/hamfront.png") };
		Image[] walkLeft = { new Image("res/hamleft.png"), new Image("res/hamleft.png") };
		Image[] walkRight = { new Image("res/hamright.png"), new Image("res/hamright.png") };

		movingUp = new Animation(walkUp, duration, false);
		movingDown = new Animation(walkDown, duration, false);
		movingLeft = new Animation(walkLeft, duration, false);
		movingRight = new Animation(walkRight, duration, false);
		ham = movingDown;

		Image[] pigWalkUp = { new Image("res/pigback.png"), new Image("res/pigback.png") };
		Image[] pigWalkDown = { new Image("res/pigfront.png"), new Image("res/pigfront.png") };
		Image[] pigWalkLeft = { new Image("res/pigleft.png"), new Image("res/pigleft.png") };
		Image[] pigWalkRight = { new Image("res/pigright.png"), new Image("res/pigright.png") };

		pigUp = new Animation(pigWalkUp, duration, false);
		pigDown = new Animation(pigWalkDown, duration, false);
		pigLeft = new Animation(pigWalkLeft, duration, false);
		pigRight = new Animation(pigWalkRight, duration, false);
		pig = pigDown;
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		worldMap.draw(hamPositionX, hamPositionY);
		ham.draw(shiftX, shiftY);
		pig.draw(hamPositionX + pigPositionX, hamPositionY + pigPositionY);
		g.drawString("This is is X " + hamPositionX + " ", 325, 50);
		g.drawString("This is is Y " + hamPositionY + " ", 325, 100);

		if (quit == true) {
			g.drawString("Resume (R)", 250, 100);
			g.drawString("Main Menu (M)", 250, 150);
			g.drawString("Quit (Q)", 250, 200);
			if (quit == false) {
				g.clear();
			}
		}
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
		Input input = gc.getInput();
		
		if(input.isKeyDown(Input.KEY_UP)){
			ham = movingUp;
			hamPositionY += delta * .1f;
			if(hamPositionY>162){
				hamPositionY -= delta * .1f;
			}
		}
		if(input.isKeyDown(Input.KEY_DOWN)){
			ham = movingDown;
			hamPositionY -= delta * .1f;
			if(hamPositionY<-600){
				hamPositionY += delta * .1f;
			}
		}

		if(input.isKeyDown(Input.KEY_LEFT)){
			ham = movingLeft;
			hamPositionX += delta * .1f;
			if(hamPositionX>334){
				hamPositionX -= delta * .1f;
			}
		}

		if(input.isKeyDown(Input.KEY_RIGHT)){
			ham = movingRight;
			hamPositionX -= delta * .1f;
			if(hamPositionX<-855){
				hamPositionX += delta * .1f;
			}
		}
		if(input.isKeyDown(Input.KEY_ESCAPE)){
			quit = true;
		}
		if(quit){
			if(input.isKeyDown(Input.KEY_R)){
				quit = false;
			}
			if(input.isKeyDown(Input.KEY_M)){
				sbg.enterState(0);
				quit = false;
			}
			if(input.isKeyDown(Input.KEY_Q)){
				System.exit(0);
			}
		}
			
			pigMove = rand.nextInt(4);
			
			if(pigMove == 0){
				pig = pigUp;
				pigPositionY += delta * .1f;
				
				if(hamPositionY + pigPositionY>162){
					pigPositionY += delta * .1f;
					
				}
			}
				if(pigMove == 1){
					pig = pigDown;
					pigPositionY -= delta * .1f;
					
				
					if(hamPositionY + pigPositionY>-600){
						pigPositionY -= delta * .1f;
						
					}
				}
					if(pigMove == 2){
						pig = pigLeft;
						pigPositionX += delta * .1f;
						
					
						if(hamPositionX + pigPositionX>334){
							pigPositionX += delta * .1f;
							
						}
					}
						if(pigMove == 3){
							pig = pigRight;
							pigPositionX -= delta * .1f;
							
						
							if(hamPositionY + pigPositionX>-855){
								pigPositionY -= delta * .1f;
								
							}
							
						}
						
							
			}
			
			
					
					

	

	public int getID() {
		return 1;
	}
}
