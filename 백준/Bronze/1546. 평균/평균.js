let fs = require('fs')
let input = fs.readFileSync('/dev/stdin').toString().trim().split('\n')

const N = +input[0]
const data = input[1].split(' ').map(Number)
const max = data.reduce((a, b) => Math.max(a, b))
let sum = 0

for (i in data) {
  data[i] = data[i] / max * 100
  sum = data.reduce((a, b) => a + b)
}
console.log((sum / N))