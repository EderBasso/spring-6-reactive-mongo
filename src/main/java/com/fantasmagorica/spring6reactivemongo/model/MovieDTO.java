package com.fantasmagorica.spring6reactivemongo.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieDTO {

    String id;
    @NotBlank
    @Size(min = 3, max = 255)
    String title;
    String plot;
    List<String> genres;
    Long runtime;
}
