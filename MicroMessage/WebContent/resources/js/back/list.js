//删除单条提交函数
function delOne(id, basePath) {
	$("#delId").val(id);
	var form = $("#mainForm");
	form.attr("action", basePath + "DeleteOneServlet.action");
	form.submit();

}
// 删除多条提交函数
function delBatch(basePath) {
	var form = $("#mainForm");
	form.attr("action", basePath + "DeleteBatchServlet.action");
	form.submit();
}
// 删除成功提示
$(function() {
	var str = $("#delOK").val();
	if ('delOK' == str) {
		alert('删除成功！');
	}
});
