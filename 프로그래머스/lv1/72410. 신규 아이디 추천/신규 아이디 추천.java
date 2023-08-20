class Solution {
    public String solution(String new_id) {
         // 1. 소문자로 치환
        String lowerString = new_id.toLowerCase();

        // 2. 소문자, 숫자, -, _, . 제외한 문자 제거
        String regex = "[^a-z0-9-_.]";
        String removeString = lowerString.replaceAll(regex, ""); // 정규식에 해당하는 문자열 제거

        // 3. . 2번 이상 연속된 부분을 하나의 .로 치환
        String regex2 = "[.]{2,}";
        String removeString2 = removeString.replaceAll(regex2, ".");

        // 4. .가 처음이나 끝에 위치한다면 제거
        String regex3 = "^[.]|[.]$";
        String removeString3 = removeString2.replaceAll(regex3, "");

        // 5. 빈 문자열이라면 a 대입
        String emptyString = removeString3;
        if (emptyString.isEmpty()) {
            emptyString = "a";
        }

        // 6. 16자 이상이면 15자로 자르고 끝에 .이 위치한다면 제거
        String regex4 = "[.]$";
        String removeString4 = emptyString;
        if (removeString4.length() >= 16) {
            removeString4 = removeString4.substring(0, 15);
            removeString4 = removeString4.replaceAll(regex4, "");
        }

        // 7. 2자 이하라면 마지막 문자를 길이가 3이 될 때까지 반복해서 끝에 붙임
        String regex5 = "[.]$";
        StringBuilder removeString5 = new StringBuilder(removeString4);
        if (removeString5.length() <= 2) {
            while (removeString5.length() < 3) {
                removeString5.append(removeString5.charAt(removeString5.length() - 1));
            }
        }

        return removeString5.toString();
    }
}