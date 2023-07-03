/**
 * https://www.acmicpc.net/problem/15650 (N과 M (2))
 */
const fs = require('fs');
const filePath = process.platform === 'linux' ? '/dev/stdin' : __dirname + '/test.txt';
const input = fs.readFileSync(filePath).toString().trim().split('\n');

const [N, M] = input[0].split(' ').map(Number);

let result = [];
let arr = Array.from({ length: M }, () => 0);
let visited = Array.from({ length: M }, () => false);
let startNum = Array.from({ length: M }, () => 1);

const dfs = (depth, N, M) => {
  if (depth === M) {
    result += arr.join(' ') + '\n';
    return;
  }

  for (let i = startNum[depth]; i <= N; i++) {
    if (visited[i]) continue;

    arr[depth] = i;
    visited[i] = true;

    if (depth !== M - 1) {
      startNum[depth + 1] = i + 1;
    }

    dfs(depth + 1, N, M);
    visited[i] = false;
  }
};

dfs(0, N, M);
console.log(result);
