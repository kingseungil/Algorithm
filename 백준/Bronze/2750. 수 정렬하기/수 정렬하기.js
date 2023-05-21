const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
// const input = fs.readFileSync('test.txt').toString().trim().split('\n');

const N = +input[0];

let arr = [];
for (let i = 1; i <= N; i++) {
  arr.push(input[i]);
}

arr.sort((a, b) => a - b);

for (let i in arr) {
  console.log(arr[i]);
}
