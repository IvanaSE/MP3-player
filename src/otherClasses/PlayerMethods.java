package otherClasses;

import interfaces.PlayerInterface;
import jaco.mp3.player.MP3Player;
/**
 * This class implements PlayerInterface methods
 * @author IvanaSE
 * @version 1.0
 *
 */
public class PlayerMethods implements PlayerInterface{
	
	private MP3Player mp3player = new MP3Player();
	/**
	 * getter for MP3Player attribute
	 * @return mp3player
	 */
	public MP3Player getPlayer() {
		return mp3player;
	}
	/**
	 * setter for MP3Player attribute
	 * @param mp3player mp3player of class jaco-pm3-player
	 */
	public void setPlayer(MP3Player mp3player) {
		this.mp3player = mp3player;
	}
	/**
	 * sets music playing
	 */
	//@Override
	public void myOpen() {
		
		mp3player.play();
		
	}
	/**
	 * sets music playing
	 */
	//@Override
	public void myPlay() {
		
		mp3player.play();
		
	}
	/**
	 * pauses the music
	 */
	//@Override
	public void myPause() {
	
		mp3player.pause();
		
	}
	/**
	 * pauses the music
	 */
	//@Override
	public void myStop() {
		
		mp3player.stop();
		
		
	}

}
