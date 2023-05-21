const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
// const input = fs.readFileSync('test.txt').toString().trim().split('\n');
const list = input[0].split(' ').map(Number);
list.sort((a, b) => a - b);
let answer = '';
for (let i in list) {
  answer += list[i] + ' ';
}
console.log(answer);
