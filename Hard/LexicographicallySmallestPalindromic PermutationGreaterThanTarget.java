class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int n=s.length();
        int[] cnt=new int[26];

        for(char ch:s.toCharArray()){
            cnt[ch-'a']++;
        }

        String mid="";

        for(int i=0;i<26;i++){
            if(cnt[i]%2==1){
                if(!mid.isEmpty()){
                    return "";
                }
                mid=String.valueOf((char)('a'+i));
            }
            cnt[i]/=2;
        }

        int h=n/2;
        int[] temp=cnt.clone();

        StringBuilder left=new StringBuilder();

        for(int i=0;i<h;i++){
            int x=target.charAt(i)-'a';

            if(temp[x]>0){
                temp[x]--;
                left.append((char)('a'+x));
            }else{
                boolean found=false;

                for(int j=x+1;j<26;j++){
                    if(temp[j]>0){
                        temp[j]--;

                        StringBuilder res=new StringBuilder(left);
                        res.append((char)('a'+j));

                        for(int k=0;k<26;k++){
                            for(int z=0;z<temp[k];z++){
                                res.append((char)('a'+k));
                            }
                        }

                        String r=new StringBuilder(res).reverse().toString();
                        return res.toString()+mid+r;
                    }
                }

                for(int p=i-1;p>=0;p--){
                    int old=left.charAt(p)-'a';
                    temp[old]++;

                    for(int j=old+1;j<26;j++){
                        if(temp[j]>0){
                            temp[j]--;

                            StringBuilder res=new StringBuilder(left.substring(0,p));
                            res.append((char)('a'+j));

                            for(int k=0;k<26;k++){
                                for(int z=0;z<temp[k];z++){
                                    res.append((char)('a'+k));
                                }
                            }

                            String r=new StringBuilder(res).reverse().toString();
                            return res.toString()+mid+r;
                        }
                    }

                    left.deleteCharAt(p);
                }

                return "";
            }
        }

        String l=left.toString();
        String pal=l+mid+new StringBuilder(l).reverse();

        if(pal.compareTo(target)>0){
            return pal;
        }

        for(int p=h-1;p>=0;p--){
            int old=left.charAt(p)-'a';
            temp[old]++;

            for(int j=old+1;j<26;j++){
                if(temp[j]>0){
                    temp[j]--;

                    StringBuilder res=new StringBuilder(left.substring(0,p));
                    res.append((char)('a'+j));

                    for(int k=0;k<26;k++){
                        for(int z=0;z<temp[k];z++){
                            res.append((char)('a'+k));
                        }
                    }

                    String r=new StringBuilder(res).reverse().toString();
                    return res.toString()+mid+r;
                }
            }
        }

        return "";
    }
}
