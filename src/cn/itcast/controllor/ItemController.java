package cn.itcast.controllor;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.itcast.exception.CustomException;
import cn.itcast.pojo.Item;
import cn.itcast.pojo.QueryVo;
import cn.itcast.service.ItemService;
@Controller
public class ItemController {


	@Autowired
	private ItemService itemService;
	
	@RequestMapping(value="/item/index.action")
	public ModelAndView index() throws Exception{
	/*	if(true){
			
			throw new CustomException("ddd");
		}*/
		
		List<Item> list = itemService.findAllItem();
		ModelAndView av = new ModelAndView();
	//	int i = 1/0;
		av.addObject("item", list);
		av.setViewName("itemList");
		return av;
	}
	//跳转需改页面
	@RequestMapping(value="/itemEdit.action")
	public ModelAndView itemEdit(Integer id){
		Item item = itemService.findItemById(id);
		ModelAndView av = new ModelAndView();
		av.addObject("item",item);
		av.setViewName("editItem");
		return av;
	}
	
	//修改
/*	@RequestMapping(value="/updateitem.action")
	public ModelAndView updateitem(Item item){
		
		itemService.updateItem(item);
		
		ModelAndView av = new ModelAndView();
		av.setViewName("success");
		return av;
	}*/
	
	@RequestMapping(value="/updateitem.action")
	public ModelAndView updateitem(Item item, MultipartFile picFile) throws Exception{
		
		//设置图片名字
		if(picFile.getSize()!=0){
			
			String picName = UUID.randomUUID().toString();
			String originalFilename = picFile.getOriginalFilename();
			String ext = FilenameUtils.getExtension(originalFilename);//后缀名
			
			//保存图片
			String name = picName+"."+ext;
			String path = "D:\\HM\\upload\\"+name;
			
			picFile.transferTo(new File(path));
			
			
			item.setPic(name);
		}
		
		itemService.updateItem(item);
		
		ModelAndView av = new ModelAndView();
		av.setViewName("success");
		
		return av;
	}
	
	@RequestMapping(value="/item/queryitem.action")
	public String queryitem(QueryVo vo){
		itemService.updateItems(vo);
		
		
	//	return "redirect:/item/index.action";
		return "forward:/item/index.action";

	}
	
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(){
		return "login";
	}
	
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(String username,HttpSession session){
		
		session.setAttribute("loginUser", username);
		return "redirect:item/index.action";
	}
	
	
	
	@RequestMapping("/test/json.action")
	public @ResponseBody Item json(@RequestBody Item item){
		item.setName("wangjing");
		
		return item;
	}
}
