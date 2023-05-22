const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
// const input = fs.readFileSync('test.txt').toString().trim().split('\n');

const N = parseInt(input[0], 10);

let arr = [];
for (let i = 1; i <= N; i++) {
  const [x, y] = input[i].split(' ').map(Number);
  arr.push([x, y]);
}

arr.sort((a, b) => a[1] - b[1] || a[0] - b[0]);

let answer = '';
for (let i = 0; i < N; i++) {
  answer += arr[i][0] + ' ' + arr[i][1] + '\n';
}
console.log(answer);
