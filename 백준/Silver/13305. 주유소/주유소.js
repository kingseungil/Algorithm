const fs = require('fs');
const filePath =
  process.platform === 'linux' ? '/dev/stdin' : __dirname + '/test.txt';
const input = fs.readFileSync(filePath).toString().trim().split('\n');

const n = +input[0];
const distances = input[1].split(' ').map(Number);
const prices = input[2].split(' ').map(Number);

let minPrice = prices[0];
for (let i = 0; i < n; i++) {
  minPrice = Math.min(minPrice, prices[i]);
  prices[i] = minPrice;
}

let cost = BigInt(0);
for (let i = 0; i < n - 1; i++) {
  cost += BigInt(distances[i]) * BigInt(prices[i]);
}
console.log(String(cost));
