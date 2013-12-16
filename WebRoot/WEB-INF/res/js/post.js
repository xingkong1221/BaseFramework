var post = function(url,frmId,loading,success){
	
	url = _path + url;
	
	var qustion = (url.lastIndexOf('?') == -1 ? '?':'&');
	if(loading){
		url += (qustion+ "loading=" + loading);
	}
	
	url = encodeURI(url);
	
	var data = '';
	if(frmId){
		if($('#' + frmId)){
			data = $('#' + frmId).serialize();
		}
	}
	
	var checkheader = function(data,textStatus, jqXHR, success){
		// TODO 逻辑待实现
		post.data = data;
		success();
	}; 
	
	$.post(url, data,function(data,textStatus, jqXHR) {
		checkheader(data,textStatus, jqXHR, success);
	});
};