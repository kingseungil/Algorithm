const fs = require('fs');
const filePath = process.platform === 'linux' ? '/dev/stdin' : __dirname + '/test.txt';
const input = fs.readFileSync(filePath).toString().trim().split('\n');

const isPalindrome = (input) => {
  // 회문인지 검사
  const reverseInput = input.split('').reverse().join('');
  if (input === reverseInput) {
    return true;
  }
};

const t = +input[0];
for (let i = 1; i <= t; i++) {
  let data = input[i];
  // 회문인 경우
  if (isPalindrome(data)) console.log(0);
  // 유사회문인지 검사
  else {
    let flag = false; // 유사 회문 여부 확인
    let n = +data.length;
    for (let j = 0; j < n / 2; j++) {
      // 대칭이 아닌 경우
      if (data[j] !== data[n - j - 1]) {
        // 왼쪽에 있는 원소를 제거한 뒤 회문 검사
        if (isPalindrome(data.slice(0, j) + data.slice(j + 1, n))) flag = true;
        // 오른쪽에 있는 원소를 제거한 뒤 회문 검사
        if (isPalindrome(data.slice(0, n - j - 1) + data.slice(n - j))) flag = true;
        break;
      }
    }
    // 유사 회문인 경우
    if (flag) console.log(1);
    // 그 외
    else console.log(2);
  }
}
