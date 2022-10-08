package com.sinaukoding.perpustakaanfarhan.entity.dto;

import com.sinaukoding.perpustakaanfarhan.entity.mapping.PengarangMapping;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
public class PengarangDTO {
    public static PengarangMapping instance;
    private Long id;

    private String nama;

    private String alamat;

    private String telp;
}
