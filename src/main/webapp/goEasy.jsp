<%--
  Created by IntelliJ IDEA.
  User: David
  Date: 2018/2/11
  Time: 11:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<script src="http://cdn-hangzhou.goeasy.io/goeasy.js"></script>
<script>
    var goEasy = new GoEasy({
        appkey: "BC-ac5dba1d32854db1958fc92d875d9c1c"
    });
    goEasy.subscribe({
        channel: "test_channel",
        onMessage: function (message) {
            alert("您有新消息：channel：" + message.channel + " 内容：" + message.content);
        },
        onSuccess: function () {
            alert("Channel订阅成功。");
        },
        onFailed: function (error) {
            alert("Channel订阅失败, 错误编码：" + error.code + " 错误信息：" + error.content)
        }
    });
</script>
</body>
</html>
