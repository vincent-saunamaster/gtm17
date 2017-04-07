// récupère élément par l'id d'une balise
var titre = document.getElementById("gros_titre");
alert(titre);

// récupère tableau d'élément par le type d'une balise
var tableau = document.getElementsByTagName("p");
alert("la page contient " + tableau.length + " paragraphes");

//récupère tableau d'élément par le nom d'une class de balise
var tableau2 = document.getElementsByClassName("para");
alert("la page contient " + tableau2.length + " éléments de class para");

//récupère le premier élément fils (a) contenu dans élément parent (p)
var elt = document.querySelector("p a");
alert(elt);

//récupère le premier élément fils (a) contenu dans élément parent (p)
var tableau3 = document.querySelectorAll(".para");
alert("la page contient " + tableau3.length + " éléments de class para");