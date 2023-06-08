const fs = require('fs');
const filePath =
  process.platform === 'linux' ? '/dev/stdin' : __dirname + '/test.txt';
const input = fs.readFileSync(filePath).toString().trim().split('\n');
const balloons = input[1].split(' ').map(Number);

// 화살의 개수를 저장할 배열
let arrows = Array.from({ length: 1000000 }, () => 0);
// 화살의 개수
let count = 0;

// 풍선을 하나씩 확인
for (let i of balloons) {
  // 해당 위치에 화살이 있으면 화살 개수를 감소시키고 이전 위치에 화살 쏘기
  if (arrows[i]) {
    arrows[i]--;
    arrows[i - 1]++;
    // 해당 위치에 화살이 없으면 count 증가, 이전 위치에 화살 쏘기
  } else {
    count++;
    arrows[i - 1]++;
  }
}

console.log(count);
