/**
 * i와 j라는 포인터를 두어 (j의 index가 1이 더 큰 상태로)
 * arr[i], arr[j]가 같지 않으면 i가 j를 따라가는 형태
 * arr[i]값을 arr[j]값으로 바꿔주면서 따라가기 때문에
 * 마지막엔 arr[i]값의 index에 1을 더해주면 개수가 나오게된다.
*/

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
