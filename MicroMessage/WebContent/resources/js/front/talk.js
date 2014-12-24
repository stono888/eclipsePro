//页面加载
$(function() {
	render();
	// 添加公共号的开场白
	var string = "客官，来啦，坐吧！<br/>回复[查看]收取更多精彩内容！";
	string += "<br/>回复[帮助]可以查看所有可用的指令。"
	appendDialog("talk_recordbox", "公众号", string);
	render();

});

/**
 * 发送消息
 */
function send() {
	var content = $("#content").val();
	if (!content) {
		alert("请输入内容！");
		return;
	}
	$.ajax({
		url : $("#basePath").val() + "AutoReplyServlet.action",
		type : "POST",
		dataType : "text",
		timeout : 10000,
		success : function(data) {
			appendDialog("talk_recordboxme", "My账号", content);
			appendDialog("talk_recordbox", "公众号", data);
			$("#content").val("");
			render();
		},
		data : {
			"content" : content
		}
	});

}

/**
 * 渲染方法，加载滚动条
 */
function render() {
	
}

/**
 * 向聊天记录中添加聊天内容
 * 
 * @param myClass
 *            添加内容的样式
 * @param name
 *            发送消息的账号名称
 * @param content
 *            发送的内容
 */
function appendDialog(myClass, name, content) {
	var div = "";
	div += $('#jp-container').html() + "<div>" + content + "</div>";
	$('#jp-container').html(div);
}

/**
 * 获取当前系统时间
 */
function getCurrentDate() {
	var date = new Date();
	return date.getFullYear()
			+ "-"
			+ (date.getMonth() + 1)
			+ "-"
			+ date.getDate()
			+ " "
			+ (date.getHours() < 10 ? "0" + date.getHours() : date.getHours())
			+ ":"
			+ (date.getMinutes() < 10 ? "0" + date.getMinutes() : date
					.getMinutes());
}