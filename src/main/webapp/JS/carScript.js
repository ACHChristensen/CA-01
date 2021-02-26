let URL = "http://localhost:8080/ca01/api/car/getall"
//let URL = "https://achc.dk/CA-01/api/car/getall" //Når vi aflevere
let carArray = [];

var data = fetch(URL)
        .then((res) => res.json())
        .then(cars => {
            const tableRows = cars.map(car => {
                const row = `<tr>
                                            <td>${car.id} </td> 
                                            <td>${car.produced} </td> 
                                            <td>${car.make} </td> 
                                            <td>${car.model} </td>
                                            <td>${car.price} </td>
                                           <tr/> `
                return row;
            })
            const rowsAsStr = tableRows.join("");
            document.getElementById("table-rows2").innerHTML = rowsAsStr;
            carsArray = [...cars];
            //HER og KUN her kan jeg bruge data
        });


var inputField = document.getElementById("sortingInput");
var sortByYear = document.getElementById("SortByYear");
//console.log(fetch(URL));
sortByYear.onclick = function () {
    var theYear = inputField.value;
    carsFiltered = carsArray.filter(car => car.produced == theYear);
//    console.log(carsFIltered);
//    carsFiltered = carsFiltered.map(car => "<tr><td>" + car.id + "</td><td>" + car.year + "</td><td>" + car.make + "</td><td>" + car.model + "</td><td>" + car.price + "</td></tr>").join("")
    console.log(carsFiltered);
//    d1.innerHTML = tab1 + cart5kt + tab2
};