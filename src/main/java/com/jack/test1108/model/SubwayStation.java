package com.jack.test1108.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 
 * @Description: 地铁站类，主要是放置小黄车的地方
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubwayStation implements Serializable {

	private static final long serialVersionID = 1L;

	/**
	 * 表示地铁站的唯一标志
	 */
	private int id;

	/**
	 * 表示地铁站的名字
	 */
	private String name;
	
	/**
	 * 表示地铁站的小黄车的数量
	 */
	private int count;

	/**
	 * 地铁站的坐标
	 */
	private Location locate;

	public SubwayStation(int id, int count, Location locate, String name) {
		this.count = count;
		this.locate = locate;
		this.id = id;
		this.name = name;
	}
	
}
