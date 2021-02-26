window.onload =

    function(){
    fetch("http://localhost:8080/ca-1/api/jokes/all")
        .then(res=>res.json())
        .then(data=> {
            document.getElementById("joke-table").innerHTML=makeTableRow(data);
        })}

        function makeTableRow(name){
    const list = name.map(function (name){
        return `<tr> <td>${name.id}</td> <td>${name.joke}</td> <td>${name.jokeName}</td> <td>${name.type}</td></tr>`
    })
    const tableheaders = "<tr><th>id</th><th>joke</th><th>jokeName</th><th>type</th></tr>"
    const joinedResult = list.join("");
    const finishedtable = tableheaders+joinedResult;
    return finishedtable;
}


document.getElementById("fetchJokeByID").addEventListener("click", function(e){
        let id = document.getElementById("joke-id").value;
    fetch(`api/jokes/${id}`)
        .then(res=>res.json())
        .then(data=> {
            document.getElementById("joke-p").innerText=data.joke;
        })
}
        )
function makeSingleTableRow(name){
    const list = `<tr> <td>${name.id}</td> <td>${name.joke}</td> <td>${name.jokeName}</td> <td>${name.type}</td></tr>`
    const tableheaders = "<tr><th>id</th><th>joke</th><th>jokeName</th><th>type</th></tr>"
    const finishedtable = tableheaders+list;
    return finishedtable;
}

document.getElementById("random-joke").addEventListener("click", function (e){
    fetch(`api/jokes/random`)
        .then(res=>res.json())
        .then(data=> {
            document.getElementById("table-rand").innerHTML=makeSingleTableRow(data);
        })
}
)



