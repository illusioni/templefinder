
$( document ).ready(function() {
	$("#searchButton").click(function(){
		searchAllTemples();
	});
	function searchAllTemples(){
		var searchString = $("#searchText").val().trim();
		if(searchString === "") { //if the string is empty fetch all the temples
			window.location = "/getAllTemples";
		} else { // if search string is present filter the results
			window.location = "/getTemples/"+searchString;
		}
	}
});
