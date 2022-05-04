package jukebox;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.mysql.cj.jdbc.IterateBlock;

public class SongsImpl {
Scanner sc=new Scanner(System.in);
		Connection con;
		List<songs> list;
		List<Podcasts> plist;
		//songs song=new songs();
		public List<songs> songdetail() throws SQLException
		{
			list=new ArrayList<songs>();
			con=Dbconnect.createConnection();
			PreparedStatement ps=con.prepareStatement("select song_id,songTitle,artistname,albumname,genrename from Songs");
			ResultSet rs=ps.executeQuery();
			System.out.format("%-20s %-20s %-20s %-20s %-20s\n\n","Songs ID","Songs Name","Artist Name","Album Name","Genre Name");
			System.out.println("------------------------------------------------------------------------------------------------------------");
			while(rs.next())
			{
				System.out.format("%-20s %-20s %-20s %-20s %-20s\n",rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
				list.add(new songs(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));

			}
			rs.close();
			ps.close();
			con.close();
			return list;
		}
		public void searchbyGenre(List<songs> getlist){
			List<songs> genrelist=new ArrayList<songs>();
			System.out.print("Enter a character....");
			String a=sc.next().trim();   // Ashish Ahuja
			System.out.format("%-20s %-20s %-20s %-20s %-20s\n\n","Songs ID","Songs Name","Artist Name","Album Name","Genre Name");
			System.out.println("============---------------------------------------------------------------------===========");
			genrelist =getlist.stream().filter(c->c.getGenrename().startsWith(a)).collect(Collectors.toList());
			for(songs s:genrelist)
			{
				System.out.format("%-20s %-20s %-20s %-20s %-20s\n",s.getSongid(),s.getSongtitle(),s.getArtistname(),s.getAlbumname(),s.getGenrename());
			}
			}
		public void searchbyArtist(List<songs> getlist){

			List<songs> genrelist=new ArrayList<songs>();
			System.out.print("Enter a character....");
			String a=sc.next().trim();
			System.out.format("%-20s %-20s %-20s %-20s %-20s\n\n","Songs ID","Songs Name","Artist Name","Album Name","Genre Name");
			System.out.println("============---------------------------------------------------------------------===========");
			genrelist =getlist.stream().filter(c->c.getArtistname().startsWith(a)).collect(Collectors.toList());
			for(songs s:genrelist)
			{
				System.out.format("%-20s %-20s %-20s %-20s %-20s\n",s.getSongid(),s.getSongtitle(),s.getArtistname(),s.getAlbumname(),s.getGenrename());
			}
			}
		public void searchbyAlbum(List<songs> getlist){
			List<songs> genrelist=new ArrayList<songs>();
			System.out.print("Enter a character....");
			String a=sc.next().trim();
			System.out.format("%-20s %-20s %-20s %-20s %-20s\n\n","Songs ID","Songs Name","Artist Name","Album Name","Genre Name");
			System.out.println("============---------------------------------------------------------------------===========");
			genrelist =getlist.stream().filter(c->c.getAlbumname().startsWith(a)).collect(Collectors.toList());
			for(songs s:genrelist)
			{
				System.out.format("%-20s %-20s %-20s %-20s %-20s\n",s.getSongid(),s.getSongtitle(),s.getArtistname(),s.getAlbumname(),s.getGenrename());
			}
			}
//--------------------------------------------------------------------------------------------PodCasts--
		public List<Podcasts> podcastsdetail() throws SQLException{
			plist=new ArrayList<Podcasts>();
			con=Dbconnect.createConnection();
			PreparedStatement ps=con.prepareStatement("select * from Podcast");
			ResultSet rs=ps.executeQuery();
			System.out.format("%-20s %-30s %-20s %-20s %-20s\n\n","Podcast ID","Podcast Name","Celeb Name","Publish Date","Episode no.");
			System.out.println("------------------------------------------------------------------------------------------------------------");
			while(rs.next())
			{
				System.out.format("%-20s %-30s %-20s %-20s %-20s\n",rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDate(4),rs.getInt(5));
				plist.add(new Podcasts(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDate(4),rs.getInt(5)));
			}

			rs.close();
			ps.close();
			con.close();
			return plist;
		}
		public void searchbyceleb(List<Podcasts> getplist){
			List<Podcasts> podcastslist=new ArrayList<Podcasts>();
			System.out.println("Enter a celebrity/Religious name do you want to search");
			String celeb=sc.next().trim();
			podcastslist=getplist.stream().filter(p->p.getPodceleb().startsWith(celeb)).collect(Collectors.toList());
			System.out.format("%-20s %-30s %-20s %-20s %-20s\n\n","Podcast ID","Podcast Name","Celeb Name","Publish Date","Episode no.");
			System.out.println("------------------------------------------------------------------------------------------------------------");
			for(Podcasts p: podcastslist)
			{
				System.out.format("%-20s %-30s %-20s %-20s %-20s\n",p.getPodid(),p.getPodname(),p.getPodceleb(),p.getPoddate(),p.getPodep());
			}
			System.out.println("::::::::::::::::::::::::::::::::");
			searchbyepisode(podcastslist);
		}
		public void searchbyDate(List<Podcasts> getplist) {
			List<Podcasts> pdate=new ArrayList<Podcasts>();
			System.out.println("Enter the date in yyyy-mm-dd format");
			String date=sc.next();
			Date pd=Date.valueOf(date);
			pdate=getplist.stream().filter(p->p.getPoddate().equals(pd)).collect(Collectors.toList());
			System.out.format("%-20s %-30s %-20s %-20s %-20s\n\n","Podcast ID","Podcast Name","Celeb Name","Publish Date","Episode no.");
			System.out.println("------------------------------------------------------------------------------------------------------------");
			for(Podcasts p: pdate)
			{
				System.out.format("%-20s %-30s %-20s %-20s %-20s\n",p.getPodid(),p.getPodname(),p.getPodceleb(),p.getPoddate(),p.getPodep());
			}
			System.out.println("::::::::::::::::::::::::::::::::");
			searchbyepisode(pdate);
			
		}
		public void searchbyepisode(List<Podcasts> getplist) {
			List<Podcasts> pod=new ArrayList<Podcasts>();
			System.out.println("Enter the episode number.");
			int a=sc.nextInt();
			for(Podcasts p: getplist)
			{
				if(p.getPodep()==a)
				{
					System.out.format("%-20s %-30s %-20s %-20s %-20s\n\n","Podcast ID","Podcast Name","Celeb Name","Publish Date","Episode no.");
					System.out.println("------------------------------------------------------------------------------------------------------------");
					System.out.format("%-20s %-30s %-20s %-20s %-20s\n",p.getPodid(),p.getPodname(),p.getPodceleb(),p.getPoddate(),p.getPodep());
				}
			}
		}
	
		
}


