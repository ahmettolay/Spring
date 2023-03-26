package com.ahmet.controller;


import com.ahmet.dto.request.SuUpdateRequestDto;
import com.ahmet.dto.response.FindAllBySuResponseDto;
import com.ahmet.repository.entity.Su;
import com.ahmet.service.SuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.ahmet.constans.EndPointList.*;

@RestController
@RequestMapping(SU)

public class SuController {
    private  final SuService suService;

    public SuController(SuService suService){
        this.suService=suService;
    }
    @GetMapping(SAVE)
    public ResponseEntity<Su> save(Su su){
        return  ResponseEntity.ok(suService.save(su));
    }
    @GetMapping(FIND_ALL)
    public List<Su> findAll(){
        return suService.findAll();
    }
//---------------------------------DTO START--------------------
@GetMapping(FIND_BY_SU)
    public ResponseEntity<List<FindAllBySuResponseDto>> findAllByMarka(String marka){
        return  ResponseEntity.ok(suService.findAllByMarka(marka));
    }
    @GetMapping(UPDATE)
    public ResponseEntity<Void> update(SuUpdateRequestDto dto){
        suService.update(dto);
        return  ResponseEntity.ok().build();
    }
//---------------------------------DTO END--------------------

}
