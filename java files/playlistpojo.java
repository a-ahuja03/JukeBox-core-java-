package jukebox;

public class playlistpojo {

	private String playlistname;
	private int songid;
	private int podcastid;
	@Override
	public String toString() {
		return "playlistpojo [playlistname=" + playlistname + ", songid=" + songid + ", podcastid=" + podcastid + "]";
	}
	public String getPlaylistname() {
		return playlistname;
	}
	public void setPlaylistname(String playlistname) {
		this.playlistname = playlistname;
	}
	public int getSongid() {
		return songid;
	}
	public void setSongid(int songid) {
		this.songid = songid;
	}
	public int getPodcastid() {
		return podcastid;
	}
	public void setPodcastid(int podcastid) {
		this.podcastid = podcastid;
	}
	public playlistpojo(String playlistname, int songid, int podcastid) {
		super();
		this.playlistname = playlistname;
		this.songid = songid;
		this.podcastid = podcastid;
	}
	
}
