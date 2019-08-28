package com.numberRangeSummarizer;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    public void testCollectedNumbers(){
        Main test = new Main();
        String numbers = "1,3,4,6,7,103,104,107,108,109,110,115,188,189,192,20";
        Collection<Integer> result =test.collect(numbers);
        assertEquals(Arrays.asList(1, 3, 4, 6, 7, 20, 103, 104, 107, 108, 109, 110, 115, 188, 189, 192),result);



    }

    @Test
    public void testSummarizedCollection(){

        Main test = new Main();
        Collection<Integer> listCollected =  Arrays.asList(1,3,4,6,7,103,104,107,108,109,110,115,188,189,192,20);
        String summarizedstr = test.summarizeCollection(listCollected);
        System.out.println(summarizedstr);

        assertEquals("1, 3 - 4, 6 - 7, 103 - 104, 107 - 110, 115, 188 - 189, 192, 20",summarizedstr);
    }

}