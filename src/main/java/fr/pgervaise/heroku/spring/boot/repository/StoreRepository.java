package fr.pgervaise.heroku.spring.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.pgervaise.heroku.spring.boot.domain.Store;

/**
 * 
 * @author pgervaise
 *
 */
public interface StoreRepository extends JpaRepository<Store, String> {
    Store findByName(String name);
}
