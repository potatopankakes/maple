(function(){

maple.productPlanPage = function() {
	this.init = function(options){
		// wireup ui
		// error msg callback
		// processing callback
		// success msg callback
	};
	
	var processError = function(response) {
		var msg;
		if ( response.stackTrace != null ) { // exception
			msg = processException(response);
		}
		else { // standard error
			msg = response.message;
		}
		$.pnotify({pnotify_text: msg, pnotify_type: "error", pnotify_width:"auto"});
	};
	
	var processException = function(response) {
		var msg = response.message;
		msg += "</br></br>";
		var i; var st = response.stackTrace;
		for (i=0; i<st.length; i++) {
			msg += st[i];
			msg += "</br>";
		};
		if ( response.cause != null ) {
			msg += "<br/>";
			msg += processException(response.cause);
		}
		return msg;
	};
	
	this.createPlan = function(maxChild, maxAlert, reportLevel, rewardLevel, nWeeks, newPlanId){
		$.ajax({
			timeout: 5000,
			url: maple.util.serviceBaseUrl + "ProductPlanSvcV1/create",
			success: function(data, textStatus, xhr){
					if ( data.success ) {
						$.pnotify("Product plan created");
					}
					else {
						processError(data.result);
					}
				},
			error: function(xhr, textStatus, ex){
					// update ui
					$.pnotify("Error communicating to the server.");
				},
			dataType:"json",
			type:"POST",
			data: {
				maxChildren: maxChild,
				maxChoreAlertsPerWk: maxAlert,
				reportLevel: reportLevel,
				rewardLevel: rewardLevel,
				planWeeks: nWeeks,
				productPlanId: newPlanId
				}
		});
	};
	
};

})();
