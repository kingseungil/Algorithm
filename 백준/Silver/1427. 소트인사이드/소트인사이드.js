const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
// const input = fs.readFileSync('test.txt').toString().trim().split('\n');

const N = input[0];

let cnt = Array(10).fill(0);

for (let x of N) {
  cnt[Number(x)]++;
}

let answer = '';
for (let i = 9; i >= 0; i--) {
  for (let j = 0; j < cnt[i]; j++) {
    answer += i + '';
  }
}

console.log(answer);
