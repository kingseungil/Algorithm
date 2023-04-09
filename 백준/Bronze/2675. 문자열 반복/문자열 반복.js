let fs = require('fs')
let input = fs.readFileSync('/dev/stdin').toString().trim().split('\n')

const testCase = +input[0]
for (let i = 1; i <= testCase; i++) {
  const [N, data] = input[i].split(' ')
  let result = []
  for (j in data) {
    result.push(data[j].repeat(N))
  }
  console.log(result.join(''));
}
