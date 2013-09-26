<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>小组简介</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/sstyles.css">

<style type="text/css">
.imgl{
   width:270px;
   height:200px;
   border:#e3e3e3  1px solid;
   padding:5px;
}
</style>
  </head>
  
  <body>
     <div id="right">
        <div class="paddingrightbox">
		<h1 style="text-align:center;color:#D9930B;">小组活动</h1>
		<p style="font-weight: bold">2010年5月 西安高校开源技术巡回讲座</p>
		<p>此系列讲座由西部开源技术中心与xiyoulinux兴趣小组合作举办，主要是进行Linux开源技术方面的宣传。</p>
		<p style="font-weight: bold">2009年9月 第六届国际自由软件日</p>
		<img src="./images/active/active_05.jpg" class="imgl"/>
		<p>http://www.xiyoulinux.org/blog/?p=133</p>
		<p>此次活动得到了中国开源推进联盟、SUN公司、中科红旗、中标的大力支持。</p>
		<p style="font-weight: bold">2009年3月15日 西安CU网友第一次聚会</p>
		<img src="./images/active/active_04.jpg" class="imgl"/>
		<p>http://www.xiyoulinux.cn/blog/?p=119</p>
		<p>这次活动得到了chinaunix的官方支持，而且chinaunix论坛:marsaber,itpub论坛版主:南非蚂蚁,chinaunix论坛版主:kns1024wh分别为我们作了SELINUX，
		      群集应用，定制Linux发行版的主题演讲。 </p>
		<p style="font-weight: bold">2008年11月27日 华为公司内核开发者lokesh来西邮交流</p>
		<p>http://www.xiyoulinux.cn/blog/?p=101</p>
		<p>lakesh为大家介绍如何学习内核开发，并对我们的日常工作进行了指导。</p>
		<p style="font-weight: bold">2008年9月20日 第五届国际自由软件日</p>
		<img src="./images/active/active_03.jpg" class="imgl"/>
		<p>http://www.xiyoulinux.cn/blog/?p=103</p>
		<p>此次活动受到了哲思自由软件社区(zeuux.org)和17LAMP.net网站的大力支持,同时也受到了西部开源技术中心的大力支持。</p>
        <p style="font-weight: bold">2008年8月12日 西安软件园-开源行动日</p>
        <p>http://www.xiyoulinux.cn/blog/?p=101</p>
        <p>此次活动是由Intel、Sun、Ibm等主办的源行动日，历时一天，Intel，Sun，Ibm公司的技术人员为我们做了关于新技 术的介绍，让大家受益匪浅。</p>
        <p style="font-weight: bold">2008年3月19日 开源校园行-西邮站</p>
        <p>http://www.xiyoulinux.cn/blog/?p=79</p>
        <p>此次活动是由国内知名开源人士于2003年发起，旨在各大高校宣传开源文化，为高校师生、社会团体、公司机构搭建一个开放的交流平 台，帮助更多的人了解开源世界的五彩缤纷和发展前景、
                      参与开源，共同推动全球开源软件运动的发展。主讲人介绍程勇(Peter Cheng)，国内开源运动的布道者，huihoo.org 开源社区协同创始人。 </p>
         <p style="font-weight: bold">2008年5月28日 自由软件之父Richard Stallman来到西邮</p>
         <p>http://www.xiyoulinux.cn/blog/?p=89</p>
         <p>Richard Stallman为我们讲解了自由软件的概念以及他对自由软件的看法。这次活动得到了系里韩俊刚主任的认可，陈莉君、王 亚刚老师也给了大力的支持。</p>
        <p style="font-weight: bold">2008年3月19日 开源校园行-西邮站</p>
        <p>http://www.xiyoulinux.cn/blog/?p=79</p>
        <p>此次活动是由国内知名开源人士于2003年发起，旨在各大高校宣传开源文化，为高校师生、社会团体、公司机构搭建一个开放的交流平台，帮助更多的人了解开源世界的五彩缤纷和发展前景、
                        参与开源，共同推动全球开源软件运动的发展。主讲人介绍程勇(Peter Cheng)，国内开源运动的布道者，huihoo.org开源社区协同创始人。 </p>
        <p style="font-weight: bold">2007年11月1日内核开发者-Herbert Xu</p>
        <img alt="" src="./images/active/active_02.jpg" class="imgl"/>
        <p>http://www.xiyoulinux.cn/blog/?p=57</p>
        <p>Herbert Xu是旅居澳洲的华人，也是一个资深的内核开发者。他负责维护Linux内核的Crypto API部分。他与我们小组成员进行了面对面的交流，并为西邮学生做了一次精彩的演讲。</p>
        <p style="font-weight: bold">2007年9月16日 第四届国际自由软件日</p>
        <img alt="" src="./images/active/active_01.jpg" class="imgl"/>
        <p>http://www.xiyoulinux.cn/blog/?p=49</p>
        <p>出席本次活动的嘉宾有西安邮电学院计算机系副主任王忠民、计算机系陈莉君教授、中国自由软件协会王开源老师、“哲思自由软件社团”创始人徐继哲先生、中科（西安）红旗LINUX集团发言人、
                            香港基石集团驻西安发言人等，我院师生及其他高校同学共300余人参加了本次活动。</p>
        </div>
      </div>
    </div>
  </body>
</html>
