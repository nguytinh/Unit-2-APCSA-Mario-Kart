package javagame;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;


public class Dead extends BasicGameState {

    Image deathScreen;
    boolean quit = false;

    public Dead( int state ){

    }

    public void init( GameContainer gc, StateBasedGame sbg ) throws SlickException {

        deathScreen = new Image( "res/deadScreen.jpg" );
    }

    public void render( GameContainer gc, StateBasedGame sbg, Graphics g ) throws SlickException {
    	deathScreen.draw(0, 0);
    	if ( quit == true ) {
            g.drawString( "Quit Game ( Q )", 250, 200 );
            
            if( quit == false ) {
                g.clear();
            }
        }
    }

    public void update( GameContainer gc, StateBasedGame sbg, int delta ) throws SlickException {
    	Input input = gc.getInput();
    	//escape
    	if(input.isKeyDown(Input.KEY_ESCAPE)) {
    		quit = true;
    	}
    	if(quit==true){
    		
    		if(input.isKeyDown(Input.KEY_Q)) {
    			System.exit(0);
    		}
    	}
        
    }

    public int getID() {
        return 2;
    }
}
