package com.sinaukoding.perpustakaanfarhan.repository;

import com.sinaukoding.perpustakaanfarhan.entity.Buku;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BukuRepository extends JpaRepository<Buku, Long> {
}
