const fs = require('fs');
const filePath =
  process.platform === 'linux' ? '/dev/stdin' : __dirname + '/test.txt';
const input = fs.readFileSync(filePath).toString().trim().split('\n');

const n = +input[0];
const distances = input[1].split(' ').map(Number);
const prices = input[2].split(' ').map(Number);

const solution = (n, distances, prices) => {
  let cost = 0;
  let cheapest = prices[0];

  for (let i = 0; i < n - 1; i++) {
    if (prices[i] < cheapest) {
      cheapest = prices[i];
    }
    cost += cheapest * distances[i];
  }
  return cost;
};

console.log(solution(n, distances, prices));
