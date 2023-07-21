package com.felipecpdev.gameapp.service.impl;

import com.felipecpdev.gameapp.entity.GameLanguage;
import com.felipecpdev.gameapp.repository.GameLanguageRepository;
import com.felipecpdev.gameapp.service.GameLanguageService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameLanguageServiceImpl implements GameLanguageService {

    private final GameLanguageRepository gameLanguageRepository;

    public GameLanguageServiceImpl(GameLanguageRepository gameLanguageRepository) {
        this.gameLanguageRepository = gameLanguageRepository;
    }

    @Override
    public List<GameLanguage> findAll() {
        return gameLanguageRepository.findAll();
    }
}
