$( document ).ready(function() {
 $("#searchButton").click(function(){
	 searchAllTemples();
 });
 function searchAllTemples(){
	 window.location = "/getAllTemples";
 }
});
