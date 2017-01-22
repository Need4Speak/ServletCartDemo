package entity;

public class Items {

	private int id;
	private String name;
	private String city;
	private int price;
	private int number;
	private String picture;

	public Items() {
	}

	public Items(int id, String name, String city, int price, int number,
			String picture) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.price = price;
		this.number = number;
		this.picture = picture;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "GoodId: " + this.id + ", GoodName: " + this.name
				+ ", GoodPrice: " + this.price + ", GoodNum :" + this.number;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		// 保证商品编号相同时，不重复添加进购物车。
		return this.getId() + this.getName().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		// 判断两个对象是否相同
		if (this == obj) {
			return true;
		} else if (obj instanceof Items) {
			Items items = (Items) obj;
			if (this.getId() == items.getId()
					&& this.getName() == items.getName()) {
				return true;
			}
			else {
				return false;
			}
		} else {
			return false;
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

}
