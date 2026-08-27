class Solution {
    private StringBuilder getrest(int f[]) {
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < 26; i++) {
            while (f[i] > 0) {
                ans.append((char)('a' + i));
                f[i]--;
            }
        }

        return ans;
    }

    public String lexGreaterPermutation(String s, String target) {
        int f[] = new int[26];

        for (int i = 0; i < s.length(); i++) {
            f[s.charAt(i) - 'a']++;
        }

        int n = target.length();
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int c = target.charAt(i) - 'a';

            if (f[c] > 0) {
                ans.append(target.charAt(i));
                f[c]--;
            } else {
                for (int j = c + 1; j < 26; j++) {
                    if (f[j] > 0) {
                        ans.append((char)('a' + j));
                        f[j]--;
                        ans.append(getrest(f));
                        return ans.toString();
                    }
                }

                while (ans.length() > 0) {
                    int last = ans.length() - 1;
                    int prev = ans.charAt(last) - 'a';

                    f[prev]++;

                    for (int j = prev + 1; j < 26; j++) {
                        if (f[j] > 0) {
                            ans.deleteCharAt(last);
                            ans.append((char)('a' + j));
                            f[j]--;
                            ans.append(getrest(f));
                            return ans.toString();
                        }
                    }

                    ans.deleteCharAt(last);
                }

                return "";
            }
        }

        while (ans.length() > 0) {
            int last = ans.length() - 1;
            int prev = ans.charAt(last) - 'a';

            f[prev]++;

            for (int j = prev + 1; j < 26; j++) {
                if (f[j] > 0) {
                    ans.deleteCharAt(last);
                    ans.append((char)('a' + j));
                    f[j]--;
                    ans.append(getrest(f));
                    return ans.toString();
                }
            }

            ans.deleteCharAt(last);
        }

        return "";
    }
}
