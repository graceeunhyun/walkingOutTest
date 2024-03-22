package jpabook.jpashop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jpabook.jpashop.domain.Album;
import jpabook.jpashop.domain.Item;
import jpabook.jpashop.domain.Movie;
import jpabook.jpashop.repository.ItemRepository;
import jpabook.jpashop.service.ItemService;

@RestController
public class ItemController {

    @Autowired
    ItemService itemService;

    @PostMapping("/movie")
    public void createMovie(@RequestBody Movie item) {
        itemService.saveItem(item);
    }

    @PostMapping("/album")
    public void createMovie(@RequestBody Album item) {
        itemService.saveItem(item);
    }

    @GetMapping("/read/items")
    public Page<Item> readItems(@RequestParam(defaultValue = "0", required = true) int page,
        @RequestParam(defaultValue = "10") int size) {
        return itemService.getAllEntities(page, size);
    }
}
