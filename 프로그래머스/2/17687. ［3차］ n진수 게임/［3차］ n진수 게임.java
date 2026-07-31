class Solution {
    public String solution(int n, int t, int m, int p) {
        int maxIdx = m * (t - 1) + p - 1;
        StringBuilder sequence = new StringBuilder();

        int num = 0;

        while (sequence.length() <= maxIdx) {
            sequence.append(convertBase(n, num));
            num++;
        }

        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < t; i++) {
            answer.append(sequence.charAt(m * i + p - 1));
        }

        return answer.toString();
    }

    private String convertBase(int n, int num) {
        if (num == 0) {
            return "0";
        }

        StringBuilder result = new StringBuilder();

        while (num > 0) {
            int remainder = num % n;

            if (remainder >= 10) {
                result.append((char) ('A' + remainder - 10));
            } else {
                result.append((char) ('0' + remainder));
            }

            num /= n;
        }

        return result.reverse().toString();
    }
}