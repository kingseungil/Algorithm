let input = require('fs').readFileSync('/dev/stdin').toString().trim().split('\n')

let count = 1
let stack = []

const N = +input[0]
for (let i = 1; i <= N; i++) {
  stack.push(+input[i])
}

let max = stack.pop()
for (let i = stack.length - 1; i >= 0; i--) {
  if (stack[i] > max) {
    count++
    max = stack[i]
  }
}

console.log(count);