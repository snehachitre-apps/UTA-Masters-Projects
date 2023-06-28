// Put your zillow.com API key here

var username = "snehachitre";
var request = new XMLHttpRequest();
var infowindow;
//var markers=[]
var marker;
//var latitude=""
//var longitude="";
var location;

//initMap() which initiates map to a location
function initMap() {
	var initialLatLng = {lat: 32.75, lng: -97.13};
	infowindow=new google.maps.InfoWindow();
	//initialize map
	var mapDiv = document.getElementById('map');
    var map = new google.maps.Map(mapDiv, {
      center: initialLatLng,
      zoom: 17
    });	
	//Initialize a mouse click event on map which then calls reversegeocode function
    google.maps.event.addListener(map, 'click', function(event) {
 //   var latitude=event.latlng.lat();
//	var longitude=event.latlng.long();
    var location=event.latLng;
	reversegeocode(event.latLng,map);
	});
	


function reversegeocode(location,map) {
    
	if (!marker) {
	//marker.setPosition(location)
	
    marker = new google.maps.Marker({
	
    position: location,
    map: map,
	draggable: true
	
	//animation: google.maps.Animation.DROP,
 });	
    infowindow.setContent('Latitude: ' + location.lat() + '<br>Longitude: ' + location.lng());	
    infowindow.open(map,marker);
    } else {
		//var new_latlang = google.maps.LatLng(location);
		marker.setPosition(location);
		infowindow.setContent('Latitude: ' + location.lat() + '<br>Longitude: ' + location.lng());	
    infowindow.open(map,marker);
	}
//var latitude = location.lat();
  // var longitude = location.lng(); 
   
    //markers.push(marker)
    //return marker;

    

   
  //get the latitude and longitude from the mouse click and get the address.
  //call geoname api asynchronously with latitude and longitude 
  
}// end of geocodeLatLng()
	
 


function clearAllMarkers(){
	infowindow.close()
	//marker.setMap(null)
	for (var i = 0; i < markers.length; i++) {
            markers[i].setMap(null);
        }
 //       markers = [];
}
// Reserse Geocoding 



function displayResult () {
    if (request.readyState == 4) {
        var xml = request.responseXML.documentElement;
        var temperature = xml.getElementsByTagName("temperature");
	document.getElementById("output").innerHTML = value;
    }
}


function sendRequest () {
    request.onreadystatechange = displayResult;
    var lat = "";
    var lng = "";
    request.open("GET"," http://api.geonames.org/findNearByWeatherXML?lat="+lat+"&lng="+lng+"&username="+username);
    request.withCredentials = "true";
    request.send(null);
}

}