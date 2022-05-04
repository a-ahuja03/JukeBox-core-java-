create database jukebox1;
use  jukebox1;
CREATE TABLE Artist (
		artistId int primary key auto_increment ,
        artistName varchar(72),
        genreId int,
        FOREIGN KEY (genreId) REFERENCES Genre(genreId)
);
CREATE TABLE Genre (
		genreId int PRIMARY KEY auto_increment,
        genreName varchar(72)
);
CREATE TABLE Album (
		albumId int PRIMARY KEY auto_increment,
        albumTitle varchar(72) ,
         tracks int NOT NULL,
        
        year int NOT NULL
);
CREATE TABLE Songs (
		song_id int primary key auto_increment,
		songTitle varchar(72) NOT NULL,
        duration float NOT NULL,
        artistId int NOT NULL,
        albumId int NOT NULL,
        genreId int not null,
       FOREIGN KEY (artistId) REFERENCES Artist(artistId),
        FOREIGN KEY (albumId) REFERENCES Album(albumId),
        FOREIGN KEY (genreId) REFERENCES Genre(genreId)
);
Alter table songs add column artistname varchar(30);
Alter table songs add column albumname varchar(30);
Alter table songs add column genrename varchar(30);

create table Podcast(
       PodcastId int primary key auto_increment,
       PodcastName varchar(70) ,
       CelebrityName varchar(40),
       publishdate date
       );
       alter table Podcast add column ep_no int;
 drop table Podcast;


alter table album add column genre varchar(20);
alter table songs drop column duration;

select * from Artist;
select * from  Genre;
select * from Album;
select * from Songs;
select * from Podcast;

-- drop table playlist;
-- drop table Playlistfsongs;
-- drop table Playlistfpodcast;
set sql_safe_updates=0;
	insert into Artist (artistName,genreId) values('Arjit singh','2'),('AP DHILLON','4'),('DILJIT DOSANJH','3'),('DILJIT DOSANJH','4');
    update Artist set artistName='Javed Ali' where genreId=4;
    insert into Artist (artistName,genreId) values('Shreya Ghoshal',3);
    insert into Genre(genreName) values('JAZZ'),('ROMANTIC'),('POP'),('PUNJABI BEATS');
    insert into Genre(genreName) values('Sad');
    -- insert into Genre(genreName) values('');
    insert into Album(albumTitle,tracks,year,genre)values('Atrangi re',3,2021,'ROMANTIC'),('Kabir singh',4,2020,'ROMANTIC');
    insert into Album(albumTitle,tracks,year,genre) values('Street Dancer',1,2019,'POP');
    insert into Album(albumTitle,tracks,year,genreid) values('Pushpa',3,2021,3);
    insert into Album(albumTitle,tracks,year,genre) values('Lover',1,2019,'PUNJABI BEATS'),('Dhoom 3',3,2018,'JAZZ');
    insert into Songs(songTitle,artistId,albumId,genreId) values('Rait zara si',3,1,2),('Pehla pehla pyaar',3,2,2);
    insert into Songs(songTitle,artistId,albumId,genreId) values('chaka chak',7,1,3),('Dua Karo',3,3,5);
    insert into Songs(songTitle,artistId,albumId,genreId) values('Lover',5,4,4),('Kamli',7,5,1),('Srivalli',4,6,2);
   
    insert into Podcast(PodcastName,CelebrityName,publishdate,ep_no) values('Healthy Mindset','Ranveer Allahbadia','2021-03-05',1);
    insert into Podcast(PodcastName,CelebrityName,publishdate,ep_no) values('Healthy Mindset','Ranveer Allahbadia','2021-03-10',2),
																			('Dark Side Of Your Brain','Siddharth Warrier','2021-12-15',1),
                                                                            ('Beginnings','Mahabharata','2014-04-20',1),
                                                                            ('Amba plight','Mahabharata','2014-04-20',2),
                                                                            ('Birth of Kuru Princes','Mahabharata','2014-04-20',3),
                                                                            ('The Guru Arrives','Mahabharata','2014-04-20',4);
                                                                            

    Alter table Album drop column genre;
    Alter table Album add column genreid int;
    update Album set genreid = 1 where albumTitle='Dhoom 3';
    update Album set genreid = 3 where albumTitle='Street Dancer';
    update Album set genreid = 3 where albumTitle='Pushpa';
    update Album set genreid = 4 where albumTitle='Lover';
#-----------------------------------------------------------
    update Songs set artistname='Arjit Singh' where artistId=3;
    update Songs set artistname='Javed Ali' where artistId=4;
    update Songs set artistname='DILJIT DOSANJH' where artistId=5;
    update Songs set artistname='Shreya Ghoshal' where artistId=7;
#----------------
    update Songs set albumname='Atrangi re' where albumId=1;
    update Songs set albumname='Kabir Singh' where albumId=2;
    update Songs set albumname='Street Dancer' where albumId=3;
    update Songs set albumname='Lover' where albumId=4;
    update Songs set albumname='Dhoom 3' where albumId=5;
    update Songs set albumname='Pushpa' where albumId=6;
    
#-------------
	update Songs set genrename='JAZZ' where genreId=1;
    update Songs set genrename='ROMANTIC' where genreId=2;
    update Songs set genrename='POP' where genreId=3;
    update Songs set genrename='PUNJABI BEATS' where genreId=4;
    update Songs set genrename='SAD' where genreId=5;
 #-----------------------------------------------------------end    
create table playlisttable(PlaylistName varchar(30),
songid int ,
Foreign key(songid) references Songs(song_id),
podcastid int,
Foreign Key(podcastid) references Podcast(PodcastId));
desc playlisttable;
-- select song_id,songTitle,artistname,albumname,genrename,PlaylistName,po.PodcastId,PodcastName,CelebrityName,ep_no
-- from Songs s join playlisttable p
-- on s.song_id=p.songid
--  join Podcast po 
--  on
--  po.PodcastId=p.podcastid
--  where PlaylistName='play3';

#-------------------------------------------------------


insert into playlisttable values('play1',3,null);
insert into playlisttable values('play1',null,2);
select * from playlisttable;
update Podcast 
set PodcastName="Chanakya-Neeti" where PodcastId=3;
