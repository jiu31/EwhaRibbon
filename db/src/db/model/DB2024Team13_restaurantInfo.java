package db.model;

/**
 * 가게 정보에 대한 항목 및 특성을 처리하는 클래스입니다.
 * <p>이 클래스는 가게의 이름, 위치, 카테고리, 브레이크 타임 여부, 혼밥 가능 여부, 주문 수 및 평균 평점을 관리합니다.</p>
 */
public class DB2024Team13_restaurantInfo {
    private String name;
    private String location;
    private String category;
    private boolean breakTime;
    private boolean eatAlone;
    private int orderCount;
    private double avgRating;

    /**
     * 가게 정보를 초기화하는 생성자입니다.
     *
     * @param name 가게 이름
     * @param location 가게 위치
     * @param category 가게의 카테고리
     * @param breakTime 가게의 브레이크 타임 여부
     * @param eatAlone 혼밥 가능한지 여부
     * @param orderCount 가게의 주문 수
     * @param avgRating 가게의 평균 평점
     */
    public DB2024Team13_restaurantInfo(String name, String location,String category, boolean breakTime, boolean eatAlone, int orderCount, double avgRating) {
        this.name = name;
        this.location = location;
        this.category = category;
        this.breakTime = breakTime;
        this.eatAlone = eatAlone;
        this.orderCount = orderCount;
        this.avgRating = avgRating;
    }

    /**
     * 가게 이름을 반환하는 메소드입니다.
     *
     * @return 가게 이름
     */
    public String getName() {
        return name;
    }

    /**
     * 가게 위치를 반환하는 메소드입니다.
     *
     * @return 가게 위치
     */
    public String getLocation() {
        return location;
    }

    /**
     * 가게의 카테고리를 반환하는 메소드입니다.
     *
     * @return 가게의 카테고리
     */
    public String getCategory() {
        return category;
    }

    /**
     * 가게의 브레이크 타임 여부를 반환하는 메소드입니다.
     *
     * @return 브레이크 타임 여부
     */
    public boolean isBreakTime() {
        return breakTime;
    }

    /**
     * 혼밥 가능한지 여부를 반환하는 메소드입니다.
     *
     * @return 혼밥 가능한지 여부
     */
    public boolean isEatAlone() {
        return eatAlone;
    }

    /**
     * 가게의 주문 수를 반환하는 메소드입니다.
     *
     * @return 가게의 주문 수
     */
    public int getOrderCount() {
        return orderCount;
    }

    /**
     * 가게의 평균 평점을 반환하는 메소드입니다.
     *
     * @return 가게의 평균 평점
     */
    public double getAvgRating() {
        return avgRating;
    }
}
