package com.demo.repo;

import com.demo.entity.DatPhong;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DatPhongRepo extends JpaRepository<DatPhong, Integer> {
    @Query("SELECT dp FROM DatPhong dp WHERE dp.maDatPhong LIKE ?1")
    //@Query(value = "SELECT * FROM dat_phong WHERE ma_dat_phong LIKE ?1", nativeQuery = true)
    List<DatPhong> search(String kw);
}
