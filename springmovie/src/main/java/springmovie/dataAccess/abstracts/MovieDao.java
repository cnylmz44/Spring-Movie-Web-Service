package springmovie.dataAccess.abstracts;

import java.util.List;

import springmovie.entities.Movie;
import springmovie.entities.MovieDetail;

public interface MovieDao {
	public MovieDetail getMovieDetailById(String id);
	public MovieDetail getMovieDetailByIdFromFile(String id);
	public List<Movie> getMoviesByName(String name);
	public boolean writeMovieDetailToFile(MovieDetail movieDetail); 
	
}
