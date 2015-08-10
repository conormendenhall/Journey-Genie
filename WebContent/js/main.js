var j = 0;
var token = "";
function onSignIn(googleUser) {
  var profile = googleUser.getBasicProfile();
  console.log('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.
  console.log('Name: ' + profile.getName());
  console.log('Image URL: ' + profile.getImageUrl());
  console.log('Email: ' + profile.getEmail());
  token = profile.getEmail();
  if(token != "") {
	$('#load').show();
	if ( $('#addAnItem').css('display') != 'none' ){
		$('#save').show();
	}
  }
}
    
function addItem() {
  console.log("cheesecake");
  $('#addedItems').append("<li id='" + j + "add'><div id='" + j + "addname'>" + document.getElementById('currentValue').value + "</div><input id='" + j + "addquantity' type='number' value='1'><button onclick='removeItem($(this))'>Remove</button>" + "<input type='checkbox'>" + "</li>");
  j++;
  document.getElementById('currentValue').value = '';
}

function removeItem(thing) {
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
		url : "FrontController",
		data : {
			"locationRequest" : location.replace(/ /g, ''), "startDate" : startDate, "endDate" : endDate, "token": token, "action" : "add"
		},
		dataType : "json",

		success : function(data) {
			$('#itemList').empty();
			$.each(data.items, function(i, value) {
			$('#itemList').append("<li id='" + i + "'><div id='" + i + "name'>" + this.name + "</div><input id='" + i + "quantity' class='quantity' type='number' value='" + this.quantity + "'><button onclick=\"removeItem($(this))\">Remove</button>" + "<input type='checkbox'>" + "</li>");
			});
			$('#addAnItem').show();
			$('#forecast').show();
			if(token != "") {
				$('#save').show();
			}
			$('#dt').empty();
			$('#min').empty();
			$('#max').empty();
			$('#id').empty();
			$('#desc').empty();
			$('#icon').empty();
			$('#city').empty();	 	
			$('#city').append("Destination: " + data.apiData.city.name + " , " + data.apiData.city.country + "<br>");
			
			for (i = data.startDate; i <= data.endDate; i++) { 
			var date = new Date(data.apiData.list[i].dt*1000);
			var days = ['Sun','Mon','Tue','Wed','Thu','Fri','Sat'];
			var months = ['Jan','Feb','Mar','Apr','May','Jun','Jul','Aug','Sep','Oct','Nov','Dec'];

			var weekDay = days[ date.getDay() ];
			var month = months[ date.getMonth() ];
			var day = date.getDate();
			var dateString = weekDay + "<br>" + month + " " + day;
			
			var minTemp = data.apiData.list[i].temp.min;
			var maxTemp = data.apiData.list[i].temp.max;
			var weatherIcon = "<img src=\"http://openweathermap.org/img/w/" + data.apiData.list[i].weather[0].icon + ".png\"";
			
			$('#dt').append("<th>" + dateString + "</th>");
			$('#min').append("<td>" + minTemp + "°F" + "</td>");
			$('#max').append("<td>" + maxTemp + "°F"+ "</td>");
			$('#desc').append("<td>" + data.apiData.list[i].weather[0].description + "</td>");
			$('#icon').append("<td>" + weatherIcon + "</td>");
			}	
		}
	});
}
	
function saveItems() {
	var itemsArray = new Array();
	$("#itemList li").each(function() {
	    var currentList = $(this).attr("id"); 
	    
	    var attribute = $(this).attr("id");
	 	attribute += "name";
	 	attribute = "#" + attribute;
	 	var parentSelector = "#" + currentList; 
	 	console.log(parentSelector);
	 	console.log(attribute);
	 	var name = $(parentSelector).find(attribute).text();
	 	console.log(name);
	 	var attribute2 = $(this).attr("id");
	 	attribute2 += "quantity";
	 	attribute2 = "#" + attribute2;
	 	console.log(parentSelector);
	 	console.log(attribute2);
	 	var name2 = $(parentSelector).find(attribute2).val();
	 	console.log(name2);
	 	itemsArray.push({name: name, quantity: name2});
	    
	});
	$("#addedItems li").each(function() {
	    var currentList = $(this).attr("id"); 
	    
	    var attribute = $(this).attr("id");
	 	attribute += "name";
	 	attribute = "#" + attribute;
	 	var parentSelector = "#" + currentList; 
	 	console.log(parentSelector);
	 	console.log(attribute);
	 	var name = $(parentSelector).find(attribute).text();
	 	console.log(name);
	 	var attribute2 = $(this).attr("id");
	 	attribute2 += "quantity";
	 	attribute2 = "#" + attribute2;
	 	console.log(parentSelector);
	 	console.log(attribute2);
	 	var name2 = $(parentSelector).find(attribute2).val();
	 	console.log(name2);
	 	itemsArray.push({name: name, quantity: name2});
	    
	});
	var sendItemsList = JSON.stringify(itemsArray);
	$.ajax({
		type : "POST",
		url : "FrontController",
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
  
function loadItems() {
  $('#save').show();
  $.ajax({
	type : "POST",
	url : "FrontController",
	data : {
		"action" : "load", "token" : token
	},
	dataType : "json",
	success : function(data) {
		$('#itemList').empty();
		$('#addedItems').empty();
		$.each(data, function(i, value) {	
			$('#itemList').append("<li id='" + i + "'><div id='" + i + "name'>" + this.name + "</div><input id='" + i + "quantity' class='quantity' type='number' value='" + this.quantity + "'><button onclick=\"removeItem($(this))\">Remove</button>" + "<input type='checkbox'>" + "</li>");
			});
		$('#addAnItem').show();
	}
  });
}
  
function signOut() {
    var auth2 = gapi.auth2.getAuthInstance();
    auth2.signOut().then(function () {
      console.log('User signed out.');
    });
    $('#load').hide();
    $('#itemList').empty();
    $('#addAnItem').hide();
    $('#save').hide();
    token = null;
}
