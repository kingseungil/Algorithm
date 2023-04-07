let fs = require('fs')
let input = fs.readFileSync('/dev/stdin').toString().trim().split('\n')

let list = input.map(e => +e)
let max = 0
let max_index = 0

for (let i = 0; i < list.length; i++) {
  if (list[i] > max) {
    max = list[i]
    max_index = i
  }
}
console.log(max)
console.log(max_index + 1)