package com.driver;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class CurrentAccount extends BankAccount {
    String tradeLicenseId; //consists of Uppercase English characters only
    private static double minBalance = 5000;
    static int MAX_CHAR = 26;

    public String getTradeLicenseId() {
        return tradeLicenseId;
    }

    public void setTradeLicenseId(String tradeLicenseId) {
        this.tradeLicenseId = tradeLicenseId;
    }

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws InsufficientBalanceException, InValidLicenseIdException {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        super(name, balance, minBalance);
        if (balance < minBalance)
            throw new InsufficientBalanceException("Insufficient Balance");
        this.tradeLicenseId = tradeLicenseId;
        validateLicenseId();

    }

    public void validateLicenseId() throws InValidLicenseIdException {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception

        boolean isValid = true;
        int n = this.tradeLicenseId.length();
        for (int i = 0; i < n - 1; i++) {
            char c1 = this.tradeLicenseId.charAt(i);
            char c2 = this.tradeLicenseId.charAt(i + 1);
            if (c1 == c2) {
                isValid = false;
                break;
            }
        }
        if(!isValid) {
           this.tradeLicenseId = rearrangeString(this.tradeLicenseId);
        }
    }

    static String rearrangeString(String str) throws InValidLicenseIdException {
        int n = str.length();

        // Store frequencies of all characters in string
        int[] count = new int[MAX_CHAR];

        for (int i = 0; i < n; i++)
            count[str.charAt(i) - 'A']++;

        // Insert all characters with their
        // frequencies into a priority_queue
        PriorityQueue<Key> pq
                = new PriorityQueue<>(new KeyComparator());
        for (char c = 'a'; c <= 'z'; c++) {
            int val = c - 'a';
            if (count[val] > 0)
                pq.add(new Key(count[val], c));
        }

        // 'str' that will store resultant value
        str = "";

        // work as the previous visited element
        // initial previous element be. ( '#' and
        // it's frequency '-1' )
        Key prev = new Key(-1, '#');

        // traverse queue
        while (pq.size() != 0) {

            // pop top element from queue and
            // add it to string.
            Key k = pq.peek();
            pq.poll();
            str = str + k.ch;

            // If frequency of previous character
            // is less than zero that means it is
            // useless, we need not to push it
            if (prev.freq > 0)
                pq.add(prev);

            // make current character as the previous
            // 'char' decrease frequency by 'one'
            (k.freq)--;
            prev = k;
        }

        // If length of the resultant string
        // and original string is not same then
        // string is not valid
        if (n != str.length())
            throw new InValidLicenseIdException("Valid License can not be generated");

        else
            return str;
    }


}

class KeyComparator implements Comparator<Key> {

    // Overriding compare()method of Comparator
    public int compare(Key k1, Key k2) {
        if (k1.freq < k2.freq)
            return 1;
        else if (k1.freq > k2.freq)
            return -1;
        return 0;
    }
}

class Key {

    int freq; // store frequency of character
    char ch;

    Key(int val, char c) {
        freq = val;
        ch = c;
    }
}

//        boolean isValid=true;
//        int n=this.tradeLicenseId.length();
//        for(int i=0;i<n-1;i++)
//        {
//            char c1=this.tradeLicenseId.charAt(i);
//            char c2=this.tradeLicenseId.charAt(i+1);
//            if(c1==c2)
//            {
//                isValid=false;
//                break;
//            }
//        }
//        if(!isValid)
//        {
//            Map<Character,Integer> hm = new HashMap<>();
//            int max=Integer.MIN_VALUE;
//            for(int i=0;i<n;i++)
//            {
//                char c1 = this.tradeLicenseId.charAt(i);
//                hm.put(c1,hm.getOrDefault(c1,0)+1);
//            }
//            for(Map.Entry<Character,Integer> map : hm.entrySet())
//            {
//                max=Math.max(max, map.getValue());
//            }
//            if(n%2==0)
//            {
//                if(max > n/2)
//                    throw new InValidLicenseIdException("Valid License can not possible");
//            }else{
//                if(max > (n+1)/2)
//                    throw new InValidLicenseIdException("Valid License can not possible");
//
//            }
//             char arr[] = new char[n];
//
//
//            int i=0;
//
//            for(Map.Entry<Character,Integer> map : hm.entrySet())
//            {
//                //int j=i;
//                char c= map.getKey();
//                while(map.getValue()!=0)
//                {
//                    arr[i]=c;
//                    i+=2;
//                    hm.put(c,map.getValue()-1);
//                    if(i>=n){
//                        i=1;
//                    }
//                }
////                if(i>=n){
////                    i=1;
////                }
//            }
//            this.tradeLicenseId=arr.toString();
//        }
