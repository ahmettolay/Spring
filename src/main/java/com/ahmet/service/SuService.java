package com.ahmet.service;

import com.ahmet.dto.request.SuUpdateRequestDto;
import com.ahmet.dto.response.FindAllBySuResponseDto;
import com.ahmet.repository.ISuRepository;
import com.ahmet.repository.entity.Su;
import com.ahmet.utility.ServiceManager;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SuService extends ServiceManager<Su, Long> {

    private ISuRepository repository;

    public SuService(ISuRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public List<FindAllBySuResponseDto> findAllByMarka(String marka) {
        return repository.findAllByMarka(marka);
    }

    public void update(SuUpdateRequestDto dto) {
        Optional<Su> su = repository.findById(dto.getId());
        if (su.isPresent()) {
            su.get().setMarka(dto.getMarka());
            su.get().setSulfat(dto.getSulfat());
            su.get().setSodyum(dto.getSodyum());
            su.get().setAmonyum(dto.getAmonyum());
            su.get().setPh(dto.getPh());
            repository.save(su.get());
        }
    }
}
