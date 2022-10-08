package com.sinaukoding.perpustakaanfarhan.entity.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sinaukoding.perpustakaanfarhan.entity.mapping.PeminjamanMapping;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PeminjamanDTO {
    public static PeminjamanMapping instance;
    private Long id;

    private Date tglPinjam;

    private Date tglkembali;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private AnggotaDTO anggota;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private PetugasDTO petugas;
}