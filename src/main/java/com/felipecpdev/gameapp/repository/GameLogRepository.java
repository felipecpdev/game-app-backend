package com.felipecpdev.gameapp.repository;

import com.felipecpdev.gameapp.entity.GameLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameLogRepository extends JpaRepository<GameLog,Long> {
}
