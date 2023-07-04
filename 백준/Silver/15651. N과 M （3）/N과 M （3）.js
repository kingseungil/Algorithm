/**
 * https://www.acmicpc.net/problem/15651 (N과 M (3))
 */
const fs = require('fs');
const filePath = process.platform === 'linux' ? '/dev/stdin' : __dirname + '/test.txt';
const input = fs.readFileSync(filePath).toString().trim().split('\n');

const [N, M] = input[0].split(' ').map(Number);

let result = '';
let arr = Array.from({ length: M }, () => 0);

const dfs = (depth, N, M) => {
  if (depth === M) {
    result += arr.join(' ') + '\n';
    return;
  }

  for (let i = 1; i <= N; i++) {
    arr[depth] = i;
    dfs(depth + 1, N, M);
  }
};

dfs(0, N, M);
console.log(result);
