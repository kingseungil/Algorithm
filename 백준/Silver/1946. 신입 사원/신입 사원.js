const fs = require('fs');
const filePath =
  process.platform === 'linux' ? '/dev/stdin' : __dirname + '/test.txt';
const input = fs.readFileSync(filePath).toString().trim().split('\n');

const testCases = +input[0];
let currentTestCase = 1; // 1번째 테스트 케이스부터 시작
// 테스트 케이스만큼 반복
for (let tc = 0; tc < testCases; tc++) {
  // 각 테스트 케이스의 첫번째 줄 = 지원자의 수
  let numOfApplicants = +input[currentTestCase];
  let scores = [];
  for (
    let i = currentTestCase + 1;
    i <= currentTestCase + numOfApplicants;
    i++
  ) {
    // 각 지원자의 서류심사 성적, 면접 성적 push
    let data = input[i].split(' ').map(Number);
    scores.push(data);
  }
  // 서류심사 성적을 기준으로 오름차순 정렬
  scores.sort((a, b) => a[0] - b[0]);
  let count = 0;
  let minValue = Number.MAX_VALUE; // 면접 성적의 최솟값
  // 면접 성적의 최솟값보다 작은 값이 나오면 count + 1, minValue 갱신
  for (let [_, y] of scores) {
    if (y < minValue) {
      minValue = y;
      count = count + 1;
    }
  }
  console.log(count);
  currentTestCase += numOfApplicants + 1; // 다음 테스트 케이스의 첫번째 줄
}
