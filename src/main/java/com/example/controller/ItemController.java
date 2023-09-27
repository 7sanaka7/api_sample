package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Item;
import com.example.resource.RequestItem;
import com.example.service.ItemService;

@RestController
@RequestMapping(value = "/item", produces="application/json;charset=UTF-8")
public class ItemController {
	
	 private final ItemService itemService;

	    @Autowired
	    // ItemServiceをインジェクション
	    public ItemController(ItemService itemService) {
	        this.itemService = itemService;
	    }
	    
	    //データ取得用のWeb　API
	    @GetMapping("/list")
	    public List<Item> list(){
	    	//List<Item>の形式で取得した値をかえす
	    	return this.itemService.findAll();
	    }
	    
	    @PostMapping("/create")
	    // データ保存用のWeb API
	    public Item create(@RequestBody RequestItem requestItem) {
	        // 保存したItemオブジェクトを返す
	        return this.itemService.insert(requestItem);
	    }

}
