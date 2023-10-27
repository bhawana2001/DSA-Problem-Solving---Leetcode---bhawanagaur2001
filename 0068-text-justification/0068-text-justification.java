class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int n=words.length;
        int i=0;
        List<String> ans=new ArrayList<>();
        while(i<n){
            int lc=words[i].length();
            int j=i+1;
            int can=0;
            while(j<n && lc+can+words[j].length()+1<=maxWidth){
                lc+=words[j].length();  //count total letters withing range
                j++;
                can++;                  //words included in current line
            }
            int vac=maxWidth-lc;    //remaining vacancy after letter count
            int atleastSpace=can==0?0:vac/can;
            int extraSpace=can==0?0:vac%can;
            if(j==n){
                atleastSpace=1;
                extraSpace=0;
            }
            StringBuilder sb=new StringBuilder();
            for(int k=i;k<j;k++){
                sb.append(words[k]);
                if(k==j-1) break;
                for(int space=0;space<atleastSpace;space++){
                    sb.append(" ");     //fill spaces that is at least required 
                }
                if(extraSpace>0){
                    sb.append(" ");     //fill spaces if there will be extra spaces required
                    extraSpace--;
                }
            }
            while(sb.length()<maxWidth){
                sb.append(" ");     //that means we need to add few spaces to make it justified
            }
            ans.add(sb.toString());
            i=j;
        }
        return ans;
    }
}