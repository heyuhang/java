<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="Hibernate.*,Hibernate.index.*"   %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>相册</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />

<link rel="stylesheet" type="text/css" href="css/droplinebar.css" />

<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>

<script src="js/droplinemenu.js" type="text/javascript"></script>

<script type="text/javascript">

//build menu with DIV ID="myslidemenu" on page:
droplinemenu.buildmenu("mydroplinemenu")

</script>

<script type="text/javascript" src="js/coin-slider.min.js"></script>


<link rel="stylesheet" href="css/coin-slider-styles.css" type="text/css" />

<script type="text/javascript" src="./fancybox/jquery.mousewheel-3.0.4.pack.js"></script>
<script type="text/javascript" src="./fancybox/jquery.fancybox-1.3.4.pack.js"></script>
<link rel="stylesheet" type="text/css" href="./fancybox/jquery.fancybox-1.3.4.css" media="screen" />

<script type="text/javascript">
	$(document).ready(function() {
		$('#coin-slider').coinslider({ width: 919, height: 298, navigation: true, delay: 4000 });
		$("a[rel=example_group]").fancybox({
				'transitionIn'		: 'none',
				'transitionOut'		: 'none',
				'titlePosition' 	: 'over',
				'titleFormat'		: function(title, currentArray, currentIndex, currentOpts) {
					return '<span id="fancybox-title-over">Image ' + (currentIndex + 1) + ' / ' + currentArray.length + (title.length ? ' &nbsp; ' + title : '') + '</span>';
				}
		});
	});
</script>
</head>

<body >
<%
	String currentPage=(String)request.getAttribute("Page");
	int currentpage=Integer.parseInt(currentPage);
	String index=(String)request.getAttribute("Index");
	List plist=(List)request.getAttribute("photo");
 %>
  <div id="wrapper">
  	<jsp:include page="head.jsp"></jsp:include>
    <div id="content">
      <div id="left">
        <div class="paddingbox">
        	<p style="font-size:14px">相册VIEW(
        	<%= ((Photo)plist.get(0)).getLabel()%>
        	)</p>
        </div>
        <div class="line"></div>
        <div class="paddingbox" align="center">
          <div class="photoblock-many"> 
        <%
        	for(int i=currentpage*9;i<currentpage*9+9 && i<plist.size();i++){
        		Photo photo=(Photo)plist.get(i);
         %>
			<div style="float:left;margin-left:4px">
			<a  rel="example_group" href="phone/<%=photo.getPath()%>" title="<%=photo.getDescription() %>">
		<% 
			if(i==currentpage*9+9-1 || i==plist.size()+1){
		%>
				<img  class="last" alt="" src="phone/<%=photo.getPath()%>" width="170" height="152" style="border:#e3e3e3 1px solid;padding:3px"/>
		<% 		
			}else{
		%>
				<img  alt="" src="phone/<%=photo.getPath()%>" width="170" height="152" style="border:#e3e3e3 1px solid;padding:3px"/>
		<%
			}
		 %>
			</a>
				<br><%=photo.getDescription() %>
			</div> 
		<%
			}
		 %>
		 	</div>
		 </div>
		 <div class="paddingbox" align="center">
		 	<% 
					if(currentpage==0){
						out.print("上一页");
					}else{
			%>
					<a href="photoView?currentPage=<%=currentpage-1%>&index=<%=index %>">上一页</a>
			<%      }
					if((currentpage+1)*9<plist.size()){
			%>
					<a href="photoView?currentPage=<%=currentpage+1%>&index=<%=index %>">下一页</a>
			<%
					}else{
						out.print("下一页");
					}
			 %>
		 
		 </div>
        
      </div>
      <div id="right">
        <div class="paddingrightbox">
        <h2>相册列表</h2><ul>
<%
		List Plist=(List)request.getAttribute("PhotoIndex");
		for(int i=0;i<Plist.size();i++){
			Photoindex p=(Photoindex)Plist.get(i);
 %>		
 			<li><a href="photoView?index=<%=p.getName() %>"><%=p.getName()%></a></li>
 		<%
 		} 
 		%>
  		</ul>
        </div>
        <div class="line"></div>
        <div class="paddingrightbox">
       
        </div>
        <div class="line"></div>
        <div class="paddingrightbox">
         
        </div>
      </div>
    </div>
    <div id="bottom"></div>
<jsp:include page="foot.jsp"></jsp:include>
</body>
</html>

 	


