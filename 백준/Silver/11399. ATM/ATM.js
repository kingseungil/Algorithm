const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
// const input = fs.readFileSync('test.txt').toString().trim().split('\n');

const n = +input[0];
const arr = input[1].split(' ').map(Number);
arr.sort((a, b) => a - b);

let result = 0;
let sum = 0;
for (let i in arr) {
  sum += arr[i];
  result += sum;
}

console.log(result);
