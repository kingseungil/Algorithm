const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
// const input = fs.readFileSync('test.txt').toString().trim().split('\n');

const N = +input[0].split(' ')[0];
const K = +input[0].split(' ')[1];
const arr = input[1].split(' ').map((x) => +x);

arr.sort((a, b) => a - b);
console.log(arr[K - 1]);
