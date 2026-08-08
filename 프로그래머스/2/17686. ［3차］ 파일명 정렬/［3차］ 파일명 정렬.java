import java.util.*;

class Solution {
    class File {
        String head;
        String number;
        String tail;
        File(String head, String number, String tail) {
            this.head = head;
            this.number = number;
            this.tail = tail;
        }
    }
    public String[] solution(String[] files) {
        int len = files.length;
        File[] fileArr = new File[len];
        for(int i = 0; i < len; i++) {
            char[] cArr = files[i].toCharArray();
            int idx = 0;
            while(idx < cArr.length && !Character.isDigit(cArr[idx])) {
                idx++;
            }
            String head = files[i].substring(0, idx);
            int gijun = idx;
            while(idx < cArr.length && cArr[idx] >= '0' && cArr[idx] <= '9') {
                idx++;
            }
            String number = files[i].substring(gijun, idx);
            gijun = idx;
            String tail = files[i].substring(gijun);
            fileArr[i] = new File(head, number, tail);
        }
        Arrays.sort(fileArr, (a, b) -> {
            if(!a.head.toLowerCase().equals(b.head.toLowerCase())) {
                return a.head.compareToIgnoreCase(b.head);
            }
            int aNum = Integer.parseInt(a.number);
            int bNum = Integer.parseInt(b.number);
            if(aNum != bNum) {
                return aNum - bNum;
            }
            return 0;
        });

        String[] answer = new String[len];
        for(int i = 0; i < len; i++) {
            String head = fileArr[i].head;
            String number = fileArr[i].number;
            String tail = fileArr[i].tail;
            answer[i] = head + number + tail;
        }
        
        return answer;
    }
}