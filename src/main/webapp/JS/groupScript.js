let URL = "http://localhost:8080/ca01/api/groupmember/getall"
//let URL = "https://achc.dk/CA-01/api/groupmember/getall" //Når vi aflevere

const getAllMembersBtn = document.getElementById("fetchMembs")

getAllMembersBtn.onclick = getAll;



function getAll() {
    var data = fetch(URL)
            .then((res) => res.json())
            .then(groupMembers => {
                const tableRows = groupMembers.map(memb => {
                    const row = `<tr>
                                            <td>${memb.name} </td> 
                                            <td>${memb.studentID} </td> 
                                            <td>${memb.favoriteShow} </td> 
                                           <tr/> `
                    return row;
                })
                const rowsAsStr = tableRows.join("");
                document.getElementById("table-rows").innerHTML = rowsAsStr
                return "Seje Reje"

                //HER og KUN her kan jeg bruge data
            })};

         