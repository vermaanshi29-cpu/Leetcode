class Solution {
    public List<Integer> maxPrimes(int n, int s) {
      List<Integer> ans = new ArrayList<>();
        for(int i=2;i<=n;i++){
            boolean prime = true;
        for(int j= 2;j*j<=i;j++){
            if(i%j==0){
                prime = false ;
                break;
            }
        }    
            if(prime){
                if(s>=i){
                    ans.add(i);
                    s-=i;
                    
                }else{
                    break;
                }
            }
        }
        return ans;
    }
}