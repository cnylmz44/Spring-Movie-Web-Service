package springmovie.entities;

import java.util.List;

public class MoviesResponse {
	private boolean success;
	private List<Movie> result;
	
	public List<Movie> getResult() {
		return result;
	}
	
	public boolean isSuccess() {
		return success;
	}
	
	public void setResult(List<Movie> result) {
		this.result = result;
	}
	
	public void setSuccess(boolean success) {
		this.success = success;
	}
}
