let fs = require('fs')
let input = fs.readFileSync('/dev/stdin').toString().trim().split('\n')

let list = input.map(e => +e)
let set = new Set()

for (let i = 0; i < list.length; i++) {
  set.add(list[i] % 42)
}

console.log(set.size);