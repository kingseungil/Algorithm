//버블정렬의 문제점
//이미 정렬이 거의 다 된 배열에서 비효율적임
//정렬이 완료된 후에도 계속 루프가 돌기때문
// => noSwaps을 이용해서 최적화
// 교환을 하지 않으면 true
// 이 경우엔 O(n)

// ES5
function bubbleSort(arr) {
  let noSwaps; 
  for (let i = arr.length; i > 0; i--) {
    noSwaps = true;
    for (let j = 0; j < i - 1; j++) {
      console.log(arr,arr[j],arr[j + 1]);
      if (arr[j] >arr[j + 1]) {
        // SWAP!
	let temp =arr[j];
	arr[j] =arr[j + 1];
	arr[j + 1] = temp;
	noSwaps = false;
      }
    }
    if (noSwaps) break;
  }
  return arr;
}

console.log(bubbleSort([8, 1, 2, 3, 4, 5, 6, 7]));
