package fr.pgervaise.heroku.spring.boot.rest.dto;

import fr.pgervaise.heroku.spring.boot.domain.Store;

/**
 * 
 * @author pgervaise
 *
 */
public class StoreDTO {

    private Integer id;
    private String name;

    public StoreDTO() {
    }

    public StoreDTO(Store store) {
        this.id = store.getId();
        this.name = store.getName();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("StoreDTO{");
        sb.append("id='").append(id).append('\'');
        if (name != null) {
            sb.append(", name='").append(name.length()).append('\'');
        }
        sb.append('}');
        return sb.toString();
    }
}
