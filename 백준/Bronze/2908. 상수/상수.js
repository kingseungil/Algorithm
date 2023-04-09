let fs = require('fs')
let input = fs.readFileSync('/dev/stdin').toString().trim().split('\n')

const data = input[0].split(' ')

let max = 0;
for (i in data) {
  const reverse = data[i].split('').reverse().join('')
  if (reverse > max) {
    max = reverse
  }
}
console.log(max);