package jukebox;

import java.io.FileNotFoundException;
import java.io.IOException;

public class songs {

	private int songid;
	private String songtitle;
	private int artistid;
	private int genreid;
	private int album;
	private String artistname;
	private String albumname;
	private String genrename;
	public String getArtistname() {
		return artistname;
	}
	public void setArtistname(String artistname) {
		this.artistname = artistname;
	}
	public String getAlbumname() {
		return albumname;
	}
	public void setAlbumname(String albumname) {
		this.albumname = albumname;
	}
	public String getGenrename() {
		return genrename;
	}
	public void setGenrename(String genrename) {
		this.genrename = genrename;
	}
	public int getSongid() {
		return songid;
	}
	public void setSongid(int songid) {
		this.songid = songid;
	}
	public String getSongtitle() {
		return songtitle;
	}
	public void setSongtitle(String songtitle) {
		this.songtitle = songtitle;
	}
	public int getArtistid() {
		return artistid;
	}
	public void setArtistid(int artistid) {
		this.artistid = artistid;
	}
	public int getGenreid() {
		return genreid;
	}
	public void setGenreid(int genreid) {
		this.genreid = genreid;
	}
	public int getAlbum() {
		return album;
	}
	public void setAlbum(int album) {
		this.album = album;
	}



	
	public songs(int songid, String songtitle, String artistname, String albumname, String genrename) {
		super();
		this.songid = songid;
		this.songtitle = songtitle;
		this.artistname = artistname;
		this.albumname = albumname;
		this.genrename = genrename;
	}
	@Override
	public String toString() {
		
		return songid+"\t\t"+songtitle+"\t\t"+artistname+"\t\t"+albumname+"\t\t"+genrename;
	}
	public void displaysongs()
	{
		System.out.format("%-10s %-10s %-10s %-10s %-10s\n ",this.getSongid(),this.getSongtitle(),this.getArtistname(),this.getAlbumname(),this.getGenrename());
		System.out.println("--------------------------------i am pojo------------------------------------");
	}

	
}
