package com.sinaukoding.perpustakaanfarhan.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "buku")
@Getter
@Setter
@NoArgsConstructor
public class Buku {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGINT(11)")
    private Long id;

    @Column(columnDefinition = "VARCHAR(255)")
    private String judul;

    @Column(columnDefinition = "VARCHAR(255)")
    private String tahunTerbit;

    @Column(columnDefinition = "INT")
    private Integer jumlah;

    @Column(columnDefinition = "VARCHAR(255)")
    private String isbn;

    @OneToMany(mappedBy = "buku")
    private List<Peminjaman_Detail> peminjaman_detailList;

    @OneToMany(mappedBy = "buku")
    private List<Pengembalian_Detail> pengembalian_detailList;

    @ManyToOne
    @JoinColumn(name = "pengarang_id")
    private Pengarang pengarang;

    @ManyToOne
    @JoinColumn(name = "penerbit_id")
    private Penerbit penerbit;
}