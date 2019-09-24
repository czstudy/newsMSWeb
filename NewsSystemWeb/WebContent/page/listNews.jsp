<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>新闻平台</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="新闻">
<meta name="author" content="www@qq.com">
<link href="<c:url value="/css/bootstrap.min.css"/>" rel="stylesheet">

<link href="<c:url value="/css/stylePage.css"/>" rel="stylesheet">
<link href="<c:url value="/css/bootstrap-responsive.min.css"/>"
	rel="stylesheet">
<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
	    <script src="js/html5shiv.js"></script>
	<![endif]-->

<!-- Fav and touch icons -->
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="<c:url value="/img/apple-touch-icon-144-precomposed.png"/>">
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="<c:url value="/img/apple-touch-icon-114-precomposed.png"/>">
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="<c:url value="/img/apple-touch-icon-72-precomposed.png"/>">
<link rel="apple-touch-icon-precomposed"
	href="<c:url value="/img/apple-touch-icon-57-precomposed.png"/>">
<link rel="shortcut icon" href="<c:url value="/img/favicon.png"/>">

<script type="text/javascript" src="<c:url value="/js/jquery.min.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/js/bootstrap.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/scripts.js"/>"></script>
<script type="text/javascript">
$(document).ready(function(){
	$('body').on('hidden', '.modal', function () {
		$(this).removeData('modal');
	});
});
</script>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="span12">
				<!--<c:import url="/common/header.jsp"></c:import>	-->			
			</div>
		</div>
	    
		<div class="row-fluid">
			<div class="page-header">
  				<h1>新闻列表</h1>
			</div>	
		</div>
		<c:if test="${!empty errorStr }">
		<div class="alert alert-error">
			<button data-dismiss="alert" class="close" type="button">×</button>
    		<strong>出错啦～</strong><p>${errorStr }</p>
    	</div>		
		</c:if>
		<table class="table table-hover table-bordered ">
			<thead>
			<tr>
				<th width="120" align="left">编号</th>
				<th width="100" align="left">标题</th>
				<th width="100" align="left">时间</th>
				
			</tr>
			</thead>
			<tbody>
			<c:forEach var="news" items="${newsList }">
				<tr>
					<td>${news.id }</td>
				<td align="center">
						<a href="<c:url value="/NewsAction?method=queryNews&amp;newsId=${news.id}"/>"  data-toggle="modal" data-target="#myModal">查看</a>
					</td>
					
					<td>${news.sendTime }</td>
					
				</tr>
			</c:forEach>
			</tbody>
			
		</table>
		<div class="pagination pagination-centered">
			<p>当前共有${count }条记录，当前第${pageNo}/${totalPage }页;&nbsp;</p>
			<ul>
				<li class="disabled">
					<a href='<c:url value="/newsAction?method=listByUserId&amp;pageNo=1"/>'>首页</a>					
				</li>
				<li class="active"><a href='<c:url value="/newsAction?method=listByUserId&amp;pageNo=${pageNo>1?pageNo-1:1 }"/>'>上一页</a></li>
				<li><a href='<c:url value="/newsAction?method=listByUserId&amp;pageNo=${pageNo<totalPage?pageNo+1:pageNo }"/>'>下一页</a></li>
				<li><a href='<c:url value="/newsAction?method=listByUserId&amp;pageNo=${totalPage }"/>'>末页</a></li>
			</ul>
		</div>
		<div>
		    <ul>
		    <c:forEach var="i" begin=1 end="${totalPage }" step=1>
		    <li class="disabled">
					<a href='<c:url value="/newsAction?method=listByUserId&amp;pageNo=${i }"/>'>${i }</a>					
				</li>
				</c:forEach>
		    </ul>
		</div>
		
		
		
	</div>
	<div class="container-fluid footer">s
        <p>15级软件开发组，承办单位 <a target="_blank" href="http://www.czc.net.cn">滁州职业技术学院</a> </p>
        
    </div>

	<div id="myModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
			<h3 id="myModalLabel">选择成员</h3>
		</div>
		<div class="modal-body">
			
		</div>
		<div class="modal-footer">
			<button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
		</div>
	</div>
</body>
</html>