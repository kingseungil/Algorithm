// 매우 비효율적
// function bubbleSort(arr) {
//   for (let i = 0; i < arr.length; i++) {
//     for (let j = 0; j < arr.length; j++) {
//       console.log(arr, arr[j], arr[j + 1]);
//       if (arr[j] > arr[j + 1]) {
//         // SWAP!
//         let temp = arr[j];
//         arr[j] = arr[j + 1];
//         arr[j + 1] = temp;
//       }
//     }
//   }
//   return arr;
// }

// ES5
// function bubbleSort(arr) {
//   for (let i = arr.length; i > 0; i--) {
//     for (let j = 0; j < i - 1; j++) {
//       console.log(arr, arr[j], arr[j + 1]);
//       if (arr[j] > arr[j + 1]) {
//         // SWAP!
//         let temp = arr[j];
//         arr[j] = arr[j + 1];
//         arr[j + 1] = temp;
//       }
//     }
//     console.log("ONE PASS COMPLETE!");
//   }
//   return arr;
// }

// ES2015
function bubbleSort(arr) {
  const swap = (arr,idx1,idx2) => {
    [arr[idx1],arr[idx2]] = [arr[idx2],arr[idx1]];
  };
  for (let i = arr.length; i > 0; i--) {
    for (let j = 0; j < i - 1; j++) {
      console.log(arr,arr[j],arr[j + 1]);
      if (arr[j] >arr[j + 1]) {
      // SWAP!
         swap(arr, j, j + 1);
      }
    }
   console.log("ONE PASS COMPLETE!");
  }
  return arr;
}
console.log(bubbleSort([37, 45, 29, 8, -3]));
