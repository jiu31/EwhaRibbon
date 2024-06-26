package db.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 리뷰를 관리하는 클래스입니다.
 * <p>이 클래스는 새로운 리뷰를 추가하는 기능을 제공합니다.</p>
 */
public class DB2024Team13_reviewManager {

    /**
     * 새로운 리뷰를 추가하는 메소드입니다.
     *
     * @param restaurantName 리뷰를 추가할 레스토랑 이름
     * @param studentId      리뷰를 작성한 학생 ID
     * @param star           리뷰의 별점
     * @return 리뷰 추가 성공 시 true, 실패 시 false를 반환합니다.
     */
    public static boolean addReview(String restaurantName, String studentId, double star) {
        String query1 = "SELECT MAX(review_id) FROM DB2024_review USE INDEX (idx_review_id)";
        String query2 = "INSERT INTO DB2024_review (review_id, rest_name, student_id, star) VALUES (?, ?, ?, ?)";
        try (Connection conn = DB2024Team13_connection.getConnection();
             PreparedStatement pStmt1 = conn.prepareStatement(query1);
             PreparedStatement pStmt2 = conn.prepareStatement(query2)) {
            ResultSet rs = pStmt1.executeQuery();
            int newReviewId = 1;
            if (rs.next()) {
                newReviewId = rs.getInt(1) + 1;
            }
            pStmt2.setInt(1, newReviewId);
            pStmt2.setString(2, restaurantName);
            pStmt2.setString(3, studentId);
            pStmt2.setDouble(4, star);
            pStmt2.executeUpdate();
            return true;
        } catch (SQLException se) {
            se.printStackTrace();
            return false;
        }
    }
}
