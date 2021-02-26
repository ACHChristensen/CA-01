let URL = "http://localhost:8080/ca01/api/car/getall"
//let URL = "https://achc.dk/CA-01/api/car/getall" //Når vi aflevere
let carsArray = [];

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


let inputField = document.getElementById("sortingInput");
let searchByInput = document.getElementById("search");
let sortByInput = document.getElementById("sort");
//console.log(fetch(URL));

sortByInput.onclick = function(){
    carsArray.sort();
}

searchByInput.onclick = function () {
    let carsFilteredTotal = [];
//    const mySet1 = new Set();
    let input = inputField.value;
    
    if (document.getElementById("year").checked) {
        let carsFilteredByYear = carsArray.filter(car => car.produced.toString().includes(input));
        carsFilteredTotal = carsFilteredTotal.concat(carsFilteredByYear);
        console.log(carsFilteredByYear);
        //let i;
//        for (i = 0; i < carsFilteredTotal.length - 1; i++) {
//            mySet1.add(carsFilteredTotal[i]);
//        }
    }
    if (document.getElementById("idsearch").checked) {
        let carsFilteredByID = carsArray.filter(car => car.id.toString().includes(input));
        carsFilteredTotal = carsFilteredTotal.concat(carsFilteredByID);
        console.log(carsFilteredByID);
        //let i;
//        for (i = 0; i < carsFilteredTotal.length - 1; i++) {
//            mySet1.add(carsFilteredTotal[i]);
//        }
    }
    if (document.getElementById("price").checked) {
        let carsFilteredByPrice = carsArray.filter(car => car.price.toString().includes(input));
        carsFilteredTotal = carsFilteredTotal.concat(carsFilteredByPrice);
        console.log(carsFilteredByPrice);
        //let i;
//        for (i = 0; i < carsFilteredTotal.length - 1; i++) {
//            mySet1.add(carsFilteredTotal[i]);
//        }
    }

    carsArray.length=0;
$.each(carsFilteredTotal, function(i, el){
    if($.inArray(el, carsArray) === -1) carsArray.push(el);
});

//let totalCars = Array.from(mySet1);
    // Set [ 1 ]

    // if(inputYear != null){

//    console.log(carsFIltered);
//    carsFiltered = carsFiltered.map(car => "<tr><td>" + car.id + "</td><td>" + car.year + "</td><td>" + car.make + "</td><td>" + car.model + "</td><td>" + car.price + "</td></tr>").join("")
    //console.log(carsFiltered);
    carsFilter(carsArray);
//    d1.innerHTML = tab1 + cart5kt + tab2
    //} 
};

function carsFilter(cars) {
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
}
;
