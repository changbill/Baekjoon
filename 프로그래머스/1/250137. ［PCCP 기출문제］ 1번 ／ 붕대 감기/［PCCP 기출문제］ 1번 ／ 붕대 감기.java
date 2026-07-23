class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int t = bandage[0];
        int healPerSec = bandage[1];
        int extraHeal = bandage[2];
        int attacksLen = attacks.length;
        int now = 0;
        int maxHealth = health;
        int healStack = 0;
        for(int i = 0; i < attacksLen; i++) {
            int attackTime = attacks[i][0];
            for(int j = now; j < attackTime; j++) {
                health += healPerSec;
                healStack++;
                if(healStack == t) {
                    health += extraHeal;
                    healStack = 0;
                }
            }
            health = Math.min(maxHealth, health);
            health -= attacks[i][1];
            healStack = 0;
            now = attackTime+1;
            if(health <= 0) {
                return -1;
            }
        }
        
        int answer = health;
        return answer;
    }
}