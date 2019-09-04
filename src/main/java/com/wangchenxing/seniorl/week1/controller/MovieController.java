package com.wangchenxing.seniorl.week1.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wangchenxing.seniorl.week1.domain.Movie;
import com.wangchenxing.seniorl.week1.domain.Type;
import com.wangchenxing.seniorl.week1.service.MovieService;

@Controller
public class MovieController {
  @Autowired 
  private MovieService service;
  //查询方法
  @RequestMapping("list")
  private String  selectall(Model m ,@RequestParam(defaultValue="")String mohu,@RequestParam(defaultValue = "1")int pageNum) {
	  PageHelper.startPage(pageNum,3);
	  //传入模糊数据
	  List list=service.selectall(mohu);
	  PageInfo info= new PageInfo(list);
	  m.addAttribute("list",list);
	  //出入分页
	  m.addAttribute("info",info);
	  m.addAttribute("mohu",mohu);
	
	  return "list";
	  
  }
  @RequestMapping("toadd")
  public String toadd(Model m) {
	  List<Type> list=service.toadd();
	  m.addAttribute("list",list);
	return "add";
	  
  }
  @RequestMapping("add")
  @ResponseBody
  public Object add(Movie me,int[] tids) {
	  try {
		  System.out.println(me);
		  service.add(me,tids);
		  return true;
	} catch (Exception e) {
		// TODO: handle exception
		return false;
	}
	
	
	  
  }
  @RequestMapping("delete")
  @ResponseBody
  public Object delete(String id) {
	  try {
		  
		  System.out.println("sadfasdf ");
		  System.out.println(id);
		  service.del(id);
		  return true;
	} catch (Exception e) {
		// TODO: handle exception
		return false;
	}
	
  }
  @RequestMapping("toupdate")
  public String toupdate(Model m) {
	  List<Type> list=service.toadd();
	  m.addAttribute("list",list);
	return "update";
	  
  }
  @RequestMapping("getupdate")
  @ResponseBody
  public Object selectupdate(int id) {
	  Movie movie= service.selectmovie(id);
	  List list= service.selectcenter(id);
	  Map map= new HashMap();
	  map.put("movie",movie);
	  map.put("list",list);
	  System.out.println(map);
	return map;
	  
  }
  
  @RequestMapping("update")
  @ResponseBody
  public Object update(Movie me,int[] tids) {
	  try {
		  System.out.println(me);
		  service.update(me,tids);
		  return true;
	} catch (Exception e) {
		// TODO: handle exception
		return false;
	}
	
	
	  
  }
  
}
