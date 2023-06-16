const fs = require('fs');
const filePath = process.platform === 'linux' ? '/dev/stdin' : __dirname + '/test.txt';
const input = fs.readFileSync(filePath).toString().trim().split('\n');

const n = +input[0];
const arr = input[1]
  .split(' ')
  .map(Number)
  .sort((a, b) => a - b);
const m = +input[2];

// 이진 탐색을 위한 start, end 설정
const start = 1;
const end = arr[n - 1];

const binarySearch = (arr, target, start, end) => {
  let result = 0;
  while (start <= end) {
    let mid = Math.floor((start + end) / 2); // 현재의 중간점(상한액)
    let sum = 0; // 배정된 예산의 합
    // 각 요청 예산을 확인하며 예산 배정
    for (const x of arr) {
      sum += Math.min(x, mid);
    }
    // 조건을 만족한다면, 중간점을 높여서 더 큰 값을 탐색
    if (sum <= target) {
      result = mid;
      start = mid + 1;
    }
    // 조건을 만족하지 않는다면, 중간점을 낮춰서 더 작은 값을 탐색
    else {
      end = mid - 1;
    }
  }
  return result;
};

console.log(binarySearch(arr, m, start, end));
