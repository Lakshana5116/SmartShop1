package com.smartshop;

import org.junit.Test;
import static org.junit.Assert.*;

public class SizeRecommendationTest {

    @Test
    public void testMediumSizeRecommendation() {

        SizeRecommendation recommendation = new SizeRecommendation();

        assertEquals(
                "M",
                recommendation.recommendSize(170, 65, 95, 80, 95)
        );
    }

    @Test
    public void testInvalidMeasurements() {

        SizeRecommendation recommendation = new SizeRecommendation();

        assertEquals(
                "Invalid measurements",
                recommendation.recommendSize(0, 65, 95, 80, 95)
        );
    }
}