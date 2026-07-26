import java.util.*;
class Solution {
    // 콘이 셔틀을 타고 사무실로 갈 수 있는 도착 시각 중 제일 늦은 시각을 구하여라.
    // 셔틀은 도착했을 때 도착한 순간에 대기열에 선 크루까지 포함해서 태우고 바로 출발한다.
    // 09:00에 도착한 셔틀은 자리가 있다면 09:00에 줄을 선 크루도 탈 수 있다.
    int n, t, m;
    String[] timetable;
    class Time {
        int hour; int minute; int freeSpace;
        Time(int hour, int minute, int freeSpace) {
            this.hour = hour;
            this.minute = minute;
            this.freeSpace = freeSpace;
        }
    }
    public String solution(int a, int b, int c, String[] d) {
        n = a; // 셔틀 운행 횟수
        t = b; // 셔틀 운행 간격
        m = c; // 한 셔틀 당 최대 크루 수
        timetable = d;  // 크루가 대기열에 도착하는 시각
        
        // List<List<Integer>> 시간대마다 크루들 넣어놓고 풀이면 다음으로 넘어가는 식으로 해서
        List<List<Integer>> table = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            table.add(new ArrayList<>());
        }
        
        Time[] times = new Time[timetable.length];
        for(int i = 0; i < timetable.length; i++) {
            int hour = Integer.parseInt(timetable[i].substring(0,2));
            int minute = Integer.parseInt(timetable[i].substring(3,5));
            times[i] = new Time(hour, minute, m);
        }
        Arrays.sort(times, (t1, t2) -> {
            if(t1.hour != t2.hour) {
                return t1.hour - t2.hour;
            } else {
                return t1.minute - t2.minute;
            }
        });
        
        // 버스시간 하나씩 순회하면서 승객 하나씩 체크, 마지막 셔틀 시간에 승객 줄이 남아있다면 마지막 승객 1분전에 배치
        // 안남아있다면 마지막 셔틀 시간에 배치
        int pasIdx = 0;
        Time[] lastPas = new Time[n];
        for(int i = 0; i < n; i++) {
            int freeSpace = m;
            int shuttleTime = 9*60 + i*t;
            int pasTime;
            System.out.println("pasHour: " + times[pasIdx].hour + ", pasMin: " + times[pasIdx].minute + ", pasIdx: " + i);
            while(pasIdx < times.length && freeSpace > 0) {
                pasTime = times[pasIdx].hour*60 + times[pasIdx].minute;
                if(pasTime > shuttleTime) break;
                freeSpace--;
                pasIdx++;
            }
            if(pasIdx == 0) {
                continue;
            }
            lastPas[i] = new Time(times[pasIdx-1].hour, times[pasIdx-1].minute, freeSpace);
            System.out.println("hour: " + times[pasIdx-1].hour + ", minute: " + times[pasIdx-1].minute);
        }
        
        String answer = "";
        if(lastPas[n-1] == null || lastPas[n-1].freeSpace > 0) {
            int time = 9*60 + (n-1)*t;
            answer = cal(time);
        } else {
            int time = lastPas[n-1].hour * 60 + lastPas[n-1].minute - 1;
            answer = cal(time);
        }
        
        return answer;
    }
    
    String cal(int time) {
        String answer = "";
        int hour = time / 60;
        int minute = time % 60;
        if(hour / 10 == 0) {
            answer += "0" + hour;
        } else {
            answer += hour;
        }
        
        answer += ':';
        
        if(minute / 10 == 0) {
            answer += "0" + minute;
        } else {
            answer += minute;
        }
        return answer;
    }
}