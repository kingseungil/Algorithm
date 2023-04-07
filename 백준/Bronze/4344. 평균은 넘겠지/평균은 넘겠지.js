let fs = require('fs')
let input = fs.readFileSync('/dev/stdin').toString().trim().split('\n')

const testCase = +input[0]
for (let i = 1; i <= testCase; i++) {
  let data = input[i].split(' ').map(Number)
  let [b, ...c] = data
  let sum = c.reduce((a, b) => a + b)
  let avg = sum / b
  let pass = 0
  for (let j = 0; j < c.length; j++) {
    if (c[j] > avg) {
      pass += 1
    }
  }
  const result = pass / b * 100
  console.log(result.toFixed(3) + '%');
}

