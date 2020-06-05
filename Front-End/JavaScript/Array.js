'use strict';

var arr = [1, 2, 3, 'a', 'b', 'c'];

console.log(arr.indexOf('a')); // 3

console.log(arr.slice(0, 3)); // [1, 2, 3]

arr.push(4, 'd');
console.log(arr); // [1, 2, 3, 'a', 'b', 'c', 4, 'd']

var a = arr.pop();
console.log(a); // d
a = arr.pop();
console.log(a); // 4
console.log(arr); // [1, 2, 3, 'a', 'b', 'c']

arr.unshift(-2, -1, 0);
console.log(arr); // [-2, -1, 0, 1, 2, 3, 'a', 'b', 'c']
a = arr.shift();
console.log(a); // -2
console.log(arr) // [-1, 0, 1, 2, 3, 'a', 'b', 'c']

arr = [2, 6, 'a', 1, 4]
arr.sort()
console.log(arr) // [ 1, 2, 4, 6, 'a' ]

arr.reverse();
console.log(arr); // [ 'a', 6, 4, 2, 1 ]

var arr1 = arr.splice(1, 2, 'b', 'c', 'd');
console.log(arr, arr1); // [ 'a', 'b', 'c', 'd', 2, 1 ] [6, 4]

// only insert elements, do not delete
arr.splice(2, 0, 9);
console.log(arr); // [ 'a', 'b', 9, 'c', 'd', 2, 1 ]

// only delete elements
arr1 = arr.splice(2, 3);
console.log(arr, arr1); // [ 'a', 'b', 2, 1 ] [9, 'c', 'd']

var added = [1, 2, 3].concat(['a', 'b', 'c']);
console.log(added); // [1, 2, 3, 'a', 'b', 'c']

console.log(added.join('-')); // 1-2-3-a-b-c