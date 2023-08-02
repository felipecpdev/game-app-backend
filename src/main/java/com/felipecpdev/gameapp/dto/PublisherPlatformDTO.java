package com.felipecpdev.gameapp.dto;

import com.felipecpdev.gameapp.entity.Publisher;
import com.felipecpdev.gameapp.entity.PublisherPlatform;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
public class PublisherPlatformDTO implements Serializable {

    private Long id;
    private PublisherDTO publisherDTO;
    private PlatformDTO platformDTO;
    private Date releaseDate;
    public PublisherPlatformDTO(PublisherPlatform publisherPlatform) {
        this.id = publisherPlatform.getId();
        this.publisherDTO = new PublisherDTO(publisherPlatform.getPublisher());
        this.platformDTO = new PlatformDTO(publisherPlatform.getPlatform());
        this.releaseDate= publisherPlatform.getReleaseDate();
    }
}
