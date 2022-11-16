drop database if exists ss2_cderdsmhqh;
create database ss2_cderdsmhqh;
use ss2_cderdsmhqh;
create table phieu_xuat(
	so_px int primary key auto_increment,
    ngay_xuat date
);
create table vat_tu(
	ma_vtu int primary key auto_increment,
    ten_vtu nvarchar(50)
);
create table chi_tiet_phieu_xuat(
	so_px_phieuxuat int,
    ma_vtu_vattu int,
    primary key(so_px_phieuxuat,ma_vtu_vattu),
    foreign key(so_px_phieuxuat) references phieu_xuat(so_px),
    foreign key(ma_vtu_vattu) references vat_tu(ma_vtu),
    dg_xuat double,
    sl_xuat int
);
create table phieu_nhap(
	so_pn int primary key auto_increment,
    ngay_nhap date
);
create table chi_tiet_phieu_nhap(
	so_pn_phieunhap int,
    ma_vtu_vattu int,
    primary key(so_pn_phieunhap,ma_vtu_vattu),
    foreign key(so_pn_phieunhap) references phieu_nhap(so_pn),
    foreign key(ma_vtu_vattu) references vat_tu(ma_vtu),
    dg_nhap double,
    sl_nhap int
);
create table don_dh(
	so_dh int primary key auto_increment,
    ngay_dh date
);
alter table don_dh
	add ma_ncc int,
	add foreign key(ma_ncc) references nhacc(ma_ncc);
    select * from don_dh;
create table chi_tiet_don_dat_hang(
	ma_vtu_vattu int,
    so_dh_dondh int,
    primary key(ma_vtu_vattu,so_dh_dondh),
    foreign key(ma_vtu_vattu) references vat_tu(ma_vtu),
    foreign key(so_dh_dondh) references don_dh(so_dh)
);
create table nhacc(
	ma_ncc int primary key,
    ten_ncc nvarchar(50),
    dia_chi nvarchar(50)
);
create table sdt(
	id int primary key auto_increment,
    sdt nvarchar(11),
    ma_ncc int,
    foreign key(ma_ncc) references nhacc(ma_ncc)
);