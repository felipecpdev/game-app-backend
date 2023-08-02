package com.felipecpdev.gameapp.repository;

import com.felipecpdev.gameapp.entity.GameMode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GameModeRepository extends JpaRepository<GameMode,Long> {

    List<GameMode> findByGameId(Long id);
}
