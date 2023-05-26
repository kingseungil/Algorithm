const fs = require('fs');
// const input = fs.readFileSync('test.txt').toString().trim().split('\n');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

const [a, b] = input[0].split(' ').map(Number);

function findMinimumOperations(a, b) {
  let operationsCount = 1;

  while (a <= b) {
    if (a === b) {
      return operationsCount;
    }
    if (b % 2 === 0) {
      b = Math.floor(b / 2);
    } else if (b % 10 === 1) {
      b = Math.floor(b / 10);
    } else {
      break;
    }
    operationsCount++;
  }

  return -1;
}

const result = findMinimumOperations(a, b);
console.log(result);
