let fs = require('fs')
let input = fs.readFileSync('/dev/stdin').toString().trim().split('\n')

const N = +input[0]

let resultCount = 0

// 그룹 단어인지 체크하는 함수
function check(data) {
  let set = new Set(data[0])
  for (let i = 0; i < data.length - 1; i++) {
    // 오른쪽 단어와 다르면
    if (data[i] != data[i + 1]) {
      // 중복이라면
      if (set.has(data[i + 1])) {
        return false
      } else {
        // 중복이 아니면 추가
        set.add(data[i + 1])
      }
    }
  }
  return true
}

for (let i = 1; i <= N; i++) {
  let data = input[i]
  if (check(data)) {
    resultCount += 1
  }
}

console.log(resultCount);