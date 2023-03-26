package com.ahmet.service;

import com.ahmet.dto.request.IftarMenuUpdateRequestDto;
import com.ahmet.dto.response.FindAllByAnaYemekResponseDto;
import com.ahmet.repository.IIftarMenuRepository;
import com.ahmet.repository.entity.IftarMenu;
import com.ahmet.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IftarMenuService extends ServiceManager<IftarMenu, Long> {

    private final IIftarMenuRepository repository;

    public IftarMenuService(IIftarMenuRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public List<FindAllByAnaYemekResponseDto> findByAnaYemek(String anaYemek) {
        List<FindAllByAnaYemekResponseDto> result = repository.findAllByAnaYemek(anaYemek);
        return result;
    }

    public void update(IftarMenuUpdateRequestDto dto) {
        Optional<IftarMenu> iftarMenu = repository.findById(dto.getId());
        if (iftarMenu.isPresent()) {
            iftarMenu.get().setFiyat(dto.getFiyat());
            iftarMenu.get().setMeze(dto.getMeze());
            iftarMenu.get().setIcecek(dto.getIcecek());
            repository.save(iftarMenu.get());
        }
    }
}
