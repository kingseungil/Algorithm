/**
 * https://www.acmicpc.net/problem/10816 (숫자 카드2)
 */
const fs = require('fs');
const filePath = process.platform === 'linux' ? '/dev/stdin' : __dirname + '/test.txt';
const input = fs.readFileSync(filePath).toString().trim().split('\n');

const numberArr = input[1]
  .split(' ')
  .map(Number)
  .sort((a, b) => a - b); // 숫자 카드에 적혀있는 정수
const targetArr = input[3].split(' ').map(Number); // 몇 개 가지고 있는 숫자 카드인지 구해야 할 정수

// lowerBound : target보다 크거나 같은 수가 처음으로 나타나는 위치를 반환하는 함수
const lowerBound = (numArr, target) => {
  let start = 0,
    end = numArr.length;

  while (start < end) {
    const mid = Math.floor((start + end) / 2);
    if (numArr[mid] >= target) end = mid;
    else start = mid + 1;
  }

  return end;
};

// upperBound : target보다 큰 수가 처음으로 나타나는 위치를 반환하는 함수
const upperBound = (numArr, target) => {
  let start = 0,
    end = numArr.length;

  while (start < end) {
    const mid = Math.floor((start + end) / 2);
    if (numArr[mid] > target) end = mid;
    else start = mid + 1;
  }

  return end;
};

// countNums : lowerBound와 upperBound를 이용하여 targetArr에 해당하는 숫자 카드의 개수를 구하는 함수
const countNums = (numArr, targetArr) => {
  const result = Array.from({ length: targetArr.length }, () => 0);

  for (let i = 0; i < targetArr.length; i++) {
    const leftIdx = lowerBound(numArr, targetArr[i]);
    const rightIdx = upperBound(numArr, targetArr[i]);
    result[i] = rightIdx - leftIdx;
  }

  return result;
};

console.log(countNums(numberArr, targetArr).join(' '));
