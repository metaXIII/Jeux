package com.metaxiii.jeux.service;

import com.metaxiii.jeux.dto.SupportDto;
import com.metaxiii.jeux.model.Support;

import java.util.List;
import java.util.Optional;

public interface ISupportService {
    List<Support> findAll();

    Optional<Support> findById(int support);

    void insert(SupportDto supportDto);
}
