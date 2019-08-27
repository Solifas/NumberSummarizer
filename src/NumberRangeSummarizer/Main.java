package NumberRangeSummarizer;

import javax.swing.plaf.synth.SynthLookAndFeel;
import java.util.*;
import java.util.Collections;

/* grouping the numbers into a range when they are sequential.
 *
 *
 * Sample Input: "1,3,6,7,8,12,13,14,15,21,22,23,24,31
 * Result: "1, 3, 6-8, 12-15, 21-24, 31"
 *
 */
public class Main implements NumberRangeSummarizer {



    @Override
    public Collection<Integer> collect(String input) {
        //Splitting the numbers
        String[] arrayOfString = input.split(",");
        int[] integers = new int[arrayOfString.length];

        for (int i = 0; i<arrayOfString.length; i++)
        {
            integers[i] = Integer.parseInt(arrayOfString[i]);


        }

        // sorting the numbers

        Arrays.sort(integers);
        List<Integer> list = new ArrayList<>();

        for(int i=0; i<integers.length; i++){
            list.add(integers[i]);

        }



        return list;

    }

    @Override
    public String summarizeCollection(Collection<Integer> input) {

        Integer[] collectedInts;
        collectedInts = input.toArray(new Integer[0]);
        List<Integer> list = new ArrayList<>();
        List<Integer> maximums = new ArrayList<>();
        List<Integer> anomalies = new ArrayList<>();
        List<Integer> minimums = new ArrayList<>();



        for(int i = 0; i<collectedInts.length;i++) {

            // "2,3,4,15,7,8,9,10,22"
            if ((i + 1 < collectedInts.length) && ((collectedInts[i] + 1 == collectedInts[i + 1]) || collectedInts[i - 1] == collectedInts[i] - 1)) {
                if (collectedInts[i] + 1 == collectedInts[i + 1]) {
                    list.add(collectedInts[i]);

                }

            } else list.add(collectedInts[i]);

            if((i - 1 > 0) && (i + 1 < collectedInts.length) && (collectedInts[i] == collectedInts[i - 1] + 1)   && collectedInts[i]+1 != collectedInts[i+1]){
                maximums.add(collectedInts[i]);
            }
            else if ((i == collectedInts.length-1) &&  (collectedInts[i] == collectedInts[i - 1] + 1) ){
                maximums.add(collectedInts[i]);
            }

            if ((i - 1 > 0) && (i + 1 < collectedInts.length) && (collectedInts[i] > collectedInts[i - 1] + 1)  && (collectedInts[i]+1 != collectedInts[i+1])) {
                anomalies.add(collectedInts[i]);
            }

            if ((i - 1 > 0) && (i + 1 < collectedInts.length) && (collectedInts[i] > collectedInts[i - 1] + 1)  && (collectedInts[i] != collectedInts[i-1]+1) && collectedInts[i]+1 == collectedInts[i+1]) {
                minimums.add(collectedInts[i]);
            }
            else if ((i==0) && (collectedInts[0]+1 == collectedInts[1])){
                minimums.add(collectedInts[i]);
            }
        }

        String[] range= new String [maximums.size()];

        for(int i = 0;i<maximums.size();i++){

            range[i] = minimums.get(i) + "-" + maximums.get(i);
        }

        String summarizedCollectn = anomalies + Arrays.toString(range);

        String arrayOfString = summarizedCollectn.replaceAll("\\[", "").replaceAll("\\]",", ");

        return arrayOfString;

    }

    public static void main(String[] args) {
        // write your code here
        Main x = new Main();

        String nums = "22,2,3,4,15,7,8,9,10,32,33,34,35,56,57,58,59,60,61,28";
        System.out.print(x.summarizeCollection(x.collect(nums)));

    }
}

