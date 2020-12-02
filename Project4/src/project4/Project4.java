package project4;

public class Project4 {
    public static void main(String[] args) {
        System.out.println("0 of 10 tests passed");

        testAdditionSmallNumbersSameSignsPositive();
        System.out.println("1 of 10 tests passed");

        testAdditionSmallNumbersSameSignsNegative();
        System.out.println("2 of 10 tests passed");
        
        testAdditionSmallNumbersOppositeSigns();
        System.out.println("3 of 10 tests passed");

        testAdditionWithNegativeAddendEquivalentToSubtraction();
        System.out.println("4 of 10 tests passed");

        testSubtractionSmallNumbersSameSignsPositive();
        System.out.println("5 of 10 tests passed");

        testSubtractionSmallNumbersSameSignsNegative();
        System.out.println("6 of 10 tests passed");

        testSubtractionOppositeSigns();
        System.out.println("7 of 10 tests passed");

        testSubtractionWithNegativeSubtrahendEquivalentToAddition();
        System.out.println("8 of 10 tests passed");

        testLargeNumbers();
        System.out.println("9 of 10 tests passed");
        
        testToStringCommaFormatting();
        System.out.println("10 of 10 tests passed!!");
        
        
    }

    public static void testAdditionSmallNumbersSameSignsPositive() {
        BigInt num1 = new BigInt("4992929");
        BigInt num2 = new BigInt("888");

        assert num1.plus(num2).equals(new BigInt("4993817"));
    }

    public static void testAdditionSmallNumbersSameSignsNegative() {
        BigInt num1 = new BigInt("-4992929");
        BigInt num2 = new BigInt("-888");

        assert num1.plus(num2).equals(new BigInt("-4993817"));
    }
    
    public static void testAdditionSmallNumbersOppositeSigns() {
        BigInt num1 = new BigInt("-4992929");
        BigInt num2 = new BigInt("888");

        assert num1.plus(num2).equals(new BigInt("-4992041"));
    }

    public static void testAdditionWithNegativeAddendEquivalentToSubtraction() {
        BigInt num1 = new BigInt("4992929");
        BigInt num2neg = new BigInt("-888");
        BigInt num2pos = new BigInt("888");

        assert num1.plus(num2neg).equals(num1.minus(num2pos));
    }

    public static void testSubtractionSmallNumbersSameSignsPositive() {
        BigInt num1 = new BigInt("4992929");
        BigInt num2 = new BigInt("888");

        assert num1.minus(num2).equals(new BigInt("4992041"));
    }

    public static void testSubtractionSmallNumbersSameSignsNegative() {
        BigInt num1 = new BigInt("-4992929");
        BigInt num2 = new BigInt("-888");

        assert num1.minus(num2).equals(new BigInt("-4992041"));
    }

    public static void testSubtractionOppositeSigns() {
        BigInt num1 = new BigInt("-4992929");
        BigInt num2 = new BigInt("888");

        assert num1.minus(num2).equals(new BigInt("-4993817"));
    }

    public static void testSubtractionWithNegativeSubtrahendEquivalentToAddition() {
        BigInt num1 = new BigInt("4992929");
        BigInt num2neg = new BigInt("-888");
        BigInt num2pos = new BigInt("888");

        assert num1.minus(num2neg).equals(num1.plus(num2pos));
    }

    public static void testLargeNumbers() {
        BigInt num = new BigInt(Integer.toString(Integer.MAX_VALUE));

        assert num.plus(num).equals(new BigInt("4294967294"));
    }
    
    public static void testToStringCommaFormatting() {
        BigInt num = new BigInt(Integer.toString(Integer.MAX_VALUE));
        
        assert num.toString().equals("2,147,483,647");
    }
}