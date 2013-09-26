<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta content="西邮linuxgroup,linux,西邮,西邮linux兴趣小组" name="keywords"></meta>
<meta content="西邮linux兴趣小组官网" name="description"></meta>
<link rel="shortcut icon" href="./images/topl.jpg" type="image/x-icon" />
<link rel="icon" href="./images/topl.jpg" type="image/gif" >
<title>LinuxQ&A</title>
<script type="text/javascript"  src="http://ajax.microsoft.com/ajax/jquery/jquery-1.4.4.min.js"></script>
<script type="text/javascript"  src="js/index_ajax.js"></script>
<script type="text/javascript"  src="js/waypoints.js"></script>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="css/sharebox.css" rel="stylesheet" type="text/css" />


</head>
<body>
<s:include value="head.jsp"></s:include>
<div id="wrap">
<div class="content">
  <div id="left">
<s:iterator value="fileu" status="fileu">
    <div id="header">
	<div class="header2">
	<div class="header3" onmouseover="floatbox(<s:property value="id"/>)" >
		    <div id="pageflip<s:property value="id"/>" class="pageflip"><span><img src="images/page_flip.png" title="加关注" onclick="addattention(<s:property value="userid" />,'<s:property value="#session['username']" />');"/></span> 
              <div id="msg_block" class="msg_block<s:property value="id"/>"></div>
            </div>
			<div id="boxcent">
				<div class="htop">
				<div class="header">
				<a href="visit?toid=<s:property value="userid"/>"><img id="trigger<s:property value="id"/>" rel="floatBox<s:property value="id"/>" src=".<s:property value="headpath" />"/>
				</a>
				</div>
                <div class="name" id="name<s:property value="id"/>"><s:property value="name"/>提问：</div>
				<s:if test="toptime!=null">
				<div style="float:right"><img src="./images/settop.gif"/></div>
				</s:if>
				</div>
				<div class="line"></div>
				<div class="cont" id="cont<s:property value="id"/>">
					<s:property value="introduct"/>
					<s:if test="label=='false'">
						<div id="boximgs"><img  id="boximg<s:property value="id"/>" src="./uploadimg/<s:property value="filepath"/>" width="20%" height="20%" onmouseup="imghover(<s:property value="id"/>);" onmouseout="imgouthover(<s:property value="id"/>);"/></div>
					</s:if>
				</div>
				<div style="height:20px;"><span class="meanstag">标签
      				:<s:property value="label"/>
    			</span><span class="imgintro">
     				 <s:property value="uploadtime"/>
    			</span></div>
			<div class="com">
			<div class="m" id="approve<s:property value="id"/>"><a href="javascript:;" onclick="approvezan(<s:property value="id"/>);">赞(<span><s:property value="approve"/></span>)</a></div>
			<div class="m" id="n">

			<a href="javascript:;" onclick="answer(<s:property value="id"/>);">回答
			(<span><s:property value="commentno"/></span>)</a></div>
			<div class="m" id="n"><a href="javascript:;" onclick="share(<s:property value="id"/>)">分享</a></div>

            </div>
            <!-- 分享 -->
<div id="box" class="box<s:property value="id"/>" style="display:none;">
<div class="rc_box1">
  <div class="rc_box2">
    <div class="rc_box3">
<!-- Baidu Button BEGIN -->  
<div id="bdshare" class="bdshare_t bds_tools get-codes-bdshare" data="{'commnet':'<s:property value="introduct"/>','desc':'<s:property value="introduct"/>','text':'<s:property value="title"/>','pic':'http://localhost:8080/LW/uploadimg/<s:property value="filepath"/>'}">   
    <a class="bds_tsina">新浪</a>  
    <a class="bds_tqq">腾讯</a>  
    <a class="bds_renren">人人</a>  
    <a class="bds_qzone">QQ </a>  
</div>  
 
<!-- Baidu Button END --> 
	</div>
  </div>
  <div class="ov1"></div>
  <div class="ov2"></div>
</div>
</div>

			<div style="clear:both"></div>

			<div id="comment-<s:property value="id"/>"></div>
			</div>
	</div>
	</div>
    </div>
<!--浮动框  -->
<div id="floatBox<s:property value="id"/>" class="shadow target_box dn">
<p>用户名：<s:property value="name"/></p>
<p>兴趣爱好：<s:property value="interest"/></p>
<p>自我介绍：<s:property value="userintr"/></p>
<p>E-MAIL:<s:property value="email"/></p>
</div>
<script type="text/javascript" src="js/jquery-powerFloat.js"></script>
</s:iterator>
<script type="text/javascript" id="bdshare_js" data="type=tools" ></script>  
<script type="text/javascript" id="bdshell_js"></script>  
<script type="text/javascript">  
        document.getElementById("bdshell_js").src = "http://share.baidu.com/static/js/shell_v2.js?t=" + new Date().getHours();  
</script> 






<s:if test="TolePage>1">
   <s:url id="url_pre" value="index">
         <s:param name="PageNow" value="PageNow-1"></s:param>
   </s:url>
   <s:url id="url_next" value="index">
         <s:param name="PageNow" value="PageNow+1"></s:param>
    </s:url>
    <s:url id="url_now" value="index">
         <s:param name="PageNow" value="PageNow"></s:param>
    </s:url> 
   <div id="headb">
   <s:if test="PageNow==1">
   		<span id="s"><a href="#">上一页</a></span>
   </s:if>
   <s:else>
   <span id="s"><s:a href="%{url_pre}">上一页</s:a></span>
   </s:else>
   <s:iterator value="fileu" status="fileu">
        <s:url id="url" value="index">
        	<s:param name="PageNow" value="PageNow"/>
   		</s:url>
   </s:iterator>

	<s:bean name="org.apache.struts2.util.Counter" id="counter">
  		<s:param name="first" value="1" />
  		<s:param name="last" value="TolePage" />
		<s:iterator>
			<s:if test="PageNow!=PageNow-1">
    		<span id="s"><a href="index?PageNow=<s:property/>"><s:property/></a></span>
    		</s:if>
    		<s:else>
    			<font color="red"><s:property/></font> 
    		</s:else>
   		</s:iterator>
  	</s:bean>
   		<span id="s"><s:a href="%{url_next}">下一页</s:a></span>
   		共<s:property value="TolePage"/>页  &nbsp;当前页:<s:property value="PageNow"/>
   </div>
 </s:if>
 <s:else>
 	<div id="headb">
 		共&nbsp;<s:property value="TolePage"/>&nbsp;页
 	</div>
 </s:else>
</div>
<div id="right">
	<div id="main-top">
	<div class="rlabel">
		<div class="header2">
	    <div class="header3">
<s:include value="photo.jsp"></s:include>
	    </div>
	    </div>
	</div>
	<!--  
	<div class="rlabel" style="margin-top:10px;">
		<div class="header2">
	    <div class="header3">
	    	<img src="<s:property value='weaphoto'/>" style="margin-left:50px" title="<s:property value='weatext'/>" />
	    </div>
	    </div>
	</div>
	-->
	</div>
</div>
<script type="text/javascript">
$(document).ready(function() {
	$("#main-top").waypoint(function(event, direction) {
		$(this).parent().toggleClass('sticky', direction === "down");
		event.stopPropagation();
	});
});
</script>
<div style="clear:both"></div>
</div>
<div id="updown"><span class="up"></span><span class="down"></span></div>

<s:if test="msg==true">
<div id="message"></div>
<br/>
<div id="tishi">
<span class="msge" onclick="message();">新消息</span>
</div>
<audio src="./images/tishi.ogg"  autoplay="autoplay">
Your browser does not support the audio tag.
</audio>
</s:if>

</div>
<div id="footer"> 
  <div class="bottom"> 
    <div class="fridmenu"> 
      <p>友情链接：<img src="images/youku.jpg" width="40" height="40"/></p>
    </div>
  </div>
  <div class="bottom2"> 
    <address  style="width:950px;margin:0 auto;font-size:17px;padding:13px 0;text-shadow:1px -2px #000">
    CopyRight-xiyoulinux 2006-2013
    </address>
  </div>
</div>
<script type="text/javascript">
function answer(num){	
	$.ajax({
	    type:"GET",
		url : "answer",
		data : {id:num},
		dataType : "json",//这里的dataType就是返回回来的数据格式了html,xml,json
		cache: false,//设置是否缓存，默认设置成为true，当需要每次刷新都需要执行数据库操作的话，需要设置成为false
		beforeSend: function(){
			$("#comment-"+num).html("<img src='./images/252.gif'/>");
		},
		success : function(data) {

            var contents="<div id='putway-"+num+"'><div class='line'></div><div id='comments'><div class='comm' id='comm-"+num+"'>";
			if(data=="")
			{
				contents+="还没有人回答此问题";
			}else{
		
				$.each(data, function(index,comment){
					contents+="<div class='comment'>";
					contents+="<span class='headpath'><img src='."+comment.headpath+"'></span>";
					contents+="<span class='username'>"+comment.name+"回答</span>:";
					contents+="<br/><div class='contentt'>"+comment.content+"</div><div>";
					contents+="<span class='anser' id='support-"+comment.comid+"'><a onclick='support("+comment.comid+","+comment.fromid+","+comment.curid+");' >支持(<span>"+comment.approvano+"</span>)</a></span>";
					contents+="<span class='time'>"+comment.commentime+"</span>";
					contents+="<div style='clear:both'></div></div></div>";
				});
				}
				contents+="</div><a name='replay"+num+"'></a>";
				contents+="<div class='ping'><s:if test='#session.xiyoulinuxusername!=null'>";
				contents+="<div class='tjwords'>共<span class='tongjiw-"+num+"'>0</span>/100</div>";
				contents+="<div class='anwser'><textarea  id='text-"+num+"'  onfocus='tongji("+num+")' cols='120'  class='question'></textarea></div>";
				contents+="<div class='located'><span id='send'><input type='button' onclick='submitans("+num+")'  value='提交答案'/></span></div>";
				contents+="</s:if><s:else>登陆后才能评论！<a href='#' id='loginbox'>登陆</a></s:else><span onclick='putaway("+num+");'>收起评论</span></div>";

				$("#comment-"+num).html(contents);
		}
	}); 
}
</script>
</body>