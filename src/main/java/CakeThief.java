/*
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
 */

package main.java;

import main.java.cakeType.CakeType;

public class CakeThief {

  public int maxDuffelBagValue(CakeType[] cakeTypes, int capacity){
    int n = cakeTypes.length;

    int memo[][] = new int[n+1][capacity+1];

    // Build table memo[][] in bottom up manner
    for (int i = 0; i <= n; i++) {
      for (int j = 0; j <= capacity; j++) {
        if (i==0 || j==0)
          memo[i][j] = 0;
        else if (cakeTypes[i-1].weight <= j)
          memo[i][j] = Math.max(cakeTypes[i-1].value + memo[i-1][j-cakeTypes[i-1].weight],  memo[i-1][j]);
        else
          memo[i][j] = memo[i-1][j];
      }
    }

    return memo[n][capacity];

  }

}
