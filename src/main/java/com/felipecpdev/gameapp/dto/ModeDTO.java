package com.felipecpdev.gameapp.dto;

import com.felipecpdev.gameapp.entity.Mode;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class ModeDTO implements Serializable {

    private Long id;
    private String modeName;

    public ModeDTO(Mode mode) {
        this.id = mode.getId();
        this.modeName = mode.getModeName();
    }
}
