<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>参与社区</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/sstyles.css">


  </head>
  
  <body>
     <div id="right">
        <div class="paddingrightbox">
 <p>
 			
 			<h1 style="text-align:center;color:#D9930B;">参与开源社区</h1>
            <b>1) kernel.org ──Linux内核开发社区</b>
            </p>
            <p>补丁提交若干，翻译、校对技术文档若干。<br/>
         	   Git地址：<br/>
                   http://www.kernel.org/pub/scm/Linux/kernel/git/torvalds/Linux-2.6.git<br/>
               邮件列表地址：<br/>
                  http://lkml.org<br/>
            </p>
            <p>
            <b>2) zeuux.org──哲思自由软件社区</b>
            </p>
            <p>
                 参与撰写、翻译、校验文档：<br/>
                 • 《哲思技术文档》参与撰写<br/>
                 • 《哲思自由软件图书》参与撰写<br/>
                 • 《可爱的Python》文章撰写和技术校对<br/>
                 • 《自由软件，自由社会》翻译<br/>
            </p>
            <p>
            <b>3) zh-kernel.org──Linux开发中文社区</b>
            </p>
            <p>
                 • HOWTO http://wiki.zh-kernel.org/doc/HOWTO 参与编写<br/>
			     • 为中文内核社区翻译文档若干<br/>
            </p>
            <p>
            <b>4) kerneltravel.net──陈莉君老师的内核之旅</b>
            </p>
            <p>
                网站维护、文档翻译等。<br/>
                 • GNU-C扩展<br/>
                     http://www.kerneltravel.net/newbie/gcc_man.html<br/>
                 详见：<br/>
                     http://xiyoulinux.cn/speechdoc/contribution.html<br/>
            </p>
            <p>
            <b>5）技术杂志稿件</b>
            </p>
            <p>
                在《网络管理员》、《开源杂志》杂志上发表技术文若干<br/>
            </p>
             <p>
            <b>6）ChinaUnix开源社区建立了XYLinux博客群</b>
            </p>
            <p>
                详见：</br>
                http://blog.chinaunix.net/group/group_1475.html<br/>
            </p>
   </div>
   </div>
   </div>
  </body>
</html>
