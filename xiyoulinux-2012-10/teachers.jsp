<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>辅导老师</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
     <div id="right">
        <div class="paddingrightbox">
		<h1 style="text-align:center;color:#D9930B;">辅导老师</h1>
		<img alt="陈丽君老师" src="./images/chenlijun.jpg" style="width:300px;height:220px;border:#e3e3e3 1px solid;padding:3px"/>
		 <p style="text-indent:2em">
		 陈莉君教授，国内Linux内核专家，对Linux内核的研究有很深的造诣。陈老师自98年来一直致力于推动Linux在中国的发展，深入研究Linux内核相关理论以及技术，
		 积极跟踪Liunx内核发展动向，为Linux爱好者默默提供着无私帮助。陈老师在我们兴趣小组发展上倾入了大量的心血。陈老师在Linux研究、学习思想上给了我们很
		 多的指导，让我们在Linux学习上或者是计算机科学的领悟上都有了一个很大的提高，鼓励我们突破思维的束缚，不断地去进行创新和发展自我。 
		  </p>
        </div>
  
        <div class="paddingrightbox">
		<img alt="王亚刚老师" src="./images/wangyagang.jpg" style="width:300px;height:220px;border:#e3e3e3 1px solid;padding:3px"/>
		<p style="text-indent:2em">
		王亚刚教授，毕业于西北大学计算机系，长期从事计算机网络和嵌入式Linux系统的开发和教学工作，评教成绩突出。
		承担多项科研项目的开发，他对Linux内核的裁剪有着相当丰富的经验。从我们兴趣小组最初的成立，到目前小组各项
		活动的进行，他都倾注了很大心血。王老师在Linux，C语言，Java以及编程思想等许多方面都使我们受益匪浅，他给了
		小组成员发展自我优秀个性的空间，鼓励学生去发现自我，完善自我。
                      还有很多的老师也给予了我们大量的支持！在此，我们小组全体成员向所有支持我们小组的老师表示衷心的感谢！ 
        </p>

        </div>
      </div>
    </div>
  </body>
</html>
