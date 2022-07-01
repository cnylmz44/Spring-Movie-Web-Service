package springmovie.business.abstracts;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import springmovie.entities.Movie;
import springmovie.entities.MovieDetail;

public interface IMovieService {
	public List<Movie> search(String name);
	public boolean addToList(String id);
	public MovieDetail getMovieDetail(String id);
}
