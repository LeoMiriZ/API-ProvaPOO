package com.livro.livro.Menu;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface MenuRepository extends CrudRepository<Menu, String> {
    
}
