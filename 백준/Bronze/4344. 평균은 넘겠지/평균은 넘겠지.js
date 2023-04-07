let fs = require('fs')
let input = fs.readFileSync('/dev/stdin').toString().trim().split('\n')

const testCase = +input[0]
for (let i = 1; i <= testCase; i++) {
  const data = input[i].split(' ').map(Number)
  const [b, ...c] = data
  const sum = c.reduce((a, b) => a + b)
  const avg = sum / b
  let pass = 0
  for (let j = 0; j < c.length; j++) {
    if (c[j] > avg) {
      pass += 1
    }
  }
  const result = pass / b * 100
  console.log(result.toFixed(3) + '%');
}


