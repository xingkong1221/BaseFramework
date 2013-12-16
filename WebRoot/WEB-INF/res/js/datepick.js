var datepick = {
	init : function(ids){
		
		var dates = ids.length == 2 ? $("#"+ids[0] + ",#" + ids[1]) : $('#' + ids[0]);
		dates.datepicker({
			showOn: "button",
			buttonImage: _path +"/res/images/calendar.gif",
			buttonImageOnly: true,
			dateFormat:"yy-mm-dd",
			dayNames: [ '星期日','星期一', '星期二', '星期三', '星期四', '星期五', '星期六'],
			dayNamesMin: ['日', '一', '二', '三', '四', '五', '六'],
			dayNamesShort: ['日', '一', '二', '三', '四', '五', '六'],
			monthNames: ['一月','二月','三月','四月','五月','六月','七月','八月','九月','十月','十一月','十二月'],
			monthNamesShort: ['一','二','三','四','五','六','七','八','九','十','十一','十二'],
		    onSelect: function(selectedDate){
		       if(ids.length == 2){
		    	   var option = (this.id == ids[0] ? "minDate" : "maxDate");
		    	   dates.not(this).datepicker("option", option, selectedDate);
		       }
		    }
		});
	}
};