# 요기요 (가상) 백엔드 실무 과제 테스트

> **배경:** 당신은 요기요 정산시스템 백엔드 개발자입니다. 사장님들에게 정확한 판매 대금을 정산하여 지급하는 것이 우리의 핵심 임무입니다.
>
> **제한 시간:** 180분
> **사용 언어:** Java (Spring Boot 환경이라고 가정)

---

## 📜 공통 제공 코드 (Skeleton Code)

아래의 데이터 클래스, Enum, Repository 인터페이스는 3문제 전반에 걸쳐 이미 존재한다고 가정하고 사용하세요.

```java
// (Lombok 어노테이션은 편의상 생략)

// 주문
public class Order {
    private Long id;
    private Long restaurantId;      // 가게 ID
    private BigDecimal totalPrice;      // 주문 총액 (고객 결제 금액)
    private BigDecimal discountPrice;     // 할인 금액
    private PromotionType promotionType; // 할인 주체
    private OrderStatus status;          // 주문 상태
    private LocalDate orderDate;         // 주문 일자

    // Getters...
}

// 가게
public class Restaurant {
    private Long id;
    private String name;
    private CommissionPolicy commissionPolicy; // 가게별 수수료 정책
    // Getters...
}

// 수수료 정책
public class CommissionPolicy {
    private CommissionType type;     // 수수료 타입
    private BigDecimal commissionRate; // 정률 (예: 0.1 -> 10%)
    private BigDecimal commissionFee;  // 정액 (예: 500 -> 500원)
    // Getters...
}

// Enum 정의
public enum OrderStatus { COMPLETED, CANCELLED }
public enum PromotionType { YOGIYO_COUPON, RESTAURANT_COUPON }
public enum CommissionType { FIXED_RATE, PER_ORDER }

// Repository (JPA Repository이라고 가정)
public interface OrderRepository {
    // 특정 가게의 특정 날짜에 완료된 주문 목록
    List<Order> findByRestaurantIdAndOrderDateAndStatus(
        Long restaurantId, LocalDate date, OrderStatus status
    );
    
    // (3번 문제용) 특정 날짜에 완료된 모든 주문
    List<Order> findByOrderDateAndStatus(LocalDate date, OrderStatus status);
}

public interface RestaurantRepository {
    Restaurant findById(Long id);
    List<Restaurant> findAll();
}

// (3번 문제용)
public interface SettlementRepository {
    DailySettlement save(DailySettlement settlement);
    List<DailySettlement> saveAll(Iterable<DailySettlement> settlements);
}
```

📂 문제 1: API 구현 (난이도: 하)
요구사항
가게 사장님이 특정 날짜의 정산 예정 금액을 조회할 수 있는 API를 구현해야 합니다.

API: GET /api/settlement/daily/{restaurantId}

Query Param: date (e.g., "2025-10-24")

비즈니스 로직:

restaurantId와 date를 받습니다.

해당 날짜에 COMPLETED (완료)된 주문만 집계합니다.

수수료 정책은 이 문제에 한해 '주문 총액의 10%'로 고정합니다.

정산 지급액 = (주문 총액 합계) - (수수료 합계)

VAT (부가세) = (수수료 합계)의 10%

응답 (Response): 아래 형식의 JSON을 반환하세요.

작업
SettlementController와 SettlementService를 만들고, 위 요구사항을 만족하는 API를 완성하세요.