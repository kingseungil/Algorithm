const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
// const input = fs.readFileSync('test.txt').toString().trim().split('\n');

let [n, k] = input[0].split(' ').map(Number);

let answer = 0;

let arr = [];
for (let i = 1; i <= n; i++) {
  arr.push(+input[i]);
}

for (let i = n - 1; i >= 0; i--) {
  if (arr[i] > k) continue;
  answer += Math.floor(k / arr[i]); // 해당 동전을 몇 개 사용해야 하는지
  k %= arr[i]; // 해당 동전으로 모두 거슬러 준 뒤 남은 금액
}

console.log(answer);
