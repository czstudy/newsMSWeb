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

<link rel="stylesheet"
	href="https://apps.bdimg.com/libs/jquerymobile/1.4.5/jquery.mobile-1.4.5.min.css">
<script src="https://apps.bdimg.com/libs/jquery/1.10.2/jquery.min.js"></script>
<script
	src="https://apps.bdimg.com/libs/jquerymobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>

<script type="text/javascript">
        function showToast(toast) {
            javascript:abc.showToast(toast);
        }
        function log(msg){
            console.log(msg);
            document.getElementById('title').innerHTML=msg;
        }
 </script>


</head>
<body>


	<div data-role="page" id="pageone">
		<div data-role="header">
			<h1>页面标题</h1>
		</div>

		<div data-role="content">
			<p>
			<div class="container">

				<!-- The justified navigation menu is meant for single line per list item.
           Multiple lines will require custom code not provided by Bootstrap. -->
				<div class="masthead">

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


						<div class="col-lg-12">



							<div class="bs-example" data-example-id="simple-table">
								<table class="table">
									<caption>新闻内容详情</caption>

									<tr>
										<!-- <th scope="row">${news.newsId }</th> -->
										<td style="text-align: center; font-size: 24px;">${news.title}</td>


									</tr>
									<tr>
										<td style="text-align: center; font-size: 9px"><f:formatDate
												value="${news.sendTime}" pattern="MM-dd" /></td>
										<!-- <td>@mdo</td> -->
									</tr>
									<tr>

										<td>${news.content}</td>

										<!-- <td>@mdo</td> -->
									</tr>


								</table>
							</div>
						</div>




						<!-- /example -->


					</div>
				</div>



			</div>
			<!-- /container -->
			</p>
		</div>

		<div data-role="footer">
			<h1>页面底部内容</h1>

			<div id="title">原始数据</div>
			<input type="button" value="toast" data-icon="back" onClick="showToast('Hello world')" />

		</div>
	</div>



</body>
</html>

