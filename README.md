# CakeThief-0-1-Knapsack
The problem is solved using dynamic programming using 0-1 Knapsack approach.

# Problem
You are a renowned thief who has recently switched from stealing precious metals
      to stealing cakes because of the insane profit margins. You end up hitting the
      jackpot, breaking into the world's largest privately owned stock of cakes—the
      vault of the Queen of England.
      While Queen Elizabeth has a limited number of types of cake, she has an unlimited
      supply of each type.
      Each type of cake has a weight and a value, stored in objects of a CakeType class:
        class CakeType {
          int weight;
          int value;
          public CakeType(int weight, int value) {
              this.weight = weight;
              this.value  = value;
          }
      }
      Java
      For example:
        // weighs 7 kilograms and has a value of 160 pounds
      new CakeType(7, 160);
      // weighs 3 kilograms and has a value of 90 pounds
      new CakeType(3, 90);
      You brought a duffel bag that can hold limited weight, and you want to make off
      with the most valuable haul possible.
      Write a function maxDuffelBagValue() that takes an array of cake type objects
      and a weight capacity, and returns the maximum monetary value the duffel bag can
      hold.
      For example:
        CakeType[] cakeTypes = new CakeType[] {
          new CakeType(7, 160),
          new CakeType(3, 90),
          new CakeType(2, 15),
      };
      int capacity = 20;
      maxDuffelBagValue(cakeTypes, capacity);
      // returns 555 (6 of the middle type of cake and 1 of the last type of cake)
      Weights and values may be any non-negative integer. Yes, it's weird to think
      about cakes that weigh nothing or duffel bags that can't hold anything. But
      we're not just super mastermind criminals—we're also meticulous about keeping
      our algorithms flexible and comprehensive.


# Solution:
1. An array of cake type and capacity is received as function parameter. Task is to have maximum value where the weight can fit in the given capacity.

2. Create a memo table of length n+1 and capacity+1. This is because we are going to solve this using dynamic programming via bottom up approach. In the end the result will be in memo[n][capacity].

3.  Start the loop from 0 to n where n is the length of cakeTypes array we received as parameter.

4. Start another loop a nested loop which will start from 0 to capacity where capacity is received as parameter.

5. if i OR j are 0 then initialize that block in memo table to 0. Which means in memo table the first row and first column will be all 0's

6. else if the weight of i-1 item in cakeTypes is less than j (which will go up to max weight the bag can carry) then we have to check
if value of cake i-1 + memo of i-1, and j (current weight) - cakeTypes[i-1] weight is more or memo of i-1 and j is more. The one with larger weight is picked up.

7. else if the weight of the item is more than the maximum weight the bag can carry, in that case we will take the result from previous block. It will look like this memo[i][j] with previous value which will be memo[i-1][j]

8. In the end memo table will be filled up and return memo[n][capacity]
