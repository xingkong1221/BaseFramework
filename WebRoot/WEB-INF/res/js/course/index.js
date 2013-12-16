$(function() {
	page.init();
});

var page = {
	init : function() {
		baseDialog.init();
		$('#cmd_create').click(page.click_cmd_create);
		list.init();
	},
	click_cmd_create : function(e) {
		e.preventDefault();
		action.to_create();
	}
};


var list = {
	pager : null,
	init : function() {
		list.pager = new Pager("pager", action.list);
	},
};
var action = {
	list : function() {
		post('/course/list', "pager", null, function() {
			$('#disp_list').empty();
			$("#disp_list").append(post.data);
			list.init();
		});
	},
};