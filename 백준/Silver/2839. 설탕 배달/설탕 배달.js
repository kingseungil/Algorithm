const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
// const input = fs.readFileSync('test.txt').toString().trim().split('\n');

let N = +input[0];

let minBags = Infinity; // 최소 봉지 개수
let valid = false; // 유효한 조합 여부

// 5kg 봉지의 최대 개수부터 시작해서 0개까지 반복
for (let i = Math.floor(N / 5); i >= 0; i--) {
  // 남은 무게를 3kg 봉지로 나누어보기
  let remain = N - i * 5;
  // 남은 무게가 3kg 봉지로 딱 나누어 떨어지면
  if (remain % 3 === 0) {
    // 유효한 조합이라고 표시
    valid = true;
    // 3kg 봉지의 개수 구하기
    let j = remain / 3;
    // 현재 최소 봉지 개수와 비교해서 작으면 갱신
    minBags = Math.min(minBags, i + j);
  }
}

// 유효한 조합이 없으면 -1 출력
if (!valid) {
  console.log(-1);
} else {
  // 최소 봉지 개수 출력
  console.log(minBags);
}
