//fonction classique
function multiplication(/* x,y */) {
	/* return x*y; */
	return arguments[0] * arguments[1]; // liste d'arguments disponible dans
	// tableau arguments
}

// fonction anonyme = une variable fonction
var varAnonyme = function() {
	return arguments[0] * arguments[1];
}

var x = Number(prompt("chiffre x", ""));
var y = Number(prompt("chiffre y", ""));

alert(multiplication(x, y));
alert(varAnonyme(x, y));