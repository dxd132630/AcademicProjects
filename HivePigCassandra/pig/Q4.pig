-- q4.pig
register '/home/004/d/dx/dxd132630/dxd132630HW2.jar'
movie = load '/dxd132630/movies.dat' using PigStorage(':') as (movieid:int,title:chararray,genre:chararray);
out = foreach movie generate myudfs.FORMAT_GENRE(genre) as gen,title;
dump out;
