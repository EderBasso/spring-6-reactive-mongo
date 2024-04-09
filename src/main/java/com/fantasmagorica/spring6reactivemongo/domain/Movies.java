package com.fantasmagorica.spring6reactivemongo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document
public class Movies {

    @Id
    String id;
    String title;
    String plot;
    List<String> genres;
    Long runtime;
}
