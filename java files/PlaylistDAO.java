package jukebox;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class PlaylistDAO {

	Connection con;
	Scanner sc=new Scanner(System.in);
	//List<playlistpojo> list;
	List<String> list;
	public void add() throws SQLException {
		
		con=Dbconnect.createConnection();
		System.out.println("Enter 1 to add both podcast and songs.\nEnter 2 to add songs.\nEnter 3 to add podcast");
		int choice=sc.nextInt();
		switch(choice) {
		case 1:
		{
		PreparedStatement ps=con.prepareStatement("insert into playlisttable() values (?,?,?)");
		System.out.print("Enter playlist name...");
		String name=sc.next();
		ps.setString(1,name);
		System.out.print("Enter Song id...");
		int sid=sc.nextInt();
		ps.setInt(2, sid);
		System.out.println("Enter podcast id");
		int pid=sc.nextInt();
		ps.setInt(3, pid);
		ps.executeUpdate();
		ps.close();
		break;
		}
		case 2:
		{
			PreparedStatement ps=con.prepareStatement("insert into playlisttable(PlaylistName,songid) values (?,?)");
			System.out.print("Enter playlist name...");
			String name=sc.next();
			ps.setString(1,name);
			System.out.print("Enter Song id...");
			int sid=sc.nextInt();
			ps.setInt(2, sid);
			ps.executeUpdate();
			ps.close();
			break;
		}
		case 3:
		{
			PreparedStatement ps=con.prepareStatement("insert into playlisttable(PlaylistName,podcastid) values (?,?)");
			System.out.print("Enter playlist name...");
			String name=sc.next();
			ps.setString(1,name);
			System.out.print("Enter Podcast id...");
			int sid=sc.nextInt();
			ps.setInt(2, sid);
			ps.executeUpdate();
			ps.close();
			break;
		}
		}
		
		System.out.println("Succesfully inserted");

		con.close();
}
	public void fetch() throws SQLException
	{
		list=new ArrayList<>();
		con=Dbconnect.createConnection();
		PreparedStatement ps=con.prepareStatement("select song_id,songTitle,artistname,albumname,genrename,PlaylistName,po.PodcastId,PodcastName,CelebrityName,ep_no from Songs s join playlisttable p on s.song_id=p.songid join Podcast po on po.PodcastId=p.podcastid ");
		ResultSet rs=ps.executeQuery();
		System.out.format("%-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s\n\n","Songs ID","Songs Name","Artist Name","Album Name","Genre Name","Playlist Name","PodcastId","Podcast Name","CelebrityName","Episode No.");
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		while(rs.next())
		{
			System.out.format("%-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s\n",rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getString(8),rs.getString(9),rs.getInt(10));
		}
		ps.close();
		rs.close();
		con.close();
	}
	public void fetchwithspecific() throws SQLException
	{
		list=new ArrayList<>();
		con=Dbconnect.createConnection();
		PreparedStatement ps=con.prepareStatement("select song_id,songTitle,artistname,albumname,genrename,PlaylistName,po.PodcastId,PodcastName,CelebrityName,ep_no from Songs s join playlisttable p on s.song_id=p.songid join Podcast po on po.PodcastId=p.podcastid where PlaylistName=?");
		System.out.print("Enter the Playlist Name...");
		String a=sc.next();
		ps.setString(1, a);
		ResultSet rs=ps.executeQuery();
		System.out.format("%-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s\n\n","Songs ID","Songs Name","Artist Name","Album Name","Genre Name","Playlist Name","PodcastId","Podcast Name","CelebrityName","Episode No.");
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		while(rs.next())
		{
			System.out.format("%-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s\n",rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getString(8),rs.getString(9),rs.getInt(10));
		}
		ps.close();
		rs.close();
		con.close();
	}
	
	public void delete() throws SQLException {
		con=Dbconnect.createConnection();
		PreparedStatement ps=con.prepareStatement("delete from playlisttable where songid=?");
		System.out.println("Enter Song id to delete the record.");
		int a=sc.nextInt();
		ps.setInt(1, a);
		ps.executeUpdate();
		System.out.println("Record Removed Succesfully...");
		ps.close();
		con.close();
		
	}
}
