package com.sinaukoding.perpustakaanfarhan.entity.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PengembalianDTO {
    private Long id;

    private Date tglPengembalian;

    private Double denda;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private PeminjamanDTO peminjaman;
}
