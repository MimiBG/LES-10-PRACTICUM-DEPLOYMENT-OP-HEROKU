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
//			    //alert("Hi, " + object.name);
//			    
//			  });
//		}
//	};
//	xhttp.open("GET", "https://ipapi.co/json/", true);
//	xhttp.send();
//}


function initPage(){
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

initPage();


//function showWeather(latitude, longitude, city) {
//	var xhttp = new XMLHttpRequest();
//	xhttp.onreadystatechange = function() {
//		if (this.readyState == 4 && this.status == 200) {
//			var json = JSON.parse(this.responseText);
//			document.getElementById("temperatuur").innerHTML = "Temperatuur: " + "&nbsp;" + (json.main.temp - 273).toFixed(1);
//			document.getElementById("luchtvochtigheid").innerHTML = "Luchtvochtigheid: " + "&nbsp;" + json.main.humidity;
//			document.getElementById("windsnelheid").innerHTML = "Windsnelheid: " + "&nbsp;" + json.wind.speed;
//			function windrichting(){
//				if (json.wind.deg > 0 && json.wind.deg < 90) {
//					return "Noord-Oost";
//				}
//				else if (json.wind.deg > 90 && json.wind.deg < 180) {
//					return "Zuid-Oost";
//				} 
//				else if (json.wind.deg > 180 && json.wind.deg < 270) {
//					return "Zuid-West";
//				}
//				else if (json.wind.deg > 270 && json.wind.deg < 360) {
//					return "Noord-West";
//				}
//				else if (json.wind.deg = 0) {
//					return "Noord";
//				}
//				else if (json.wind.deg = 90) {
//					return "Oost";
//				}
//				else if (json.wind.deg = 180) {
//					return "Zuid";
//				}
//				else if (json.wind.deg = 270) {
//					return "West";
//				}
//			}
//			document.getElementById("windrichting").innerHTML = "Windrichting: " + "&nbsp;" + windrichting();
//			var sunRiseA = new Date(json.sys.sunrise * 1000);
//			var sunSetA = new Date(json.sys.sunset* 1000);
//			sunRiseB = sunRiseA.toGMTString();
//			sunSetB = sunSetA.toGMTString();
//			document.getElementById("zonsopgang").innerHTML = "Zonsopgang: " + "&nbsp;" + sunRiseB;
//			document.getElementById("zonsondergang").innerHTML = "Zonsondergang: " + "&nbsp;" + sunSetB;
//			document.getElementById("titel2").innerHTML = "&nbsp;" + "<h3>Het weer in " + city + "</h>";
//		}
//	};
//	var key = "c4ccca13b7b4b3da9c7171ee33e9dd39";
//	xhttp.open("GET", "https://api.openweathermap.org/data/2.5/weather?lat=" + latitude + "&lon=" + longitude + "&appid=" + key, true);
//	//xhttp.open("GET", "http://api.openweathermap.org/data/2.5/weather?q="+ city + "&appid=" + key, true);
//	xhttp.send();
//}

function showWeather(latitude, longitude, city) {
	  fetch("https://api.openweathermap.org/data/2.5/weather?lat=" + latitude + "&lon=" + longitude + "&appid=c4ccca13b7b4b3da9c7171ee33e9dd39")
	  .then(response => response.json())
	  .then(function(myJson) {
		  document.getElementById("temperatuur").innerHTML = "Temperatuur: " + "&nbsp;" + (myJson.main.temp - 273).toFixed(1);
		  document.getElementById("luchtvochtigheid").innerHTML = "Luchtvochtigheid: " + "&nbsp;" + myJson.main.humidity;
		  document.getElementById("windsnelheid").innerHTML = "Windsnelheid: " + "&nbsp;" + myJson.wind.speed;
		  function windrichting(){
				if (myJson.wind.deg > 0 && myJson.wind.deg < 90) {
					return "Noord-Oost";
				}
				else if (myJson.wind.deg > 90 && myJson.wind.deg < 180) {
					return "Zuid-Oost";
				} 
				else if (myJson.wind.deg > 180 && myJson.wind.deg < 270) {
					return "Zuid-West";
				}
				else if (myJson.wind.deg > 270 && myJson.wind.deg < 360) {
					return "Noord-West";
				}
				else if (myJson.wind.deg = 0) {
					return "Noord";
				}
				else if (myJson.wind.deg = 90) {
					return "Oost";
				}
				else if (myJson.wind.deg = 180) {
					return "Zuid";
				}
				else if (myJson.wind.deg = 270) {
					return "West";
				}
			}
		  document.getElementById("windrichting").innerHTML = "Windrichting: " + "&nbsp;" + windrichting();
		  var sunRiseA = new Date(myJson.sys.sunrise * 1000);
		  var sunSetA = new Date(myJson.sys.sunset* 1000);
		  sunRiseB = sunRiseA.toGMTString();
		  sunSetB = sunSetA.toGMTString();
		  document.getElementById("zonsopgang").innerHTML = "Zonsopgang: " + "&nbsp;" + sunRiseB;
		  document.getElementById("zonsondergang").innerHTML = "Zonsondergang: " + "&nbsp;" + sunSetB;
		  document.getElementById("titel2").innerHTML = "&nbsp;" + "<h3>Het weer in " + city + "</h>";
	  });
}


//function loadCountries() {
//	var xhttp = new XMLHttpRequest();
//	xhttp.onreadystatechange = function() {
//		if (this.readyState == 4 && this.status == 200) {
//			var json = JSON.parse(this.responseText);
//			var tabel = document.getElementById("mijnTabel");
////			for (var i=0; i < json.length ; i++){
////				var rij = tabel.insertRow(i+1);
////				var cell1 = rij.insertCell(0);
////				var cell2 = rij.insertCell(1);
////				var cell3 = rij.insertCell(2);
////				var cell4 = rij.insertCell(3);
////				var cell5 = rij.insertCell(4);
////				cell1.innerHTML = json[i].name;
////				cell2.innerHTML = json[i].capital;
////				cell3.innerHTML = json[i].region;
////				cell4.innerHTML = json[i].surface;
////				cell5.innerHTML = json[i].population;
////			}
//			
//			for (const object of json) {
//				var rij = tabel.insertRow(1);
//				rij.addEventListener("click", function() {
//					showWeather(object.latitude, object.longitude, object.capital);
//				    //alert("Hi, " + object.name);
//				    
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

loadCountries();

// https://www.mkyong.com/javascript/how-to-access-json-object-in-javascript/