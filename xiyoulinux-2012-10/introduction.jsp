<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="Hibernate.*"   %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk" />
<title>小组简介</title>
<link href="css/sstyle.css" rel="stylesheet" type="text/css" />

<link rel="stylesheet" type="text/css" href="css/droplinebar.css" />

<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>

<script src="js/droplinemenu.js" type="text/javascript"></script>

<script type="text/javascript">

//build menu with DIV ID="myslidemenu" on page:
droplinemenu.buildmenu("mydroplinemenu")

</script>

<script type="text/javascript" src="js/jquery-1.4.2.js"></script>
<script type="text/javascript" src="js/coin-slider.min.js"></script>
<script type="text/javascript" src="js/phone.js"></script>
<link rel="stylesheet" href="css/coin-slider-styles.css" type="text/css" />

<script type="text/javascript">
	$(document).ready(function() {
		$('#coin-slider').coinslider({ width: 919, height: 298, navigation: true, delay: 4000 });
	});
</script>

</head>
  
  <body>
   <div id="wrapper">
  	<jsp:include page="head.jsp"></jsp:include>
  	    <div id="content" >
      <div id="left" >
	    <div class="paddingbox">
		</div>
		<div class="line"></div>
        <div class="paddingbox" >
		<img src="./images/b1.png" width="30" height="30"/>&nbsp;&nbsp;&nbsp;
		<a href="introduction.jsp?Page=int">小组简介</a>
		
		</div>
        <div class="line"></div>
        <div class="paddingbox">
		<img src="./images/b2.png" width="30" height="30"/>&nbsp;&nbsp;&nbsp;
		<a href="introduction.jsp?Page=tea">辅导老师</a>
		</div>
		<div class="line"></div>
        <div class="paddingbox">
		<img src="./images/b3.png" width="30" height="30"/>&nbsp;&nbsp;&nbsp;
		<a href="introduction.jsp?Page=active">小组活动</a>
		</div>
		<div class="line"></div>
        <div class="paddingbox">
		<img src="./images/b4.png" width="30" height="30"/>&nbsp;&nbsp;&nbsp;
		<a href="introduction.jsp?Page=com">参与社区</a>
		</div>
		<div class="line"></div>
        <div class="paddingbox">
		<img src="./images/b5.png" width="30" height="30"/>&nbsp;&nbsp;&nbsp;
		<a href="introduction.jsp?Page=red">获得奖励</a>
		</div>
	    <div class="line"></div>
        <div class="paddingbox">
		<img src="./images/b6.png" width="30" height="30"/>&nbsp;&nbsp;&nbsp;
		<a href="member">历届成员</a>
		</div>
		<div class="line"></div>
      </div>
 <%
 		String str=request.getParameter("Page");
 		if(str.equals("int")){
  %>
 		<jsp:include page="introduct.jsp"></jsp:include>
 	<%
 		}else if(str.equals("tea")){
 	 %>
 	 	<jsp:include page="teachers.jsp"></jsp:include>
 	<%
 		}else if(str.equals("active")){
 	 %>
 	 <jsp:include page="active.jsp"></jsp:include>
 	 <%
 	 	}else if(str.equals("com")){
 	  %>
 	  <jsp:include page="community.jsp"></jsp:include>
 	  <%
 	  }else if(str.equals("red")){
 	   %>
 	   <jsp:include page="reward.jsp"></jsp:include>
 	   <%
 	   }
 	   %>
    <div id="bottom"></div>
    <div id="footer">
      <div style="width:400px; float:left;"><a href="http://www.xiyoulinux.org">xiyoulinux.org</a>  All Rights</div>
      <div style="width:400px; float:right; text-align: right;"> 友情链接：• 西安邮电大学  •  西邮图书馆  •  西邮BBS  •  计算机学院  </div>
    </div>
  </div>
  </div>
  </body>
</html>
