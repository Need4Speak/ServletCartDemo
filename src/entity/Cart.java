package entity;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Cart {

	// 购买商品集合
	private HashMap<Items, Integer> goods;

	// 购物车总金额
	private double totalPrice;

	// Construct
	public Cart() {
		goods = new HashMap<Items, Integer>();
		totalPrice = 0.0;
	}

	public HashMap<Items, Integer> getGoods() {
		return goods;
	}

	public void setGoods(HashMap<Items, Integer> goods) {
		this.goods = goods;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	// 添加商品进购物车
	public boolean addGoodsInCart(Items item, int number) {
		
		if (goods.containsKey(item)) {
			goods.put(item, goods.get(item)+number);
		}
		else {
			goods.put(item, number);
		}
		// 重新计算购物车的总金额
		calTotalPrice();
		return true;
	}

	// 从购物车删除商品
	public boolean removeGoodsFromCart(Items item) {
		goods.remove(item);
		// 重新计算购物车的总金额
		calTotalPrice();
		return true;
	}

	// 统计购物车总金额、
	public double calTotalPrice() {
		double sum = 0.0;
		// 获得键的集合
		Set<Items> keys = goods.keySet();
		Iterator<Items> it = keys.iterator();
		while (it.hasNext()) {
			Items items = it.next();
			sum += items.getPrice() * goods.get(items);
		}
		// 设置购物车的总金额
		this.setTotalPrice(sum);
		return this.getTotalPrice();
	}

	// For test
	public static void main(String[] args) {
		Items items1 = new Items(1, "good1", "locate1", 200, 500, "001.jpg");
		Items items2 = new Items(2, "good2", "locate2", 100, 400, "002.jpg");
		Items items3 = new Items(1, "good1", "locate1", 200, 500, "001.jpg");

		Cart cart = new Cart();
		cart.addGoodsInCart(items1, 2);
		cart.addGoodsInCart(items2, 3);
		//cart.addGoodsInCart(items1, 1);  //item1已经在cart中了，再添加不起作用。
		cart.addGoodsInCart(items3, 4);

		// 遍历购物网商品集合
		// Map.Entry是Map声明的一个内部接口，此接口为泛型，定义为Entry<K,V>。它表示Map中的一个实体（一个key-value对）。
		Set<Map.Entry<Items, Integer>> items = cart.getGoods().entrySet();
		for (Map.Entry<Items, Integer> eachItem : items) {
			System.out.println(eachItem);
		}
		System.out.println("总金额： " + cart.calTotalPrice());
	}
}
