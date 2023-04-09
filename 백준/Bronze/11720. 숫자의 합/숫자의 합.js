let fs = require('fs')
let input = fs.readFileSync('/dev/stdin').toString().trim().split('\n')

const data = input[1].split('').map(Number)
let sum = 0;

for (i in data) {
  sum += data[i]
}

console.log(sum);