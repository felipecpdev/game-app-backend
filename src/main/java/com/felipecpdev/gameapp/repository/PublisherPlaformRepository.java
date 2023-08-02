package com.felipecpdev.gameapp.repository;

import com.felipecpdev.gameapp.entity.Publisher;
import com.felipecpdev.gameapp.entity.PublisherPlatform;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PublisherPlaformRepository extends JpaRepository<PublisherPlatform,Long> {

    List<PublisherPlatform> findByPublisherIn(List<Publisher> publisher);
}
