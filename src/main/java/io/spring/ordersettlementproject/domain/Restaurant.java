package io.spring.ordersettlementproject.domain;

public class Restaurant {
    private Long id;
    private String name;
    private CommissionPolicy commissionPolicy; // 가게별 수수료 정책

    public Restaurant(Long id, String name, CommissionPolicy commissionPolicy) {
        this.id = id;
        this.name = name;
        this.commissionPolicy = commissionPolicy;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public CommissionPolicy getCommissionPolicy() {
        return commissionPolicy;
    }
}