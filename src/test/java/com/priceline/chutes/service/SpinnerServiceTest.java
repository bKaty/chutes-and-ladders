package com.priceline.chutes.service;

import com.priceline.chutes.service.impl.SpinnerServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SpinnerServiceTest {
    @Test
    public void test_whenSpinInvokedThenRandomNumberBetweenOneAndSixGenerated(){
        SpinnerService spinnerService = new SpinnerServiceImpl();
        assertTrue(spinnerService.spin() <=6 && spinnerService.spin() >=1);

    }
}
