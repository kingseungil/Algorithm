/**
 * https://www.acmicpc.net/problem/1300 (K번째 수)
 */
const fs = require('fs');
const filePath = process.platform === 'linux' ? '/dev/stdin' : __dirname + '/test.txt';
const input = fs.readFileSync(filePath).toString().trim().split('\n');

const N = +input[0]; // 배열의 크기
const K = +input[1]; // 찾고자 하는 수

// mid보다 작거나 같은 수의 개수를 반환하는 함수
const countLessOrEqual = (mid, n) => {
  let count = 0;
  for (let i = 1; i <= n; i++) {
    count += Math.min(Math.floor(mid / i), n);
  }
  return count;
};

const binarySearch = (n, k) => {
  let start = 1;
  let end = n * n;
  let answer = 0; // k번째 수

  while (start <= end) {
    let mid = Math.floor((start + end) / 2);

    // mid보다 작거나 같은 수의 개수가 k보다 크거나 같으면
    if (countLessOrEqual(mid, n) >= k) {
      answer = mid;
      end = mid - 1;
    }
    // mid보다 작거나 같은 수의 개수가 k보다 작으면
    else {
      start = mid + 1;
    }
  }
  return answer;
};

console.log(binarySearch(N, K));
