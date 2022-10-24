package com.leetcode.favorite.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MeetRoom {

    public static void main(String[] args) {
        MeetRoom.Interval interval1 = new MeetRoom.Interval(0,30);
        MeetRoom.Interval interval2 = new MeetRoom.Interval(5,10);
        MeetRoom.Interval interval3 = new MeetRoom.Interval(15,20);
        MeetRoom.Interval interval4 = new MeetRoom.Interval(18,20);

        List<Interval> list = new ArrayList<>();
        list.add(interval1);
        list.add(interval2);
        list.add(interval3);
        list.add(interval4);

        MeetRoom mr = new MeetRoom();
        System.out.println(mr.minMeetingRooms(list));
    }


    static class Interval {
         int start, end;
         Interval(int start, int end) {
             this.start = start;
             this.end = end;
         }
     }

    public int minMeetingRooms(List<Interval> intervals) {
        // 对intervals，按start升序排列
        Collections.sort(intervals, (x, y) -> x.start - y.start);
        List<Integer> rooms = new ArrayList<Integer>();
        boolean flag = false;
        for (Interval x : intervals) {
            for (int i = 0; i < rooms.size(); i++) {
                // 满足这个条件，说明可以共用一个room
                if (x.start > rooms.get(i)) {
                    rooms.set(i, x.end);
                    flag = true;
                    break;
                }
            }
            // flag = false,说明只能新开一个room
            if (!flag) {
                rooms.add(x.end);
            }
            flag = false;
        }
        // 最后rooms的大小，即结果
        return rooms.size();
    }

}
