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

       // solution(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 4});
        solution(new int[]{1, 1, 1, 1, 1});//<<<
        solution(new int[]{1, 1, 1, 1, 1, 1, 1, 1});//<<<<
        // solution(new int[]{1, 1, 1, 1, 1, 1, 4});
        // solution(new int[]{1, 1, 1, 1, 1, 1});
       // solution(new int[]{1, 1, 1, 1});
        //solution(new int[]{4, 1, 1, 1});
        //solution(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0});


        //Input:
       //solution(new int[]{3, 1, 4, 1});
        //Output:
        //4311


        //Input:
        //solution(new int[]{3, 1, 4, 1, 5, 9});
        //Output:
        //94311

      //  solution(new int[]{3});
       // solution(new int[]{1});


    }

    boolean foundItMarkAll;

    int solution(int[] l) {
        int[] solution;// = 0;
        int solutionFound = 0;
        int[] sortedL = sortedMaxToMin(l);
        int[] tempL = sortedL;
        int sumAll;


        sumAll = sumA(tempL);
        foundItMarkAll = foundItMod3(sumAll);
        if (foundItMarkAll) {
            solutionFound = combinedIntoInt(tempL);
        } else {
            //shorten by one
            //sum
            //set the marker
            solution = sqeezeIt(sortedL, foundItMarkAll);
            if (foundItMarkAll) {
                solutionFound = combinedIntoInt(solution);
            } else {
                solution = sqeezeIt(solution, foundItMarkAll);
                if (foundItMarkAll) {
                    solutionFound = combinedIntoInt(solution);
                } else {
                    solution = sqeezeIt(solution, foundItMarkAll);
                    if (foundItMarkAll) {
                        solutionFound = combinedIntoInt(solution);
                    } else {
                        solution = sqeezeIt(solution, foundItMarkAll);
                        if (foundItMarkAll) {
                            solutionFound = combinedIntoInt(solution);
                        } else {
                            solution = sqeezeIt(solution, foundItMarkAll);
                            if (foundItMarkAll) {
                                solutionFound = combinedIntoInt(solution);
                            } else {
                                solution = sqeezeIt(solution, foundItMarkAll);
                                if (foundItMarkAll) {
                                    solutionFound = combinedIntoInt(solution);
                                } else {
                                    solution = sqeezeIt(solution, foundItMarkAll);
                                    if (foundItMarkAll) {
                                        solutionFound = combinedIntoInt(solution);
                                    } else {
                                        solution = sqeezeIt(solution, foundItMarkAll);
                                    }
                                }
                            }
                        }
                    }
                }
            }

        }


        foundItMarkAll = false;
        Log.i("AppTag", "solutionFound: " + solutionFound);
        return solutionFound;
    }


    /*

     */


    int[] sqeezeIt(int[] tempL, boolean foundItMark) {
        int sumA;
        int[] solutionFound = new int[tempL.length - 1];
        for (int k = tempL.length - 1; k >= 0; k--) {
            if (foundItMarkAll == false) {
                int[] tempTempL = shortenByOne(tempL, k);
                sumA = sumA(tempTempL);
                foundItMarkAll = foundItMod3(sumA);
                if (foundItMarkAll) {
                    //solutionFound = combinedIntoInt(tempTempL);
                    solutionFound = tempTempL;
                } else {
                    //solutionFound = new int[]{0};
                    // tempTempL = tempL;
                }
            }
        }
        return solutionFound;
    }


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

