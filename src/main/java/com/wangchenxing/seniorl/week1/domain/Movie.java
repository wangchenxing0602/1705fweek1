package com.wangchenxing.seniorl.week1.domain;

public class Movie {
  private Integer id;//编号
  private String name;//姓名
  private String con;//描述
  private String doc;//导演
  private String date;//日期
@Override
public String toString() {
	return "Movie [id=" + id + ", name=" + name + ", con=" + con + ", doc=" + doc + ", date=" + date + "]";
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getCon() {
	return con;
}
public void setCon(String con) {
	this.con = con;
}
public String getDoc() {
	return doc;
}
public void setDoc(String doc) {
	this.doc = doc;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
  

}
