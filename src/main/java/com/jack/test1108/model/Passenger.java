package com.jack.test1108.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 
 * @Description: 乘客类，表示乘客的相关信息
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Passenger implements Serializable {
	private static final long serialVersionID = 1L;

	/**
	 * 骑行速度每秒一格子
	 */
	private int speed = 1;

	/**
	 * 乘客每次能骑的车的数量
	 */
	private int loadCapacity = 1;

	/**
	 * 表示某个乘客选择的路线
	 */
	private Way way;
	
	/**
	 * 乘客所需要骑行的总里程
	 */
	private int distance;

	/**
	 * 乘客启动的时间，秒数
	 */
	private int startTime;

	/**
	 * 起始地铁站
	 */
	private SubwayStation originSubwayStation;

	/**
	 * 目的地地铁站
	 */
	private SubwayStation destSubwayStation;

	public Passenger(Way way,int startTime,SubwayStation originSubwayStation,SubwayStation destSubwayStation) {
		this.way = way;
		this.distance = way.getDistance();
		this.startTime = startTime;
		this.originSubwayStation = originSubwayStation;
		this.destSubwayStation = destSubwayStation;
	}

	
	
	
	
	
	
}
