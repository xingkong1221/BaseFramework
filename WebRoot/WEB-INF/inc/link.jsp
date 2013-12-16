<!-- CSS -->
<link rel="stylesheet" type="text/css" href="${_RM_ }/css/${_SKIN_}/common.css">
<link rel="stylesheet" type="text/css" href="${_RM_ }/css/${_SKIN_}/global.css">
<link rel="stylesheet" type="text/css" href="${_RM_ }/css/${_SKIN_}/public.css">
<link rel="stylesheet" type="text/css" href="${_RM_ }/css/${_SKIN_}/pagestyle.css">
<link rel="stylesheet" type="text/css" href="${_RM_ }/css/${_SKIN_}/platManage.css">
<link rel="stylesheet" type="text/css" href="${_RM_ }/css/${_SKIN_ }/classStudy/base.css"/>
<link rel="stylesheet" type="text/css" href="${_RM_ }/css/${_SKIN_ }/classStudy/font-form.css"/>
<link rel="stylesheet" type="text/css" href="${_RM_ }/css/${_SKIN_ }/classStudy/layout.css"/>
<link rel="stylesheet" type="text/css" href="${_RM_ }/css/${_SKIN_ }/classStudy/main.css"/>
<link rel="stylesheet" type="text/css" href="${_RM_ }/css/${_SKIN_}/system.css"/>
<link rel="stylesheet" type="text/css" href="${_RM_ }/css/${_SKIN_}/themes/ui-lightness/jquery.ui.all.css"/>
<link rel="stylesheet" type="text/css" href="${_RM_ }/css/${_SKIN_}/themes/validation/validationEngine.jquery.css"/>



<!-- JAVASCRIPT -->
<script type="text/javascript" src="${_RM_ }/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="${_RM_ }/js/dialog.js"></script>
<script type="text/javascript" src="${_RM_ }/js/base-dialog.js"></script>
<script type="text/javascript" src="${_RM_ }/js/jquery.form.js"></script>

<script type="text/javascript" src="${_RM_ }/js/ui/jquery.ui.core.js"></script>
<script type="text/javascript" src="${_RM_ }/js/ui/jquery.ui.widget.js"></script>
<script type="text/javascript" src="${_RM_ }/js/ui/jquery.ui.mouse.js"></script>
<script type="text/javascript" src="${_RM_ }/js/ui/jquery.ui.draggable.js"></script>
<script type="text/javascript" src="${_RM_ }/js/ui/jquery.ui.position.js"></script>
<script type="text/javascript" src="${_RM_ }/js/ui/jquery.ui.resizable.js"></script>
<script type="text/javascript" src="${_RM_ }/js/ui/jquery.ui.dialog.js"></script>
<script type="text/javascript" src="${_RM_ }/js/ui/jquery.ui.button.js"></script>
<script type="text/javascript" src="${_RM_ }/js/ui/jquery.ui.tabs.js"></script>
<script type="text/javascript" src="${_RM_ }/js/ui/jquery.effects.core.js"></script>
<script type="text/javascript" src="${_RM_ }/js/ui/jquery.effects.fade.js"></script>
<script type="text/javascript" src="${_RM_ }/js/com.dw.party.global.js"></script>
<script type="text/javascript" src="${_RM_ }/js/loading-min.js"></script>  
<script type="text/javascript" src="${_RM_ }/js/jquery.bgiframe.min.js"></script>
<script type="text/javascript" src="${_CTX_PATH_ }/js/jquery.validationEngine-zh_CN.js"></script>  
<script type="text/javascript" src="${_RM_ }/js/jquery.validationEngine.js"></script>  
<script type="text/javascript" src="${_CTX_PATH_ }/js/jquery.ui.datepicker.js"></script>  


<script type="text/javascript" src="${_CTX_PATH_ }/js/pager.js"></script>
<script type="text/javascript" src="${_CTX_PATH_ }/js/post.js"></script>

<script type="text/javascript">
var ctx ="${_CTX_PATH_}";
var _path ="${_CTX_PATH_}";
var _form_isRunning = false;
var _platform_ID = "${platformId}";

jQuery.ajaxCore = jQuery.ajax;
jQuery.ajax=function(url, options){
	if ( typeof url === "object" ) {
		options = url;
		url = undefined;
	}
	options = options || {};
	if( !options.data ){
		options.data = {};
	}
	if( !options.data.platformId){
		options.data.platformId = _platform_ID;
	}
	if( url ){
		var index = url.indexOf("?");
		if( index > 0 ){
			var s = url.substring(index+1).split("&");
			if(s)
				for(var i in s){
					var strs = s[i].split("=");
					if(strs.length == 2	&& $.trim(strs[0])=="platformId" && $.trim(strs[1])==_platform_ID){
						delete options.data.platformId;
					}
				}
		}
	}
	
	return jQuery.ajaxCore(url, options);
};

$(document).ready(function(){
	 baseDialog.init();
});
</script>