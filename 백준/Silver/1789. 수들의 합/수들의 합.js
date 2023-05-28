const fs = require('fs');
// const input = fs.readFileSync('test.txt').toString().trim().split('\n');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

let s = +input;
let sum = 0;
let current = 0;

while (sum <= s) {
  current += 1;
  sum += current;
}

console.log(current - 1);
