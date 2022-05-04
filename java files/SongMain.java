package jukebox;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class SongMain {

	public static void main(String[] args) throws SQLException, ParseException, UnsupportedAudioFileException, IOException, LineUnavailableException {
		SongsImpl sng=new SongsImpl();
		List<songs> listmain = null;
		List<Podcasts> plist=null;
		Scanner sc=new Scanner(System.in);
		PlaylistDAO pd=new PlaylistDAO();
		List<playlistpojo> pl=new ArrayList<playlistpojo>();
		char y,c;
		//----------
		//pd.add();
		//pd.fetch();
		//----------
		System.out.format("%100s","🙏🙏 ...Namaskaram...🙏🙏 \n\n ");
		
		do {

		System.out.println("Select below:-\nEnter 1 for Song Details.\nEnter 2 for Podcasts Details.\nEnter 3 for Playlist Details.");
		int d=sc.nextInt();
		switch(d)
		{
		case 1:
		{
			listmain=sng.songdetail();
			System.out.println("------------------------------------------------------------------------------------------------------------");
			do {
				System.out.println("\n\nEnter :-\n1.Search By Genre.\n2.Search By Artist.\n3.Search By Album.\n0. Main menu.");
				int a=sc.nextInt();
				switch(a)
				{
				case 1: sng.searchbyGenre(listmain); break;
				case 2: sng.searchbyArtist(listmain); break;
				case 3: sng.searchbyAlbum(listmain); break;
				default: break;	
				}
				System.out.println(":::::::::::::::::::::::\npress y to continue.\npress n to discontinue.\n:::::::::::::::::::::::");
				y=sc.next().charAt(0);
				}while(y!='n');
			
		break;	
		}
		case 2:
		{
			plist=sng.podcastsdetail();
			System.out.println("------------------------------------------------------------------------------------------------------------");
			do {
				System.out.println("\n\nEnter :-\n1.Search By Celebrity.\n2.Search By Date.\n0. Main menu.");
				int a=sc.nextInt();
				switch(a)
				{
				case 1: sng.searchbyceleb(plist); break;
				case 2: sng.searchbyDate(plist);  break;
				default: break;	
				}
				System.out.println(":::::::::::::::::::::::\npress y to continue.\npress n to discontinue.\n:::::::::::::::::::::::");
				y=sc.next().charAt(0);
				}while(y!='n');
			break;
		}
		case 3:
		{
			System.out.println("------------------------------------------------------------------------------------------------------------");
			do {
				System.out.println("\n\nEnter :-\n1.For Addition.\n2.For fetching.\n3.For deleting.\n4.Fetch with specific playlist Name.\n0. Main menu.");
				int a=sc.nextInt();
				switch(a)
				{
				case 1: pd.add(); break;
				case 2: pd.fetch(); break;
				case 3: pd.delete(); break;
				case 6: System.out.println(listmain+"\n"+plist); break;
				case 4: {pd.fetchwithspecific();
				System.out.println("Enter 1 to play songs.\nEnter 2 to play podcasts");
				int z=sc.nextInt();
				if(z==1) 
				{
				PlayTrack pt=new PlayTrack();
				String xyz=pt.playingsongs(listmain);
				player play1=new player();
				play1.playtmusic(xyz);
				}
				if(z==2) 
				{
					PlayTrack pt=new PlayTrack();
					String xyz=pt.playingpodcasts(plist);
					player play1=new player();
					play1.playtmusic(xyz);
				}
				break;}
				default: break;
				}

				System.out.println(":::::::::::::::::::::::\npress y to continue.\npress n to discontinue.\n:::::::::::::::::::::::");
				y=sc.next().charAt(0);
				}while(y!='n');
		}
		default: break;
		}
		System.out.println("Press c for continue browsing.\nPress e for exit.");
		c=sc.next().charAt(0);
		}while(c!='e');
		System.out.format("%100s","🙏🙏 ...ThankYou for Using Our Jukebox...🙏🙏 ");
	}
}
