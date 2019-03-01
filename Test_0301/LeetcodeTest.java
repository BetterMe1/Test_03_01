package Test_0301;

/*
3.���ظ��ַ�����Ӵ�
����һ���ַ����������ҳ����в������ظ��ַ��� ��Ӵ� �ĳ��ȡ�

ʾ�� 1:
����: "abcabcbb"
���: 3 
����: ��Ϊ���ظ��ַ�����Ӵ��� "abc"�������䳤��Ϊ 3��
ʾ�� 2:
����: "bbbbb"
���: 1
����: ��Ϊ���ظ��ַ�����Ӵ��� "b"�������䳤��Ϊ 1��
ʾ�� 3:
����: "pwwkew"
���: 3
����: ��Ϊ���ظ��ַ�����Ӵ��� "wke"�������䳤��Ϊ 3��
��ע�⣬��Ĵ𰸱����� �Ӵ� �ĳ��ȣ�"pwke" ��һ�������У������Ӵ���
 */
/*
 * ������
 * ��i����s�����е��ַ���j��������ַ��Ƿ����Ӵ�ǰ����ַ��ظ�(j��ʼΪ0)��������ظ���count������һ��
 * ����ظ�������max��ֵ�����µ��Ӵ��Ǵ��ظ��ַ�����һ���ַ������ַ���ɵ��Ӵ���
 * (��"abcabcbb"������������Ϊ3���ַ�'a'ʱjָ���⵽��ڶ����ַ�����Ϊ0���ַ�'a'�ظ���
 * �µ��Ӵ���Ӧ�ô�����Ϊ1���ַ�������Ϊ3���ַ���ɵ��ַ���"bca")jҲӦ��ָ�����ַ�������λ��
 * ���ѭ����ȥ������Լ�������ظ��ַ�����Ӵ��ĳ��ȡ�
 * ע����󷵻�max��count�����ֵ����Ϊcount��������ֵû�и��µ�max�С�
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
//            	j = ret;//ʹjָ��ָ�������Ӵ�����λ
//        	}
//        	else{
//        		max = Math.max(max, count);
//        		count = i - j; //j��ʱָ����Ǽ�⵽���ظ��ַ���λ�ã�i�Ǳ��������ַ���i-j���µ��Ӵ��ĳ���  	
//        		j++; //����jָ���λ��,ʹjָ��ָ���µ��Ӵ�����λ
//        		ret = j;//��¼�µ��Ӵ�����λ�������������Ժ���ʹ��
//        	}
//        }
//        return Math.max(max, count);
//    }
//}
/*
5. ������Ӵ�
����һ���ַ��� s���ҵ� s ����Ļ����Ӵ�������Լ��� s ����󳤶�Ϊ 1000��

ʾ�� 1��
����: "babad"
���: "bab"
ע��: "aba" Ҳ��һ����Ч�𰸡�
ʾ�� 2��
����: "cbbd"
���: "bb"
 */
/*
 * ������
 * res��������󳤶ȵĻ��Ĵ�����ʼΪ""��iָ�����s��Ѱ����iΪ���ĵ�������Ӵ�����i��i+1Ϊ���ĵ�ż�����ַ����������ȴ���res�ĳ��ȣ�����res��������Ϸ���res��
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
        	//��iΪ���ĵ�������Ӵ�
        	int j=i-1;
        	for(; j>=0 && 2*i-j < s.length();j--){
        		if(s.charAt(j) != s.charAt(2*i-j)){
        			break;
        		}
        	}
        	//������Ĵ��ĳ��ȴ���res�ĳ��ȣ�����res.
        	if(2*i-2*j-1 > res.length()){
        		res = s.substring(j+1, 2*i-j);
        	}
        	//��i��i+1Ϊ���ĵ�ż�����ַ���
        	if(i+1<s.length() && s.charAt(i)== s.charAt(i+1)){
        		j = i-1;
        		for(; j>=0 && 2*i-j+1<s.length(); j--){
        			if(s.charAt(j) != s.charAt(2*i-j+1)){
        				break;
        			}
        		}
        		//������Ĵ��ĳ��ȴ���res�ĳ��ȣ�����res.
        		if(2*i-2*j >res.length()){
        			res = s.substring(j+1, 2*i-j+1);
        		}
        	}
        }
        return res;
    }
}
