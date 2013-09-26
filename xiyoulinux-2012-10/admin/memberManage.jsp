<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page isELIgnored="false" %>
<%@ page import="Hibernate.*,Hibernate.index.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>成员管理</title>
    
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
  
  
        </div>
        <div class="line"></div>
        <div class="paddingbox">
        <h2>VIEW</h2>
        <%
        	List plist=(List)request.getAttribute("mlist");
        	for(int i=0;i<plist.size();i++){
        		Member photo=(Member)plist.get(i);
         %>
			<div style="float:left;margin-left:5px"><img  src="images/member/<%=photo.getPhoto()%>" width="50" height="50"/>
				<br><%=photo.getName()%><a href="memberManage?mid=<%=photo.getId()%>">删除</a>	
			</div> 
		<%
			}
		 %>
       	</div>
      </div>
      <div id="right">
        <div class="line"></div>
        <div class="paddingrightbox">
          <h1>成员列表</h1><ul>
<%
	List list=(List)request.getAttribute("mindex");
	for(int i=0;i<list.size();i++){
		Memberindex p=(Memberindex)list.get(i);
 %>
 		<li><a href="memberManage?index=<%=p.getGrade() %>"><%=p.getGrade()  %></a>
 		<a href="memberManage?action=delindex&id=<%=p.getId()  %>">删除</a>
 		</li>
 <%
 	}
  %>
 		</ul>
        </div>
        <div class="line"></div>
        <div class="paddingrightbox">
          <h1>增加成员</h1>
          <form action="/xiyoulinux2/memberManage" method="post">
          	年级<br>
          	<input type="text" name="pname"/><input type="submit" value="创建"/>
          </form>
          <div class="line"></div>
 			<form action="addmember.jsp" method="post" enctype="multipart/form-data">
			<table border="0" width="560">
				<tr>
					<td>姓名:</td>
				</tr>
				<tr>
					<td><input type="text" name="name" /></td>
				</tr>
				<tr>
					<td>E-mail:</td>
				</tr>
				<tr>
					<td><input type="text" name="email" /></td>
				</tr>			   
				<tr>
					<td>年级:</td>
				</tr>
				<tr>
					<td><input type="text" name="grade" value="${Pname}"/></td>
				</tr>
		   		<tr>
				    <td>上传相片：</td>
				</tr>
				<tr>
					<td>
						<input type="file" name="photo"/>
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

