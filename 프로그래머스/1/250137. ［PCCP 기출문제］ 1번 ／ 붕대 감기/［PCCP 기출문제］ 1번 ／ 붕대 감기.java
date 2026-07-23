class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int t = bandage[0];
        int healPerSec = bandage[1];
        int extraHeal = bandage[2];
        int maxHealth = health;
        
        int prevTime = 0;
        for(int[] attack : attacks) {
            int time = attack[0];
            int damage = attack[1];
            
            int diff = time - prevTime - 1;
            int heal = healPerSec * diff + (diff / t) * extraHeal;
            
            health += heal;
            health = Math.min(health, maxHealth);
            
            health -= damage;
            if(health <= 0) {
                return -1;
            }
            System.out.println(health);
            prevTime = time;
        }
        
        int answer = health;
        return answer;
    }
}