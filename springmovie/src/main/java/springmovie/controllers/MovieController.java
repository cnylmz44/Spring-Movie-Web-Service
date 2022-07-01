package springmovie.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import springmovie.business.abstracts.IMovieService;
import springmovie.entities.Movie;
import springmovie.entities.MovieDetail;

@RestController
public class MovieController {
	
	private IMovieService movieService;
	
	@Autowired
	public MovieController(IMovieService movieService) {
		this.movieService = movieService;
	}
	
	@RequestMapping(path = "/movies/search", method = RequestMethod.GET)
	public List<Movie> search(@RequestParam(name = "movie-name") String name) {		
		
		return this.movieService.search(name);
	}
	
	@PostMapping("/movies/saveToList/{id}")
	public boolean addToList(@PathVariable(name = "id") String id){
        //operations
		return this.movieService.addToList(id);
    }
	
	@RequestMapping(path = "/movies/detail", method = RequestMethod.GET)
    public MovieDetail getMovieDetail(@RequestParam(name = "id") String id){
        //operations
    	return this.movieService.getMovieDetail(id);
    }
	
	
}
