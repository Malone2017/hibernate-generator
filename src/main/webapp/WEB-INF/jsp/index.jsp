<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>Bootstrap 101 Template</title>

<!-- Bootstrap -->
<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet"
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

<link
	href="http://cdn.bootcss.com/highlight.js/8.0/styles/monokai_sublime.min.css"
	rel="stylesheet">
<script src="http://cdn.bootcss.com/highlight.js/8.0/highlight.min.js"></script>
</head>
<body>
	<h1>你好，世界！</h1>
	<div id="entity" class="j_div">
		<form class="form-inline">
			<button data-clipboard-target="#content" class="btn btn-default"
				id="J_copy" type="button">复制代码</button>
		</form>
		<pre>
			<code class="java">
				<div id="content">${entity }</div>
			</code>
		</pre>
	</div>
	<div id="mapping" style="display: none;" class="j_div">
		<form class="form-inline">
			<button data-clipboard-target="#content2" class="btn btn-default"
				id="J_copy_2" type="button">复制代码</button>
		</form>
		<pre>
			<code class="java">
				<div id="content2">${mapping }</div>
			</code>
		</pre>
	</div>
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
	<script
		src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"
		integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
		crossorigin="anonymous"></script>

	<script src="/clipboard.js"></script>

	<script type="text/javascript">
		$(function() {
			
			hljs.initHighlightingOnLoad();
			new Clipboard('#J_copy');
			new Clipboard('#J_copy_2');
			$(".j_div").off("click").on("click",function(){
				$(this).show().siblings().hide();
			});
		})
	</script>
</body>
</html>