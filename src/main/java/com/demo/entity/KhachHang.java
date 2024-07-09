package com.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="khach_hang")
public class KhachHang {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    Integer id;

    @Column(name="ma_khach_hang")
    String maKhachHang;

    @Column(name="ten_khach_hang")
    String tenKhachHang;
}
