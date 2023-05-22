const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
// const input = fs.readFileSync('test.txt').toString().trim().split('\n');

const subtractionArr = input[0].split('-');

let answer = 0;
for (let i = 0; i < subtractionArr.length; i++) {
  let num = subtractionArr[i]
    .split('+')
    .map(Number)
    .reduce((a, b) => a + b);
  if (i === 0) answer += num;
  else answer -= num;
}

console.log(answer);
