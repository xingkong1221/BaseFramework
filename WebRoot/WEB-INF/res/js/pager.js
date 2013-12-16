/**
 * 该分页组件配合pager.jsp使用
 * 该分页组件支持同记录列表支持多个分页条（分页条的容器id设置相同即可）
 * @param targetID 包含分页条的容器id
 * @param fn 点击分页的提交函数对象
 * @returns {Pager}
 * @author osmos
 */
function Pager(targetID, fn) {
	//分页条的容器id
	this.targetID = targetID;
	//分页的提交函数
	this.fn = fn;
	//当前第几页
	this.pageth = parseInt($('#' + targetID).find('#_pageth').val());
	if(this.pageth=="NaN"){
		this.pageth = 1;
	}
	//页大小
	this.pageSize=parseInt($('#' + targetID).find('#_pageSize').val());
	//共有多少页
	this.pageCount = parseInt($('#' + targetID).find('#_pageCount').val());
	//共有多少记录
	this.rowCount = parseInt($('#' + targetID).find('#_rowCount').val());
	//排序字段
	this.sort = $('#' + targetID).find('#_sort').val();
	//排序方向
	this.dir = $('#' + targetID).find('#_dir').val();
	
	//如果无记录隐藏分页条,并显示无记录信息
	if(this.rowCount == 0){
		$('#' + targetID).css('display','none');
		$('#' + targetID).before($("<div id='nodata' class='pager' style='margin-top:12px;text-align: center;font-weight: bold'>暂无任何记录！</div>"));
	}
	
	if(this.pageth==1){
		$('#' + targetID).find('#_pre').attr('disabled','ture');
	}
	if(this.pageth == this.pageCount){
		$('#' + targetID).find('#_next').attr('disabled','ture');
	}
	//跳转到某页
	this.jump = function(pageth) {
		if (pageth != null && pageth != undefined) {
			this.pageth = pageth;
		}
		this.fn();
	};
	var data = { pager : this };
	//点击上页
	$('#' + targetID).find('#_pre').click(data, function(event) {
		event.preventDefault();
		var pager = event.data.pager;
		if (pager.pageth <= 1)
			return;
		pager.pageth = pager.pageth - 1;
		$("#_pageth").val(pager.pageth);
		pager.jump();
	});
	//点击下页
	$('#' + targetID).find('#_next').click(data,function(event) {
		event.preventDefault();
		var pager = event.data.pager;
		if (pager.pageth >= pager.pageCount)
			return;
		pager.pageth = pager.pageth + 1;
		$("#_pageth").val(pager.pageth);
		pager.jump();
	});
	//点击页码
	$('#' + targetID + ' a[id^=item]').click(data, function(event) {
		event.preventDefault();
		var pager = event.data.pager;
		var id = $(this).attr('id').substring('item'.length);
		pager.pageth = parseInt(id) ;
		$("#_pageth").val(pager.pageth);
		pager.jump();
	});
	//返回分页查询字符串
	this.queryString = function(){
		var sort = '';
		if($('#' + targetID).find('#_sort').val()){
			sort = $('#' + targetID + ' #_sort').val();
		}
		var dir = '';
		if($('#' + targetID).find('#_dir').val()){
			dir = $('#' + targetID + ' #_dir').val();
		}
		var str = "&pageth=" + this.pageth + "&sort=" + sort + "&dir=" + dir;
		return str;
	};
	//重置分页相关数据
	this.reset = function(){
		this.pageth = 1;
		$('#' + targetID).find('#_sort').val('');
		$('#' + targetID).find('#_dir').val('');
	};
};
