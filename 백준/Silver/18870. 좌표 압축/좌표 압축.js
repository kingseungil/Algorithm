const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
// const input = fs.readFileSync('test.txt').toString().trim().split('\n');

const arr = input[1].split(' ').map(Number);
const arrSet = [...new Set(arr)].sort((a, b) => a - b);

const indexMap = new Map();
for (let i = 0; i < arrSet.length; i++) {
  indexMap.set(arrSet[i], i);
}

const result = arr.map((number) => indexMap.get(number));

let answer = '';
for (let i of result) {
  answer += i + ' ';
}
console.log(answer);
