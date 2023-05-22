const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
// const input = fs.readFileSync('test.txt').toString().trim().split('\n');

const N = input[0];

let arr = [];
for (let i = 0; i < N.length; i++) {
  arr.push(N[i]);
}
arr.sort((a, b) => parseInt(b) - parseInt(a));
console.log(arr.join(''));
