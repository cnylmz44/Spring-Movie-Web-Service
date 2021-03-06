package springmovie.business.concretes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import springmovie.business.abstracts.IMovieService;
import springmovie.dataAccess.abstracts.MovieDao;
import springmovie.entities.Movie;
import springmovie.entities.MovieDetail;

@Component
public class MovieManager implements IMovieService{
	
	@Autowired
	private MovieDao movieDao;
	
	@Autowired
	public MovieManager(MovieDao movieDao) {
		this.movieDao = movieDao;
	}
	
	
	@Override
	public List<Movie> search(String name) {
		// TODO Auto-generated method stub
		return this.movieDao.getMoviesByName(name);
	}

	@Override
	public boolean addToList(String id) {
	
		// TODO Auto-generated method stub
		return this.movieDao.writeMovieDetailToFile(this.movieDao.getMovieDetailById(id));
	}

	@Override
	public MovieDetail getMovieDetail(String id) {
		// TODO Auto-generated method stub
		
		// Checking for existing in movie-list
		if(this.movieDao.getMovieDetailByIdFromFile(id)==null) return this.movieDao.getMovieDetailById(id);
		else return this.movieDao.getMovieDetailByIdFromFile(id);
			
	}

}
