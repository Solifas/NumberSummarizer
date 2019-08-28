package com.numberRangeSummarizer;


/*mport java.util.List;
import java.util.Collection;
import java.util.Arrays;
import java.util.ArrayList;


*//* grouping the numbers into a range when they are sequential.
 *
 *
 * Sample Input: "1,3,6,7,8,12,13,14,15,21,22,23,24,31
 * Result: "1, 3, 6-8, 12-15, 21-24, 31"
 *
 *//*
public class Main implements NumberRangeSummarizer {


    public Collection<Integer> collect(String input) {
        //Separate the numbers with ","
        String[] arrayOfString = input.split(",");
        int[] integers = new int[arrayOfString.length];
//
        for (int i = 0; i < arrayOfString.length; i++) {
            integers[i] = Integer.parseInt(arrayOfString[i]);
        }

        // sorting the numbers

        Arrays.sort(integers);
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < integers.length; i++) {
            list.add(integers[i]);

        }


        return list;

    }*/


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 *
 * TODO : Add class comment
 *
 */
public class Main implements NumberRangeSummarizer
{
    public static void main(String[] args)
    {
        Main nr = new Main();
        String input = "99,100,101,102,103,104,107,108,109,110,115,188,189,192,20";
        Collection<Integer> collectinput = (List<Integer>)nr.collect(input);
        String range = nr.summarizeCollection(collectinput);
        System.out.println(range);
    }

    /**
     *
     * TODO : Add method comment

     * @param input
     * @return
     *
     */
    public Collection<Integer> collect(String input) {
        //Separate the numbers with ","
        String[] arrayOfString = input.split(",");
        int[] integers = new int[arrayOfString.length];
//
        for (int i = 0; i < arrayOfString.length; i++) {
            integers[i] = Integer.parseInt(arrayOfString[i]);
        }

        // sorting the numbers

        Arrays.sort(integers);
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < integers.length; i++) {
            list.add(integers[i]);

        }


        return list;

    }

    /**
     *
     * TODO : Add method comment
     *
     * @param input
     * @return
     *
     */
    public String summarizeCollection(Collection<Integer> input)
    {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> inputList = new ArrayList<Integer>(input);
        int length = inputList.size();
        int start;
        int next;
        for (int a = 0; a < length; a++)
        {
            if (a == length - 1)
            {
                if(inputList.get(length-2) != inputList.get(length-1))
                {
                    sb.append(inputList.get(a) + ",");
                }
                break;
            }

            start = (Integer)inputList.get(a);
            next = (Integer)inputList.get(a + 1);
            if (next == start + 1)
            {
                count++;
                int lowestBound = start;
                // Loop until the range breaks - where the loop breaks is your upper bound for the current range.
                for (int i = a + 1; ; i++)
                {
                    start = (Integer)inputList.get(i);
                    next = (Integer)inputList.get(i + 1);

                    if (next == start + 1)
                    {
                        count++;
                    }
                    else
                    {
                        a = i;
                        if (count != 0)
                        {
                            sb.append(lowestBound + " - " + (Integer)inputList.get(i) + ", ");
                        }
                        break;
                    }
                }
                count = 0;
            }
            else
            {
                sb.append(start + ", ");
            }
        }
        String ranges = sb.toString();
        return ranges.substring(0, ranges.length() - 1);
    }

}
