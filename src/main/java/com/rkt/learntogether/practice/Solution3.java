package com.rkt.learntogether.practice;

import java.util.*;

/**
 * 2. Meetup Schedule
 *
 */
class Solution3 {

        public static void main(String[] args) {

            Integer[] a = {1,2,1,2,2};
            Integer[] b = {3,2,1,3,3};
            List<Integer> firstDay = Arrays.asList(a);
            List<Integer> lastDay = Arrays.asList(b);
            int result = countMeetings(firstDay, lastDay);
            System.out.println("=====>"+result);
        }

    /*
     * Complete the 'countMeetings' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY firstDay
     *  2. INTEGER_ARRAY lastDay
     */

    public static int countMeetings(List<Integer> firstDay, List<Integer> lastDay) {
        // Write your code here
        int totalInvestors = firstDay.size();
        Set<Integer> metDays = new HashSet<>();
        SortedSet<Investor> investors = new TreeSet<>();

        Investor inv;

        for(int i= 0; i < totalInvestors; i++) {
            int j = firstDay.get(i);
            if(j == lastDay.get(i)){
                metDays.add(j);
            } else {
                inv = new Investor();
                inv.start=firstDay.get(i);
                inv.end=lastDay.get(i);
                inv.id=i;
                investors.add(inv);
            }
        }

        for(Investor i : investors) {
            for(int j=i.start; j<= i.end; j++){
                if(metDays.add(j)) { ;
                    break;
                }
            }
        }

        return metDays.size();

    }

    static class Investor implements Comparable<Investor>{
        public Integer id;
        public Integer start;
        public Integer end;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Investor investor = (Investor) o;
            return id.equals(investor.id);
        }

        @Override
        public int compareTo(Investor o) {
            int comp = this.end - o.end;
            if(comp == 0){
                comp = this.start - o.start;
            }
            return comp;
        }
    }

}

/*
A start-up owner is looking to meet new investors to get some funds for his company.
Each investor has a tight schedule that the owner has to respect.
Given the schedules of the days investors are available, determine how many meetings the owner can schedule.
 Note that the owner can only have one meeting per day.

The schedules consists of two integer arrays, <em>firstDay</em> and <em>lastDay</em>.
Each element in the array <em>firstDay</em> represents the first day an investor is available,
and each element in <em>lastDay</em> represents the last day an investor is available, both inclusive.</p>


<p><strong>Example:</strong></p>

<p><em>firstDay = [1,2,3,3,3]</em></p>

<p><em>lastDay= [2,2,3,4,4]</em></p>


<li>There are 5 investors [I-0, I-1, I-2, I-3, I-4]</li>
<li>The investor I-0 is available from day 1 to day 2 inclusive [1, 2]</li>
<li>The investor I-1 is available in day 2 only [2, 2]. The investor I-2 is available in day 3 only [3, 3]</li>
<li>The investors I-3 and I-4 are available from day 3 to day 4 only [3, 4]</li>
<li>The owner can only meet 4 investors out of 5 : I-0 in day 1, I-1 in day 2, I-2 in day 3 and I-3 in day 4. The graphic below shows the scheduled meetings in green and blocked days are in gray.</li>


<p>Complete the function <em>countMeetings</em> in the editor below.</p>

<p>countMeetings has the following parameters:</p>

<p>&nbsp;&nbsp;&nbsp;&nbsp;<em>int firstDay[n]:</em>&nbsp; an array of integers where the value of each element <em>firstDay[i]</em> is the first day the <em>i<sup>-th</sup></em> investor is available to meet.

<em>int lastDay[n]</em>: an array of integers where the value of each element <em>lastDay[i]</em> is the last day the <em>i<sup>th</sup></em> investor is available to meet.

Returns:

<em>int:</em> an integer that represents the maximum number of meetings possible.
*/
