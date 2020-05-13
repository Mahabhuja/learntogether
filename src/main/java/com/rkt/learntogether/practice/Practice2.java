package com.rkt.learntogether.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



class Solution2 {

    /*1. Transactions by Location and IP


     * Complete the 'getTransactions' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER userId
     *  2. INTEGER locationId
     *  3. INTEGER netStart
     *  4. INTEGER netEnd
     *
     *  https://jsonmock.hackerrank.com/api/transactions/search?userId=
     */
    public static final String TOTAL_PAGES = "total_pages";
    public static int getTransactions(int userId, int locationId, int netStart, int netEnd) throws IOException {
        String url = "https://jsonmock.hackerrank.com/api/transactions/search?userId="+userId;

        int currentPage =1;
        int totalPage = 1;
        Map<String, Object> response;
        List<UserData> userData;
        BigDecimal amount = BigDecimal.ZERO;

        while(currentPage <= totalPage) {
            response = getResponse(url+"&page="+currentPage);
            if(totalPage == 1){
                totalPage = (Integer) response.get(TOTAL_PAGES);
            }
            userData = (ArrayList) response.get("data");

            for(UserData d : userData) {
                if(d.locationId == locationId && netStart<=d.ip && d.ip<=netEnd) {
                    String amt = d.amount.replace(",", "");
                    amount = amount.add(new BigDecimal(amt));
                }
            }

            currentPage++;
        }
        amount = amount.setScale(0, BigDecimal.ROUND_HALF_EVEN);
        return amount.intValue();
    }


    public static Map<String, Object> getResponse(String url) throws IOException {

        InputStream is = new URL(url).openStream();
        Map<String, Object> response = new HashMap<>();
        try(BufferedReader rd = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))){

            StringBuilder sb = new StringBuilder();
            int copy;
            while((copy = rd.read()) != -1){
                sb.append((char) copy);
            }
            int totalPageStartIdx = sb.indexOf(TOTAL_PAGES);
            int totalPageEndIdx = sb.indexOf(",",totalPageStartIdx);
            totalPageStartIdx = totalPageStartIdx+13;
            int totalPages = Integer.parseInt(sb.substring(totalPageStartIdx, totalPageEndIdx));
            response.put(TOTAL_PAGES, totalPages);

            String dataStr = sb.substring(sb.indexOf("[")+1, sb.indexOf("]"));
            String[] data = dataStr.split("},\\{");
            List<UserData> userDataList = new ArrayList<>();
            UserData userData;
            StringBuilder sb1;
            for(String d: data){
                userData = new UserData();
                sb1 = new StringBuilder(d);

                int a1 = sb1.indexOf("amount")+10;
                int a2 = sb1.indexOf("\",",a1);
                userData.amount = sb1.substring(a1,a2);

                int i1 = sb1.indexOf("ip\":\"")+5;
                int i2 = sb1.indexOf(".",i1);
                userData.ip = Integer.parseInt(sb1.substring(i1,i2));

                int l1 = sb1.indexOf("location")+16;
                int l2 = sb1.indexOf(",",l1);
                userData.locationId = Integer.parseInt(sb1.substring(l1,l2));

                userDataList.add(userData);
            }

        response.put("data",userDataList);
        } catch(Exception ex){
            ex.printStackTrace();
        }
        finally{
            try{
                if(is!=null) {
                    is.close();
                }
            } catch(Exception e){
                e.printStackTrace();
            }
        }

        return response;
    }

    static class UserData {
        public String amount;
        public int ip;
        public int locationId;
    }


        public static void main(String[] args) {

            int userId = Integer.parseInt(args[0]);

            int locationId = Integer.parseInt(args[1]);

            int netStart = Integer.parseInt(args[2]);

            int netEnd = Integer.parseInt(args[3]);

            int result = 0;
            try {
                result = Solution2.getTransactions(userId, locationId, netStart, netEnd);
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("=====>"+result);
        }

}

