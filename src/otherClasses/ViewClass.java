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
	private PlayerMethods pm = new PlayerMethods();
	
	
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
		frmMyApplication.getContentPane().add(btnPlay).setEnabled(false);
		frmMyApplication.getContentPane().add(btnPause).setEnabled(false);
		frmMyApplication.getContentPane().add(btnStop).setEnabled(false);
		frmMyApplication.getContentPane().add(btnOpen);
		frmMyApplication.getContentPane().add(lblNowPlaying);
	}
	
	public void addActionListeners(){
		//add action listener to btnPlay
		btnPlay.addActionListener(this);
		//add action listener to btnPause
		btnPause.addActionListener(this);
		
		btnStop.addActionListener(this);
		
		btnOpen.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		//add action performed to btnPlay
		if(e.getSource()==btnPlay){
		
			pm.myPlay();
		}
		
		if(e.getSource()==btnPause){
			
			pm.myPause();	
		}
		
		if(e.getSource()==btnStop){
			
			pm.myStop();	
		}
		
		if(e.getSource()==btnOpen){
			
			JFileChooser fileChooser= new JFileChooser();
			int returnVal = fileChooser.showOpenDialog(null);
			
			if(returnVal == JFileChooser.APPROVE_OPTION){
				//file sparar undan den valda filen
				
				File file = new File ("" + fileChooser.getSelectedFile());
				
				if (file.toString().contains(".mp3")){
					pm.myStop();
					pm.setPlayer(new MP3Player (file));
					pm.myOpen();
					lblNowPlaying.setText("Now playing: " + file.getName());
			
					btnPlay.setEnabled(true);
					btnPause.setEnabled(true);
					btnStop.setEnabled(true);
				}else{
					lblNowPlaying.setText("Cannot play that file, please choose a file in mp3 format.");
				}
			}
		}
	
	}
}

