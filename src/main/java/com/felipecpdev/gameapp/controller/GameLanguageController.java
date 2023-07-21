package com.felipecpdev.gameapp.controller;

import com.felipecpdev.gameapp.entity.GameLanguage;
import com.felipecpdev.gameapp.service.GameLanguageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/game-language")
public class GameLanguageController {


    private final GameLanguageService gameLanguageService;

    public GameLanguageController(GameLanguageService gameLanguageService) {
        this.gameLanguageService = gameLanguageService;
    }

    @GetMapping
    public List<GameLanguage> findAll(){
        List<GameLanguage> gameLanguageList= gameLanguageService.findAll();
        return gameLanguageList;
    }
}
