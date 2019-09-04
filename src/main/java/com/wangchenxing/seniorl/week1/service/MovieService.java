package com.wangchenxing.seniorl.week1.service;

import java.util.List;

import com.wangchenxing.seniorl.week1.domain.Movie;
import com.wangchenxing.seniorl.week1.domain.Type;

public interface MovieService {

	List selectall(String mohu);

	List<Type> toadd();

	void add(Movie me, int[] tids);

	void del(String id);

	Movie selectmovie(int id);

	List selectcenter(int id);

	void update(Movie me, int[] tids);

	



}
