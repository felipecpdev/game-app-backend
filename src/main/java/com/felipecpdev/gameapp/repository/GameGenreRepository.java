package com.felipecpdev.gameapp.repository;

import com.felipecpdev.gameapp.entity.GameGenre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GameGenreRepository extends JpaRepository<GameGenre,Long> {

    List<GameGenre> findByGameId(Long id);
}
