package com.wangchenxing.seniorl.week1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wangchenxing.seniorl.week1.dao.MovieMapper;
import com.wangchenxing.seniorl.week1.domain.Movie;
import com.wangchenxing.seniorl.week1.domain.Type;

@Service
public class MovieServiceimpl implements MovieService{
  @Autowired
  private MovieMapper mapper;
//查询方法 传入模糊数据
public List selectall(String mohu) {
	// TODO Auto-generated method stub
	return mapper.selectall(mohu);
}
@Override
public List<Type> toadd() {
	// TODO Auto-generated method stub
	return mapper.toadd();
}
@Override
public void add(Movie me, int[] tids) {
	// TODO Auto-generated method stub
	mapper.add(me);
	if(null!=tids) {
		for (int tid : tids) {
			mapper.addids(me.getId(),tid);
			
		}
	}
	
}
@Override
public void del(String id) {
	// TODO Auto-generated method stub
	mapper.del(id);
	mapper.delcenter(id);
}
@Override
public Movie selectmovie(int id) {
	// TODO Auto-generated method stub
	return mapper.selectmovie(id);
}
@Override
public List selectcenter(int id) {
	// TODO Auto-generated method stub
	return mapper.selectcenter(id);
}
@Override
public void update(Movie me, int[] tids) {
	// TODO Auto-generated method stub
	mapper.update(me);
	mapper.delcenter(me.getId());
	if(null!=tids) {
		for (int tid : tids) {
			mapper.addids(me.getId(),tid);
			
		}
	}
}


  
}
