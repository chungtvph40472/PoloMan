CREATE DATABASE POLOMAN
GO

USE POLOMAN
GO
---------------------------Nhan Vien-------------------------------
	CREATE TABLE NhanVien
	(
		Id INT IDENTITY(1,1) PRIMARY KEY,
		MaNhanVien AS (CONCAT('NV', RIGHT('000' + CAST(Id AS NVARCHAR),3))),
		TenNhanVien NVARCHAR(50) NULL,
		DiaChi NVARCHAR(50) NULL,
		MatKhau VARCHAR(30),
		GioiTinh BIT NULL,
		Email VARCHAR(50) NULL,
		SoDienThoai VARCHAR(10) NULL,
		ChucVu NVARCHAR(10) NULL,
		NgayTao DATE NULL,
		NgaySua DATE NULL,
		TrangThai INT DEFAULT 1,
	)
	GO

	INSERT INTO NhanVien (
		TenNhanVien, DiaChi, MatKhau, GioiTinh,
		Email, SoDienThoai, ChucVu, NgayTao, NgaySua, TrangThai
	)
	VALUES 
		( N'Lừ Văn Hiếu',  N'1 Trịnh Văn Bô',     '1234', 1, 'hieu@gmail.com',   '0999999999', N'Quản lý',     '2025-03-01', NULL, 1),
		( N'Thái Văn Chung',    N'27 Cầu Diễn', '1234', 1, 'chung@gmail.com',   '0922222222', N'Nhân viên', '2025-04-01', NULL, 1),
		( N'Nguyễn Thế Thắng',      N'136 Hồ Tùng Mậu',   '1234', 1, 'thang@gmail.com',   '0933333333', N'Quản lý',   '2025-05-10', NULL, 1),
		( N'Nguyễn Sỹ An',    N'321 Lý Thường Kiệt',  '1234', 1, 'an@gmail.com',   '0944444444', N'Nhân viên', '2025-05-10', NULL, 1),
		( N'Đặng Thùy Dương',   N'82 Nguyễn Trãi','1234', 0, 'duong@gmail.com',   '0955555555', N'Nhân viên',     '2025-04-17', NULL, 1);
		

---------------------------Khach Hang-------------------------------

	CREATE TABLE KhachHang
	(
		Id INT IDENTITY(1,1) PRIMARY KEY,
		MaKhachHang AS(CONCAT('KH', RIGHT ('000' + CAST(Id AS NVARCHAR), 3))),
		TenKhachHang NVARCHAR(50) NULL,
		GioiTinh BIT NULL,
		SoDienThoai VARCHAR(10) NULL,
		DiaChi NVARCHAR(255) NULL,
		NgayTao DATE NULL,
		TrangThai INT NULL DEFAULT 1
	)
	GO

	INSERT INTO KhachHang (TenKhachHang, GioiTinh, SoDienThoai, DiaChi, NgayTao, TrangThai)
	VALUES
		(N'Nguyễn Văn An',     1, '0911000001', N'12 Lê Lợi, Q1',         '2025-03-01', 1),
		(N'Trần Thị Bình',     0, '0911000002', N'45 Nguyễn Huệ, Q3',     '2025-03-02', 1),
		(N'Lê Văn Cường',      1, '0911000003', N'78 Trần Phú, Q5',       '2025-03-03', 1),
		(N'Phạm Thị Dung',     0, '0911000004', N'23 Lý Tự Trọng, Q1',    '2025-03-04', 1),
		(N'Huỳnh Văn Em',       1, '0911000005', N'67 Pasteur, Q3',        '2025-03-05', 1),
		(N'Võ Thị Phương',     0, '0911000006', N'90 Nguyễn Trãi, Q5',    '2025-03-06', 1),
		(N'Ngô Văn Giang',     1, '0911000007', N'101 Hai Bà Trưng, Q1',  '2025-03-07', 1),
		(N'Tăng Thị Hồng',     0, '0911000008', N'134 Lê Văn Sỹ, Q3',     '2025-03-08', 1),
		(N'Trịnh Văn Long',    1, '0911000009', N'11 Hoàng Hoa Thám, Q5', '2025-03-09', 1),
		(N'Đặng Thị Mai',      0, '0911000010', N'222 Nguyễn Đình Chiểu','2025-03-10', 1);
	
	
	---------------------------Voucher-------------------------------

	CREATE TABLE Voucher
	(
		Id INT IDENTITY(1,1) PRIMARY KEY,
		TenVoucher NVARCHAR(10) NULL,
		MoTa NVARCHAR(50) NULL,
		PhanTramGiamGia INT NULL,
		NgayTao DATE NULL,
		NgaySua DATE NULL,
		NgayBatDau DATE NULL,
		NgayKetThuc DATE NULL,
		TrangThai INT NULL DEFAULT 1
	)
	GO
	--Drop table Voucher
	INSERT INTO Voucher (TenVoucher, MoTa, PhanTramGiamGia, NgayTao, NgaySua, NgayBatDau, NgayKetThuc, TrangThai)
	VALUES
		(NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),
		(N'GP30', N'Giảm giá dịp lễ 30/4 - 1/5', 15, '2024-04-25', NULL, '2024-04-28', '2024-05-03', 1), 
		(N'HE10', N'Khuyến mãi hè 2024', 10, '2024-05-15', NULL, '2024-05-20', '2024-06-30', 1);

	---------------------------Chat Lieu-------------------------------

	CREATE TABLE ChatLieu
	(
		Id INT IDENTITY(1,1) PRIMARY KEY,
		MaChatLieu AS (CONCAT('CL', RIGHT('000' + CAST(Id AS NVARCHAR), 3))) PERSISTED,
		TenChatLieu NVARCHAR(20) NULL,
		TrangThai INT NULL DEFAULT 1
	)
	GO

	INSERT INTO ChatLieu (TenChatLieu, TrangThai)
	VALUES 
		(N'Cotton', 1),
		(N'Polyester', 1),
		(N'Nylon', 1);

	---------------------------Kich Thuoc-------------------------------

	CREATE TABLE KichThuoc
	(
		Id INT IDENTITY(1,1) PRIMARY KEY,
		MaKichThuoc AS (CONCAT('KT', RIGHT('000' + CAST(Id AS NVARCHAR), 3))) PERSISTED,
		TenKichThuoc NVARCHAR(20) NULL,
		TrangThai INT NULL DEFAULT 1
	)
	GO

	INSERT INTO KichThuoc(TenKichThuoc, TrangThai)
	VALUES 
		(N'M', 1),
		(N'L', 1),
		(N'XL', 1),
		(N'XXL', 1);


	---------------------------Mau Sac-------------------------------

	CREATE TABLE MauSac
	(
		Id INT IDENTITY(1,1) PRIMARY KEY,
		MaMauSac AS (CONCAT('MS', RIGHT('000' + CAST(Id AS NVARCHAR), 3))) PERSISTED,
		TenMauSac NVARCHAR(20) NULL,
		TrangThai INT NULL DEFAULT 1
	)
	GO

		INSERT INTO MauSac (TenMauSac, TrangThai)
	VALUES 
		(N'Đỏ', 1),
		(N'Xanh', 1),
		(N'Vàng', 1),
		(N'Trắng', 1),
		(N'Đen', 1),
		(N'Hồng', 1),
		(N'Tím', 1);


	---------------------------Thuong Hieu-------------------------------

	CREATE TABLE ThuongHieu
	(
		Id INT IDENTITY(1,1) PRIMARY KEY,
		MaThuongHieu AS (CONCAT('TH', RIGHT('000' + CAST(Id AS NVARCHAR), 3))) PERSISTED,
		TenThuongHieu NVARCHAR(20) NULL,
		TrangThai INT NULL DEFAULT 1
	)
	GO

		INSERT INTO ThuongHieu(TenThuongHieu, TrangThai)
	VALUES 
		(N'PoloMan', 1)

	---------------------------San Pham-------------------------------

	CREATE TABLE SanPham
	(
		Id INT IDENTITY(1,1) PRIMARY KEY,
		IdThuongHieu INT NULL,
		MaSanPham AS (CONCAT('SP', RIGHT('000' + CAST(Id AS NVARCHAR), 3))) PERSISTED,
		TenSanPham NVARCHAR(30) NULL,
		HinhAnh NVARCHAR(100) NULL,
		Gia DECIMAL(10,2) NULL,
		SoLuong INT  NULL,
		TrangThai INT NULL DEFAULT 1

		FOREIGN KEY(IdThuongHieu) REFERENCES ThuongHieu(Id),
	)
	GO

	INSERT INTO SanPham (IdThuongHieu, TenSanPham, HinhAnh, Gia, SoLuong, TrangThai)
	VALUES 
		(1, N'Áo Polo Nam JACK', N'ao_polo1.jpg', 199000, 50, 1),
		(1, N'Áo Polo Nam DAVID', N'ao_polo2.jpg', 215000, 30, 1),
		(1, N'Áo Polo Nam VINI', N'ao_polo3.jpg', 239000, 45, 1),
		(1, N'Áo Polo Nam GOLDEN', N'ao_polo4.jpg', 185000, 60, 1),
		(1, N'Áo Polo Nam PETER', N'ao_polo5.jpg', 205000, 25, 1),
		(1, N'Áo Polo Nam JUN', N'ao_polo6.jpg', 259000, 40, 1),
		(1, N'Áo Polo Nam KALLI', N'ao_polo7.jpg', 198000, 35, 1),
		(1, N'Áo Polo Nam NOAH', N'ao_polo8.jpg', 210000, 38, 1),
		(1, N'Áo Polo Nam MIA', N'ao_polo9.jpg', 225000, 42, 1),
		(1, N'Áo Polo Nam WILL', N'ao_polo10.jpg', 249000, 28, 1);


	---------------------------San Pham Chi Tiet-------------------------------

	CREATE TABLE SanPhamChiTiet
	(
		Id INT IDENTITY(1,1) PRIMARY KEY,
		IdSanPham INT NULL,
		IdMauSac INT NULL,
		IdKichThuoc INT NULL,
		IdChatLieu INT Null,
		TenSanPham NVARCHAR(30) NULL,
		HinhAnh NVARCHAR(100) NULL,
		Gia DECIMAL(10,2) NULL,
		MoTa NVARCHAR(50) NULL, 
		SoLuong INT  NULL,
		TrangThai INT NULL DEFAULT 1

		FOREIGN KEY(IdSanPham) REFERENCES SanPham(Id),
		FOREIGN KEY(IdMauSac) REFERENCES MauSac(Id),
		FOREIGN KEY(IdKichThuoc) REFERENCES KichThuoc(Id),
		FOREIGN KEY(IdChatLieu) REFERENCES ChatLieu(Id),
	)
	GO

	INSERT INTO SanPhamChiTiet (IdSanPham, IdMauSac, IdKichThuoc, IdChatLieu, MoTa, SoLuong, TrangThai)
	VALUES 
		(1, 1, 2, 1, N'Áo Polo JACK - Màu Đỏ, Size L', 10, 1),
		(2, 2, 3, 1, N'Áo Polo DAVID - Màu Xanh, Size XL', 12, 1),
		(3, 3, 2, 2, N'Áo Polo VINI - Màu Vàng, Size L', 8, 1),
		(4, 1, 1, 2, N'Áo Polo GOLDEN - Màu Đỏ, Size M', 15, 1),
		(5, 4, 3, 1, N'Áo Polo PETER - Màu Trắng, Size XL', 7, 1),
		(6, 6, 2, 3, N'Áo Polo JUN - Màu Hồng, Size L', 10, 1),
		(7, 7, 2, 1, N'Áo Polo KALLI - Màu Tím, Size L', 9, 1),
		(8, 5, 4, 2, N'Áo Polo NOAH - Màu Đen, Size XXL', 11, 1),
		(9, 5, 2, 2, N'Áo Polo MIA - Màu Đen, Size L', 13, 1),
		(10, 2, 1, 3, N'Áo Polo WILL - Màu Xanh, Size M', 6, 1);


	---------------------------Hoa Don-------------------------------

	CREATE TABLE HoaDon
	(
		Id INT IDENTITY(1,1) PRIMARY KEY,
		IdKhachHang INT NULL,
		IdNhanVien INT NULL,
		IdVoucher INT NULL,
		MaHoaDon AS (CONCAT ('HD', RIGHT('00000' + CAST(Id AS NVARCHAR), 5))) PERSISTED,
		TienDua  DECIMAL(10,2) NULL,
		ThanhTien DECIMAL(10,2) NULL,
		NgayTao DATE NULL,
		NgayThanhToan DATE NULL, 
		TrangThai INT NULL DEFAULT 1

		FOREIGN KEY(IdVoucher) REFERENCES Voucher(Id),
		FOREIGN KEY(IdKhachHang) REFERENCES KhachHang(Id),
		FOREIGN KEY(IdNhanVien) REFERENCES NhanVien(Id)
		
	)
	GO

	INSERT INTO HoaDon (IdKhachHang, IdNhanVien, IdVoucher, TienDua, ThanhTien, NgayTao, NgayThanhToan, TrangThai)
	VALUES 
		(1, 2, 1, 500000, 398000, '2024-07-01', '2024-07-01', 1),
		(2, 1, NULL, 500000, 193500, '2024-07-05', '2024-07-05', 1),
		(3, 2, 2, 700000, 609450, '2024-07-10', '2024-07-11', 1),
		(4, 3, NULL, 200000, 185000, '2024-07-12', NULL, 0),
		(5, 1, 3, 500000, 369000, '2024-07-15', '2024-07-15', 1);


	---------------------------Hoa Don Chi Tiet-------------------------S------

	CREATE TABLE HoaDonChiTiet
	(
		Id INT IDENTITY(1,1) PRIMARY KEY,
		IdHoaDon INT NULL,
		IdSanPhamChiTiet INT NULL,
		SoLuong INT,
		Gia DECIMAL(10,2),
		GiamGia INT,
		ThanhTien DECIMAL(10,2),
		TrangThai INT DEFAULT 1,

		FOREIGN KEY(IdHoaDon) REFERENCES HoaDon(Id),
		FOREIGN KEY(IdSanPhamChiTiet) REFERENCES SanPhamChiTiet(Id)
	)
	GO

	INSERT INTO HoaDonChiTiet (IdHoaDon, IdSanPhamChiTiet, SoLuong, Gia, GiamGia, ThanhTien, TrangThai)
	VALUES 
		(1, 1, 2, 398000, 0, 398000, 1),
		(2, 2, 1, 215000, 10, 193500, 1),
		(3, 3, 3, 717000, 15, 609450, 1),
		(4, 4, 1, 185000, 0, 185000, 1),
		(5, 5, 2, 410000, 10, 369000, 1);

	--------------------------- SELECT -------------------------------

		SELECT * FROM NhanVien
		SELECT * FROM KhachHang
		SELECT * FROM ChatLieu
		SELECT * FROM ThuongHieu
		SELECT * FROM KichThuoc
		SELECT * FROM MauSac
		SELECT * FROM Voucher
		SELECT * FROM HoaDonChiTiet
		SELECT * FROM HoaDon
		SELECT * FROM SanPham
		SELECT * FROM SanPhamChiTiet
	