<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page isELIgnored="false" %>
<%@ page import="Hibernate.*,java.text.SimpleDateFormat" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>文件管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
<link href="css/manager.css" rel="stylesheet" type="text/css" />

<link href="css/table.css" rel="stylesheet" type="text/css" />

<link rel="stylesheet" type="text/css" href="css/droplinebar.css" />

<link rel="stylesheet" href="css/coin-slider-styles.css" type="text/css" />
<script type="text/javascript">
	var XMLHttp;
	//创建XMLHttpRequest对象
	function createXMLRequest(){
		if(window.XMLHttpRequest){//Mozilla
			XMLHttpReq=new XMLHttpRequest();
		}else if(window.ActiveXObject){//IE
			try{
				XMLHttp=new ActiveXObject("Msxml2.XMLHTTP");
			}catch(e){
				try{
					XMLHttp=new ActiveXObject("Microsoft.XMLHTTP");
				}catch(e){}
			}
		}
	}
	//处理响应函数
	function AddStateChange(){
		if(XMLHttp.readyState==4){
			if(XMLHttp.status==200){
				AddSortList();
			}else{
				window.alert("页面异常");
			}
		}
	}
	//增加信息
	function Delete(fileid){
		id=document.getElementById("name").value;
		if(name==""){
			return;
		}
		var url="fileManager?action=delete&fileid="+fileid;
		createXMLHttpRequest();
		XMLHttp.onreadystatechange=Calldelete;
		XMLHttp.open("post","fileManager.jsp",true);
		XMLHttp.send("id="+fileid);
	}
    function checkCallback(){
    	if(xmlHttp.readyState==4){//回调完成
		if(xmlHttp.status==200){
			var text=xmlHttp.responseText;
			
			if(text=="true"){
				document.getElementById("content").innerHTML="ID已经存在！";
			}else{
				document.getElementById("content").innerHTML="可以使用";
			}
		}
	}
</script>
	<script language="javascript">
		function goUpdate(thisurl){
			window.open(thisurl,"修改","width=600,height=420,scrollbars=yes,resizable=yes");
		}
		function goDelete(thisurl){
			window.open(thisurl,"修改","width=360,height=200,scrollbars=yes,resizable=yes");
		}
</script>

</head>

<body>
<%
	String currentPage=(String)request.getAttribute("Page");
	int currentpage=Integer.parseInt(currentPage);
 %>
   <div id="wrapper">
    <div id="topbar"></div>
    <div id="nav"><div id="mydroplinemenu" class="droplinebar">
<ul>
<li><a href="fileManager">首页-文件管理</a></li>
<li><a href="blogManage">博客管理</a>
</li>
<li><a href="photoManage">相册管理</a>
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
           <h2>文件管理-文件上传</h2>
			<form action="uploadFile.jsp" method="post" enctype="multipart/form-data">
			<table border="0" width="560">
				<tr>
					<td>标题:</td>
					<td><input type="text" name="title"/></td>
					<td>&nbsp;</td>
					<td>作者:</td>
					<td><input type="text" name="author" /></td>
				</tr>
				<tr>
					<td>标签:</td>
					<td><select name="label" >
					    <option value="Linux内核" label="Linux内核">Linux内核</option>
						<option value="云计算" label="云计算">云计算</option>
			            <option value="web" label="web">web</option>
			            <option value="移动互联网" label="移动互联网">移动互联网</option>
						</select></td>
					<td>&nbsp;</td>
					<td>地址：</td>
					<td><input type="text" name="address" /></td>
				</tr>
		   		<tr>
				    <td>上传文件：</td>
					<td colspan="4">
						<input type="file" name="path" />
					</td>
				</tr>
	             <tr>
				    <td>内容说明：</td>
					<td colspan="4">
						<textarea rows="5" cols="50" name="content" ></textarea>
					</td>
				</tr>
				<tr align="center">
					<td colspan="5">
						<input type="submit" value="提交"/>
					</td>
				</tr>		
	</form>   
		   </table>
        </div>
        <div class="line"></div>
        <div class="paddingbox">
		  <h2>文件管理-文件列表</h2>
		  <table border="0" width="560" class="file">
		  	<tr class="tr">
				<td>标题</td>
				<td>标签</td>
				<td>作者</td>
				<td>日期</td>
				<td>编辑</td>
				<td>删除</td>
			</tr>
			<%
			    List list=(List)request.getAttribute("content");
			    SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
				for(int i=currentpage*5;i<currentpage*5+5 && i<list.size();i++){
					File file=(File)list.get(i);
					if(i%2==0){	
			 %>	
			<tr class="tc">
			<% 	}else{
			%>
				<tr>
			<% 
			}
			%>
				<td><%=file.getTitle()%></td>
				<td><%=file.getLabel() %></td>
				<td><%=file.getAuthor() %></td>
			
				<td><%=df.format(file.getTime()) %></td>
				<td><a  onClick="goUpdate('update.jsp?file=<%=file %>')">编辑</a></td>
				<td><a  href="fileManager?action=delete&fileid=<%=file.getId() %>&currentpage="+currentpage">删除</a></td>
			</tr>
			<%
				}
			 %>
			<tr class="tb">
				<td colspan="6" class="tb">
			<% 
					if(currentpage==0){
						out.print("上一页");
					}else{
			%>
					<a href="fileManager?currentPage=<%=currentpage-1%>">上一页</a>
			<%      }
					if((currentpage+1)*5<list.size()){
			%>
					<a href="fileManager?currentPage=<%=currentpage+1%>">下一页</a>
			<%
					}else{
						out.print("下一页");
					}
			 %>
				</td>
			</tr>
		  </table>
       	</div>
      </div>
      <div id="right">
        <div class="paddingrightbox">
          <h1>天气预报</h1> 
      <%
   		List<String> wealist=(List<String>)request.getAttribute("weather");
   		String wea=(String)request.getAttribute("weatherG");
 		for(String str:wealist){
 			out.println(str);
 		}
   %>  
   		<br><img src="<%=wea %>" width="100px" height="70px"/><a href="http://www.weather.com.cn/weather/101110101.shtml" target="blank_">>>详细信息</a>
        </div>
        <div class="line"></div>
        <div class="paddingrightbox">
          <h1>关于小组</h1>
          <p>&nbsp;</p>
          <p><span class="browntext"> 西邮Linux兴趣小组直属于西安邮电学院计算机学院</span><br />
           由王亚刚老师,王聪,刘洋等同学于2006年9月策划并组建,现已成为陕西高校中具有深远影响力的技术小组。 <br />
            小组本着"学习Linux系统，崇尚自由软件，宣传开源文化"的精神，在Linux的学习和应用中起到了带头的作用！小组成员主要学习方向有：<br />
            Linux平台应用软件开发、Linux平台嵌入式开发、Linux内核分析、Linux服务器配置等。</p>
        </div>
      </div>
    </div>
    <div id="bottom"></div>
<jsp:include page="/foot.jsp"></jsp:include>
</body>
</html>

