package com.bichpormak.enums;

public enum PromotionalCode {

    WELCOME_10("WELCOME10"),
    VIP_50("VIP50");

    private String promotionalCode;
    private static boolean instance;

    PromotionalCode(String promotionalCode) {

        if (isAvailablePromotionalCode(promotionalCode)) {

            this.promotionalCode = promotionalCode;
            changeInstance();

        } else {
            throw new IllegalArgumentException("Not found promo");
        }

    }

    public static void changeInstance() {

        if (!instance) {
            instance = true;
        }

    }

    public static boolean isAvailablePromotionalCode(String promotionalCode) {

        if (instance) {
            return false;
        }

        for (PromotionalCode promo : PromotionalCode.values()) {
            if (promo.promotionalCode.equalsIgnoreCase(promotionalCode)) {
                return true;
            }
        }

        return false;

    }

}
