


let girls = ["janne","hanne", "sanne"];

let boys = ["peter","lars", "ole"];

let all = [...girls,...boys];



showGirls();
showBoys();
showAll();
document.getElementById('deletelast').checked = true;

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
    
    all = [...girls,...boys];
    showGirls();
    showAll();
    
}
function addBoy(){
    boys.push(document.getElementById('boystring').value);
    
    all = [...girls,...boys];
    showBoys();
    showAll();
}

document.getElementById('removeboy').addEventListener("click", removeBoy);
function removeBoy(){
    let order = document.getElementById('deletelast').checked;
    if (order === true) {
        boys.pop();
    }
    else{
        boys.shift();
    }
    showBoys();
    showAll();
}
document.getElementById('removegirl').addEventListener("click", removeGirl);
function removeGirl(){
    let order = document.getElementById('deletelast').checked;
    if (order === true) {
        girls.pop();
    }
    else{
        girls.shift();
    }
    showGirls();
    showAll();
}

document.getElementById('sortall').addEventListener("click", sortAll);
function sortAll(){
    all = all.sort();
    showAll();
}
document.getElementById('reverseall').addEventListener("click", reverseAll);
function reverseAll(){
    all = all.reverse();
    showAll();
}