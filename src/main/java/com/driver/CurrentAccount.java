package com.driver;

import java.util.HashMap;
import java.util.Map;

public class CurrentAccount extends BankAccount{
    public String getTradeLicenseId() {
        return tradeLicenseId;
    }

    public void setTradeLicenseId(String tradeLicenseId) {
        this.tradeLicenseId = tradeLicenseId;
    }

    String tradeLicenseId; //consists of Uppercase English characters only
    private static double minBalance=5000;

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        super(name,balance,minBalance);
        if(balance<minBalance)
            throw new InsufficientBalanceException("Insufficient Balance");
        this.tradeLicenseId=tradeLicenseId;
        validateLicenseId();

    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception

        boolean isValid=true;
        int n=this.tradeLicenseId.length();
        for(int i=0;i<n-1;i++)
        {
            char c1=this.tradeLicenseId.charAt(i);
            char c2=this.tradeLicenseId.charAt(i+1);
            if(c1==c2)
            {
                isValid=false;
                break;
            }
        }
        if(!isValid)
        {
            Map<Character,Integer> hm = new HashMap<>();
            int max=Integer.MIN_VALUE;
            for(int i=0;i<n;i++)
            {
                char c1 = this.tradeLicenseId.charAt(i);
                hm.put(c1,hm.getOrDefault(c1,0)+1);
            }
            for(Map.Entry<Character,Integer> map : hm.entrySet())
            {
                max=Math.max(max, map.getValue());
            }
            if(n%2==0)
            {
                if(max > n/2)
                    throw new InValidLicenseIdException("Valid License can not possible");
            }else{
                if(max > (n+1)/2)
                    throw new InValidLicenseIdException("Valid License can not possible");

            }
             char arr[] = new char[n];


            int i=0;

            for(Map.Entry<Character,Integer> map : hm.entrySet())
            {
                //int j=i;
                char c= map.getKey();
                while(map.getValue()!=0)
                {
                    arr[i]=c;
                    i+=2;
                    hm.put(c,map.getValue()-1);
                    if(i>=n){
                        i=1;
                    }
                }
//                if(i>=n){
//                    i=1;
//                }
            }
            this.tradeLicenseId=arr.toString();
        }

    }

}
