CREATE DATABASE exam;

USE exam;

CREATE TABLE RentalSpaces (
    id INT AUTO_INCREMENT PRIMARY KEY,
    code VARCHAR(10) UNIQUE NOT NULL,
    status ENUM('Trống', 'Hạ tầng', 'Đầy đủ') NOT NULL,
    area DECIMAL(10, 2) CHECK (area > 20),
    floor TINYINT CHECK (floor BETWEEN 1 AND 15),
    type ENUM('Văn phòng chia sẻ', 'Văn phòng trọn gói') NOT NULL,
    price DECIMAL(15, 2) CHECK (price > 1000000),
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    CONSTRAINT chk_dates CHECK (DATEDIFF(end_date, start_date) >= 180)
);

CREATE INDEX idx_type_price_floor ON RentalSpaces (type, price, floor);

DELIMITER //

CREATE PROCEDURE AddRentalSpace (
    IN p_code VARCHAR(10),
    IN p_status ENUM('Trống', 'Hạ tầng', 'Đầy đủ'),
    IN p_area DECIMAL(10, 2),
    IN p_floor TINYINT,
    IN p_type ENUM('Văn phòng chia sẻ', 'Văn phòng trọn gói'),
    IN p_price DECIMAL(15, 2),
    IN p_start_date DATE,
    IN p_end_date DATE
)
BEGIN
    IF EXISTS (SELECT 1 FROM RentalSpaces WHERE code = p_code) THEN
        SELECT 'Mã mặt bằng vừa thêm đã tồn tại' AS Error;
    END IF;

    IF DATEDIFF(p_end_date, p_start_date) < 180 THEN
        SELECT 'Ngày kết thúc phải cách ngày bắt đầu ít nhất 6 tháng' AS Error;
    END IF;

    INSERT INTO RentalSpaces (code, status, area, floor, type, price, start_date, end_date)
    VALUES (p_code, p_status, p_area, p_floor, p_type, p_price, p_start_date, p_end_date);
END //

CREATE PROCEDURE GetRentalSpacesSortedByArea()
BEGIN
    SELECT * FROM RentalSpaces
    ORDER BY area ASC;
END //

DELIMITER ;



