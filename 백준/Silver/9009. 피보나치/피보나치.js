const fs = require('fs');
const filePath =
  process.platform === 'linux' ? '/dev/stdin' : __dirname + '/test.txt';
const input = fs.readFileSync(filePath).toString().trim().split('\n');

const t = +input[0];

for (let i = 1; i <= t; i++) {
  const fibo = generateFibonacci(+input[i]);
  const result = findMinimumCases(fibo, +input[i]);
  result.sort((a, b) => a - b);
  console.log(...result);
}

function generateFibonacci(num) {
  const fibo = [0, 1]; // 피보나치 기본 값인 0,1로 배열 초기화

  while (fibo[fibo.length - 1] <= num) {
    const nextFibo = fibo[fibo.length - 1] + fibo[fibo.length - 2];
    fibo.push(nextFibo);
  }
  return fibo.slice(0, fibo.length - 1); // 마지막 값 빼주기 (num보다 크므로)
}

function findMinimumCases(array, num) {
  let currentNum = num;
  let resultArray = [];

  for (let i = array.length - 1; i >= 0; i--) {
    if (array[i] <= currentNum) {
      resultArray.push(array[i]);
      currentNum -= array[i];
      if (currentNum === 0) {
        break;
      }
    }
  }

  return resultArray;
}
