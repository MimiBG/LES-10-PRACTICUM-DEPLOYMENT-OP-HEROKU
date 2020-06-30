function Calculator(event) {
	console.log("Stap 1");
	var formData = new FormData(document.querySelector("#myform"));
	var encData = new URLSearchParams(formData.entries());

	fetch("restservices/calculator/telop", { method: 'POST', body: encData })
    .then(response => response.json())
    .then(function(myJson) {
    	console.log(myJson.Resultaat);
    	document.querySelector("#result").innerHTML = myJson.Resultaat;
    });
}

document.querySelector("#send").addEventListener("click", Calculator);