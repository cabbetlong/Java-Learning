'use strict'; // must use keyword 'var' to define a variable

// Number:
console.log(12e3);
console.log(NaN); // Not a number
console.log(Infinity);
console.log(2 / 0); // Infinity
console.log(0 / 0); // NaN


// String:
console.log('abc');
console.log("123");


// Bool:
// Use triple '='(===) to compare two values
console.log(1 === 1); // false
// If types of two values are different, always return false
console.log(false === 1); // false

console.log('NaN === NaN: ', NaN === NaN); // false
console.log('isNaN(NaN): ', isNaN(NaN)); // true

// float comparison
console.log('1 / 3 === (1 - 2 / 3): ', 1 / 3 === (1 - 2 / 3)); // false
console.log('Math.abs(1 / 3 - (1 - 2 / 3)) < 0.0000001: ', Math.abs(1 / 3 - (1 - 2 / 3)) < 0.0000001); // true


// Array:
console.log('This is an array: ', [1, 2, 3.14, 'Hello', null, true]);


// Object:
var person = {
    name: 'Cabbet',
    age: 15,
    hobbies: ['Singing', 'Reading'],
    hasCar: true
}
console.log(person)


// Variable 
var $a = 1; // $a is a legal variable name