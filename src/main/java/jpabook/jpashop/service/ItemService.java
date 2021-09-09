package jpabook.jpashop.service;

import jpabook.jpashop.domain.Item;
import jpabook.jpashop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemService {

//    private final ItemRepository repository;
    @Autowired ItemRepository repository;

    public void saveItem(Item item) {
        repository.save(item);
    }

    public List<Item> findItems() {
        return repository.findAll();
    }

    public Optional<Item> findOne(Long itemID) {
        return repository.findById(itemID);
    }
}
