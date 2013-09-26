<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="Hibernate.*,Hibernate.index.*,java.text.SimpleDateFormat"   %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>讲座</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />

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
<%
	String currentPage=(String)request.getAttribute("Page");
	int currentpage=Integer.parseInt(currentPage);
	String index=(String)request.getAttribute("Index");
 %>
  <div id="wrapper">
  	<jsp:include page="head.jsp"></jsp:include>
    <div id="content">
      <div id="left">
        <div class="paddingbox">
        	小组讲座PPT&FILE
        </div>
        <div class="line"></div>
        <div class="paddingbox">
        <%
        	SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
        	List list=(List)request.getAttribute("FileList");
        	if(list.isEmpty()==true){
        		out.print("关于这方面还没有可开始的讲座");
        	}else
        	for(int i=currentpage*10;i<currentpage*10+10 && i<list.size();i++){
        		File file=(File)list.get(i);
         %>
          		<li>关于"<%=file.getTitle() %>"演讲&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 地点：<%=file.getAddress() %>&nbsp;&nbsp;
          		演讲者：<%=file.getAuthor() %>&nbsp;&nbsp;<%=df.format(file.getTime()) %>
 				<a href="down.jsp?url=<%=file.getPath() %>">下载</a>
 				</li> 
			 <div class="line"></div>
		<%
			}
		 %>
		 
        </div>
         <div class="paddingbox" align="center">
		 	<% 
					if(currentpage==0){
						out.print("上一页");
					}else{
			%>
					<a href="photoView?currentPage=<%=currentpage-1%>&index=<%=index %>">上一页</a>
			<%      }
					if((currentpage+1)*9<list.size()){
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
        <h2>讲稿分类列表</h2><ul>
<%
		List flist=(List)request.getAttribute("FileIndex");
		for(int i=0;i<flist.size();i++){
			Fileindex p=(Fileindex)flist.get(i);
 %>		
 			<li><a href="Lectures?index=<%=p.getName() %>"><%=p.getName()%></a></li>
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

 	


