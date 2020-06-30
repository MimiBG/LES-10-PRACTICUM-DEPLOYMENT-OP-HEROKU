//function initPage() {
//	var xhttp = new XMLHttpRequest();
//	xhttp.onreadystatechange = function() {
//		if (this.readyState == 4 && this.status == 200) {
//			var json = JSON.parse(this.responseText);
//			document.getElementById("landcode").innerHTML += "&nbsp;" + json.country;
//			document.getElementById("land").innerHTML += "&nbsp;" + json.country_name;
//			document.getElementById("regio").innerHTML += "&nbsp;" + json.region;
//			document.getElementById("stad").innerHTML += "&nbsp;" + json.city;
//			document.getElementById("postcode").innerHTML += "&nbsp;" + json.postal;
//			document.getElementById("latitude").innerHTML += "&nbsp;" + json.latitude;
//			document.getElementById("longitude").innerHTML += "&nbsp;" + json.longitude;
//			document.getElementById("ip").innerHTML +=  "&nbsp;" + json.ip;
//			showWeather(json.latitude, json.longitude, json.city);
//			var mijnPlaats = document.getElementById("stad");
//			mijnPlaats.addEventListener("click", function() {
//				showWeather(json.latitude, json.longitude, json.city);
//			    
//			  });
//		}
//	};
//	xhttp.open("GET", "https://ipapi.co/json/", true);
//	xhttp.send();
//}

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

//function showWeather(latitude, longitude, city) {
//	//console.log(JSON.parse(window.localStorage.getItem(city)));
//	//console.log(JSON.parse(window.localStorage.getItem(city)).calltimer);
//	
//	if(window.localStorage.getItem(city)==null || Date.now() - new Date(JSON.parse(window.localStorage.getItem(city)).calltimer) >= 10000 ) {
//		console.log(city + " OPGEHAALD UIT API!");
//		var xhttp = new XMLHttpRequest();
//		var key = "c4ccca13b7b4b3da9c7171ee33e9dd39";
//		xhttp.open("GET", "https://api.openweathermap.org/data/2.5/weather?lat=" + latitude + "&lon=" + longitude + "&appid=" + key, true);
//		xhttp.send();
//		
//		xhttp.onreadystatechange = function() {
//			if (this.readyState == 4 && this.status == 200) {
//				var json = JSON.parse(this.responseText);
//				var currentdate = Date.now();
//				//console.log(currentdate);
//				json.calltimer = currentdate;
//				//console.log(json.calltimer);
//				document.getElementById("temperatuur").innerHTML = "Temperatuur: " + "&nbsp;" + (json.main.temp - 273).toFixed(1) + " C";
//				document.getElementById("luchtvochtigheid").innerHTML = "Luchtvochtigheid: " + "&nbsp;" + json.main.humidity + "%";
//				document.getElementById("windsnelheid").innerHTML = "Windsnelheid: " + "&nbsp;" + json.wind.speed + " km/u";
//				function windrichting(){
//					if (json.wind.deg > 0 && json.wind.deg < 90) {
//						return "Noord-Oost";
//					}
//					else if (json.wind.deg > 90 && json.wind.deg < 180) {
//						return "Zuid-Oost";
//					} 
//					else if (json.wind.deg > 180 && json.wind.deg < 270) {
//						return "Zuid-West";
//					}
//					else if (json.wind.deg > 270 && json.wind.deg < 360) {
//						return "Noord-West";	
//					}
//					else if (json.wind.deg = 0) {
//						return "Noord";
//					}
//					else if (json.wind.deg = 90) {
//						return "Oost";
//					}
//					else if (json.wind.deg = 180) {
//						return "Zuid";
//					}
//					else if (json.wind.deg = 270) {
//						return "West";
//					}
//				}
//				document.getElementById("windrichting").innerHTML = "Windrichting: " + "&nbsp;" + windrichting();
//				var sunRiseA = new Date(json.sys.sunrise * 1000);
//				var sunSetA = new Date(json.sys.sunset* 1000);
//				sunRiseB = sunRiseA.toLocaleTimeString();
//				sunSetB = sunSetA.toLocaleTimeString();
//				document.getElementById("zonsopgang").innerHTML = "Zonsopgang: " + "&nbsp;" + sunRiseB;
//				document.getElementById("zonsondergang").innerHTML = "Zonsondergang: " + "&nbsp;" + sunSetB;
//				document.getElementById("titel2").innerHTML = "<h3>Het weer in " + city + "</h3>";
//				
//				
//				window.localStorage.setItem(city, JSON.stringify(json))
//			}
//			}} else {
//				var json = JSON.parse(window.localStorage.getItem(city));
//				
//				//console.log("existed: "+ json);
//				console.log(city + " OPGEHAALD UIT LOCALSTORAGE!");
//				document.getElementById("temperatuur").innerHTML = "Temperatuur: " + "&nbsp;" + (json.main.temp - 273).toFixed(1) + " C";
//				document.getElementById("luchtvochtigheid").innerHTML = "Luchtvochtigheid: " + "&nbsp;" + json.main.humidity + "%";
//				document.getElementById("windsnelheid").innerHTML = "Windsnelheid: " + "&nbsp;" + json.wind.speed + " km/u";
//				function windrichting(){
//					if (json.wind.deg > 0 && json.wind.deg < 90) {
//						return "Noord-Oost";
//					}
//					else if (json.wind.deg > 90 && json.wind.deg < 180) {
//						return "Zuid-Oost";
//					} 
//					else if (json.wind.deg > 180 && json.wind.deg < 270) {
//						return "Zuid-West";
//					}
//					else if (json.wind.deg > 270 && json.wind.deg < 360) {
//						return "Noord-West";
//					}
//					else if (json.wind.deg = 0) {
//						return "Noord";
//					}
//					else if (json.wind.deg = 90) {
//						return "Oost";
//					}
//					else if (json.wind.deg = 180) {
//						return "Zuid";
//					}
//					else if (json.wind.deg = 270) {
//						return "West";
//					}
//				}
//				document.getElementById("windrichting").innerHTML = "Windrichting: " + "&nbsp;" + windrichting();
//				var sunRiseA = new Date(json.sys.sunrise * 1000);
//				var sunSetA = new Date(json.sys.sunset* 1000);
//				sunRiseB = sunRiseA.toLocaleTimeString();
//				sunSetB = sunSetA.toLocaleTimeString();
//				document.getElementById("zonsopgang").innerHTML = "Zonsopgang: " + "&nbsp;" + sunRiseB;
//				document.getElementById("zonsondergang").innerHTML = "Zonsondergang: " + "&nbsp;" + sunSetB;
//				document.getElementById("titel2").innerHTML = "<h3>Het weer in " + city + "</h3>";
//			};
//	
//}

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
			 cell1.innerHTML = object.name;
			 cell2.innerHTML = object.capital;
			 cell3.innerHTML = object.region;
			 cell4.innerHTML = object.surface;
			 cell5.innerHTML = object.population;
		 }
	  });
}

//function loadCountries() {
//	var xhttp = new XMLHttpRequest();
//	xhttp.onreadystatechange = function() {
//		if (this.readyState == 4 && this.status == 200) {
//			var json = JSON.parse(this.responseText);
//			var tabel = document.getElementById("mijnTabel");
//			for (const object of json) {
//				var rij = tabel.insertRow(1);
//				rij.addEventListener("click", function() {
//					showWeather(object.latitude, object.longitude, object.capital);
//				  });
//				
//				var cell1 = rij.insertCell(0);
//				var cell2 = rij.insertCell(1);
//				var cell3 = rij.insertCell(2);
//				var cell4 = rij.insertCell(3);
//				var cell5 = rij.insertCell(4);
//				cell1.innerHTML = object.name;
//				cell2.innerHTML = object.capital;
//				cell3.innerHTML = object.region;
//				cell4.innerHTML = object.surface;
//				cell5.innerHTML = object.population;
//			}
//		}
//	};
//	xhttp.open("GET", "restservices/countries", true);
//	xhttp.send();
//}

initPage();
loadCountries();


// https://www.mkyong.com/javascript/how-to-access-json-object-in-javascript/