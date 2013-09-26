<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="Hibernate.*,java.text.SimpleDateFormat"   %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk" />
<title>首页</title>
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
  <div id="wrapper">
  	<jsp:include page="head.jsp"></jsp:include>
    <div id="content">
      <div id="left">
        <div class="paddingbox">
          <h1>XiYou Linux 主页</h1>
          <p>&nbsp;</p>
          <img src="images/pic01.jpg" alt="" width="142" height="142" class="leftimg" /><strong>xiyou linux group</strong><br />
      	西邮Linux兴趣小组追求的是一种开放、自由、分享的文化。在这里，我们所有的成员组成一个大家庭;在这里，我们携手走进Linux世界，走进计算
      	机世界，享受技术所带来的乐趣；我们抵制平庸，追求充满激情的生活，追求自由开放的精神;我们喜爱Linux，热爱开源文化,崇尚自由的技术世界和头脑风暴式的技术探讨；在这里，没有所谓的权威,没有所谓的规矩，也没有任何的等级观念；在这里，每个成员都是主人，每个成员都可以宣扬自己优秀的个性。我们的目标是发展一批批优秀的计算机人才。
		</div>
        <div class="line"></div>
        <div class="paddingbox">
		相册
    <div class="blk_18"> <a class="LeftBotton" onmousedown="ISL_GoUp_1()" onmouseup="ISL_StopUp_1()" onmouseout="ISL_StopUp_1()" href="javascript:void(0);" target="_self"><</a>
    <div class="pcont" id="ISL_Cont_1">
    <div class="ScrCont">
    <div id="List1_1">
    <%
	Map map=(Map)request.getAttribute("photo");
	Iterator it=map.entrySet().iterator();
	while(it.hasNext()){
		Map.Entry entry=(Map.Entry)it.next();
		String str1=(String)entry.getKey();
		String str2=(String)entry.getValue();
 %>

    <a class="pl" href="photoView?index=<%=str1 %>" ><img src="./phone/<%=str2 %>" alt=""  width="260" height="195"/>相册名称:<%=str1 %></a>
 	<%
 		}
 	 %>
    <!-- piclist end -->
    </div>
    <div id="List2_1"></div>
    </div>
    </div>
    <a class="RightBotton" onmousedown="ISL_GoDown_1()" onmouseup="ISL_StopDown_1()" onmouseout="ISL_StopDown_1()" href="javascript:void(0);" target="_self">&gt;</a> </div>
    <div class="c"></div>
    <script type="text/javascript">
    <!--
    picrun_ini()
    //-->
    </script>
    <!-- picrotate_left end -->
		</div>
		
   
        <div class="line"></div>

     <div class="paddingbox">
  <div class="woaicss">
<script language="javascript"> 
 function woaicssq(num){
 for(var id = 1;id<=2;id++)
 {
 var MrJin="woaicss_con"+id;
 if(id==num)
 document.getElementById(MrJin).style.display="block";
 else
 document.getElementById(MrJin).style.display="none";
 }
 if(num==1) 
 document.getElementById("woaicsstitle").className="woaicss_title woaicss_title_bg1";
 if(num==2)
 document.getElementById("woaicsstitle").className="woaicss_title woaicss_title_bg2";
 }
</script>
 <ul class="woaicss_title woaicss_title_bg1" id="woaicsstitle">
  <li><a href="Lectures" target="_blank" onmouseover="javascript:woaicssq(1)">小组讲座</a></li>
  <li><a href="#" target="_blank" onmouseover="javascript:woaicssq(2)">小组博客</a></li>
 </ul>
 <%
        request.setCharacterEncoding("gbk");
 		List queList=(List)request.getAttribute("question");
 		List list=(List)request.getAttribute("content");
 %>
 <div class="woaicss_con" id="woaicss_con1" style="display:block;">
   <ul>
 	<%
 		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
 		for(int i=0;i<list.size();i++){
 			File file=(File)list.get(i);
 	%>
 		<li><%=file.getTitle() %>&nbsp;&nbsp;&nbsp;地址：<%=file.getAddress() %>&nbsp;&nbsp;&nbsp;时间：<%=df.format(file.getTime()) %>&nbsp;
 		<a href="down.jsp?url=<%=file.getPath() %>">下载</a><br>
 		</li>
 	<% 
 		}
 	%>
   </ul>
   <a href="Lectures"><img src="images/view.png" alt="" width="56" height="32" align="right" /></a>
 	</div>
 <div class="woaicss_con" id="woaicss_con2" style="display:none;">
   <ul>
		<li></li>
   </ul>
   
   <a href="Lectures"><img src="images/view.png" alt="" width="56" height="32" align="right" /></a>
   </div>
</div>
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
   		<br><img src="<%=wea %>" width="100px" height="70px"/>
   		<a href="http://www.weather.com.cn/weather/101110101.shtml" target="blank_">>>详细信息</a>
        </div>
        <div class="line"></div>
        <div class="paddingrightbox">
          <h1>关于小组</h1>
          <p>&nbsp;</p>
          <p><span class="browntext"> 西邮Linux兴趣小组直属于西安邮电学院计算机学院</span><br />
           由王亚刚老师,王聪,刘洋等同学于2006年9月策划并组建,现已成为陕西高校中具有深远影响力的技术小组。 <br />
          小组成员主要学习方向有：<br />
            Linux平台应用软件开发、Linux平台嵌入式开发、Linux内核分析、Linux服务器配置等。</p>
        </div>
        <div class="line"></div>
        <div class="paddingrightbox">
          <h1>小组动态</h1>
          <p>&nbsp;</p>
          <p><span class="browntext">西邮Linux兴趣小组直属于西安邮电学院计算机学院</span><br />
            由王亚刚老师,王聪,刘洋等同学于2006年9月策划并组建,现已成为陕西高校中具有深远影响力的技术小组。 <br />
            小组本着"学习Linux系统，崇尚自由软件，宣传开源文化"的精神 <br />
            Linux平台应用软件开发、Linux平台嵌入式开发、Linux内核分析、Linux服务器配置等。 </p>
        </div>
      </div>
    </div>
    <div id="bottom"></div>
<jsp:include page="foot.jsp"></jsp:include>
</body>
</html>

 	


