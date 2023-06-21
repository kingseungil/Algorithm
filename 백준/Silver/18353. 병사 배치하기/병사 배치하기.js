/**
 * https://www.acmicpc.net/problem/18353 (병사 배치하기)
 */
const fs = require('fs');
const filePath = process.platform === 'linux' ? '/dev/stdin' : __dirname + '/test.txt';
const input = fs.readFileSync(filePath).toString().trim().split('\n');

const N = +input[0]; // 군인 수
const soldiersArr = input[1].split(' ').map(Number);
soldiersArr.reverse(); // 가장 긴 증가하는 부분 수열(LIS)을 찾아야 하므로 배열을 뒤집는다.

const findExcludedSoldiers = (arr) => {
  let dp = Array.from({ length: 1 }, () => 0); // LIS 배열
  for (const x of arr) {
    // 마지막 값보다 현재 값이 크다면 LIS 배열에 추가
    if (dp[dp.length - 1] < x) dp.push(x);
    // x 이하인 값이 존재한다면 해당 값과 교체
    else {
      let lowerBoundIndex = lowerBound(dp, x);
      dp[lowerBoundIndex] = x;
    }
  }
  return dp.length - 1; // -1 하는 이유는 초기 dp 배열에 0을 넣어두었기 때문
};

const lowerBound = (arr, target) => {
  let start = 0;
  let end = arr.length;
  while (start < end) {
    let mid = Math.floor((start + end) / 2);
    if (arr[mid] >= target) end = mid;
    else start = mid + 1;
  }
  return end;
};
console.log(N - findExcludedSoldiers(soldiersArr));
