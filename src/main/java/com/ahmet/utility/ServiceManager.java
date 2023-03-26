package com.ahmet.utility;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public class ServiceManager<T,ID> implements  Iservice<T,ID>{


    private  final JpaRepository<T,ID> repository;

    public ServiceManager(JpaRepository<T,ID> repository){
        this.repository=repository;
    }
    @Override
    public T save(T t) {
        return repository.save(t);
    }

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }
}
