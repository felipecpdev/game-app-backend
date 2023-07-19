package com.felipecpdev.gameapp.repository;

import com.felipecpdev.gameapp.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game,Long> {
}
