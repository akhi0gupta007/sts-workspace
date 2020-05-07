let users = [
    {name:'Akhilesh'},
    {name:'Abhishek'},
    {name:'Aditi'}
]

const akhilesh = users.find(
    user => user.name ==='Akhilesh'
);
console.log(akhilesh);
