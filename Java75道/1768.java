class Solution {
	public String mergeAlternately(String word1, String word2) {
		StringBuilder str = new StringBuilder();
		int p = 0;
        int min = Math.min(word1.length(), word2.length());
		while (p < min) {
			str.append(word1.charAt(p)).append(word2.charAt(p ++));
		}
		str.append(word1.substring(p)).append(word2.substring(p));
		return str.toString();
	}
}