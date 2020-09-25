package com.metaxiii.jeux.impl;

import com.metaxiii.jeux.dto.SupportDto;
import com.metaxiii.jeux.model.Support;
import com.metaxiii.jeux.repository.SupportRepository;
import com.metaxiii.jeux.service.ISupportService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
@AllArgsConstructor
public class SupportServiceImpl implements ISupportService {
    private final SupportRepository supportRepository;

    @Override
    public List<Support> findAll() {
        return supportRepository.findAll();
    }

    @Override
    public Optional<Support> findById(int support) {
        return supportRepository.findById(support);
    }

    @Override
    public void insert(SupportDto supportDto) {
        Support support = new Support();
        support.setNom(supportDto.getSupport());
        supportRepository.save(support);
    }
}
