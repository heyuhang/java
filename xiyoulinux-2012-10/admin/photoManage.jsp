<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page isELIgnored="false" %>
<%@ page import="Hibernate.index.*,Hibernate.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>相册管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
<link href="css/manager.css" rel="stylesheet" type="text/css" />

<link href="css/table.css" rel="stylesheet" type="text/css" />

<link rel="stylesheet" type="text/css" href="css/droplinebar.css" />

<link rel="stylesheet" href="css/coin-slider-styles.css" type="text/css" />



</head>

<body>
   <div id="wrapper">
    <div id="topbar"></div>
    <div id="nav"><div id="mydroplinemenu" class="droplinebar">
<ul>
<li><a href="fileManager">首页-文件管理</a></li>
<li><a href="blogManage">博客管理</a>
</li>
<li><a href="photoManage">相册管理</a></li>
<li><a href="memberManage">小组成员管理</a></li>
<li><a href="#">管理员设置</a></li>
<c:if ${user!=null }>			
<div style="float:right;margin-top:10px">欢迎您：${user }</div></c:if>	
  </ul>
</div>
</div>
<div id="header"><div id='coin-slider'>
	<img src='images/headerpic.jpg' />
</div>
</div>
    <div id="topbar2"></div>
    <div id="content">
      <div id="left">
        <div class="paddingbox">
  
<%
			List plist=(List)request.getAttribute("List");
 %>  
        </div>
 <%
 			if(plist.size()>0){
  %>
        <h2>图片区(<%=((Photo)plist.get(0)).getLabel() %>)</h2>
  <%
  		}else{
  		
   %>	<h2>还没上传相册</h2>
   <%
   		}
    %>
        <div class="line"></div>
        <div class="paddingbox">
        
        <%
        	
        	for(int i=0;i<plist.size();i++){
        		Photo photo=(Photo)plist.get(i);
         %>
			<div style="float:left;margin-left:5px"><img  src="phone/<%=photo.getPath()%>" width="180" height="160"/>
				<br><%=photo.getDescription() %><a href="photoManage?Path=<%=photo.getPath()%>">删除</a>	
			</div> 
		<%
			}
		 %>
       	</div>
      </div>
      <div id="right">
        <div class="paddingrightbox">
          <h1>天气预报</h1> 
        </div>
        <div class="line"></div>
        <div class="paddingrightbox">
          <h1>相册列表</h1><ul>
<%
	List list=(List)request.getAttribute("Pindex");
	for(int i=0;i<list.size();i++){
		Photoindex p=(Photoindex)list.get(i);
 %>
 		<li><a href="photoManage?index=<%=p.getName() %>"><%=p.getName() %></a>
 		<a href="photoManage?action=delindex&index=<%=p.getName() %>">删除</a>
 		</li>
 <%
 	}
  %>
 		</ul>
        </div>
        <div class="line"></div>
        <div class="paddingrightbox">
          <h1>相册上传</h1>
          <form action="/xiyoulinux2/photoManage" method="post">
          	相册名<br>
          	<input type="text" name="pname"/><input type="submit" value="创建"/>
          </form>
          <div class="line"></div>
 			<form action="uploadPhoto.jsp" method="post" enctype="multipart/form-data">
			<table border="0" width="560">
				<tr>
					<td>相册:</td>
				</tr>
				<tr>
					<td><input type="text" name="label" value="${Pname}"/></td>
				</tr>
		   		<tr>
				    <td>上传相片：</td>
				</tr>
				<tr>
					<td>
						<input type="file" name="path"/>
					</td>
				</tr>
	             <tr>
				    <td>内容说明：</td>
				</tr>
				<tr>
					<td>
					   <textarea rows="5" cols="25" name="description"></textarea>
					</td>
				</tr>
				<tr>
					<td>
						<input type="submit" value="提交"/>
					</td>
				</tr>		
	</form>   
		   </table>      
        </div>
      </div>
    </div>
    <div id="bottom"></div>
<jsp:include page="/foot.jsp"></jsp:include>
</body>
</html>

