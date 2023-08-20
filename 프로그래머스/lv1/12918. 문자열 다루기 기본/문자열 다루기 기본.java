class Solution {
    public boolean solution(String s) {
        // int stringLength = s.length();
        // if (stringLength != 4 && stringLength != 6) {
        //     return false;
        // }
        return s.matches("[0-9]{4}|[0-9]{6}");
    }
}