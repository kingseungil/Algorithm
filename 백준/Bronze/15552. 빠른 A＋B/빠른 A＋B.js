let fs = require('fs')
let input = fs.readFileSync('/dev/stdin').toString().trim().split('\n')

const T = +input[0]
let answer = []

for (let i=1;i<=T;i++){
    let data = input[i].split(' ')
    let a = +data[0]
    let b = +data[1]
    answer += a+b+'\n'
}

console.log(answer)