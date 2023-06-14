const fs = require('fs');
const filePath = process.platform === 'linux' ? '/dev/stdin' : __dirname + '/test.txt';
const input = fs.readFileSync(filePath).toString().trim().split('\n');

// 회문인지 검사하는 함수
const isPalindrome = (input) => {
  const n = input.length;
  for (let i = 0; i < n / 2; i++) {
    if (input[i] !== input[n - i - 1]) {
      return false;
    }
  }
  return true;
};

const t = +input[0];

for (let i = 1; i <= t; i++) {
  const data = input[i];
  // 회문인 경우
  if (isPalindrome(data)) {
    console.log(0);
  }
  // 유사 회문인 경우
  else {
    let flag = false; // 유사 회문인지 아닌지 판별하는 변수
    const n = data.length;
    for (let j = 0; j < n / 2 && !flag; j++) {
      // 대칭이 아닌 경우
      if (data[j] !== data[n - j - 1]) {
        // 왼쪽에 있는 원소를 제거한 뒤, 회문인지 검사
        if (isPalindrome(data.slice(0, j) + data.slice(j + 1))) flag = true;
        // 오른쪽에 있는 원소를 제거한 뒤, 회문인지 검사
        if (isPalindrome(data.slice(0, n - j - 1) + data.slice(n - j))) flag = true;
        break;
      }
    }
    if (flag) {
      console.log(1);
    } else {
      console.log(2);
    }
  }
}
