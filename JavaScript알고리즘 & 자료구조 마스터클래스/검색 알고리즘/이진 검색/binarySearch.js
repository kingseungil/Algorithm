// Big O => log(n)
// 정렬이 돼있어야 사용 가능!
function binarySearch(arr,elem) {
  let start = 0;
  let end =arr.length - 1;
  let middle = Math.floor((start + end) / 2);
  while (arr[middle] !==elem&& start <= end) {
		console.log(start, middle, end);
    if (elem<arr[middle]) {
      end = middle - 1;
    } else {
      start = middle + 1;
    }
    middle = Math.floor((start + end) / 2);
  }
	console.log(start, middle, end);
  returnarr[middle] ===elem? middle : -1;
	// if (arr[middle] === elem) {
  //   return middle;
  // }
  // return -1;
}

console.log(binarySearch([2, 5, 6, 9, 13, 15, 28, 30], 28));

//  0  1  2  3   4   5   6   7
// [2, 5, 6, 9, 13, 15, 28, 30]
//  S        M               E

//  0  1  2  3   4   5   6   7
// [2, 5, 6, 9, 13, 15, 28, 30]
//              S   M       F

//  0  1  2  3   4   5   6   7
// [2, 5, 6, 9, 13, 15, 28, 30]
//                     S(M)  E
