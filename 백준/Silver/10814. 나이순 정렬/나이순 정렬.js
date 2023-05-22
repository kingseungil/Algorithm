const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
// const input = fs.readFileSync('test.txt').toString().trim().split('\n');

const N = +input[0];

let arr = [];
for (let i = 1; i <= N; i++) {
  arr.push(input[i].split(' '));
}

arr.sort((a, b) => a[0] - b[0]);

for (let i of arr) {
  console.log(`${i[0]} ${i[1]}`);
}
