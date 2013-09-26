<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="Hibernate.*,Hibernate.index.*"   %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk" />
<title>小组成员   </title>
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
  	    <div id="content">
      <div id="left">
	    <div class="paddingbox">
		</div>
		<div class="line"></div>
        <div class="paddingbox">
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
		<img src="./images/b5.png" width="30" height="30"/>&nbsp;&nbsp;&nbsp;
		<a href="member">历届成员</a>
		</div>
		<div class="line"></div>
        <div class="paddingbox">
		<img src="./images/b6.png" width="30" height="30"/>&nbsp;&nbsp;&nbsp;小组T恤
		</div>
		<div class="line"></div>
      </div>
      <div id="right">
        <div class="paddingrightbox">
        <%
        	List list=(List)request.getAttribute("mindex");
        	List mlist=(List)request.getAttribute("mlist");
        	
         %>
         <h2>历届小组成员列表</h2>
         <p>这都是我们小组的成员，我们一起在实验室度过了快乐的大学时光，这段时光值得我们留恋，值得我们记忆，虽然我们离开了兴趣小组，但是我们的心还在，我们依然关心着小组的发展，小组的明天。 </p>
         <br />
         <%
         	for(int i=0;i<list.size();i++){
         		Memberindex midex=(Memberindex)list.get(i);
          %>
          <div style="width:600px;border-bottom:1px solid #e3e3e0"><p style="padding:3px 5px;font-size:16px;width:100px;color:#d9930b">
          <%=midex.getGrade() %>
          </p>
          </div>
        
          <%
          		for(int j=0;j<mlist.size();j++){
          		Member m=(Member)mlist.get(j);
          		if(m.getGrade().equals(midex.getGrade())){
           %>
           		<div style="width:600px;height:70px">
           		<img src="./images/member/<%=m.getPhoto() %>"/ style="width:60px;height:80px;border:#e3e3e0 1px;padding:3px;float:left">
           		<br><div style="float:left">姓名：<%=m.getName() %></div><br />
           		<div style="float:left">E-mail：<%=m.getEmail() %></div><br />
           		<div style="float:left">个人简介：<%=m.getDescrable() %></div>
           		</div>
           		<br>
           <%
           			}
           		}
           	}
            %>
        </div>
	  </div>
    </div>
    <div id="bottom"></div>
<jsp:include page="foot.jsp"></jsp:include>
  </div>
  </div>
  </body>
</html>
