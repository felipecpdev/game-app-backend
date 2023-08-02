package com.felipecpdev.gameapp.dto;

import com.felipecpdev.gameapp.entity.Publisher;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class PublisherDTO implements Serializable {

    private Long id;
    private String publisherName;

    public PublisherDTO(Publisher publisher) {
        this.id = publisher.getId();
        this.publisherName = publisher.getPublisherName();
    }
}
