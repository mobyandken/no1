package cn.itcast.pojo;

import java.util.List;

public class QueryVo {

	private Item item;
	private List<Item> itemList;
	

	public List<Item> getItemList() {
		return itemList;
	}

	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}
	
}
