package org.example.emtlab_a.model.dto;

import lombok.Data;
import org.example.emtlab_a.model.Country;

@Data
public class AuthorDto {
    private String name;
    private String surname;
    private Long countryId;

    public AuthorDto() {
    }

    public AuthorDto(String name, String surname, Long countryId) {
        this.name = name;
        this.surname = surname;
        this.countryId = countryId;
    }
}
