function initPage() {
	fetch("https://ipapi.co/json/")
	.then(response => response.json())
	.then(function(myJson) {
		document.getElementById("landcode").innerHTML += "&nbsp;" + myJson.country;
		document.getElementById("land").innerHTML += "&nbsp;" + myJson.country_name;
		document.getElementById("regio").innerHTML += "&nbsp;" + myJson.region;
		document.getElementById("stad").innerHTML += "&nbsp;" + myJson.city;
		document.getElementById("postcode").innerHTML += "&nbsp;" + myJson.postal;
		document.getElementById("latitude").innerHTML += "&nbsp;" + myJson.latitude;
		document.getElementById("longitude").innerHTML += "&nbsp;" + myJson.longitude;
		document.getElementById("ip").innerHTML +=  "&nbsp;" + myJson.ip;
		showWeather(myJson.latitude, myJson.longitude, myJson.city);
		var mijnPlaats = document.getElementById("stad");
		mijnPlaats.addEventListener("click", function() {
		showWeather(myJson.latitude, myJson.longitude, myJson.city);  
		  });
	});
}

function showWeather(latitude, longitude, city) {
	if(window.localStorage.getItem(city)==null || Date.now() - new Date(JSON.parse(window.localStorage.getItem(city)).calltimer) >= 10000 ) {
		console.log(city + " OPGEHAALD UIT API!");
		fetch("https://api.openweathermap.org/data/2.5/weather?lat=" + latitude + "&lon=" + longitude + "&appid=c4ccca13b7b4b3da9c7171ee33e9dd39")
		.then(response => response.json())
		.then(function(json) {
			var currentdate = Date.now();
			json.calltimer = currentdate;
			document.getElementById("temperatuur").innerHTML = "Temperatuur: " + "&nbsp;" + (json.main.temp - 273).toFixed(1) + " C";
			document.getElementById("luchtvochtigheid").innerHTML = "Luchtvochtigheid: " + "&nbsp;" + json.main.humidity + "%";
			document.getElementById("windsnelheid").innerHTML = "Windsnelheid: " + "&nbsp;" + json.wind.speed + " km/u";
			function windrichting(){
				if (json.wind.deg > 0 && json.wind.deg < 90) {
					return "Noord-Oost";
				}
				else if (json.wind.deg > 90 && json.wind.deg < 180) {
					return "Zuid-Oost";
				} 
				else if (json.wind.deg > 180 && json.wind.deg < 270) {
					return "Zuid-West";
				}
				else if (json.wind.deg > 270 && json.wind.deg < 360) {
					return "Noord-West";	
				}
				else if (json.wind.deg = 0) {
					return "Noord";
				}
				else if (json.wind.deg = 90) {
					return "Oost";
				}
				else if (json.wind.deg = 180) {
					return "Zuid";
				}
				else if (json.wind.deg = 270) {
					return "West";
				}
			}
			document.getElementById("windrichting").innerHTML = "Windrichting: " + "&nbsp;" + windrichting();
			var sunRiseA = new Date(json.sys.sunrise * 1000);
			var sunSetA = new Date(json.sys.sunset* 1000);
			sunRiseB = sunRiseA.toLocaleTimeString();
			sunSetB = sunSetA.toLocaleTimeString();
			document.getElementById("zonsopgang").innerHTML = "Zonsopgang: " + "&nbsp;" + sunRiseB;
			document.getElementById("zonsondergang").innerHTML = "Zonsondergang: " + "&nbsp;" + sunSetB;
			document.getElementById("titel2").innerHTML = "<h3>Het weer in " + city + "</h3>";
			window.localStorage.setItem(city, JSON.stringify(json))
		});
		
		
	} else {
		var json = JSON.parse(window.localStorage.getItem(city));
		
		//console.log("existed: "+ json);
		console.log(city + " OPGEHAALD UIT LOCALSTORAGE!");
		document.getElementById("temperatuur").innerHTML = "Temperatuur: " + "&nbsp;" + (json.main.temp - 273).toFixed(1) + " C";
		document.getElementById("luchtvochtigheid").innerHTML = "Luchtvochtigheid: " + "&nbsp;" + json.main.humidity + "%";
		document.getElementById("windsnelheid").innerHTML = "Windsnelheid: " + "&nbsp;" + json.wind.speed + " km/u";
		function windrichting(){
			if (json.wind.deg > 0 && json.wind.deg < 90) {
				return "Noord-Oost";
			}
			else if (json.wind.deg > 90 && json.wind.deg < 180) {
				return "Zuid-Oost";
			} 
			else if (json.wind.deg > 180 && json.wind.deg < 270) {
				return "Zuid-West";
			}
			else if (json.wind.deg > 270 && json.wind.deg < 360) {
				return "Noord-West";
			}
			else if (json.wind.deg = 0) {
				return "Noord";
			}
			else if (json.wind.deg = 90) {
				return "Oost";
			}
			else if (json.wind.deg = 180) {
				return "Zuid";
			}
			else if (json.wind.deg = 270) {
				return "West";
			}
		}
		document.getElementById("windrichting").innerHTML = "Windrichting: " + "&nbsp;" + windrichting();
		var sunRiseA = new Date(json.sys.sunrise * 1000);
		var sunSetA = new Date(json.sys.sunset* 1000);
		sunRiseB = sunRiseA.toLocaleTimeString();
		sunSetB = sunSetA.toLocaleTimeString();
		document.getElementById("zonsopgang").innerHTML = "Zonsopgang: " + "&nbsp;" + sunRiseB;
		document.getElementById("zonsondergang").innerHTML = "Zonsondergang: " + "&nbsp;" + sunSetB;
		document.getElementById("titel2").innerHTML = "<h3>Het weer in " + city + "</h3>";
		
		
	};
}




function loadCountries() {
	  fetch("restservices/countries")
	  .then(response => response.json())
	  .then(function(myJson) {
		 var tabel = document.getElementById("mijnTabel");
		 
		 
		 
		 for (const object of myJson) {
			 var rij = tabel.insertRow(1);
			 rij.addEventListener("click", function() {
				showWeather(object.latitude, object.longitude, object.capital); 
			 });
			 var cell1 = rij.insertCell(0);
			 var cell2 = rij.insertCell(1);
			 var cell3 = rij.insertCell(2);
			 var cell4 = rij.insertCell(3);
			 var cell5 = rij.insertCell(4);
			 var cell6 = rij.insertCell(5);
			 var cell7 = rij.insertCell(6);
			 cell1.innerHTML = object.name;
			 cell2.innerHTML = object.capital;
			 cell3.innerHTML = object.region;
			 cell4.innerHTML = object.surface;
			 cell5.innerHTML = object.population;
			 cell6.innerHTML = '<input id="'+ object.code + '" type="submit" value="Wijzig">';
			 cell7.innerHTML = '<input id="'+ object.code + '" type="submit" value="Verwijder">';

			 
			 var valueVerwijder = document.querySelector("div.tabelBox input[value='Verwijder']");
			 valueVerwijder.addEventListener("click", verwijderFunc);
			 
			 var valueWijzig = document.querySelector("div.tabelBox input[value='Wijzig']");
			 valueWijzig.addEventListener("click", wijzigFunc);
			 
			 
		 }
	  });
}


var voegToe = document.querySelector("#voegToe");
voegToe.addEventListener("click", addCountryFuncForm);

function addCountryFuncForm() {
	modal.style.display = "block";
	document.getElementById("wijzigGegevens").innerHTML += '<input id="countrycode" name="countrycode" type="text" value="" required>CODE*<br><br>';
	document.getElementById("wijzigGegevens").innerHTML += '<input name="iso3" type="text" value="" required>ISO3*<br><br>';
	document.getElementById("wijzigGegevens").innerHTML += '<input name="name" type="text" value="" required>NAME*<br><br>';
	document.getElementById("wijzigGegevens").innerHTML += '<input name="continent" type="text" value="" required>CONTINENT*<br><br>';
	document.getElementById("wijzigGegevens").innerHTML += '<input name="region" type="text" value="" required>REGION*<br><br>';
	document.getElementById("wijzigGegevens").innerHTML += '<input name="surface" type="number" value="" required>SURFACEAREA*<br><br>';
	document.getElementById("wijzigGegevens").innerHTML += '<input name="indepyear" type="number" value="">INDEPYEAR<br><br>';
	document.getElementById("wijzigGegevens").innerHTML += '<input name="population" type="number" value="" required>POPULATION*<br><br>';
	document.getElementById("wijzigGegevens").innerHTML += '<input name="lifeexpectancy" type="text" value="">LIFEEXPECTANCY<br><br>';
	document.getElementById("wijzigGegevens").innerHTML += '<input name="gnp" type="text" value="">GNP<br><br>';
	document.getElementById("wijzigGegevens").innerHTML += '<input name="gnpoid" type="text" value="">GNPOID<br><br>';
	document.getElementById("wijzigGegevens").innerHTML += '<input name="localname" type="text" value="" required>LOCALNAME*<br><br>';
	document.getElementById("wijzigGegevens").innerHTML += '<input name="governmentform" type="text" value="" required>GOVERNMENTFORM*<br><br>';
	document.getElementById("wijzigGegevens").innerHTML += '<input name="headofstate" type="text" value="" >HEADOFSTATE<br><br>';
	document.getElementById("wijzigGegevens").innerHTML += '<input name="latitude" type="number" value="">LATITUDE<br><br>';
	document.getElementById("wijzigGegevens").innerHTML += '<input name="longitude" type="number" value="" >LONGITUDE<br><br>';
	document.getElementById("wijzigGegevens").innerHTML += '<input name="capital" type="text" value="">CAPITAL<br><br>';
	document.getElementById("wijzigGegevens").innerHTML += '<input id="post" type="submit" value="Verzend"><br><br>';
	document.querySelector("#post").addEventListener("click", addCountryFunc);

}

var logIn = document.querySelector("#logIn");
logIn.addEventListener("click", addLoginForm);

function addLoginForm() {
	modal.style.display = "block";
	document.getElementById("wijzigGegevens").innerHTML = '<input name="username" type="text" value="" required>USERNAME<br><br>'//<input name="password" type="password" value="" required>PASSWORD<br><br><input type="submit" id="login" value="login"><br><br>';
	document.getElementById("wijzigGegevens").innerHTML += '<input name="password" type="password" value="" required>PASSWORD<br><br>';
	document.getElementById("wijzigGegevens").innerHTML += '<input type="button" id="login" value="login"><br><br>';
	document.querySelector("#login").addEventListener("click", login);

}

function login(event) {
	console.log("Stap 1");
	var formData = new FormData(document.querySelector("#wijzigGegevens"));
	var encData = new URLSearchParams(formData.entries());

	fetch("restservices/authentication", { method: 'POST', body: encData })
    .then(function(response) {
    	if (response.ok) return response.json();
    	else throw "Wrong username/password";
    	})
    	.then(myJson => window.sessionStorage.setItem("myJWT", myJson.JWT))
    	.catch(error => console.log(error));
}


function addCountryFunc() {
	var formData = new FormData(document.querySelector("#wijzigGegevens"));
    var encData = new URLSearchParams(formData.entries());
    
    fetch("restservices/countries", { method: 'POST', body: encData, headers: {'Authorization': 'Bearer ' + window.sessionStorage.getItem("myJWT")} })
    	.then(response => response.json())
    	.then(function (myJson) { console.log(myJson); });
}

var putHandler = function() {
	var id = document.getElementById("countrycode").value;
    var formData = new FormData(document.querySelector("#wijzigGegevens"));
    var encData = new URLSearchParams(formData.entries());

    fetch("restservices/countries/" + id, { method: 'PUT', body: encData, headers: {'Authorization': 'Bearer ' + window.sessionStorage.getItem("myJWT")} } )
        .then(response => response.json())
        .then(function (myJson) { console.log(myJson); })
};

function wijzigFunc(){
	modal.style.display = "block";
	console.log("Wijzig functie test! " + this.id);
	fetch("restservices/countries/" + this.id)
	.then(response => response.json())
	.then(function(myJson){
		console.log(JSON.stringify(myJson));
		document.getElementById("wijzigGegevens").innerHTML = '<input name="name" type="text" value="'+ myJson.name +  '">LAND<br><br>';
		document.getElementById("wijzigGegevens").innerHTML += '<input name="capital" type="text" value="'+ myJson.capital +  '">CAPITAL<br><br>';
		document.getElementById("wijzigGegevens").innerHTML += '<input name="region" type="text" value="'+ myJson.region +  '">REGION<br><br>';
		document.getElementById("wijzigGegevens").innerHTML += '<input name="surface" type="number" value="'+ myJson.surface +  '">SURFACE<br><br>';
		document.getElementById("wijzigGegevens").innerHTML += '<input name="population" type="number" value="'+ myJson.population +  '">POPULATION<br><br>';
		document.getElementById("wijzigGegevens").innerHTML += '<input id="countrycode" name="countrycode" type="text" value="'+ myJson.code +  '" readonly>CODE<br><br>';
		document.getElementById("wijzigGegevens").innerHTML += '<input id="put" type="submit" value="Verzend"><br><br>';
		document.querySelector("#put").addEventListener("click", putHandler);
	});
}

function verwijderFunc(){
	var id = this.id;
	fetch("restservices/countries/" + id, deleteCheck)
		.then(function (response) {
			if (response.ok)
				console.log("Country deleted!");
			else console.log("Could not delete country!");
		})
		.catch(error => console.log(error));
}

var deleteCheck = {
		method: 'DELETE',
		headers : {
		'Authorization': 'Bearer ' + window.sessionStorage.getItem("myJWT") }
		}

initPage();
loadCountries();

//Get the modal
var modal = document.getElementById('myModal');

// Get the button that opens the modal
var btn = document.getElementById("myBtn");

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

// When the user clicks on <span> (x), close the modal
span.onclick = function() {
    modal.style.display = "none";
}


// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}



