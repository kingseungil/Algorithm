const fs = require('fs');

const input = fs.readFileSync('/dev/stdin').toString().trim().split(' ');

// 풀이
function solution(arr) {
  const a = +arr[0]
  let sum = a * (a+1) / 2
  return sum
}

console.log(solution(input));