package com.niral.savefromtmdb.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieCompanyDto {
    private String description;
    private String headquarters;
    private String homepage;
    private Integer id;
    private String logo_path;
    private String name;
    private String origin_country;
    private String parent_company;
}
