package com.ahmet.repository;

import com.ahmet.dto.response.FindAllByAnaYemekResponseDto;
import com.ahmet.repository.entity.IftarMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IIftarMenuRepository extends JpaRepository<IftarMenu, Long> {

    @Query("select new com.ahmet.dto.response.FindAllByAnaYemekResponseDto(i.anaYemek,i.corba,i.tatli) from IftarMenu i where i.anaYemek like ?1%")
    List<FindAllByAnaYemekResponseDto> findAllByAnaYemek(String anaYemek);
}

