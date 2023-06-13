const fs = require('fs');
const filePath =
  process.platform === 'linux' ? '/dev/stdin' : __dirname + '/test.txt';
const input = fs.readFileSync(filePath).toString().trim().split('\n');

let [n, k] = input[0].split(' ').map(Number);

const checkBaskets = (n, k) => {
  // 최소 공 개수 계산
  const minBalls = (k * (k + 1)) / 2;
  // 바구니에 공을 나누어 담을 수 있는지 확인
  if (n < minBalls) {
    // 공을 나누어 담을 수 없는 경우
    return -1;
  } else {
    n -= minBalls; // 최소 공 개수만큼 빼줌
    return n % k === 0 ? k - 1 : k; // 나머지가 0이면 k-1, 아니면 k
  }
};

console.log(checkBaskets(n, k));
