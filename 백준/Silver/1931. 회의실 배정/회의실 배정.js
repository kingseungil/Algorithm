const fs = require('fs');
const filePath =
  process.platform === 'linux' ? '/dev/stdin' : __dirname + '/test.txt';
const input = fs.readFileSync(filePath).toString().trim().split('\n');

const n = +input[0];

let arr = [];
for (let i = 1; i <= n; i++) {
  const [start, end] = input[i].split(' ').map(Number);
  arr.push([start, end]);
}

// 시작 시간과 끝나는 시간이 작은 회의 순으로 정렬
// 끝나는 시간이 같은 경우, 시작 시간이 빠른 회의 순으로 정렬
const sortArray = (a, b) => {
  if (a[1] === b[1]) {
    return a[0] - b[0];
  }
  return a[1] - b[1];
};

arr.sort(sortArray);

let count = 0;
let endTime = 0;
for (let i in arr) {
  const [start, end] = arr[i];
  if (start >= endTime) {
    count += 1;
    endTime = end;
  }
}

console.log(count);
