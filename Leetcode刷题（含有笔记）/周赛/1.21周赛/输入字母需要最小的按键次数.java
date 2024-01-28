class Solution {
    public int minimumPushes(String word) {
        int res = 0;
        if(word.length() <= 8){
            res =  word.length();
        }
        else if(8 < word.length()&& word.length()<= 16){
            res =  8+2*(word.length() - 8);
        }else if(16 < word.length() && word.length() <= 24){
            res = 24 + 3*(word.length() - 16);
        }else if (word.length() > 24 && word.length() <=26){
            res = 48 + (word.length()-24)*4;
        }
        
        return res;
    }
}