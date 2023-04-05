const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
// 풀이
function solution(x) {
  const num = +x[0]
  const answer = [];
  for(let i=1;i<10;i++){
      answer.push(`${num} * ${i} = ${num*i}`)
  }
  return answer.join('\n');
}

console.log(solution(input));