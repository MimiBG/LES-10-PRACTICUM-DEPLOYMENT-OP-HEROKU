var newValue2 = "";
function copy(event) {
	//console.log(event.target.textContent);
	var newValue = event.target.textContent;
	newValue2 = newValue2 + newValue;

	document.querySelector("#display").innerHTML = newValue2;
	console.log(eval(newValue2));
}

Array.prototype.forEach.call(document.querySelectorAll('button'), function(b) {
	b.addEventListener("click", copy);
});
