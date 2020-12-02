package project4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BigInt {
    private List<Integer> nums;
    private boolean negative;

    public BigInt(String s) {
        this.negative = '-' == s.charAt(0);
        this.nums = new ArrayList<>();
        for (int i = (this.negative ? 1 : 0); i < s.length(); i++) {
            this.nums.add(Integer.parseInt("" + s.charAt(i)));
        }
    }

    private BigInt(List<Integer> nums, boolean negative) {
        this.nums = nums;
        this.negative = negative;
    }

    public BigInt plus(BigInt addend) {
        return this.plus(addend, false);
    }

    private BigInt plus(BigInt addend, boolean shouldFlip) {
        boolean sameSigns = this.negative == addend.isNegative();
        if (!sameSigns) {
            if (addend.isNegative()) {
                return this.minus(new BigInt(addend.getNums(), false));
            } else {
                return new BigInt(this.nums, false).minus(addend, true);
            }
        }

        //Pad the smaller number with 0s at the front. This is a hack.
        BigInt largerNum = BigInt.max(this, addend);
        BigInt smallerNum = BigInt.min(this, addend);
        if (largerNum.getNums().size() != smallerNum.getNums().size()) {
            int zerosToPad = largerNum.getNums().size() - smallerNum.getNums().size();
            String numString = smallerNum.isNegative() ? "-" : "";
            for (int i = 0; i < zerosToPad; i++) {
                numString += "0";
            }
            for (Integer i : smallerNum.getNums()) {
                numString += i.toString();
            }
            smallerNum = new BigInt(numString);
        }

        Integer carryover = 0;
        List<Integer> biggerNums = largerNum.getNums();
        List<Integer> smallerNums = smallerNum.getNums();
        List<Integer> result = new ArrayList<>();

        

        for (int i = biggerNums.size() - 1; i >= 0 ; i--) {
            Integer num1 = biggerNums.get(i);
            Integer num2 = smallerNums.get(i);
            Integer sum = num1 + num2 + carryover;

            if (sum > 9) {
                //Sum of two single digit numbers can't be greater than 18 so carryover can't be more than 1
                carryover = 1;
                sum -= 10;
            } else {
                carryover = 0;
            }

            result.add(sum);
        }
        Collections.reverse(result);
        return new BigInt(result, shouldFlip ? !this.negative : this.negative);
    }

    public BigInt minus(BigInt subtrahend) {
        return minus(subtrahend, false);
    }

    private BigInt minus(BigInt subtrahend, boolean shouldFlip) {
        boolean sameSigns = this.negative == subtrahend.isNegative();
        if (!sameSigns) {
            if (subtrahend.isNegative()) {
                return this.plus(new BigInt(subtrahend.getNums(), false));
            } else {
                return new BigInt(this.nums, false).plus(subtrahend, true);
            }
        }

         //Pad the smaller number with 0s at the front. This is a hack.
         BigInt largerNum = BigInt.max(this, subtrahend);
         BigInt smallerNum = BigInt.min(this, subtrahend);
         if (largerNum.getNums().size() != smallerNum.getNums().size()) {
             int zerosToPad = largerNum.getNums().size() - smallerNum.getNums().size();
             String numString = smallerNum.isNegative() ? "-" : "";
             for (int i = 0; i < zerosToPad; i++) {
                 numString += "0";
             }
             for (Integer i : smallerNum.getNums()) {
                 numString += i.toString();
             }
             smallerNum = new BigInt(numString);
        }

        //Copy these lists so that the numbers inside the original object don't get changed
        //this caused a test to fail where i modified some of the numbers here!
        List<Integer> largerNums = new ArrayList<>(largerNum.getNums()); 
        List<Integer> smallerNums = new ArrayList<>(smallerNum.getNums());
        
        List<Integer> result = new ArrayList<>();

        for (int i = largerNums.size() - 1; i >= 0; i--) {
            Integer largerDigit = largerNums.get(i);
            Integer smallerDigit = smallerNums.get(i);
            Integer difference;
            if (largerDigit >= smallerDigit) {
                difference = largerDigit - smallerDigit;
            } else {
                // Time to carry!
                for (int j = i - 1; j >= 0; j--) {
                    if (largerNums.get(j) != 0) {
                        largerNums.set(j, largerNums.get(j) - 1);
                        for (int k = (j + 1); k < i; k++) {
                            largerNums.set(k, 9);
                        }
                        break;
                    }
                }
                
                difference = (largerDigit + 10) - smallerDigit;
                
            }
            result.add(difference);
        }
        Collections.reverse(result);

        boolean resultIsNegative = this.negative && subtrahend.isNegative() ? true : BigInt.equals(subtrahend, new BigInt(largerNums, false));
        if (shouldFlip) {
            resultIsNegative = !resultIsNegative;
        }
        return new BigInt(result, resultIsNegative);
    }

    private static BigInt max(BigInt num1, BigInt num2) {
        int num1size = num1.getNums().size();
        int num2size = num2.getNums().size();
        if (num1size != num2size) {
            return num1size > num2size ? num1 : num2;
        } else {
            for (int i = 0; i < num1.getNums().size(); i++) {
                int num1num = num1.getNums().get(i);
                int num2num = num2.getNums().get(i);
                if (num1num != num2num) {
                    return num1num > num2num ? num1 : num2;
                }
            }
        }

        //This must mean they're equal; just return num1
        return num1;
    }

    private static BigInt min(BigInt num1, BigInt num2) {
        int num1size = num1.getNums().size();
        int num2size = num2.getNums().size();
        if (num1size != num2size) {
            return num1size < num2size ? num1 : num2;
        } else {
            for (int i = 0; i < num1.getNums().size(); i++) {
                int num1num = num1.getNums().get(i);
                int num2num = num2.getNums().get(i);
                if (num1num != num2num) {
                    return num1num < num2num ? num1 : num2;
                }
            }
        }

        //This must mean they're equal; just return num1
        return num1;
    }

    private static boolean equals(BigInt num1, BigInt num2) {
        int num1size = num1.getNums().size();
        int num2size = num2.getNums().size();
        if (num1size != num2size) {
            return false;
        } else {
            for (int i = 0; i < num1.getNums().size(); i++) {
                if (num1.getNums().get(i) != num2.getNums().get(i)) {
                    return false;
                }
            }
        }
        return true;
    }

    public List<Integer> getNums() {
        return this.nums;
    }
    public boolean isNegative() {
        return this.negative;
    }

    @Override
    public String toString() {
        String toReturn = negative ? "-" : "";
        for (Integer i : nums) {
            toReturn += i.toString();
        }
        return toReturn;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof BigInt)) {
            return false;
        }
        BigInt that = (BigInt)o;

        if (this.isNegative() != that.isNegative()) {
            return false;
        }
        if (this.getNums().size() != that.getNums().size()) {
            return false;
        }

        for (int i = 0; i < this.getNums().size(); i++) {
            if (this.getNums().get(i) != that.getNums().get(i)) {
                return false;
            }
        }
        return true;
    }
}