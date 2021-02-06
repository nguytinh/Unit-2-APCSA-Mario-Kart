package javagame;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;


public class Menu extends BasicGameState {

    Image playNow;
    Image exitGame;
    Image marioFront;

    public Menu( int state ){

    }

    public void init( GameContainer gc, StateBasedGame sbg ) throws SlickException {

        playNow = new Image( "res/playNow.png" );
        exitGame = new Image( "res/exitGame.png" );
        marioFront = new Image( "res/mariooo.png" );
    }

    public void render( GameContainer gc, StateBasedGame sbg, Graphics g ) throws SlickException {
        g.drawString( "Welcome to Mario Kart", 100, 50 );
            // play and quit button
        playNow.draw( 100, 100 );
        exitGame.draw( 100, 200 );
            // creates Mario
        marioFront.draw(400, 150);
    }

    public void update( GameContainer gc, StateBasedGame sbg, int delta ) throws SlickException {
            // Mouse position
        int posX = Mouse.getX();
        int posY = Mouse.getY();

        if( ( posX > 100 && posX < 311 ) && ( posY > 209 && posY < 260 ) ) {
            if( Mouse.isButtonDown( 0 ) ) {
                sbg.enterState( 1 );
            }
        }

        if( ( posX > 100 && posX < 311 ) && ( posY > 109 && posY < 160 ) ) {
            if( Mouse.isButtonDown( 0 ) ) {
                System.exit( 0 );
            }
        }
    }

    public int getID() {
        return 0;
    }
}
