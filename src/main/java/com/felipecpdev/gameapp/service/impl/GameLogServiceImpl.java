package com.felipecpdev.gameapp.service.impl;

import com.felipecpdev.gameapp.entity.GameLog;
import com.felipecpdev.gameapp.repository.GameLogRepository;
import com.felipecpdev.gameapp.service.GameLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameLogServiceImpl implements GameLogService {

    public final GameLogRepository gameLogRepository;

    public GameLogServiceImpl(GameLogRepository gameLogRepository) {
        this.gameLogRepository = gameLogRepository;
    }

    @Override
    public List<GameLog> findAll() {
        return gameLogRepository.findAll();
    }
}
