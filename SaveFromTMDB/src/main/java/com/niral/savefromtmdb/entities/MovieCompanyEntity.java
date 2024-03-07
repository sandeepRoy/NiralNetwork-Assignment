package com.niral.savefromtmdb.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "movie_company")
public class MovieCompanyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer local_id;

    @Column(name = "description")
    private String description;
    @Column(name = "headquarters")
    private String headquarters;
    @Column(name = "homepage")
    private String homepage;
    @Column(name = "id")
    private Integer id;
    @Column(name = "logo_path")
    private String logo_path;
    @Column(name = "name")
    private String name;
    @Column(name = "origin_country")
    private String origin_country;
    @Column(name = "parent_company")
    private String parent_company;

    public MovieCompanyEntity() { }

    public MovieCompanyEntity(String description, String headquarters, String homepage, Integer id, String logo_path, String name, String origin_country, String parent_company) {
        this.description = description;
        this.headquarters = headquarters;
        this.homepage = homepage;
        this.id = id;
        this.logo_path = logo_path;
        this.name = name;
        this.origin_country = origin_country;
        this.parent_company = parent_company;
    }

    public Integer getLocal_id() {
        return local_id;
    }

    public void setLocal_id(Integer local_id) {
        this.local_id = local_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHeadquarters() {
        return headquarters;
    }

    public void setHeadquarters(String headquarters) {
        this.headquarters = headquarters;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogo_path() {
        return logo_path;
    }

    public void setLogo_path(String logo_path) {
        this.logo_path = logo_path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin_country() {
        return origin_country;
    }

    public void setOrigin_country(String origin_country) {
        this.origin_country = origin_country;
    }

    public String getParent_company() {
        return parent_company;
    }

    public void setParent_company(String parent_company) {
        this.parent_company = parent_company;
    }
}
