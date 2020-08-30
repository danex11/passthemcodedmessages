# passthemcodedmessages
Second exercise from google challenges.

Required skills:

  -Looping.
  -Conditions.
  -Operations on arrays.
  -Nesting loops.
 
 
 To be noted:
 
 You will need to check the result of a modulo 3 operation, to verify if a sum of digits is dividable by 3 without the rest remaining.
 
 Effectively when You ignore everything about your digits but this rest remaining after modulo3, your set of:
 {9,4,1,5,1,3}
 will be reduced to 
 {0,1,1,2,1,0}.
 One thing this sugests to us is that there are only three types of digits that can be deleted from our set: zeros, ones and twos.
 
 Deleting number that is dividable by 3 itself will not change the overall dividability for the sum - this is our zero.
 Deleting number that is dividable by 3 with remaining rest of 1 will change sum by one.
 Deleting number that is dividable by 3 with remaining rest of 2 will change sum by two.
 
 Now for series of natural numbers:
 0,1,2,3,4,5,6,7,8,9,10...103...104...105...
 modulo 3 rests:
 0,1,2,0,1,2,0,1,2,0,1 ...1  ...2  ...0  ...
 
 Whatever our sum is, we never need to move more than two positions to the left to find sum that is dividable by 3.
 We never need to delete more than two digits out of our initial set find set that has a sum dividible by 3 without the rest remaining.
 We only need to check for original set, 
 than delete a single element one by one and check the sum, 
 than for this shorter set we have to nest another loop that is deleting single element one by one and performs the check out. 
 
 If they would want it it be dividable by said 100, or any given by user number, than the code would have to have some procedural properties.
 
 
 
 
 
 
