USE DB2024Team13;

# 뷰 삭제
DROP VIEW IF EXISTS DB2024_rest_order_count;
DROP VIEW IF EXISTS DB2024_rest_avg_rating;

# 테이블 삭제
DROP TABLE IF EXISTS DB2024_order;
DROP TABLE IF EXISTS DB2024_review;
DROP TABLE IF EXISTS DB2024_bookmark;
DROP TABLE IF EXISTS DB2024_menu;
DROP TABLE IF EXISTS DB2024_restaurant;
DROP TABLE IF EXISTS DB2024_customer;
DROP TABLE IF EXISTS DB2024_section;

# 데이터베이스 삭제
DROP DATABASE IF EXISTS DB2024Team13;