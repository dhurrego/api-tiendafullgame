package com.fullgame.service;

import java.util.List;


import com.fullgame.model.Director;

public interface IDirectorService {
	
	public List<Director> getDirectores() throws Exception;
	public Director getDirector(Integer ideDirector) throws Exception;
	public Director createDirector(Director director) throws Exception;
	public Director updateDirector(Director director) throws Exception;
	public boolean deleteDirector(Integer ideDirector) throws Exception;
	
}
