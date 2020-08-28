package danieldiv.pseudochellenge.passthemcodedmessages;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //solution(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 4});

        solution(new int[]{1, 1, 1, 1, 1, 1, 1, 1});


        solution(new int[]{1, 1, 1, 1, 1, 1, 4});
        solution(new int[]{1, 1, 1, 1, 1, 1});
        solution(new int[]{1, 1, 1, 1});
        solution(new int[]{4, 1, 1, 1});
        solution(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0});
        solution(new int[]{3});
        solution(new int[]{1});


        //Input:
        solution(new int[]{3, 1, 4, 1});
        //Output:
        //4311


        //Input:
        solution(new int[]{3, 1, 4, 1, 5, 9});
        //Output:
        //94311

        //Input:
        solution(new int[]{ 4, 1, 7, 1, 4});
        //Output:
        //


    }

    boolean foundItMarkAll;

    int solution(int[] l) {
        int[] solution;// = 0;
        int solutionFound = 0;
        int[] sortedL = sortedMaxToMin(l);
        int[] tempL = sortedL;
        int[] tempTempL;
        int[] tempTempLL;
        int sumAll;
        int sumA;

        boolean foundForLengthLength;
        boolean foundForLengthLengthMinus1 = false;
        boolean foundForLengthLengthMinus2 = false;
        boolean foundItFinal = false;

        /////////////////////////////CHECK for length = length
        sumAll = sumA(tempL);
        foundForLengthLength = foundItMod3(sumAll);
        if (foundForLengthLength) {
            /////////////////////////////Solution exists for length = length
            solutionFound = combinedIntoInt(tempL);
            foundItFinal = true;
        } else if (foundItFinal == false) {
            ////    /////////////////////////CHECK for length = length-1
            for (int k = tempL.length - 1; k >= 0; k--) {
                //short bu one element on position k
                Log.i("AppTag", "tempLbefore: " + Arrays.toString(tempL));
                tempTempL = shortenByOne(tempL, k);
                Log.i("AppTag", "tempTempL: " + Arrays.toString(tempTempL));
                sumA = sumA(tempTempL);
                Log.i("AppTag", "sumA " + sumA);
                if (foundItFinal == false)
                    foundForLengthLengthMinus1 = foundItMod3(sumA);
                Log.i("AppTag", "foundMark1: " + foundForLengthLengthMinus1);
                if (foundForLengthLengthMinus1) {
                    ////    /////////////////////////Solution exists for length = length-1
                    solutionFound = combinedIntoInt(tempTempL);
                    foundItFinal = true;
                    foundForLengthLengthMinus1 = false;
                    Log.i("AppTag", "foundMarkFinal: " + foundItFinal);
                }
                ////    /////////////////////////CHECK for length = length-2
                if (k == 0 && foundItFinal == false) {
                    Log.i("AppTag", "LLOOOOPPPP2222222222222"+"LLOOOOPPPP2222222222222");
                    //we are doing shortening by one for original array, but now we will also do
                    //shorten again for every length=length-1 array
                    //effectively having all arrays of length=length-2 possible

                    //generate length=length-1
                    for (int kk = tempL.length - 1; kk >= 0; kk--) {
                        //short by one element on position kk
                        tempTempL = shortenByOne(tempL, kk);
                        //generate length=length-1-1
                        for (int i = tempTempL.length - 1; i >=0 ; i--) {
                            Log.i("AppTag", "tempTempLLbefore: " + Arrays.toString(tempTempL));
                            tempTempLL = shortenByOne(tempTempL, i);
                            Log.i("AppTag", "tempTempLL: " + Arrays.toString(tempTempLL));
                            sumA = sumA(tempTempLL);
                            Log.i("AppTag", "sumA " + sumA);
                            //if you found final solution just casually continue the loop, just do not assign new valuet to foundForLengthLengthMinus2
                            if (foundItFinal == false)
                                foundForLengthLengthMinus2 = foundItMod3(sumA);
                            Log.i("AppTag", "foundMark2: " + foundForLengthLengthMinus2);
                            if (foundForLengthLengthMinus2) {
                                ////    /////////////////////////Solution exists for length = length-2
                                solutionFound = combinedIntoInt(tempTempLL);
                                foundItFinal = true;
                                foundForLengthLengthMinus2 = false;
                                Log.i("AppTag", "foundMarkFinal: " + foundItFinal);
                            }
                        }
                    }


                }
            }
        }


        foundItMarkAll = false;
        Log.i("AppTagF", "solutionFound: " + solutionFound);
        return solutionFound;
    }




    /*

     */




    int[] sortedMaxToMin(int[] digitsToBeSortedMaxMin) {
        // length tells us how many elements there are, for array {a, b, c} length=3
        int[] digitsToCombineSortedMaxMin = new int[digitsToBeSortedMaxMin.length];
        int[] tempL = digitsToBeSortedMaxMin;
        int indexOfMax = 0;

        for (int n = 0; n < digitsToCombineSortedMaxMin.length; n++) {
            //  Log.i("AppTag", "sortempL: " + Arrays.toString(tempL));
            int max = -1;
            //      find th Value of the maximum
            for (int i = 0; i < tempL.length; i++) {
                if (tempL[i] > max) {
                    max = tempL[i];
                }
            }

            //find index of the last max value from the right
            for (int ii = tempL.length - 1; ii > -1; ii--) {
                // Log.i("AppTag", "ii: " + ii);
                if (tempL[ii] == max) {
                    indexOfMax = ii;
                    // Log.i("AppTag", "indexOfMax: " + indexOfMax);
                    //tempL[ii] = 0;
                }
            }
            //here we are zeroing first value equal to max from the left
            //for indexOfMax=0 we want to do one roll (or hardwrite it)
            // Log.i("AppTag", "indexOfMax: " + indexOfMax);
            for (int iii = 0; iii < indexOfMax + 1; iii++) {
                if (tempL[iii] == max) {
                    tempL[iii] = 0;
                }
            }


            digitsToCombineSortedMaxMin[n] = max;
        }
        //Log.i("AppTag", "digitsToCombineSortedMaxMin: " + Arrays.toString(digitsToCombineSortedMaxMin));
        return digitsToCombineSortedMaxMin;
    }

    int combinedIntoInt(int[] digitsToCombine) {
        //making intiger out of array elements
        int Combined = 0;
        int times = 0;
        int numberToComb = 0;
        // for every element of digitsToCombineSortedMaxMin
        for (int i = 1; i < digitsToCombine.length + 1; i++) {
            //decimator
            for (int j = 1; j < i; j++) {
                if (times != 0) {
                    times = times * 10;
                }
            }
            if (times == 0) {
                times = 1;
            }
            //digit
            numberToComb = (digitsToCombine[digitsToCombine.length - i]);
            //combine digits with decimator
            Combined = Combined + numberToComb * times;
            //reset decimator
            times = 1;
            // Log.i("AppTag", "i: " + i);
            // Log.i("AppTag", "times: " + times);
        }
        return Combined;
    }

    int sumA(int[] tmp) {
        int sumA = 0;
        for (int j = 0; j < tmp.length; j++) {
            sumA = sumA + tmp[j];
        }
        return sumA;
    }

    int[] shortenByOne(int[] tmp, int index) {
        int[] shortened = new int[tmp.length - 1];
        for (int i = 0; i < shortened.length; i++) {
            shortened[i] = tmp[i];
            if (i >= index) {
                shortened[i] = tmp[i + 1];
            }
        }
        return shortened;
    }

    boolean foundItMod3(int sumA) {
        if (sumA % 3 == 0) {
            return true;
        } else {
            return false;
        }
    }


}

