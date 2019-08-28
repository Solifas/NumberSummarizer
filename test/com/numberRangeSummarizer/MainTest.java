package com.numberRangeSummarizer;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    public void testCollectedNumbers(){
        Main test = new Main();
        String numbers = "99,100,101,102,103,104,107,108,109,110,115,188,189,192,20";
        Collection<Integer> result =test.collect(numbers);
        assertEquals(Arrays.asList(20,99,100,101,102,103,104,107,108,109,110,115,188,189,192),result);

        String summarizedstr = test.summarizeCollection(result);
        System.out.println(summarizedstr);
        assertEquals("20, 115, 192, 99-104, 107-110, 188-189, ",summarizedstr);

    }

    @Test
    public void testSummarizedCollection(){

        Main test = new Main();
        Collection<Integer> listCollected =  Arrays.asList(20,21,22,23,24,25);
        String summarizedstr = test.summarizeCollection(listCollected);

        assertEquals("20-25 ",summarizedstr);
    }

}