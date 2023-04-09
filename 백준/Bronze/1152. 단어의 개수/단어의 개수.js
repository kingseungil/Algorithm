let fs = require('fs')
let input = fs.readFileSync('/dev/stdin').toString().trim().split('\n')

const data = input[0].split(' ')
if (data[0] === '') {
  console.log(0);
} else {
  console.log(data.length);
}