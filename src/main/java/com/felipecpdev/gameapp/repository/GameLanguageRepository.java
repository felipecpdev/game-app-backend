package com.felipecpdev.gameapp.repository;

import com.felipecpdev.gameapp.entity.GameLanguage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameLanguageRepository extends JpaRepository<GameLanguage,Long> {
}
