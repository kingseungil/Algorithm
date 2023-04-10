let fs = require('fs')
let input = fs.readFileSync('/dev/stdin').toString().trim().split('\n')

const N = +input[0]


for (let i = 1; i <= N; i++) {
  const data = input[i].split(' ').reverse()
  console.log(`Case #${i}: ${data.join(' ')}`);
}