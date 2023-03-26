package com.ahmet.repository;

import com.ahmet.dto.response.FindAllBySuResponseDto;
import com.ahmet.repository.entity.Su;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISuRepository  extends JpaRepository<Su,Long> {
    @Query("select new com.ahmet.dto.response.FindAllBySuResponseDto(s.marka,s.ph) from Su s where s.marka like ?1%")
    List<FindAllBySuResponseDto> findAllByMarka(String marka);
}
