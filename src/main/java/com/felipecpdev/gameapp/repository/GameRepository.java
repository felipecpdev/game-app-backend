package com.felipecpdev.gameapp.repository;

import com.felipecpdev.gameapp.entity.Game;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface GameRepository extends JpaRepository<Game, Long> {
    Page<Game> findByGameNameContainsIgnoreCase(String gameName, Pageable pageable);
}
