(function(){

var regNS = function(fns) {
	var ns = fns.split('.');
	var root = window;
	for(var i = 0; i < ns.length; i++){
		if (!root[ns[i]])
			root[ns[i]] = {};
		root = root[ns[i]];
	}
}; 

regNS("maple.util");

maple.util = {
	regNamespace: regNS,
	serviceBaseUrl: "svc/",
	displayMsg: function(msg) {
		$.pnotify({pnotify_text: msg, pnotify_type: "info", pnotify_width:"auto"});
	},
	displayError: function(msg) {
		$.pnotify({pnotify_text: msg, pnotify_type: "error", pnotify_width:"auto"});
	},
	processError: function(response) {
		this.displayError(response.stackTrace != undefined ? this.processException(response) : response.message);
	},
	processException: function(response) {
		var msg = response.message;
		msg += "</br></br>";
		var i; var st = response.stackTrace;
		for (i=0; i<st.length; i++) {
			msg += st[i];
			msg += "</br>";
		};
		if ( response.cause != undefined ) {
			msg += "<br/>";
			msg += this.processException(response.cause);
		}
		return msg;
	}
};

})();
