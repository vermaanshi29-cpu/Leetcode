class Solution {
    public int minRotations(String s) {
        int current = 0;
        int answer = 0;
        
     for(char ch :s.toCharArray()){
         int target = ch - '0';
         
         int diff = Math.abs(current-target);
         int rotations= Math.min(diff,10-diff);
         
         answer += rotations;
         current = target;
     }   
        return answer;
    }
}