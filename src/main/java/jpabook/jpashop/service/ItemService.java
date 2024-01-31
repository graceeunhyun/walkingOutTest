package jpabook.jpashop.service;

import jpabook.jpashop.domain.Item;
import jpabook.jpashop.domain.Movie;
import jpabook.jpashop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class ItemService {

//    private final ItemRepository repository;
    @Autowired
    private ItemRepository repository;

    public void saveItem(Item item) {
        repository.save(item);
    }

    public void updateItem(Long itemId, String name, int price, int stockQuantity) {
        Item item = repository.findById(itemId).get();
        item.setName(name);
        item.setPrice(price);
        item.setStockQuantity(stockQuantity);
    }

    public void updateMovie(Movie movie) {
        Movie item = (Movie) repository.findById(movie.getId()).get();
        item.setName(movie.getName());
        item.setPrice(movie.getPrice());
        item.setStockQuantity(movie.getStockQuantity());
        item.setActor(movie.getActor());
        item.setDirector(movie.getDirector());

    }

    public List<Item> findItems() {
        return repository.findAll();
    }

    public Optional<Item> findOne(Long itemID) {
        return repository.findById(itemID);
    }

    public Page<Item> getAllEntities(int page, int size){
        PageRequest pageRequest = PageRequest.of(page, size);
        return repository.findAll(pageRequest);
    }


}
