/**
 * https://www.acmicpc.net/problem/15649 (N과 M (1))
 */
const fs = require('fs');
const filePath = process.platform === 'linux' ? '/dev/stdin' : __dirname + '/test.txt';
const input = fs.readFileSync(filePath).toString().trim().split('\n');

const [N, M] = input[0].split(' ').map(Number);

let result = [];

const dfs = (depth, N, M) => {
  if (depth === M) {
    console.log(result.join(' '));
    return;
  }

  for (let i = 1; i <= N; i++) {
    if (result.includes(i)) continue;
    result.push(i);
    dfs(depth + 1, N, M);
    result.pop();
  }
};

dfs(0, N, M);
