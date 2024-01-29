package jpabook.jpashop.service;

import jpabook.jpashop.domain.Item;
import jpabook.jpashop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class ItemService {

//    private final ItemRepository repository;
    @Autowired ItemRepository repository;

    public void saveItem(Item item) {
        repository.save(item);
    }

    public void updateItem(Long itemId, String name, int price, int stockQuantity) {
        Item item = repository.findById(itemId).get();
        item.setName(name);
        item.setPrice(price);
        item.setStockQuantity(stockQuantity);
    }

    public List<Item> findItems() {
        return repository.findAll();
    }

    public Optional<Item> findOne(Long itemID) {
        return repository.findById(itemID);
    }
}
