CREATE DATABASE  ASM_J5
GO

USE ASM_J5
GO

CREATE TABLE SanPham(
 ID INT IDENTITY(1,1) PRIMARY KEY,
 Ma varchar(15) not null,
 Ten varchar(100) not null,
 TrangThai int
)
CREATE TABLE MauSac(
 ID INT IDENTITY(1,1) PRIMARY KEY,
 Ma varchar(15) not null,
 Ten varchar(100) not null,
 TrangThai int
)
CREATE TABLE KichThuoc(
 ID INT IDENTITY(1,1) PRIMARY KEY,
 Ma varchar(15) not null,
 Ten varchar(100) not null,
 TrangThai int
)
CREATE TABLE SPChiTiet(
 ID INT IDENTITY(1,1) PRIMARY KEY,
 MaSPCT varchar(15) not null,
 IdKichThuoc int Foreign key references KichThuoc(ID),
 IdMauSac int Foreign key references MauSac(ID),
 IdSanPham int Foreign key references SanPham(ID),
 TrangThai int
)

CREATE TABLE KhachHang(
 ID INT IDENTITY(1,1) PRIMARY KEY,
 MaKH varchar(15) not null,
 Ten varchar(100) not null,
 SDT varchar(20),
 TrangThai int
)

CREATE TABLE NhanVien(
 ID INT IDENTITY(1,1) PRIMARY KEY,
 MaNV varchar(15) not null,
 TenDangNhap varchar(100) not null,
 MatKhau varchar(15),
 TrangThai int
)

CREATE TABLE HoaDon(
 ID INT IDENTITY(1,1) PRIMARY KEY,
 IdNhanVien int Foreign key references NhanVien(ID),
 IdKhachHang int Foreign key references KhachHang(ID),
 TrangThai int
)

CREATE TABLE HoaDonChiTiet(
 ID INT IDENTITY(1,1) PRIMARY KEY,
 IdHoaDon int Foreign key references HoaDon(ID),
 IdSPCT int Foreign key references SPChiTiet(ID),
 SoLuong int,
 DonGia Money,
 TrangThai int
)



