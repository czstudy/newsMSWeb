<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>新闻详情页</title>

<!-- Bootstrap -->
<link href='<c:url value="/css/bootstrap.min.css"/>' rel="stylesheet">

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
</head>
<body>
	<div class="container">

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
							<li><a href="#">关于我们</a></li>
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown" role="button" aria-haspopup="true"
								aria-expanded="false">校园新闻 <span class="caret"></span></a>
								<ul class="dropdown-menu">
									<li><a href="#">娱乐</a></li>
									<li><a href="#">体育</a></li>
									<li><a href="#">生活</a></li>
									<li role="separator" class="divider"></li>
									<li><a href="#">社团</a></li>
									<li role="separator" class="divider"></li>
									<li><a href="#">正业</a></li>
								</ul></li>
						</ul>
						<form class="navbar-form navbar-left">
							<div class="form-group">
								<input type="text" class="form-control" placeholder="Search">
							</div>
							<button type="submit" class="btn btn-default">Submit</button>
						</form>
						<ul class="nav navbar-nav navbar-right">
							<li><a href="page/loginPage.jsp">登录</a></li>
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
				<p class="lead">你的新闻，我的乐园!</p>
				<!--  
				<p >
					<a class="btn btn-lg btn-success" href="#" role="button">Get
						started today</a>
				</p>
				
				-->
			</div>

			<!-- Example row of columns -->
			<div class="row">
				<div class="col-lg-4">



					<h2>Safari bug warning!</h2>
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

				<div class="col-lg-8">


					<div class="bs-example" data-example-id="simple-table">
						<table class="table">
							<caption>新闻内容详情</caption>
													
									<tr>
										<!-- <th scope="row">${news.newsId }</th> -->
										<td  style="text-align:center;font-size: 24px;">${news.title}</td>
										
										
									</tr>
									<tr>
										<td  style="text-align:center;font-size: 9px">
										<f:formatDate value="${news.sendTime}" pattern="MM-dd"/>
										</td>
										<!-- <td>@mdo</td> -->
									</tr>
									<tr>
										
										<td>${news.content}</td>
										
										<!-- <td>@mdo</td> -->
									</tr>

								
						</table>
					</div>
					<div class="bs-example" data-example-id="simple-table">
						
						<form class="form-horizontal" action="<c:url value='/CommentAction?ddd=1'/>">
							<input type="hidden" name="method" value="toSender"/>
							<input type="hidden" name="userId" value="${userId }"/>
							<div class="form-group form-group-lg">
								<label class="col-sm-2 control-label" for="formGroupInputLarge">
									发表评论：</label>
								<div class="col-sm-10">
									<input class="form-control" type="text"
										id="formGroupInputLarge" placeholder="Large input">
								</div>
								
							</div>
							<input type="submit"  value="发表" class="btn btn-primary"/>
						</form>

					</div>
					<div class="bs-example" data-example-id="simple-table">
					      <c:if test="${ commentList!=null }">
					                    评论：
					         <ul>
					      
					             <c:forEach items="${commentList }"  var="comment">
					                 
					                 <li><c:out value="${comment.content }"/> </li>

					             </c:forEach>
					         </ul>
					      </c:if>
					</div>
					
				</div>


				

				<!-- /example -->


			</div>
		</div>

		<!-- Site footer -->
		<footer class="footer">
			<p>
				&copy; 2016 Company, Inc.<a href="admin/login.jsp">进入后台</a>
			</p>
		</footer>

	</div>
	<!-- /container -->


	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>

