const fs = require('fs');
const filePath = process.platform === 'linux' ? '/dev/stdin' : __dirname + '/test.txt';
const input = fs.readFileSync(filePath).toString().trim().split('\n');
const distances = input[1].split(' ').map(Number);
const prices = input[2].split(' ').map(Number);

// 각 도시의 기름값을 최소 기름값으로 업데이트
const updatedPrices = prices.reduce((acc, price, i) => {
  const minPrice = i === 0 ? price : Math.min(price, acc[i - 1]);
  return [...acc, minPrice];
}, []);

// 거리 * 기름값을 BigInt로 계산
const calculateCost = (distances, prices) => {
  return distances.reduce((acc, distance, i) => {
    const currentCost = BigInt(distance) * BigInt(prices[i]);
    return acc + currentCost;
  }, BigInt(0));
};

const cost = calculateCost(distances, updatedPrices);
console.log(String(cost)); // BigInt는 뒤에 n이 붙으므로 String으로 변환