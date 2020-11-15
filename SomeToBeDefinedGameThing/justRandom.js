let tryMe = () => console.log('test');

//tryMe();

//(() => console.log('test2'))();


(() => console.log(`${tryMe()}`))();


const add = (numOne, numTwo) => numOne+numTwo;

let num1 = 2;
let num2 = 3;

console.log(add(num1, num2));

(() => console.log(`well, let's try this then ${add(num1, num2)} and that's it`))();