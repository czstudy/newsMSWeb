<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>新闻系统后台</title>

<!-- Bootstrap -->
<link href='<c:url value="/css/bootstrap.min.css"/>' rel="stylesheet">

<!-- 
<link rel="stylesheet" type="text/css" href="<c:url value="/css/default.css"/>" media="screen" />
		
		 -->
		<link rel="stylesheet" href="<c:url value="/js/themes/default/default.css"/>" />
		<link rel="stylesheet" href="<c:url value="/js/plugins/code/prettify.css"/>" />

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->


<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="<c:url value='/js/jquery.min.js'/>"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src='<c:url value="/js/bootstrap.min.js"/>'></script>


<script charset="utf-8" src="<c:url value="/js/kindeditor.js"/>"></script>
		<script charset="utf-8" src="<c:url value="/js/lang/zh_CN.js"/>"></script>
		<script type="text/javascript">
		function upload(){
			window.open ('<c:url value="/admin/upload.jsp"/>',
					'newwindow','height=100,width=400,top=0,left=0,toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no') ;
		}
		KindEditor.ready(function(K) {
		var editor1 = K.create('textarea[name="descipt"]', {			
			uploadJson : '<c:url value="/UpAction"/>'			
		});
		});
		</script>

</head>
<body>

    
	<div class="container">
        <c:if test="${empty  realName}">
        <c:redirect url="login.jsp"></c:redirect>
    </c:if>
		<!-- The justified navigation menu is meant for single line per list item.
           Multiple lines will require custom code not provided by Bootstrap. -->
		<div class="masthead">
			<nav class="navbar navbar-default">
				<div class="container-fluid">
					<!-- Brand and toggle get grouped for better mobile display -->
					<div class="navbar-header">
						<button type="button" class="navbar-toggle collapsed"
							data-toggle="collapse"
							data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
							<span class="sr-only">Toggle navigation</span> <span
								class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="#">Brand</a>
					</div>

					<!-- Collect the nav links, forms, and other content for toggling -->
					<div class="collapse navbar-collapse"
						id="bs-example-navbar-collapse-1">
						<ul class="nav navbar-nav">
							<li class="active"><a href="<c:url value='/WelcomeAction'/>">首页<span class="sr-only">(current)</span></a></li>
							
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown" role="button" aria-haspopup="true"
								aria-expanded="false">新闻管理 <span class="caret"></span></a>
								<ul class="dropdown-menu">
									<li><a href="#">新闻列表</a></li>
									<li><a href="<c:url value='/NewsAction?method=toCreate'/>">添加新闻</a></li>
									
									<li role="separator" class="divider"></li>
									<li><a href="#">新闻统计</a></li>
									<li role="separator" class="divider"></li>
									
								</ul></li>
						</ul>
						<form class="navbar-form navbar-left">
							<div class="form-group">
								<input type="text" class="form-control" placeholder="Search">
							</div>
							<button type="submit" class="btn btn-default">Submit</button>
						</form>
						<ul class="nav navbar-nav navbar-right">
							<li><a href="login.jsp">登录</a></li>
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown" role="button" aria-haspopup="true"
								aria-expanded="false">相关操作 <span class="caret"></span></a>
								<ul class="dropdown-menu">
									<li><a href="#">记住我们</a></li>
									<li><a href="#">收藏</a></li>

									<li role="separator" class="divider"></li>
									<li><a href="#">退出</a></li>
								</ul></li>
						</ul>
					</div>
					<!-- /.navbar-collapse -->
				</div>
				<!-- /.container-fluid -->
			</nav>
			<!--  
			<nav>
				<ul class="nav nav-justified">
					<li class="active"><a href="#">Home</a></li>
					<li><a href="#">体育新闻</a></li>
					<li><a href="#">娱乐新闻</a></li>
					<li><a href="#">社团</a></li>
					<li><a href="#">About</a></li>
					<li><a href="#">Contact</a></li>
					<li><a href="page/loginPage.jsp">sign in</a></li>
				</ul>
			</nav>
		</div>
      -->
			<!-- Jumbotron -->
			<div class="jumbotron">
				<h1>欢迎光临</h1>
				<p class="lead">新闻 后台系统!</p>
				<!--  
				<p >
					<a class="btn btn-lg btn-success" href="#" role="button">Get
						started today</a>
				</p>
				
				-->
			</div>

			<!-- Example row of columns -->
			<div class="row">
				<div class="col-lg-3">



					<h2>  ${realName}</h2>
					<p class="text-danger">As of v9.1.2, Safari exhibits a bug in
						which resizing your browser horizontally causes rendering errors
						in the justified nav that are cleared upon refreshing.</p>
					<p>Donec id elit non mi porta gravida at eget metus. Fusce
						dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh,
						ut fermentum massa justo sit amet risus. Etiam porta sem malesuada
						magna mollis euismod. Donec sed odio dui.</p>
					<p>
						<a class="btn btn-primary" href="#" role="button">View details
							&raquo;</a>
					</p>


				</div>

				<div class="col-lg-9">


					<div class="bs-example" data-example-id="simple-table">
						<table class="table">
							<caption>添加新闻</caption>
							
							<tbody>

							
									<tr>
										<!-- <th scope="row">${news.newsId }</th> -->
										<td>内容</td>
										<td>
										    <textarea id="descipt" name="descipt" style="width:700px;height:700px;"></textarea>
										</td>
										<!-- <td>@mdo</td> -->
									</tr>

								
								
								<tr>
									<th scope="row">标题2</th>
									<td>Jacob</td>
									
								</tr>
								<tr>
									
									<td><input type="submit" name="sss" value="添加"/></td>
									<td>@twitter</td>
								</tr>
								
								
							</tbody>
						</table>
					</div>
				</div>


				
				

				<!-- /example -->


			</div>
		</div>

		<!-- Site footer -->
		<footer class="footer">
			<p>
				&copy; 2016 Company, Inc.<a href="../welcomeAction">进入前台</a>
			</p>
		</footer>

	</div>
	<!-- /container -->


	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>

    
  
