//map returns new object istead of mutating it
let num = [1, 2, 3, 4];

let result = num.map((elm) => {
  return elm * 2; //returning is important
});

console.log(result); //new object

//Alternative single liner
result = num.map((elm) => elm * 3);

console.log(result);

var cars = [
  { model: "Maruti", price: "CHEAP", quantity: 10 },
  { model: "VOLKSWAGEN", price: "expensive", quantity: 3 },
  { model: "TATA", price: "CHEAP", quantity: 0 },
];

var prices = cars.map((car) => car.price);
console.log(prices);

const cheapCars = cars.filter((car) => car.price === "CHEAP");
console.log("Cheap cars", cheapCars);

//using mmultiple filters

const cheapAndAvailable = cars.filter( car => car.quantity > 0 && car.price==='CHEAP');

console.log("Cheap cars and in stock", cheapAndAvailable);

