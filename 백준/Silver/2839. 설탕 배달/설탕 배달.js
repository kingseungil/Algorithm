const fs = require('fs');
// const input = fs.readFileSync('test.txt').toString().trim().split('\n');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

let n = +input[0];
let count = 0;
let valid = false;

while (n >= 0) {
  if (n === 0 || n % 5 === 0) {
    count += Math.floor(n / 5);
    console.log(count);
    valid = true;
    break;
  }
  n -= 3;
  count += 1;
}

if (!valid) {
  console.log(-1);
}
