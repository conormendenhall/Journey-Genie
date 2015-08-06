 var j = 0;
    var itemsArray = new Array();
    var token = "";
    function onSignIn(googleUser) {
    	  var profile = googleUser.getBasicProfile();
    	  console.log('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.
    	  console.log('Name: ' + profile.getName());
    	  console.log('Image URL: ' + profile.getImageUrl());
    	  console.log('Email: ' + profile.getEmail());
    	  token = profile.getEmail();
    	}
    
      function addItem() {
	    console.log("cheesecake");
	    $('#addedItems').append("<li id='" + j + "'><div id='" + j + "name'>" + document.getElementById('currentValue').value + "</div><input class='quantity' type='number' value='1'><button onclick='removeItem($(this), 'addedItems')'>Remove</button>" + "<input type='checkbox'>" + "</li>");
	    j++;
	    itemsArray.push({name: document.getElementById('currentValue').value, quantity: 1});
	document.getElementById('currentValue').value = '';
}

function removeItem(thing, location)
{
	var attribute = thing.parent().attr("id");
 	attribute += "name";
 	attribute = "#" + attribute;
 	var parentSelector = "#" + location; 
 	var itemFound = $('parentSelector').find('attribute').text();
	console.log(itemFound);
	var indexes = $.map(itemsArray, function(obj, index) {
	    if(obj.name == itemFound) {
	        return index;
	    }
	})
	console.log(indexes);
	itemsArray.splice(indexes, 1);
	console.log(itemsArray);
	thing.parent().remove();
	
}

	function findAddress() {
		var location = document.getElementById('location').value;
		console.log(document.getElementById('startdatepicker').value);
		var seconds = new Date().getTime() / 86400000;
		var today = new Date();
		var startDate = new Date(document.getElementById('startdatepicker').value);
		var endDate = new Date(document.getElementById('enddatepicker').value);
		today.setHours(0);
		today.setMinutes(0);
		today.setSeconds(0);
		console.log(startDate);
		console.log(today);
		startDate = startDate.getTime() - today.getTime();
		startDate = Math.ceil(startDate / 86400000);
		console.log(startDate);
		endDate = endDate.getTime() - today.getTime();
		endDate = Math.ceil(endDate / 86400000);
		console.log(endDate);
		
		$.ajax({
			type : "POST",
			url : "APIKey",
			data : {
				"locationRequest" : location.replace(/ /g, ''), "startDate" : startDate, "endDate" : endDate, "token": token, "action" : "add"
			},
			dataType : "json",

			success : function(data) {
				$('#itemList').empty();
				$.each(data.items, function(i, value) {
				$('#itemList').append("<li id='" + i + "'><div id='" + i + "name'>" + this.name + "</div><input class='quantity' type='number' value='" + this.quantity + "'><button onclick=\"removeItem($(this), 'itemList')\">Remove</button>" + "<input type='checkbox'>" + "</li>");
				itemsArray.push({name: this.name, quantity: this.quantity});
				});
				$('#addAnItem').show();
				$('#forecast').show();
				$('#dt').empty();
				$('#min').empty();
				$('#max').empty();
				$('#id').empty();
				$('#desc').empty();
				$('#icon').empty();
				$('#city').empty();
			 	
				console.log(itemsArray);
				$('#city').append("Location: " + data.weatherInfoObject.city.name + " , " + data.weatherInfoObject.city.country + "<br>");
				
				for (i = data.startDate; i <= data.endDate; i++) { 
				$('#dt').append("<th>" + data.weatherInfoObject.list[i].dt + "</th>");
				$('#min').append("<td>" + data.weatherInfoObject.list[i].temp.min + "°F" + "</td>");
				$('#max').append("<td>" + data.weatherInfoObject.list[i].temp.max + "°F"+ "</td>");
				$('#desc').append("<td>" + data.weatherInfoObject.list[i].weather[0].description + "</td>");
				$('#icon').append("<td>" + data.weatherInfoObject.list[i].weather[0].icon + "</td>");
				}	
			}
		});
	}
	
	function saveItems()
	{
		var sendItemsList = JSON.stringify(itemsArray);
		$.ajax({
			type : "POST",
			url : "APIKey",
			data : {
				"itemsArray" : sendItemsList, "action" : "save", "token" : token
			},
			dataType : "json",

			success : function(data) {
				}
		});
	}
  $(document).ready(function() {
    $("#startdatepicker").datepicker({
    	  minDate: 0,
    	  onSelect: function(selected) {
    		$("#enddatepicker").datepicker("option", "minDate", selected);
    	  }
    });
  });
  
  $(document).ready(function() {
	    $("#enddatepicker").datepicker({ 
	    	  minDate: 0,
	    	  onSelect: function(selected) {
	    		$("#startdatepicker").datepicker("option", "maxDate", selected);
	    	  }
	    	});
	  });
  
  
  function signOut() {
	    var auth2 = gapi.auth2.getAuthInstance();
	    auth2.signOut().then(function () {
	      console.log('User signed out.');
	    });
	  }
