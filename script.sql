use master
go
if exists (select * from sys.databases where name =N'PhongTro')
	drop database PhongTro
go
Create Database PhongTro
go 
use PhongTro

go

create table Phong(
	Maphong nvarchar(50) primary key,
	Tenphong nvarchar(50),
	Songuoitoida int,
	Dongia float,
	Trangthai nvarchar(1000),
	Mota nvarchar (1000)
	)
go

insert into Phong values('P01','Phong so 1',4,3000000,'Da thue','')
insert into Phong values('P02','Phong so 2',3,2850000,'Da thue','')
insert into Phong values('P03','Phong so 3',3,2850000,'Con trong','')
insert into Phong values('P04','Phong so 4',2,2000000,'Da thue','')
insert into Phong values('P05','Phong so 5',3,2850000,'Con trong','')
go

create table Dichvu(
	Madichvu nvarchar(50) primary key,
	Tendichvu nvarchar(50),
	Dongia float,
	Donvi nvarchar(50),
	Mota nvarchar(1000)
)
go
insert into Dichvu values('DV01','Internet',100000,'/thang','')
insert into Dichvu values('DV02','Dien',3500,'/kwh','')
insert into Dichvu values('DV03','Nuoc',3000,'/m3','')
insert into Dichvu values('DV04','Cap',30000,'/thang','')
insert into Dichvu values('DV05','Giu xe',200000,'/thang','')
go
create table Thietbi(
	Mathietbi nvarchar(50) primary key,
	Maphong nvarchar(50),
	Tenthietbi nvarchar(100),
	Donvi nvarchar(50),
	Gia float,
	Trangthai nvarchar(1000),
	Mota nvarchar(1000),
	Soluong int
)
go
insert into Thietbi values('Mtb01','P01','Tu Lanh','Cai',4000000,'Con Moi','',1)
insert into Thietbi values('Mtb02','P02','May Lanh','Cai',3000000,'Con Moi','',1)
insert into Thietbi values('Mtb03','P03','Bep','Cai',2000000,'Da qua su dung','',1)
insert into Thietbi values('Mtb04','P04','Tu Quan Ao','Cai',900000,'Da qua su dung','',1)
insert into Thietbi values('Mtb05','P05','May Rua Chen','Cai',2000000,'Con Moi','',1)
go

create table Admin(
	Username nvarchar(50) primary key,
	Pass nvarchar(50),
	Sdt nvarchar(20),
	Email nvarchar(50),
	Ghichu nvarchar(1000)
)
go
insert into Admin values('Hao','123','0328750105','haokhoi@gmail.com','')
insert into Admin values('Tuong','456','0326785699','tuong@gmail.com','')
insert into Admin values('Nga','789','0327385618','nga@gmail.com','')
insert into Admin values('Tuan','234','03378264855','tuan@gmail.com','')
insert into Admin values('Lap','678','0285627463','lap@gmail.com','')
go
create table Hoadondiennuoc(
	Mahoadon nvarchar(50) primary key,
	Maphong nvarchar(50),
	Ngaylap date,
	Chisodau int,
	Chisocuoi int,
	Tieuthu as Chisocuoi-Chisodau
)
go
insert into Hoadondiennuoc(Mahoadon,Maphong,Ngaylap,Chisodau,Chisocuoi) values('Mhdd01','P01','03/30/2019',85,125)
insert into Hoadondiennuoc(Mahoadon,Maphong,Ngaylap,Chisodau,Chisocuoi) values('Mhdd02','P02','03/30/2019',23,88)
insert into Hoadondiennuoc(Mahoadon,Maphong,Ngaylap,Chisodau,Chisocuoi) values('Mhdd03','P03','03/30/2019',55,98)
insert into Hoadondiennuoc(Mahoadon,Maphong,Ngaylap,Chisodau,Chisocuoi) values('Mhdd04','P04','03/30/2019',113,169)
insert into Hoadondiennuoc(Mahoadon,Maphong,Ngaylap,Chisodau,Chisocuoi) values('Mhdd05','P05','03/30/2019',124,187)

insert into Hoadondiennuoc(Mahoadon,Maphong,Ngaylap,Chisodau,Chisocuoi) values('Mhdn01','P01','03/30/2019',94,143)
insert into Hoadondiennuoc(Mahoadon,Maphong,Ngaylap,Chisodau,Chisocuoi) values('Mhdn02','P02','03/30/2019',50,85)
insert into Hoadondiennuoc(Mahoadon,Maphong,Ngaylap,Chisodau,Chisocuoi) values('Mhdn03','P03','03/30/2019',83,126)
insert into Hoadondiennuoc(Mahoadon,Maphong,Ngaylap,Chisodau,Chisocuoi) values('Mhdn04','P04','03/30/2019',99,147)
insert into Hoadondiennuoc(Mahoadon,Maphong,Ngaylap,Chisodau,Chisocuoi) values('Mhdn05','P05','03/30/2019',111,167)
go

create table Khachhang(
	Makhachhang nvarchar(50) primary key,
	Maphong nvarchar(50),
	Ten nvarchar(50),
	Namsinh date,
	Cmnd nvarchar(50),
	Diachi nvarchar(50),
	Nghenghiep nvarchar(50),
	Sdt nvarchar(50),
	Hinh image
)
go
insert into Khachhang values('Mkh01','P01','nguyenvuhao','09/30/2000','02953658572','621 nguyen kiem,p9,phu nhuan','ban boong','0328750105',null)
insert into Khachhang values('Mkh02','P02','phanhoangkhoa','08/23/2000','02953658582','826 le van sy,p3,go vap','Giao vien','0382749471',null)
insert into Khachhang values('Mkh03','P03','dangkientuong','02/12/2000','02953658555','42 quang trung,p7,go vap','Dien Vien','03726492739',null)
insert into Khachhang values('Mkh04','P04','phamthuynga','01/13/2000','03928472649','723 phan dinh phung,p9,phu nhuan','nguoi mau','03284038558',null)
insert into Khachhang values('Mkh05','P05','nguyenvantuan','04/30/2000','02857365949','983 no trang long,p5,binh thanh','Cameraman','032846197',null)
go
create table Chi(
	Machi nvarchar(50) primary key,
	Tenkhoanchi nvarchar(50),
	Ngaychi date,
	Loaikhoanchi nvarchar(50),
	Sotien float,
	Mota nvarchar(1000)
)
go
insert into Chi values('Mchi01','tien dien','03/27/2019','/hang thang',1000000,'')
insert into Chi values('Mchi02','tien nuoc','03/27/2019','/thang',1200000,'')
insert into Chi values('Mchi03','tien internet','03/27/2019','/thang',300000,'')
insert into Chi values('Mchi04','tien sua may bom','09/15/2019','/sua chua',500000,'')
insert into Chi values('Mchi05','tien mua may lanh','01/12/2019','/mua moi',150000,'')
go
create table Hoadonphong(
	Mahd nvarchar(50) primary key,
	Thangnam date,
	Maphong nvarchar(50),
	Nguoidaidien nvarchar(50),
	Ngaythanhtoan date,
	Tinhtrang nvarchar(1000)
)
go
insert into Hoadonphong values('Mahdp1','03/30/2019','P01','Nguyen Van A','04/01/2019','Da thanh toan')
insert into Hoadonphong values('Mahdp2','03/30/2019','P02','Nguyen Van B','04/01/2019','Da thanh toan')
insert into Hoadonphong values('Mahdp3','03/30/2019','P03','Nguyen Van C','04/01/2019','Chua thanh toan')
insert into Hoadonphong values('Mahdp4','03/30/2019','P04','Nguyen Van D','04/01/2019','Da thanh toan')
insert into Hoadonphong values('Mahdp5','03/30/2019','P05','Nguyen Van E','04/01/2019','Chua thanh toan')
go
create table Hopdong(
	Mahopdong nvarchar(50) primary key,
	Maphong nvarchar(50) not null,
	Nguoidaidien nvarchar(50),
	Sdt nvarchar(15),
	Tiendatcoc float,
	Ngaydatcoc date,
	Ngayhethan date
)
go
insert into Hopdong values('hopdong1','P01','Nguyen Van A','0394857295',1000000,'02/15/2019','12/30/2019')
insert into Hopdong values('hopdong2','P02','Nguyen Van B','0338572659',1000000,'02/15/2019','12/30/2019')
insert into Hopdong values('hopdong3','P03','Nguyen Van C','0327483675',1000000,'02/15/2019','12/30/2019')
insert into Hopdong values('hopdong4','P04','Nguyen Van D','0626836372',1000000,'02/15/2019','12/30/2019')
insert into Hopdong values('hopdong5','P05','Nguyen Van E','0383957938',1000000,'02/15/2019','12/30/2019')
go
create table Sudungdv(
	Masddv nvarchar(50) primary key,
	Maphong nvarchar(50),
	Madichvu nvarchar(50)
)
go
insert into Sudungdv values('Masddv1','P01','DV01')
insert into Sudungdv values('Masddv2','P02','DV01')
insert into Sudungdv values('Masddv3','P03','DV04')
insert into Sudungdv values('Masddv4','P04','DV04')
insert into Sudungdv values('Masddv5','P05','DV05')
insert into Sudungdv values('Masddv6','P05','DV05')
go
--Tao khoa phu
alter table Thietbi add constraint FK_Thietbiphong
	foreign key(Maphong) references Phong(Maphong)
go
alter table Hoadondiennuoc add constraint FK_hoadondiennuoc
	foreign key(Maphong) references Phong(Maphong)
go
alter table Hopdong add constraint FK_hopdongnha
	foreign key(Maphong) references Phong(Maphong)
go
alter table Sudungdv add constraint FK_Sudungdichvu
	foreign key(Maphong) references Phong(Maphong)
go
alter table Sudungdv add constraint FK_Dichvu
	foreign key(Madichvu) references Dichvu(Madichvu)
go
alter table Hoadonphong add constraint FK_Hoadonphong
	foreign key(Maphong) references Phong(Maphong)
go
alter table Khachhang add constraint FK_Khachhang
	foreign key(Maphong) references Phong(Maphong)






