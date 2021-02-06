package javagame;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Play extends BasicGameState {

        // Animations for moving in all directions plus current state
    Animation car, movingUp, movingDown, movingLeft, movingRight;
    Image worldMap;
        // User quits
    boolean quit = false;
    boolean next = false;
    int[] duration = { 200, 200 };
    float carPositionX = 248;
    float carPositionY = 147;
    float shiftX = 320;
    float shiftY = 160;

    public Play( int state ){

    }

    public void init( GameContainer gc, StateBasedGame sbg ) throws SlickException {
        worldMap = new Image( "res/FinalMap.png" );
        Image[] walkUp = { new Image( "res/CarUp.png" ), new Image( "res/CarUp.png" ) };
        Image[] walkDown = { new Image( "res/CarDown.png" ), new Image( "res/CarDown.png" ) };
        Image[] walkLeft = { new Image( "res/CarLeft.png" ), new Image( "res/CarLeft.png" ) };
        Image[] walkRight = { new Image( "res/CarRight.png" ), new Image( "res/CarRight.png" ) };

        movingUp = new Animation( walkUp, duration, false );
        movingDown = new Animation( walkDown, duration, false );
        movingLeft = new Animation( walkLeft, duration, false );
        movingRight = new Animation( walkRight, duration, false );
        car = movingDown;

    }

    public void render( GameContainer gc, StateBasedGame sbg, Graphics g ) throws SlickException {
        worldMap.draw( carPositionX, carPositionY );
        car.draw( shiftX, shiftY );
        g.drawString("Car's X: " + carPositionX + "\nCar's Y: " + carPositionY, 400, 20 );

        if ( quit == true ) {
            g.drawString( "Resume ( R )", 250, 100 );
            g.drawString( "Main Menu ( M )", 250, 150 );
            g.drawString( "Quit Game ( Q )", 250, 200 );
            
            if( quit == false ) {
                g.clear();
            }            
        }
        if ( next == true ) {
            g.drawString( "Next Level ( N )", 250, 200 );
            
            if( next == false ) {
                g.clear();
            }
        }
    }

    public void update( GameContainer gc, StateBasedGame sbg, int delta ) throws SlickException {
    	Input input = gc.getInput();
    	//movement up
    	if(input.isKeyDown(Input.KEY_UP)){
    		car = movingUp;
    		carPositionY += delta * .2f;
    		if(carPositionY>162) {
    			carPositionY -= delta * .2f;
    		}
    	}
    	//movement down
    	if(input.isKeyDown(Input.KEY_DOWN)){
    		car = movingDown;
    		carPositionY -= delta * .2f;
    		if(carPositionY<-600) {
    			carPositionY += delta * .2f;
    		}
    	}
    	//movement left
    	if(input.isKeyDown(Input.KEY_LEFT)){
    		car = movingLeft;
    		carPositionX += delta * .2f;
    		if(carPositionX>324) {
    			carPositionX -= delta * .2f;
    		}
    	}
    	//movement right
    	if(input.isKeyDown(Input.KEY_RIGHT)){
    		car = movingRight;
    		carPositionX -= delta * .2f;
    		if(carPositionX<-840) {
    			carPositionX += delta * .2f;
    		}
    	}
    	//escape
    	if(input.isKeyDown(Input.KEY_ESCAPE)) {
    		quit = true;
    	}
    	if(quit==true){
    		if(input.isKeyDown(Input.KEY_R)) {
    			quit = false;
    		}
    		if(input.isKeyDown(Input.KEY_M)) {
    			sbg.enterState(0);
    		}
    		if(input.isKeyDown(Input.KEY_N)) {
    			quit = false;
    		}
    		if(input.isKeyDown(Input.KEY_Q)) {
    			System.exit(0);
    		}
    	}
    	
    	if(carPositionX <= -575.0 && carPositionY <= -250.0) {
    		sbg.enterState(2);
    	}
    	
    	if(carPositionX <= -500.0 && carPositionY >= 145) {
    		next = true;
    		if(next==true){
        		if(input.isKeyDown(Input.KEY_ESCAPE)) {
        			next = false;
        		}
    		}
    	}
    	
    }

    public int getID() {
        return 1;
    }
}
