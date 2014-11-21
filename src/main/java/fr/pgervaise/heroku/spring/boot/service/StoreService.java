package fr.pgervaise.heroku.spring.boot.service;

import java.util.Collection;

import org.springframework.stereotype.Service;

import fr.pgervaise.heroku.spring.boot.domain.Store;

/**
 * 
 * @author pgervaise
 *
 */
public interface StoreService {

    Collection<Store> getStoreList();
    Store getStoreByName(String name);

}
