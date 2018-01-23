package com.henry.sa;

public class City {
    int x;
    int y;
    String name;
    // 生成一个随机的城市
    public City(){
        this.x = (int)(Math.random()*200);
        this.y = (int)(Math.random()*200);
    }

    public City(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public City(int x, int y, String name){
        this.x = x;
        this.y = y;
        this.name = name;
    }
    
    public City(double x, double y, String name){
    	
    	
        this.name = name;
    }
    
    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// 计算两个城市之间的距离
    public double distanceTo(City city){
        int xDistance = Math.abs(getX() - city.getX());
        int yDistance = Math.abs(getY() - city.getY());
        double distance = Math.sqrt( (xDistance*xDistance) + (yDistance*yDistance) );

        return distance;
    }

    @Override
    public String toString(){
        return getName();
    }
}
