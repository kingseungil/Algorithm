const fs = require('fs');
const filePath = process.platform === 'linux' ? '/dev/stdin' : __dirname + '/test.txt';
const input = fs.readFileSync(filePath).toString().trim().split('\n');

const [N, M] = input[0].split(' ').map(Number);
const arr = input[1]
  .split(' ')
  .map(Number)
  .sort((a, b) => a - b);

const start = 0;
const end = arr[arr.length - 1];

const panametricSearch = (arr, target, start, end) => {
  let result = 0;
  while (start <= end) {
    let mid = Math.floor((start + end) / 2);
    let sum = 0;
    for (const x of arr) {
      if (x >= mid) {
        sum += x - mid;
      }
    }
    if (sum >= target) {
      result = mid;
      start = mid + 1;
    } else {
      end = mid - 1;
    }
  }
  return result;
};

console.log(panametricSearch(arr, M, start, end));
