package com.priceline.chutes.service.impl;

import com.priceline.chutes.service.SpinnerService;
import java.util.Random;

public class SpinnerServiceImpl implements SpinnerService {

    private Random random = new Random();
     public int spin(){
        return random.nextInt(6) + 1;
    }

}
