package com.sinaukoding.perpustakaanfarhan.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "pengembalian_detail")
@Getter
@Setter
@NoArgsConstructor
public class Pengembalian_Detail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "BIGINT(11)")
    private Long pengembalian_id;

    @ManyToOne
    @JoinColumn(name = "buku_id")
    private Buku buku;
}