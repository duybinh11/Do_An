package Dao;

import java.util.ArrayList;

public interface dao_interface <T>{
	public void insert(T t);
	public void delete(String value);
	public void  fix(T t,String value);
	public ArrayList<T> get_data(String value);
}
