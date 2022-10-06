package com.sinaukoding.perpustakaanfarhan.entity.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class PeminjamanRequest {
    private Long id;

    private Date tglPinjam;

    private Date tglkembali;

    private AnggotaDTO anggota;

    private List<BukuDTO> listBuku;
}
