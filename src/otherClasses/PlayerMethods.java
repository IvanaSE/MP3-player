package otherClasses;

import interfaces.PlayerInterface;
import jaco.mp3.player.MP3Player;

public class PlayerMethods implements PlayerInterface{
	
	private MP3Player mp3player = new MP3Player();

	public MP3Player getPlayer() {
		return mp3player;
	}

	public void setPlayer(MP3Player mp3player) {
		this.mp3player = mp3player;
	}

	@Override
	public void myOpen() {
		mp3player.stop();
		mp3player.play();
		
	}

	@Override
	public void myPlay() {
		
		mp3player.play();
		
	}

	@Override
	public void myPause() {
	
		mp3player.pause();
		
	}

	@Override
	public void myStop() {
		
		mp3player.stop();
		
		
	}

}
