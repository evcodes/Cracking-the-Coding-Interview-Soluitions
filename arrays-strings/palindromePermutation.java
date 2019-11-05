import java.util.*;

class PalindromePermutation{

    /*
    Idea, build a hashmap ensure that all elements are of even 
    parity except for one or none!.
    */
    protected boolean detectPalindrome(String input){

        if (input.length() <2){
            return true;
        }

        boolean isPalindrome = false;
        String prep = input.toLowerCase().trim();

        HashMap<String, Integer> map = new HashMap<String, Integer>();

        for (int i =0; i<prep.length(); i++){
            String currSubstring=prep.substring(i, i+1); 

            if (map.containsKey(currSubstring)){
                int val = map.get(currSubstring)+1;
                map.put(currSubstring, val);
            }else{
                map.put(currSubstring,1);
            }
        }
        int countOdd = countOdd(map);

        if (countOdd < 2 && prep.length() > 2 ){
            isPalindrome = true;
        }
        System.out.println(isPalindrome);
        return isPalindrome;
    }

    protected int countOdd(HashMap <String, Integer> map){
        int oddNum = 0;

        for (Map.Entry<String,Integer> mapElement : map.entrySet()) { 
            int value = (int)mapElement.getValue();
            if (value % 2 == 1){
                oddNum +=1;
            }
        }
        return oddNum;
    }

    public static void main(String[] args){
        PalindromePermutation pp = new PalindromePermutation();
        pp.detectPalindrome("Anna");
        pp.detectPalindrome("Civic");
        pp.detectPalindrome("Kayak");
        pp.detectPalindrome("rotator");       
    }
}