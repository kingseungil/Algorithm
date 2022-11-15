function getDigit(num,i) {
  return Math.floor(Math.abs(num) / Math.pow(10,i)) % 10;
}

console.log(getDigit(7323, 2)); // 3

function digitCount(num) {
  if (num=== 0) return 1;
  return Math.floor(Math.log10(Math.abs(num))) + 1;
}

console.log(digitCount(21388)); // 5

function mostDigits(nums) {
  let maxDigits = 0;
  for (let i = 0; i <nums.length; i++) {
    maxDigits = Math.max(maxDigits,digitCount(nums[i]));
  }
  return maxDigits; 
}

console.log(mostDigits([1, 22, 333, 4444])); // 4
