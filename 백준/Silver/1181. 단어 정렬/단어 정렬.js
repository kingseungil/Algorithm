const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
// const input = fs.readFileSync('test.txt').toString().trim().split('\n');

const arr = input.slice(1);

function CompareFunc(a, b) {
  if (a.length !== b.length) return a.length - b.length;
  return a.localeCompare(b);
}

arr.sort(CompareFunc);

console.log([...new Set(arr)].join('\n'));
