/**
 * https://www.acmicpc.net/problem/10974 (모든 순열)
 */
const fs = require('fs');
const filePath = process.platform === 'linux' ? '/dev/stdin' : __dirname + '/test.txt';
const input = fs.readFileSync(filePath).toString().trim().split('\n');

const N = +input[0];

let result = [];
let arr = Array.from({ length: N }, () => 0);
let visited = Array.from({ length: N }, () => false);

const dfs = (depth) => {
  if (depth === N) {
    result += arr.join(' ') + '\n';
    return;
  }

  for (let i = 1; i <= N; i++) {
    if (visited[i]) continue;

    arr[depth] = i;
    visited[i] = true;
    dfs(depth + 1);
    visited[i] = false;
  }
};

dfs(0);
console.log(result.trim());
