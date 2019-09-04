package com.wangchenxing.seniorl.week1.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wangchenxing.seniorl.week1.domain.Movie;
import com.wangchenxing.seniorl.week1.domain.Type;

public interface MovieMapper {
  //取出模糊数据
	List selectall(@Param("mohu")String mohu);

	List<Type> toadd();

	void add(Movie me);

	void addids(@Param("id")Integer id, @Param("tid")int tid);

	void del(@Param("id")String id);

	void delcenter(@Param("id")String id);

	Movie selectmovie(@Param("id")int id);

	List selectcenter(@Param("id")int id);

	void update(Movie me);

	void delcenter(@Param("id")Integer id);


}
