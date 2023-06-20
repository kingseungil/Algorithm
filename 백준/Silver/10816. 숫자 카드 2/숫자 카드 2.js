/**
 * https://www.acmicpc.net/problem/10816 (숫자 카드2)
 */
const fs = require('fs');
const filePath = process.platform === 'linux' ? '/dev/stdin' : __dirname + '/test.txt';
const input = fs.readFileSync(filePath).toString().trim().split('\n');

const numberArr = input[1].split(' ').map(Number); // 숫자 카드에 적혀있는 정수
const targetArr = input[3].split(' ').map(Number); // 몇 개 가지고 있는 숫자 카드인지 구해야 할 정수

const binarySearch = (arr, targetArr) => {
  const result = Array.from({ length: targetArr.length }, () => 0);
  const numCnt = {};

  // 각 숫자 카드 종류별로 개수를 구합니다.
  for (const num of arr) {
    numCnt[num] = (numCnt[num] || 0) + 1;
  }

  // 숫자 카드 종류별로 개수를 조회한 결과를 반환합니다.
  for (let i = 0; i < targetArr.length; i++) {
    const target = targetArr[i];
    if (numCnt.hasOwnProperty(target)) {
      result[i] = numCnt[target];
    }
  }

  return result;
};

console.log(binarySearch(numberArr, targetArr).join(' '));
