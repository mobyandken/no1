package cn.itcast.mapper;

import java.util.List;

import cn.itcast.pojo.Item;

public interface ItemMapper {

	//查询所有item
	public List<Item> findAllItem();

	public Item findItemById(Integer id);
	//update
	public void updateItem(Item item);

}
