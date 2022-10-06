package com.sinaukoding.perpustakaanfarhan.repository;

import com.sinaukoding.perpustakaanfarhan.entity.Peminjaman;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeminjamanRepository extends JpaRepository<Peminjaman, Long> {
}
