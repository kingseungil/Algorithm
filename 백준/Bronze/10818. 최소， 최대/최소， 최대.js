let fs = require('fs')
let input = fs.readFileSync('/dev/stdin').toString().trim().split('\n')

const N = +input[0]
const arr = input[1].split(' ').map(e=>+e)

const max = arr.reduce((acc,cur)=>Math.max(acc,cur))
const min = arr.reduce((acc,cur)=>Math.min(acc,cur))

console.log(`${min} ${max}`)
