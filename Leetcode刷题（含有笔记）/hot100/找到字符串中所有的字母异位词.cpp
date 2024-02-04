class Solution
{
public
    List<Integer> findAnagrams(String s, String p)
    {
        List<Integer> res = new ArrayList<>();
        int len = p.length();

        int[] charCountP = new int[26];
        int[] charCountCur = new int[26];

        for (char ch : p.toCharArray())
        {
            charCountP[ch - 'a']++;
        }

        for (int i = 0; i <= s.length() - len; i++)
        {
            Arrays.fill(charCountCur, 0);
            for (char ch : s.substring(i, i + len).toCharArray())
            {
                charCountCur[ch - 'a']++;
            }

            if (Arrays.equals(charCountP, charCountCur))
            {
                res.add(i);
            }
        }

        return res;
    }
}