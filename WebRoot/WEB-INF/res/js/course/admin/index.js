$(function() {
	page.init();
});

var page = {
	init : function() {
		baseDialog.init();
		list.init();
	},
};


var list = {
	pager : null,
	init : function() {
		list.pager = new Pager("pager", action.list);
		$("a[id=cmd_remove]").click(list.click_remove);
	},
	click_remove : function (event) {
		event.preventDefault();
		var url = $(this).attr("href");
		baseDialog.confirm('是否删除该记录？', function(){
			action.remove(url);
		});
	},
};
var action = {
	list : function() {
		post('/course/admin/list', "pager", null, function() {
			$('#disp_list').empty();
			$("#disp_list").append(post.data);
			list.init();
		});
	},
	remove : function(url) {
		post(url, null, null, function() {
			if (post.data == true) {
				baseDialog.alert("删除记录成功！");
			} else {
				baseDialog.alert("删除记录失败！");
			}
			action.list();
		});
	},
};

