/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


let girls = ["janne","hanne", "sanne"];

let boys = ["peter","lars", "ole"];

let all = [];



showGirls();
showBoys();
showAll();

function showGirls(){
    
    let girlstr = '<ul>';

    girls.forEach(function(girl) {
        girlstr +='<li>' + girl + '</li>';
    });

    girlstr += '</ul>';
    console.log(girlstr);
    document.getElementById("girlcontainer").innerHTML = girlstr;
    console.log(document.getElementById("girlcontainer"));
}


function showBoys(){
    
    let boystr = '';

    boys.forEach(function(boy) {
        boystr +='<li>' + boy + '</li>';
        //document.getElementById(boycontainer).innerHTML
    });

    //boystr += '</ul>';
    document.getElementById("boycontainer").innerHTML = boystr;
}


function showAll(){
    all = [...girls,...boys];
    let allstr = '<ul>';

    all.forEach(function(person) {
        allstr +='<li>' + person + '</li>';
    });

    allstr += '</ul>';
    document.getElementById("allcontainer").innerHTML = allstr;

}

document.getElementById('addboy').addEventListener("click", addBoy);
document.getElementById('addgirl').addEventListener("click", addGirl);

function addGirl(){
    girls.push(document.getElementById('girlstring').value);
    //opdater udskrift
    showGirls();
    showAll();
    
}
function addBoy(){
    boys.push(document.getElementById('boystring').value);
    showBoys();
    showAll();
}