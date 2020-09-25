package com.metaxiii.jeux.impl;

import com.metaxiii.jeux.model.Support;
import com.metaxiii.jeux.repository.SupportRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SupportServiceImplTest {

    @InjectMocks
    private SupportServiceImpl aze;

    @Mock
    private SupportRepository supportRepository;

    @Test
    void findById() {
        when(supportRepository.findById(1)).thenReturn(Optional.of(new Support()));
        assertDoesNotThrow(() -> aze.findById(1));
    }
}