package com.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@Entity
@Table(name="dat_phong")
public class DatPhong {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    Integer id;

    @NotBlank(message="Thiếu mã")
    @Column(name="ma_dat_phong")
    String maDatPhong;

    @NotNull(message="Thiếu ngày đặt")
    @DateTimeFormat(pattern="dd/MM/yyyy")
    @Column(name="ngay_gio_dat")
    @Temporal(TemporalType.DATE)
    Date ngayGioDat;

    @NotNull(message="Thiếu khách hàng")
    @ManyToOne @JoinColumn(name="id_khach_hang")
    KhachHang khachHang;

    @NotNull(message="Thiếu số khách")
    @Column(name="so_luong_khach")
    Integer soLuongKhach;

    @NotNull(message="Thiếu số phòng")
    @Column(name="so_luong_phong_dat")
    Integer soLuongPhongDat;

    @Column(name="ghi_chu")
    String ghiChu;
}
