public class Palindrome {
    public Deque<Character> wordToDeque(String word){
        Deque<Character> deque = new LinkedListDeque<>();
        int length = word.length();
        for(int i=0;i<length;i++){
            deque.addLast(word.charAt(i));
        }
        return deque;
    }

    public boolean isPalindrome(String word){
        if (word==null || word.length()<=1){
            return true;
        }
        int length = word.length();
        for (int i = 0; i < length / 2; i++) {
            if (word.charAt(i) != word.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
