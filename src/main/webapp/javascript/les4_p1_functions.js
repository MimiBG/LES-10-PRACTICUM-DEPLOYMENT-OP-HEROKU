var textField2;
function myIntervalFunction() {
	var textField = document.querySelector("#text").value;
	if (textField != textField2) {
		textField2 = document.querySelector("#text").value;
		console.log(document.querySelector("#text").value);
	} else {
		//console.log("Tekst isn't changed!!");
	}
}

var intervalID = setInterval(myIntervalFunction, 5000);
