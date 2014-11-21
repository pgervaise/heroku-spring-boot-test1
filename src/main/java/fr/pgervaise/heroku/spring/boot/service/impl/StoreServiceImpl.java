package fr.pgervaise.heroku.spring.boot.service.impl;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import fr.pgervaise.heroku.spring.boot.domain.Store;
import fr.pgervaise.heroku.spring.boot.repository.StoreRepository;
import fr.pgervaise.heroku.spring.boot.service.StoreService;

/**
 * 
 * @author pgervaise
 *
 */
@Service
public class StoreServiceImpl implements StoreService {

    @Resource
    private StoreRepository storeRepository;

    public StoreServiceImpl() {
    }

    public Collection<Store> getStoreList() {
        return storeRepository.findAll();
    }

    public Store getStoreByName(String name) {
        return storeRepository.findByName(name);
    }
}
