package com.felipecpdev.gameapp.repository;

import com.felipecpdev.gameapp.entity.GameLanguage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GameLanguageRepository extends JpaRepository<GameLanguage,Long> {

    List<GameLanguage> findByGameId(Long id);
}
