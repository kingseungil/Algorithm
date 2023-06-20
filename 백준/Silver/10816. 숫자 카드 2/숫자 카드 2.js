/**
 * https://www.acmicpc.net/problem/10816 (숫자 카드2)
 */
const fs = require('fs');
const filePath = process.platform === 'linux' ? '/dev/stdin' : __dirname + '/test.txt';
const input = fs.readFileSync(filePath).toString().trim().split('\n');

const numberArr = input[1].split(' ').map(Number); // 숫자 카드에 적혀있는 정수
const targetArr = input[3].split(' ').map(Number); // 몇 개 가지고 있는 숫자 카드인지 구해야 할 정수

const lowerBound = (arr, target) => {
  let start = 0,
    end = arr.length;

  while (start < end) {
    const mid = Math.floor((start + end) / 2);
    if (arr[mid] >= target) end = mid;
    else start = mid + 1;
  }

  return end;
};

const upperBound = (arr, target) => {
  let start = 0,
    end = arr.length;

  while (start < end) {
    const mid = Math.floor((start + end) / 2);
    if (arr[mid] > target) end = mid;
    else start = mid + 1;
  }

  return end;
};

const countNums = (numArr, targetArr) => {
  const result = Array.from({ length: targetArr.length }, () => 0);
  numArr.sort((a, b) => a - b);

  for (let i = 0; i < targetArr.length; i++) {
    const leftIdx = lowerBound(numArr, targetArr[i]);
    const rightIdx = upperBound(numArr, targetArr[i]);
    result[i] = rightIdx - leftIdx;
  }

  return result;
};

console.log(countNums(numberArr, targetArr).join(' '));
