package cn.itcast.service;

import java.util.List;

import cn.itcast.pojo.Item;
import cn.itcast.pojo.QueryVo;

public interface ItemService {

	public List<Item> findAllItem();

	public Item findItemById(Integer id);

	public void updateItem(Item item);

	public void updateItems(QueryVo vo);

}
