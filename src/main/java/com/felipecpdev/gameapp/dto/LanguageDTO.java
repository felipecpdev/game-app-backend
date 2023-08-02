package com.felipecpdev.gameapp.dto;

import com.felipecpdev.gameapp.entity.Language;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class LanguageDTO implements Serializable {
    private Long id;
    private String languageName;

    public LanguageDTO(Language language) {
        this.id = language.getId();
        this.languageName = language.getLanguageName();
    }
}
