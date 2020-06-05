'use strict';

var multi_str = `this 
is 
a 
multiple 
string.`
console.log(multi_str);

var name = 'Jack';
var age = 18;
console.log(`${name} is ${age} years old now.`)

// some functions of string
var str = 'Hello world.'
console.log(str.toUpperCase()); // HELLO WORLD.
console.log(str.toLowerCase()); // hello world.
console.log(str.indexOf('world')); // 6
console.log(str.replace('world', 'guys')); // Hello guys.
console.log(str.substring(0, 5)); // Hello
console.log(str.substring(6)); // world.
console.log(str.length); // 12