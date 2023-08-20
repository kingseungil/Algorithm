class Solution {
    public String solution(String new_id) {
         // 1. 소문자로 치환
        String lowerCaseId = new_id.toLowerCase();

        // 2. 소문자, 숫자, -, _, . 제외한 문자 제거
        String removeInvalidCharsPattern = "[^a-z0-9-_.]";
        String validCharsOnly = lowerCaseId.replaceAll(removeInvalidCharsPattern, "");

        // 3. . 2번 이상 연속된 부분을 하나의 .로 치환
        String multipleDotsPattern = "[.]{2,}";
        String singleDot = validCharsOnly.replaceAll(multipleDotsPattern, ".");

        // 4. .가 처음이나 끝에 위치한다면 제거
        String startEndDotPattern = "^[.]|[.]$";
        String noStartEndDot = singleDot.replaceAll(startEndDotPattern, "");

        // 5. 빈 문자열이라면 a 대입
        String nonEmptyString = noStartEndDot.isEmpty() ? "a" : noStartEndDot;

        // 6. 16자 이상이면 15자로 자르고 끝에 .이 위치한다면 제거
        String endDotPattern = "[.]$";
        String maxLength15 =
          nonEmptyString.length() >= 16 ? nonEmptyString.substring(0, 15) : nonEmptyString;
        String noEndDot = maxLength15.replaceAll(endDotPattern, "");

        // 7. 2자 이하라면 마지막 문자를 길이가 3이 될 때까지 반복해서 끝에 붙임
        StringBuilder result = new StringBuilder(noEndDot);
        while (result.length() <= 2) {
            result.append(result.charAt(result.length() - 1));
        }

        return result.toString();
    }
}