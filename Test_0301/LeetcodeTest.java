package Test_0301;

/*
3.无重复字符的最长子串
给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

示例 1:
输入: "abcabcbb"
输出: 3 
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:
输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:
输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
/*
 * 分析：
 * 用i遍历s中所有的字符，j检验这个字符是否与子串前面的字符重复(j初始为0)，如果不重复，count计数加一，
 * 如果重复，更新max的值，且新的子串是从重复字符的下一个字符到此字符组成的子串，
 * (如"abcabcbb"，遍历到索引为3的字符'a'时j指针检测到与第二个字符索引为0的字符'a'重复，
 * 新的子串就应该从索引为1的字符到索引为3的字符组成的字符串"bca")j也应该指向新字符串的首位，
 * 如此循环下去，便可以计算出无重复字符的最长子串的长度。
 * 注意最后返回max、count的最大值，因为count最后计数的值没有更新到max中。
 */
//public class LeetcodeTest {
//	public static void main(String[] args) {
//		Solution So = new Solution();
//		String s = "abcabcbb";
//		System.out.println(So.lengthOfLongestSubstring(s));
//	}
//}
//class Solution {
//    public int lengthOfLongestSubstring(String s) {
//    	int max = 0;
//    	int count = 0;
//    	int j=0;
//    	int ret = 0;
//        for(int i=0; i<s.length(); i++){
//        	for(; j<i; j++){
//        		if(s.charAt(i) == s.charAt(j))
//        			break;
//        	}
//        	if(i == j){
//        		count++;
//            	j = ret;//使j指针指向现在子串的首位
//        	}
//        	else{
//        		max = Math.max(max, count);
//        		count = i - j; //j此时指向的是检测到的重复字符的位置，i是遍历到的字符，i-j是新的子串的长度  	
//        		j++; //更新j指针的位置,使j指针指向新的子串的首位
//        		ret = j;//记录新的子串中首位的索引，便于以后多次使用
//        	}
//        }
//        return Math.max(max, count);
//    }
//}
/*
5. 最长回文子串
给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

示例 1：
输入: "babad"
输出: "bab"
注意: "aba" 也是一个有效答案。
示例 2：
输入: "cbbd"
输出: "bb"
 */
/*
 * 分析：
 * res用来存最大长度的回文串，初始为""，i指针遍历s，寻找以i为中心的奇回文子串、以i、i+1为中心的偶回文字符串，若长度大于res的长度，更新res，遍历完毕返回res。
 */
public class LeetcodeTest {
	public static void main(String[] args) {
		Solution So = new Solution();
		String s = "cbbd";
		System.out.println(So.longestPalindrome(s));
	}
}
class Solution {
    public String longestPalindrome(String s) {
    	String res = "";
        for(int i=0; i<s.length(); i++){
        	//以i为中心的奇回文子串
        	int j=i-1;
        	for(; j>=0 && 2*i-j < s.length();j--){
        		if(s.charAt(j) != s.charAt(2*i-j)){
        			break;
        		}
        	}
        	//如果回文串的长度大于res的长度，更新res.
        	if(2*i-2*j-1 > res.length()){
        		res = s.substring(j+1, 2*i-j);
        	}
        	//以i、i+1为中心的偶回文字符串
        	if(i+1<s.length() && s.charAt(i)== s.charAt(i+1)){
        		j = i-1;
        		for(; j>=0 && 2*i-j+1<s.length(); j--){
        			if(s.charAt(j) != s.charAt(2*i-j+1)){
        				break;
        			}
        		}
        		//如果回文串的长度大于res的长度，更新res.
        		if(2*i-2*j >res.length()){
        			res = s.substring(j+1, 2*i-j+1);
        		}
        	}
        }
        return res;
    }
}
