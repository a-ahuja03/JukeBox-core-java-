package jukebox;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import jukebox1.SongsDetails;

public class PlayTrack
{Scanner sc=new Scanner(System.in);
player play1;
//	public void  playingsongs(List<songs> list) throws UnsupportedAudioFileException, IOException, LineUnavailableException
//	{
//	
//	System.out.println("Enter the song id");
//	Integer x=sc.nextInt();
//	String filepath="";
//	
//	Iterator<songs> it=list.iterator();
//	while(it.hasNext())
//	{
//		if(x.equals(list.get(0).getSongid()))
//		{
//			if(x==5)
//				filepath="A:\\assignment\\jdbcDemo\\src\\Lover.wav";
//			play1.playtmusic(filepath);
//			if(x==1)
//				filepath="A:\\assignment\\jdbcDemo\\src\\Rait zara.wav";
//			play1.playtmusic(filepath);
//		}
//	}}
	//==============================================
	public String  playingsongs(List<songs> list) throws IOException, LineUnavailableException, UnsupportedAudioFileException {
		System.out.println("ENter song id");
		Integer x=sc.nextInt();
		String filepath="";
		
		for(songs s:list)
		{
				if(x.equals(s.getSongid()))
			{
			if(x==5) {
				filepath="A:\\assignment\\jdbcDemo\\resou\\Lover.wav";
				
				return filepath;
			
			}
			if(x==1) {
				filepath="A:\\assignment\\jdbcDemo\\resou\\Rait zara.wav";
				return filepath;
				}
			if(x==2) {
				filepath="A:\\assignment\\jdbcDemo\\resou\\Pehla Pyaar.wav";
				return filepath;
			}
			}
		}
		return filepath;
	}
//--------------------------------------------------------------------------------podcast.	
	public String  playingpodcasts(List<Podcasts> list) throws UnsupportedAudioFileException, IOException, LineUnavailableException
	{
		
	System.out.println("Enter the Podcast id");
	Integer x=sc.nextInt();
	String filepath="";
	for(Podcasts p:list)
	{
		if(x.equals(p.getPodid()))
		{
			if(x==3) {
				filepath="A:\\assignment\\jdbcDemo\\resou\\Chanakya-Neeti-Explained.wav";
				return filepath;
			}
		}
	}
	return filepath;
	}
	}
