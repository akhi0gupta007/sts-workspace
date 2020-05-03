const arr = [1, 2, 3, 45, 6, 7,8];

arr.forEach(
    (elm) => {
        console.log(elm);
    }
);

//filters
const newArr = arr.filter((elm) => elm % 2 === 0);
//console.log(newArr);

const newArr1 = arr.map((elm) => elm * elm);
//console.log(newArr1);
console.log(arr);
const sum = arr.reduce(
    (num1,num2) => {
        console.log(num1,num2);
        return num1+num2;
    }
);

console.log(`Sum is ${sum}`);