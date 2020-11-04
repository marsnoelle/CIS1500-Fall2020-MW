package project3;
import java.util.*;

public class PowerBallTicket {
    private int[] whiteNumbers;
    private int redNumber;
    private final double GRAND_PRIZE = 100000000000.0;
    
    // this is for the easy pick
    public PowerBallTicket(){
        Random rng = new Random();
        whiteNumbers = new int[5];
        
        for (int index = 0; index < 5; index++){
            boolean keepGoing = true;
            int candidate = -1;
            while(keepGoing) {
                boolean anyMatch = false;
                candidate = rng.nextInt(69) + 1;
                for (int j = 0; j < index; j++) {
                    if (candidate == whiteNumbers[j]) {
                        anyMatch = true;
                    }
                }
                if (!anyMatch) {
                    keepGoing = false;
                }
            }
            whiteNumbers[index] = candidate;
        }
        
        redNumber = rng.nextInt(26) + 1;
    }
    public PowerBallTicket(int[] whiteNumbers, int redNumber){
        if (whiteNumbers.length != 5){
           throw new IllegalArgumentException("5 numbers must be passed in for the white numbers");
        }
        
        for (int index = 0; index < 5; index++) {
            if (whiteNumbers[index] < 1 || whiteNumbers[index] > 69) {
                throw new IllegalArgumentException("Invalid white number: " + whiteNumbers[index]);
            }
        }
        
        
        if (redNumber < 1 || redNumber > 26) {
            throw new IllegalArgumentException("Invalid red number: " + redNumber);
        }
        
        this.whiteNumbers = whiteNumbers;
        this.redNumber = redNumber;
    }
    
    public double getWinnings(PowerBallTicket winningTicket) {
        int whiteMatches = 0;
        for (int whiteNum : whiteNumbers) {
            if (winningTicket.hasWhiteNumber(whiteNum)){
                whiteMatches++;
            }
        }
        boolean redMatches = redNumber == winningTicket.getRedNumber();
        
        double toReturn = 0.0;
        
        if (redMatches) {
            switch (whiteMatches) {
                case 0:
                case 1:
                    toReturn = 4.0;
                    break;
                case 2:
                    toReturn = 7.0;
                    break;
                case 3:
                    toReturn = 100.0;
                    break;
                case 4:
                    toReturn = 50000.0;
                    break;
                case 5:
                    toReturn = GRAND_PRIZE;
                    break;
                default:
                    toReturn = 0.0;
                    break;
            }
        } else {
            switch (whiteMatches) {
                case 3:
                    toReturn = 7.0;
                    break;
                case 4:
                    toReturn = 100.0;
                    break;
                case 5:
                    toReturn = 1000000;
                    break;
                default:
                    toReturn = 0.0;
                    break;
            }
        }
        
        return toReturn;
    }
    
    public int[] getWhiteNumbers() {
        return this.whiteNumbers;
    }
    
    public double getRedNumber() {
        return this.redNumber;
    }
    
    public boolean hasWhiteNumber(int num) {
        boolean toReturn = false;
        for (int whiteNumber : whiteNumbers) {
            if (whiteNumber == num) {
                toReturn = true;
                break;
            }
        }
        return toReturn;
    }
    
    @Override
    public String toString() {
        String toReturn = "";
        toReturn += "WHITE BALLS: ";
        for (int whiteNumber : whiteNumbers) {
            toReturn += whiteNumber + " ";
        }
        toReturn += "\nPOWERFUL BALL: " + redNumber;
        
        return toReturn;
    }
}
    