package dao;

import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import util.*;

import util.DBHelper;

import entity.Items;

public class ItemsDAO {

	// 获取所有商品的信息
	public ArrayList<Items> getAllItems() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Items> list = new ArrayList<Items>(); // 商品集合

		try {
			conn = DBHelper.getConnection();
			String sql = "select * from items;";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Items item = new Items();
				item.setId(rs.getInt("id"));
				item.setName(rs.getString("name"));
				item.setCity(rs.getString("city"));
				item.setNumber(rs.getInt("number"));
				item.setPrice(rs.getInt("price"));
				item.setCity(rs.getString("city"));
				item.setPicture(rs.getString("picture"));
				list.add(item);
			}
			return list;
		} catch (Exception e) {
			return null;
			// TODO: handle exception
		} finally {
			// 释放数据集对象
			if (rs != null) {
				try {
					rs.close();
					rs = null;
				} catch (Exception e2) {
					e2.printStackTrace();
					// TODO: handle exception
				}
			}

			// 释放语句对象
			if (stmt != null) {
				try {
					stmt.close();
					stmt = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
	}

	public Items getItemsById(int id) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = DBHelper.getConnection();
			String sql = "select * from items where id=?;";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			if (rs.next()) {
				Items item = new Items();
				item.setId(rs.getInt("id"));
				item.setName(rs.getString("name"));
				item.setCity(rs.getString("city"));
				item.setNumber(rs.getInt("number"));
				item.setPrice(rs.getInt("price"));
				item.setCity(rs.getString("city"));
				item.setPicture(rs.getString("picture"));
				return item;
			} else {
				return null;
			}
		} catch (Exception e) {
			return null;
			// TODO: handle exception
		} finally {
			// 释放数据集对象
			if (rs != null) {
				try {
					rs.close();
					rs = null;
				} catch (Exception e2) {
					e2.printStackTrace();
					// TODO: handle exception
				}
			}

			// 释放语句对象
			if (stmt != null) {
				try {
					stmt.close();
					stmt = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
	}

	// 获取最近浏览的五条商品信息
	public ArrayList<Items> getViewList(String list) {
		ArrayList<Items> itemslist = new ArrayList<Items>();
		int iCount = 5;// 每次返回前五条记录
		if (list != null && list.length() > 0) {
			String[] arr = list.split(",");
			arr = ArrayRepeatedElementDel.repetitionDel(arr); // array_unique 
			// 商品记录大于等于5条。
			if (arr.length >= 5) {
				for (int i = arr.length-1; i >= arr.length - iCount; i--) {
					itemslist.add(getItemsById(Integer.parseInt(arr[i])));
				}
			} else {
				for (int i = arr.length-1; i >= 0; i--) {
					itemslist.add(getItemsById(Integer.parseInt(arr[i])));
				}
			}
			return itemslist;
		} else {
			return null;
		}
	}
}
