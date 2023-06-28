const fs = require('fs');
const filePath = process.platform === 'linux' ? '/dev/stdin' : __dirname + '/test.txt';
const input = fs.readFileSync(filePath).toString().trim().split('\n');

const [N, M] = input[0].split(' ').map(Number);

let result = [];  // 백트래킹 결과를 저장할 배열

// depth-현재 탐색 깊이, N-최대 범위, M-탐색해야 할 깊이
const dfs = (depth, N, M) => {
  // 탐색 깊이가 M과 같아지면 탐색 종료
  if (depth === M) {
    console.log(result.join(' '));  // 결과 출력, 탐색한 수들을 공백으로 연결해서 출력
    return;
  }

  // 브루트포스 탐색: 1부터 N까지 모든 수를 탐색
  for (let i = 1; i <= N; i++) {
    // 이미 탐색한 수라면 건너뛰고 다음 반복
    if (result.includes(i)) continue;
    
    // 백트래킹 수행: 현재 탐색하려는 수를 결과 배열에 추가
    result.push(i);
    dfs(depth + 1, N, M); // 깊이를 늘려서 다음 수를 탐색
    result.pop(); // 백트래킹:  다음 수를 탐색하기 전에 마지막으로 탐색한 수를 제거
  }
};

dfs(0, N, M);  // 탐색 시작
