/**
 * https://www.acmicpc.net/problem/10974 (모든 순열)
 */
const fs = require('fs');
const filePath = process.platform === 'linux' ? '/dev/stdin' : __dirname + '/test.txt';
const input = fs.readFileSync(filePath).toString().trim().split('\n');

const N = +input[0];

let result = [];

const dfs = (depth) => {
  if (depth === N) {
    console.log(result.join(' '));
    return;
  }

  for (let i = 1; i <= N; i++) {
    if (result.includes(i)) continue;

    result.push(i);
    dfs(depth + 1);
    result.pop();
  }
};

dfs(0);
