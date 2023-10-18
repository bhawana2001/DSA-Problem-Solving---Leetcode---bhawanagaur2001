/**
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface Master {
 *     public int guess(String word) {}
 * }
 */
class Solution {
    public void findSecretWord(String[] words, Master master) {
        Random r = new Random();
        List<String> powe=new ArrayList<>();
        for(String word:words){
            powe.add(word);
        }
        while(powe.size()!=0){
             int index = r.nextInt(powe.size());
             String wordGuessed = powe.get(index);
             int match=master.guess(wordGuessed);
             if(match==6) {
                 return;
             }
             List<String> temp=new ArrayList<>();
             for(String w:powe){
                 if(findMatch(w,wordGuessed)==match){
                     temp.add(w);
                 }
             }
             powe=temp;
        }
    }
    public int findMatch(String w1,String w2){
        int count=0;
        for(int i=0;i<6;i++){
            if(w1.charAt(i)==w2.charAt(i)) count++;
        }
        return count;
    }
}