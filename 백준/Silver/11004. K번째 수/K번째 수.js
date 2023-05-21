const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
// const input = fs.readFileSync('test.txt').toString().trim().split('\n');

const [_N, K] = input[0].split(' ').map(Number);
const arr = input[1].split(' ').map(Number);
arr.sort((a, b) => a - b);

console.log(arr[K - 1]);
