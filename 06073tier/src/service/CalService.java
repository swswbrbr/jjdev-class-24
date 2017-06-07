package service;

public class CalService {
	int result = 0;
	public int add(int x, int y){
		result = x +  y;
		return result;
	}
	
	public int min(int x, int y){
		result = x - y;
		return result;
	}
	
	public int mul(int x, int y){
		result = x * y;
		return result;
	}
	
	public int div(int x, int y){
		result = x/y;
		return result;
	}

}
