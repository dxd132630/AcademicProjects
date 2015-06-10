rating = load '/dxd132630/ratings.dat' using PigStorage(':') as (uid:int,mid:int,rat:float,time:chararray);
movie = load '/dxd132630/movies.dat' using PigStorage(':') as (movieid:int,title:chararray,genre:chararray);
c = cogroup rating by mid inner,movie by movieid inner;
out = foreach c generate flatten(rating),flatten(movie);
lim = limit out 6;
dump lim;
store lim into '/dxd132630/3aq';
