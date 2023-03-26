package com.ahmet.utility;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Iservice <T,ID>{
    T save(T t);
    List<T> findAll();

}
