package otherClasses;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JLabel;

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
	public void open() {
		JFileChooser fileChooser= new JFileChooser();
		int returnVal = fileChooser.showOpenDialog(null);
		if(returnVal == JFileChooser.APPROVE_OPTION){
			//file sparar undan den valda filen
			File file = new File ("" + fileChooser.getSelectedFile());
			mp3player.stop();
			mp3player= new MP3Player (file);
			mp3player.play();
			JLabel lblNowPlaying = new JLabel();
			lblNowPlaying.setText("Now playing: " + file.getName());
		
		}
	}

	@Override
	public void play() {
		final MP3Player player = new MP3Player(new File("null"));
		player.play();
		
	}

	@Override
	public void pause() {
		final MP3Player player = new MP3Player(new File("null"));
		player.pause();
		
	}

	@Override
	public void stop() {
		final MP3Player player = new MP3Player(new File("null"));
		player.stop();
		
		
	}

}
