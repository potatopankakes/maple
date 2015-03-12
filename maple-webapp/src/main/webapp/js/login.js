(function(){

maple.loginPage = function() {
	this.init = function(options){
		// wireup ui
		// error msg callback
		// processing callback
		// success msg callback
	};
	
	this.login = function(username, password, options){
		requestSalt(username, password, options);
	};
	
	var requestSalt = function(u,p,o){
		$.ajax({
			timeout: 5000,
			url: maple.util.serviceBaseUrl + "LoginSvcV1/salt",
			success: function(data, textStatus, xhr){
					var r = data.result;
					if (r != null) {
						var seqno = r.seqNo;
						var c = encode(u,p,r.salt,seqno);
						requestLogin(u,seqno,c);
					}
					else {
						alert("results of requestSalt were unexpected");
					}
				},
			error: function(xhr, textStatus, ex){
					// update ui
					alert("requestLogin errored");
				},
			dataType:"json",
			data: {
				email: u
				}
		});
	};
	
	var encode = function(u,p,s,n) {
		var iterPhase1=1000;
		s = Crypto.util.base64ToBytes(s);
		p = Crypto.charenc.UTF8.stringToBytes(p);
		var m = s.concat(p); // create the salt & password digest
		m = iterEncode(m,iterPhase1);
		var iterPhase2 = 10;
		n = Crypto.charenc.UTF8.stringToBytes(n.toString());
		m = n.concat(m); // create salt & sequence number & salt/password digest
		m = s.concat(m);
		m = iterEncode(m,iterPhase2);
		return Crypto.util.bytesToBase64(m);
	};
	
	var iterEncode = function(m,n) {
		for ( var i=0; i<n; i++ ) {
			m = Crypto.SHA256(m, { asBytes: true });
		}
		return m;
	};

	var requestLogin = function(e,n,c){
		$.ajax({
			timeout: 5000,
			url: maple.util.serviceBaseUrl + "LoginSvcV1/login",
			success: function(data, textStatus, xhr){
					// update ui
					alert("requestLogin succeeded");
				},
			error: function(xhr, textStatus, ex){
					// update ui
					alert("requestLogin errored");
				},
			dataType:"json",
			type:"POST",
			data: { email: e, seqNo: n, cred: c }
		});
	};
	
};

})();
