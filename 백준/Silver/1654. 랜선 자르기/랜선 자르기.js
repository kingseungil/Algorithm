/**
 * https://www.acmicpc.net/problem/1654 랜선 자르기
 */
const fs = require('fs');
const filePath = process.platform === 'linux' ? '/dev/stdin' : __dirname + '/test.txt';
const input = fs.readFileSync(filePath).toString().trim().split('\n');

// K : 이미 가지고 있는 랜선의 개수 (1<=K<=10_000)
// N : 필요한 랜선의 개수 (1 <= N <= 1_000_000) => target
const [K, N] = input[0].split(' ').map(Number);

// 배열 만들어주기
let arr = [];
for (let i = 1; i <= K; i++) {
  arr.push(+input[i]);
}

// 이진 탐색을 위해 start,end 설정
const start = 1;
const end = Math.max(...arr);

const parametricSearch = (arr, target, start, end) => {
  let result = 0;
  while (start <= end) {
    let count = 0; // 길이가 mid일 때 만들 수 있는 랜선의 개수
    let mid = Math.floor((start + end) / 2);
    for (const x of arr) {
      count += Math.floor(x / mid);
    }
    // 만들 수 있는 랜선의 개수가 충분한 경우 (길이를 늘려야 함)
    if (count >= target) {
      result = mid;
      start = mid + 1;
    }
    // 만들 수 있는 랜선의 개수가 부족한 경우 (길이를 줄여야 함)
    else {
      end = mid - 1;
    }
  }
  return result;
};

console.log(parametricSearch(arr, N, start, end));
