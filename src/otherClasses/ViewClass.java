package otherClasses;



import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;

import jaco.mp3.player.MP3Player;

public class ViewClass implements ActionListener {

	private JFrame frmMyApplication;
	private JButton btnPlay = new JButton("PLAY");
	private JButton btnPause = new JButton("PAUSE");
	private JButton btnStop = new JButton("STOP");
	private JButton btnOpen = new JButton ("OPEN");
	private JLabel lblNowPlaying = new JLabel("Now playing: no song");
	private MP3Player player = new MP3Player(new File("/home/ivana/Music/prva_ljubav.mp3"));
	private File file = new File("/home/ivana/Music/prva_ljubav.mp3");
	final JFileChooser fileChooser = new JFileChooser();
	
	
	/**
	 * Launch the application.
	 */
	
//flyttad till Main classen  
 	/*Main method
	public static void main(String[] args) {
					ViewClass window = new ViewClass();
					window.frmMyApplication.setVisible(true);
	}
*/
	/**
	 * Create the application.
	 */
	public ViewClass() {
		createGUI();
		addComponentsToFrame();
		addActionListeners();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void createGUI() {
		frmMyApplication = new JFrame();
		frmMyApplication.getContentPane().setBackground(Color.PINK);
		frmMyApplication.setTitle("My mp3-player");
		frmMyApplication.setBounds(100, 100, 492, 197);
		frmMyApplication.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMyApplication.getContentPane().setLayout(null);
			
		btnPlay.setBounds(58, 72, 84, 25);
		btnPause.setBounds(300, 72, 84, 25);
		btnStop.setBounds(396, 72, 84, 25);
		btnOpen.setBounds(179, 72, 92, 25);
		lblNowPlaying.setBounds(34, 45, 446, 15);
		
		frmMyApplication.setVisible(true);
		
	}
	
	public void addComponentsToFrame(){
		frmMyApplication.getContentPane().add(btnPlay);
		frmMyApplication.getContentPane().add(btnPause);
		frmMyApplication.getContentPane().add(btnStop);
		frmMyApplication.getContentPane().add(btnOpen);
		frmMyApplication.getContentPane().add(lblNowPlaying);
	}
	
	public void addActionListeners(){
		//add action listener to btnBlack
		btnPlay.addActionListener(this);
		//add action listener to btnRed
		btnPause.addActionListener(this);
		
		btnStop.addActionListener(this);
		
		btnOpen.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//add action performed to btnBlack
		//add action performed to btnRed
		if(e.getSource()==btnPlay){
			player.play();
			lblNowPlaying.setText("Now playing: " + file.getName());
		}
		
		if(e.getSource()==btnPause){
			player.pause();
		}
		
		if(e.getSource()==btnStop){
			player.stop();
		}
		
		if(e.getSource()==btnOpen){
			
			int returnVal = fileChooser.showOpenDialog(null);
			if(returnVal == JFileChooser.APPROVE_OPTION){
				//file sparar undan den valda filen
				file = fileChooser.getSelectedFile();
				MP3Player player= new MP3Player (file);
				player.play();
				lblNowPlaying.setText("Now playing: " + file);
						
			}	
			
		}
		
	}
	
}

