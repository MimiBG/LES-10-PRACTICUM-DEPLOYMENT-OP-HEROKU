function registerFunc(){
	console.log("JS registerFunc Entered!");
	var formData = new FormData(document.querySelector("#maakCharityAcocount"));
    var encData = new URLSearchParams(formData.entries());
    
    fetch("restservices/register", { method: 'POST', body: encData })
    .then(response => response.json())
    .then(function (myJson) { console.log(myJson); });
}

document.querySelector("#maakAccount").addEventListener("click", registerFunc);

function loginFunc(){
	console.log("JS loginFunc Entered!");
	var formData = new FormData(document.querySelector("#loginForm"));
	var encData = new URLSearchParams(formData.entries());
	
	fetch("restservices/authentication", { method: 'POST', body: encData })
		.then(response => response.json())
		.then(function (myJson) { console.log(myJson); });
}

document.querySelector("#login").addEventListener("click", loginFunc);