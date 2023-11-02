package io.hari.lld.services;

import io.hari.lld.repo.BaseRepo;

import java.util.List;
import java.util.Optional;

/**
 * @author Hariom Yadav
 * @since 02-Nov-2023
 */
public abstract class BaseService<T> {

    BaseRepo<T> repo;

    public BaseService(BaseRepo<T> repo) {
        this.repo = repo;
    }

    List<T> findAll(){
        return repo.findAll();
    }

    public Optional<T> findById(Long id){
        return repo.findById(id);
    }

    public T save(T input){
        return repo.save(input);
    }

    public void delete(T input){
        repo.delete(input);
    }

}
