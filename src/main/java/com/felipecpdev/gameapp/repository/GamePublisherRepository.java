package com.felipecpdev.gameapp.repository;

import com.felipecpdev.gameapp.entity.GamePublisher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface GamePublisherRepository extends JpaRepository<GamePublisher,Long> {

    List<GamePublisher> findByGameId(long id);
}
