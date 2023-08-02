package com.felipecpdev.gameapp.dto;

import com.felipecpdev.gameapp.entity.Platform;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class PlatformDTO implements Serializable {

    private Long id;
    private String platformName;

    public PlatformDTO(Platform platform) {
        this.id = platform.getId();
        this.platformName = platform.getPlatformName();
    }
}
