package fr.pgervaise.heroku.spring.boot.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.pgervaise.heroku.spring.boot.domain.Store;
import fr.pgervaise.heroku.spring.boot.rest.dto.StoreDTO;
import fr.pgervaise.heroku.spring.boot.service.StoreService;

/**
 * 
 * @author pgervaise
 *
 */
@RestController
@RequestMapping("/api/rest")
public class StoreResource {

    @Inject
    private StoreService storeService;

    public StoreResource() {
    }

    @RequestMapping(value = "stores",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    // @Timed
    public List<StoreDTO> getList() {
        return ((List<Store>) storeService.getStoreList())
                .stream()
                .map(StoreDTO::new)
                .collect(Collectors.toList());
        
    }
}
