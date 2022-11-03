function countUniqueValues(arr) {
  if (arr.length === 0) {
    return 0;
  }
  let i = 0;
  for (let j = 1; j < arr.length; j++) {
    // 루프 내에서 i 배열과 j 배열의 각 index를 비교
    if (arr[i] !== arr[j]) {
      i++; // j는 for문에 의해 자동으로 증가
      arr[i] = arr[j];
    }
    console.log(i, j);
  }
  return i + 1; // i는 인덱스이기때문에 1을 더해줘야 개수가 나온다.
}
