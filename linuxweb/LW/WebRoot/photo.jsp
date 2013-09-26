<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>    
    <title>图片浏览</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
<style type="text/css">
.demo{width: 250px;height: 200px;clear: both;position: relative;border:1px solid #d3d3d3}
.demo .bx_wrap ul img {width: 250px;height: 200px;padding:0;margin:0;}
.demo .bx_wrap{
	position: relative; 
	width: 250px; 
	overflow: hidden;
}
.demo .bx_wrap ul li{
	list-style:none;
	float:left;
}
.demo .bx_wrap a.prev {
	width:20px;
	height:24px;
	line-height:24px;
	outline-style:none;
	outline-width: 0;
	position:absolute; 
	top:85px; 
	left:-2px; 
	text-indent:-999em; 
	z-index:1900;
	background: url(./images/arr_left.gif) no-repeat;
}
.demo .bx_wrap a.next {
	width:20px;
	height:24px;
	line-height:24px; 
	left:226px;
	position: absolute;
	top:85px; 
	text-indent:-999em; 
	z-index:11000;
	background:url(./images/arr_right.gif) no-repeat;
}
</style>
  </head>
  
  <body>
<script type="text/javascript" src="js/bxCarousel.js"></script>
<script type="text/javascript">
$(function(){
	$('#demo2').bxCarousel({
		display_num: 1, 
		move: 1,
	});
});
</script>
<div class="demo">
    <div class="bx_wrap">
        <div class="bx_container">
          <ul id="demo2">
        <li><img src="uploadimg/a-3.jpg" width="250" height="200" title="linux" /></li>
    	<li><img src="uploadimg/a-1.jpg" width="250" height="200" title="linux" /></li>
        <li><img src="uploadimg/a-2.jpg" width="250" height="200" title="linux" /></li>
        <li><img src="uploadimg/a-4.jpg" width="250" height="200" title="linux" /></li>
        <li><img src="uploadimg/a-5.jpg" width="250" height="200" title="linux" /></li>
    </ul>
    </div>
    </div>
</div>  
  </body>
</html>
