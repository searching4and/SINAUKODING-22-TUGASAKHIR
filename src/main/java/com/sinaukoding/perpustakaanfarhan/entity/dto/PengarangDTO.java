package com.sinaukoding.perpustakaanfarhan.entity.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
public class PengarangDTO {
    private Long id;

    private String nama;

    private String alamat;

    private String telp;
}
