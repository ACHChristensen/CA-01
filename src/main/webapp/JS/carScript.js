let URL = "http://localhost:8080/ca01/api/car/getall"
//let URL = "https://achc.dk/CA-01/api/car/getall" //Når vi aflevere

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
                

                //HER og KUN her kan jeg bruge data
            });