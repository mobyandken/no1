package cn.itcast.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.itcast.mapper.ItemMapper;
import cn.itcast.pojo.Item;
import cn.itcast.pojo.QueryVo;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemMapper itemMapper;
	
	
	public List<Item> findAllItem() {
		
		return itemMapper.findAllItem();
	}


	public Item findItemById(Integer id) {
		return itemMapper.findItemById(id);
	}


	public void updateItem(Item item) {
		itemMapper.updateItem(item);
	}


	public void updateItems(QueryVo vo) {
		List<Item> itemList = vo.getItemList();
		for (Item item : itemList) {
			itemMapper.updateItem(item);
		}
	}



}
