```javascript
functionanagrams(first,second) {
  if (first.length !==second.length) {
    return false;
  }
  const lookup = {};

//첫번째 문자열 루프
for (let i = 0; i <first.length; i++) {
    let letter =first[i];
// if letter exists, increment, otherwise set to 1
lookup[letter] ? (lookup[letter] += 1) : (lookup[letter] = 1);
  }
console.log(lookup);

//두번째 문자열 루프
for (let i = 0; i <second.length; i++) {
    let letter =second[i];
// can't find letter or letter is zero then it's not an anagram
if (!lookup[letter]) {
      return false;
    } else {
      lookup[letter] -= 1;
    }
  }
  return true;
}

console.log(anagrams("anagram", "nagaram"));

// tip!! for문을 중첩하지 않고 두개의 for문을 만들어서 O(n)으로 해결
```
