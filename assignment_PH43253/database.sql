Create database ASM_J5
go
use ASM_J5
go

create table sanpham(
 id int identity(1,1) primary key,
 ma varchar(15) not null,
 ten nvarchar(100) not null,
 trangthai int
)

create table mausac(
 id int identity(1,1) primary key,
 ma varchar(15) not null,
 ten nvarchar(100) not null,
 trangthai int
)
create table kichthuoc(
 id int identity(1,1) primary key,
 ma varchar(15) not null,
 ten nvarchar(100) not null,
 trangthai int
)
create table spchitiet(
 id int identity(1,1) primary key,
 maspct varchar(15) not null,
 idkichthuoc int foreign key references kichthuoc(id),
 idmausac int foreign key references mausac(id),
 idsanpham int foreign key references sanpham(id),
 soluong int,
 dongia money,
 trangthai int
)
create table nhanvien(
 id int identity(1,1) primary key,
 manv varchar(15) not null,
 tendangnhap varchar(100) not null,
 ten nvarchar(100) ,
 matkhau varchar(50),
 vaitro int,
 trangthai int
)

create table khachhang(
 id int identity(1,1) primary key,
 makh varchar(15) not null,
 ten nvarchar(100) ,
 sdt varchar(20),
 trangthai int
)

create table hoadon(
 id int identity(1,1) primary key,
 idnhanvien int foreign key references nhanvien(id),
 idkhachhang int foreign key references khachhang(id),
 ngaymuahang datetime,
 trangthai int
)

create table hoadonchitiet(
 id int identity(1,1) primary key,
 idhoadon int foreign key references hoadon(id),
 idspct int foreign key references spchitiet(id),
 soluong int, 
 dongia money,
 trangthai int
)
