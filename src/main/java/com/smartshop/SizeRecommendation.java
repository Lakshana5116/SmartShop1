package com.smartshop;

public class SizeRecommendation {

    public String recommendSize(double height, double weight,
                                double chest, double waist, double hip) {

        if (height <= 0 || weight <= 0 || chest <= 0
                || waist <= 0 || hip <= 0) {
            return "Invalid measurements";
        }

        if (chest < 90 && waist < 75 && hip < 90) {
            return "S";
        } else if (chest < 100 && waist < 85 && hip < 100) {
            return "M";
        } else if (chest < 110 && waist < 95 && hip < 110) {
            return "L";
        } else {
            return "XL";
        }
    }
}