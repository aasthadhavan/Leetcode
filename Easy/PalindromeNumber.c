bool isPalindrome(int x) {
    if(x<0){
        return false;
    }
     int n=x;
     double rev=0;
     while(n>0){
        int rmdr=n%10;
        rev=rev*10 +rmdr;
        n=n/10;
     }
     if(rev==x){
        return true;
     }
     else{
        return false;
     }
    
}