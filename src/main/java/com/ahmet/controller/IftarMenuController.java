package com.ahmet.controller;

import com.ahmet.dto.request.IftarMenuUpdateRequestDto;
import com.ahmet.dto.response.FindAllByAnaYemekResponseDto;
import com.ahmet.repository.entity.IftarMenu;
import com.ahmet.service.IftarMenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.ahmet.constans.EndPointList.*;

@RestController
@RequestMapping(IFTAR_MENU)
@RequiredArgsConstructor
public class IftarMenuController {

    private final IftarMenuService iftarMenuService;

    // http://localhost:9090/dev/v1/iftar-menu/save?anaYemek=tavuk%C4%B1zgara&corba=tavuksuyucorba&meze=coban-salata&icecek=ayran&tatli=s%C3%BCtla%C3%A7&fiyat=225
    @GetMapping(SAVE)
    public ResponseEntity<IftarMenu> save(IftarMenu iftarMenu) {
        return ResponseEntity.ok(iftarMenuService.save(iftarMenu));
    }

    //http://localhost:9090/dev/v1/iftar-menu/find-all
    @GetMapping(FIND_ALL)
    public List<IftarMenu> findAll() {
        List<IftarMenu> result = iftarMenuService.findAll();
        return result;
    }
//---------------------------------DTO START--------------------

    @GetMapping(FIND_BY_ANAYEMEK)
    public ResponseEntity<List<FindAllByAnaYemekResponseDto>> findAllByAnaYemek(String anaYemek) {
        List<FindAllByAnaYemekResponseDto> result = iftarMenuService.findByAnaYemek(anaYemek);
        return ResponseEntity.ok(result);
    }
@GetMapping(UPDATE)
    public  ResponseEntity<Void> update(IftarMenuUpdateRequestDto dto){
        iftarMenuService.update(dto);
        return  ResponseEntity.ok().build();
    }
}
//---------------------------------DTO END--------------------
