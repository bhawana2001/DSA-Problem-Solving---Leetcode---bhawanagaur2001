class Solution {
    public int numUniqueEmails(String[] emails) {
        HashMap<String,Integer> map= new HashMap<>();
        for(int i=0;i<emails.length;i++){
         String ln=getLocalName(emails[i]);
         String dn=getDomainName(emails[i]);
         String cln=checkLocalName(ln);
            cln=cln+"@"+dn;
            map.put(cln,0);
        }
          return map.size();
    }
    public String checkLocalName(String name){
        String output="";
        for(int i=0;i<name.length();i++){
            if(name.charAt(i)=='.'){
                continue;
            }
            else if(name.charAt(i)=='+'){
                return output;
            }
            else{
                output+=name.charAt(i);
            }
        }  
        return output;
         }
    public String getLocalName(String email){
        return email.substring(0,email.indexOf("@"));
    }
    public String getDomainName(String email){
        return email.substring(email.indexOf("@")+1);
    } 
}