-- q2.pig
rating = load '/dxd132630/ratings.dat' using PigStorage(':') as (uid:int,mid:int,rat:float,time:chararray);
movie = load '/dxd132630/movies.dat' using PigStorage(':') as (movieid:int,title:chararray,genre:chararray);
cogrp = cogroup rating by mid,movie by movieid;
topgp = limit cogrp 6;
dump topgp;
