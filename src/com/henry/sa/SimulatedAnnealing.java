package com.henry.sa;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SimulatedAnnealing {

	public static List<City> allCitys = new ArrayList<City>();

    //计算 接受的概率
    public static double acceptanceProbability(int energy, int newEnergy, double temperature) {
        // 如果新的解决方案较优，就接受
        if (newEnergy < energy) {
            return 1.0;
        }
        return Math.exp((energy - newEnergy) / temperature);
    }

    public static void main(String[] args) {
        // 创建所有的城市城市列表
        init();
        Tour best = sa();
        System.out.println("Final solution distance: " + best.getDistance());
        System.out.println("Tour: " + best);
    }

	//返回近似的 最佳旅行路径
	private static Tour sa() {
		// 初始化温度
        double temp = 10000;

        // 冷却速率
        double coolingRate = 0.003;

        // 初始化的解决方案
        Tour currentSolution = new Tour();
        currentSolution.generateIndividual();

        System.out.println("Initial solution distance: " + currentSolution.getDistance());

        // 设置当前为最优的方案
        Tour best = new Tour(currentSolution.getTour());

        // 循环直到系统冷却
        while (temp > 1) {
            // 生成一个邻居
            Tour newSolution = new Tour(currentSolution.getTour());

            // 获取随机位置
            int tourPos1 = (int) (newSolution.tourSize() * Math.random());
            int tourPos2 = (int) (newSolution.tourSize() * Math.random());

            City citySwap1 = newSolution.getCity(tourPos1);
            City citySwap2 = newSolution.getCity(tourPos2);

            // 交换
            newSolution.setCity(tourPos2, citySwap1);
            newSolution.setCity(tourPos1, citySwap2);

            // 获得新的解决方案的花费
            int currentEnergy = currentSolution.getDistance();
            int neighbourEnergy = newSolution.getDistance();

            // 决定是否接受新的 方案
            if (acceptanceProbability(currentEnergy, neighbourEnergy, temp) > Math.random()) {
                currentSolution = new Tour(newSolution.getTour());
            }

            // 记录找到的最优方案
            if (currentSolution.getDistance() < best.getDistance()) {
                best = new Tour(currentSolution.getTour());
            }

            // 冷却
            temp *= 1-coolingRate;
        }
		return best;
	}

	private static void init() {
/*		City city = new City(60, 200);
	    allCitys.add(city);
	    City city2 = new City(180, 200);
	    allCitys.add(city2);
	    City city3 = new City(80, 180);
	    allCitys.add(city3);
	    City city4 = new City(140, 180);
	    allCitys.add(city4);
	    City city5 = new City(20, 160);
	    allCitys.add(city5);
	    City city6 = new City(100, 160);
	    allCitys.add(city6);
	    City city7 = new City(200, 160);
	    allCitys.add(city7);
	    City city8 = new City(140, 140);
	    allCitys.add(city8);
	    City city9 = new City(40, 120);
	    allCitys.add(city9);
	    City city10 = new City(100, 120);
	    allCitys.add(city10);
	    City city11 = new City(180, 100);
	    allCitys.add(city11);
	    City city12 = new City(60, 80);
	    allCitys.add(city12);
	    City city13 = new City(120, 80);
	    allCitys.add(city13);
	    City city14 = new City(180, 60);
	    allCitys.add(city14);
	    City city15 = new City(20, 40);
	    allCitys.add(city15);
	    City city16 = new City(100, 40);
	    allCitys.add(city16);
	    City city17 = new City(200, 40);
	    allCitys.add(city17);
	    City city18 = new City(20, 20);
	    allCitys.add(city18);
	    City city19 = new City(60, 20);
	    allCitys.add(city19);
	    City city20 = new City(160, 20);
	    allCitys.add(city20);*/
		/*
		 * 
		各城市坐标：
		110.361901,21.284643 湛江
		110.923018,21.680707 茂名
		111.980863,21.878328 阳江
		112.049853,22.930431 云浮
		112.463792,23.066693 肇庆
		113.084701,22.597712 江门
		113.121495,23.041154 佛山
		113.052505,23.699317 清远
		113.254876,23.151786 广州
		113.397455,22.533633 中山
		113.576828,22.285582 珠海
		113.756202,23.036897 东莞
		114.055158,22.56354 深圳
		114.418505,23.126264 惠州
		114.699063,23.758601 河源
		115.379763,22.802559 汕尾
		113.595226,24.825186 韶关
		116.124854,24.303565 梅州
		116.368618,23.572189 揭阳
		116.621581,23.673902 潮州
		116.685971,23.368526 汕头*/
		
		City city0 = new City(computeCityX(110.361901),computeCityY(21.284643), "湛江");
	    allCitys.add(city0);
		City city1 = new City(computeCityX(110.923018),computeCityY(21.680707), "茂名");
	    allCitys.add(city1);
		City city2 = new City(computeCityX(111.980863),computeCityY(21.878328), "阳江");
	    allCitys.add(city2);
		City city3 = new City(computeCityX(112.049853),computeCityY(22.930431), "云浮");
	    allCitys.add(city3);
		City city4 = new City(computeCityX(112.463792),computeCityY(23.066693), "肇庆");
	    allCitys.add(city4);
		City city5 = new City(computeCityX(113.084701),computeCityY(22.597712), "江门");
	    allCitys.add(city5);
		City city6 = new City(computeCityX(113.121495),computeCityY(23.041154), "佛山");
	    allCitys.add(city6);
		City city7 = new City(computeCityX(113.052505),computeCityY(23.699317), "清远");
	    allCitys.add(city7);
		City city8 = new City(computeCityX(113.254876),computeCityY(23.151786), "广州");
	    allCitys.add(city8);
		City city9 = new City(computeCityX(113.397455),computeCityY(22.533633), "中山");
	    allCitys.add(city9);
		City city10 = new City(computeCityX(113.576828),computeCityY(22.285582), "珠海");
	    allCitys.add(city10);
		City city11 = new City(computeCityX(113.756202),computeCityY(23.036897), "东莞");
	    allCitys.add(city11);
		City city12 = new City(computeCityX(114.055158),computeCityY(22.56354), "深圳");
	    allCitys.add(city12);
		City city13 = new City(computeCityX(114.418505),computeCityY(23.126264), "惠州");
	    allCitys.add(city13);
		City city14 = new City(computeCityX(114.699063),computeCityY(23.758601), "河源");
	    allCitys.add(city14);
		City city15 = new City(computeCityX(115.379763),computeCityY(22.802559), "汕尾");
	    allCitys.add(city15);
		City city16 = new City(computeCityX(113.595226),computeCityY(24.825186), "韶关");
	    allCitys.add(city16);
		City city17 = new City(computeCityX(116.124854),computeCityY(24.303565), "梅州");
	    allCitys.add(city17);
		City city18 = new City(computeCityX(116.368618),computeCityY(23.572189), "揭阳");
	    allCitys.add(city18);
		City city19 = new City(computeCityX(116.621581),computeCityY(23.673902), "潮州");
	    allCitys.add(city19);
		City city20 = new City(computeCityX(116.685971),computeCityY(23.368526), "汕头");
	    allCitys.add(city20);

	}
	
	static int computeCityX(double x){
		BigDecimal bx = new BigDecimal(x);
		BigDecimal b = new BigDecimal(110.361901);
		return bx.divide(b,5,BigDecimal.ROUND_HALF_DOWN).multiply(new BigDecimal(10000)).intValue() - 10000;
		
	}
	static int computeCityY(double y){
		BigDecimal by = new BigDecimal(y);
		BigDecimal b = new BigDecimal(21.284643);
		return by.divide(b,5,BigDecimal.ROUND_HALF_DOWN).multiply(new BigDecimal(10000)).intValue() - 10000;
	}
}