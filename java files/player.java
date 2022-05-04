package jukebox;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class player  {
    Scanner sc= new Scanner(System.in);
	
	  public void playtmusic(String filepath) throws IOException, LineUnavailableException, UnsupportedAudioFileException {
		System.out.println(filepath);  
	File file=new File(filepath);                  
	
	AudioInputStream audioStream=AudioSystem.getAudioInputStream(file.getAbsoluteFile());
	Clip clip = AudioSystem.getClip();
	clip.open(audioStream);
	
	String response="";
	
	
    while(!response.equals("Q")) {
    	System.out.println("P = play, S = Stop, R = Reset, Q = Quit");
    	System.out.println("Enter your choice");
    	 response=sc.next().toUpperCase();
    	switch(response) {
    	case "P" :  clip.start();
    	break;
    	case "S" : clip.stop();
    	break;
    	case "R" : clip.setMicrosecondPosition(0);
    	break;
    	case "Q" : clip.close();
    	break;
    	default : System.out.println("Not a valid Response");
    	}
    }
   
	
	
}
}