let fs = require('fs')
let input = fs.readFileSync('/dev/stdin').toString().trim().split('\n')

function solution(n) {
    const a = Number(n[0].split(' '))
    for(let i=1;i<=n;i++){
        console.log('*'.repeat(i))
    }
}

solution(input)