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
<title>个人中心</title>
<script type="text/javascript" src="js/CJL.0.1.min.js"></script>
<script type="text/javascript" src="js/AlertBox.js"></script>
<script type="text/javascript" src="js/index_ajax.js"></script>
<script type="text/javascript" src="js/addcom.js"></script>
<script src="http://ajax.microsoft.com/ajax/jquery/jquery-1.4.4.min.js"></script>
<link href="css/user.css" rel="stylesheet" type="text/css" />
<link href="css/sharebox.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
$(document).ready(function() {
	$("#alertcount").hide();
	$("#alertmsg").show();
	$("#tijiao").show();
	$("#tijiao2").hide();
	$("#studyshow").css("background-color","#BBBBBB");
	
	$("#user-fa").bind("click",function(){
		$("#user-send").show();
	});
});
   function msgalert(){
		$("#alertmsg").show();
   		$("#alertcount").hide();   		
   }
   function countalert(){
		$("#alertmsg").hide();
   		$("#alertcount").show();   		
   }
    function check(){
        if($("#load1").attr("value")=="" || $("#load2").attr("value")=="" || $("#load3").attr("value")=="" 
        || $("#load4").attr("value")=="" ){
            alert('INPUT不能空！');
            return false;
         }else if($("#load1").value.length>400){
            alert('内容太长!(200字以内)'); 
            return false;        	
         }else{
          return true;
         }
    }
    function check_b(){

        if($("#loadb1").attr("value")=="" || $("#loadb2").attr("value")==""  || $("#loadb4").attr("value")=="" ){
            alert('INPUT不能空！');
            return false;
         }else if($("#load1").value.length>400){
            alert('内容太长!(200字以内)'); 
            return false;        	
         }else{
          return true;
         }
    }
    function checkcount(){
		var quen=/^\s*[A-Za-z0-9]{5,16}\s*$/;
    	if($("#idBoxTxt1").attr("value")=="" || $("#idBoxTxt2").attr("value")=="" || $("#idBoxTxt3").attr("value")==""){
    		alert('密码不能为空！');
    		return false;
    	}else if(!quen.test($("#idBoxTxt2").attr("value")) || !quen.test($("#idBoxTxt3").attr("value"))){
    		
    		alert('密码由5个字符字母和数字组成！');
    		return false;   
    	}else if($("#idBoxTxt2").attr("value")!=$("#idBoxTxt3").attr("value")){
     		alert('重复密码不同！');
    		return false;   	
    	}
    	return true;
    }
	function checkmsg(){
        if($("#idBoxTxt4").attr("value")=="" 
         ){
          	alert('INPUT不能空！');
    		return false;
    	}
    	return true;	
	}



$(function() {
	//target参数加载
	$("#trigger").powerFloat({
		target: $("#targetBox")	
	});
});
</script>
<style>
.dn{
	display:none;
	background-color:#fff;
	width:300px;
	padding:5px;
}
.shadow{
	-moz-box-shadow:0 0 5px rgba(52, 83, 139, .6); 
	-webkit-box-shadow:0 0 5px rgba(52, 83, 139, .6); 
	box-shadow:0 0 5px rgba(52, 83, 139, .6);
}
.gpep{
	
	border:1px solid #bbb;
}
.gpep img{
	width:30px;
	height:30px;
}
.gpep a{
	text-decoration:none;
	color:#000;
	padding:5px 5px;
}
.gpep a:hover{
	color:#19558f;
}
</style>
</head>
<body>
<div id="header">
  <div class="toplogo"> </div>
  <div class="top"> 
    <ul>
      <li><a href="exit">退出</a></li>
      <li><a href="regist">注册</a></li>
      <li><a href="index">首页</a></li>
    </ul>
  </div>
</div>
<div id="contents">
<div class="person">
      <s:property value="user.name"/>的个人主页
</div>
<div id="userleft">
    <div id="header11">
	<div class="header22">
	<div class="header33">
		<div class="userhead"><div><img src=".<s:property value='user.headpath'/>"  /></div></div>

		<div class="line"></div>
		<div class="descration">
			<div class="publish"><a id="trigger" href="javascript:;" rel="targetBox">
			关注：<s:property value="atteno"/></a>
			</div>
<s:if test="atteno>0">
<!--浮动框  -->
<div id="targetBox" class="shadow target_box dn">
我关注的人：
<div class="gpep">
<s:iterator value="attention" status="stat">
	<span><a href="visit?toid=<s:property value="id"/>" ><img src=".<s:property value="headpath"/>"/><s:property value="name"/></a></span>
</s:iterator>
</div>
</div>
<script type="text/javascript" src="js/jquery-powerFloat.js"></script>
</s:if>
			<div class="publish">
			<a href="#fabiao" id="user-fa">发表：<s:property value="filesize"/></a>
			</div>
			
			<div class="publish">
			<a id="loginbox" href="javascript:;">
			个人信息管理
			</a>
			</div>
		

			
			      		
		</div>
	</div>
	</div>
    </div>

	
</div>
<div id="userright">

	<s:if test="filesize==0">
		您还么有发表内容<br><br>
    </s:if>
    <s:else>
<s:iterator value="filel" status="stat">
    <div id="header1" class="del<s:property value="id"/>">
	<div class="header2">
	<div class="header3">
			<div id="boxcent">
				<div class="htop">
				<div class="header">
				<a href="visit?toid=<s:property value="userid"/>"><img id="trigger<s:property value="id"/>" rel="floatBox<s:property value="id"/>" src=".<s:property value="user.headpath" />"/>
				</a>
				</div>
                <div class="name" id="name<s:property value="id"/>"><s:property value="title"/></div>
               
        <s:if test="#session['xiyou_admin']!=null">
			<s:if test="toptime!=null"> 
			<span id="settop<s:property value="id"/>">
      		<span style="float:right;font-size:15px;color:#BBBBBB;padding:5px 5px" onclick="deltop(<s:property value="id"/>);">取消置顶</span>
      		</span>
      		</s:if>
      		<s:else>
      		<span id="settop<s:property value="id"/>"><span  style="float:right;font-size:15px;color:#BBBBBB;padding:5px 5px" onclick="settop(<s:property value="id"/>);">置顶</span>     		
      		</span>
      		</s:else>
      	</s:if>
      
      	 <span style="float:right;font-size:15px;color:#BBBBBB;padding:5px 5px" onclick="delfile(<s:property value="id"/>);">删除</span>
  
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
			<div class="m" id="approve<s:property value="id"/>"><a href="javascript:;" onclick="approve(<s:property value="id"/>);">赞(<span><s:property value="approve"/></span>)</a></div>
			<div class="m" id="n">

			<a href="javascript:;" onclick="comment(<s:property value="id"/>);">评论
			(<span><s:property value="commentno"/></span>)</a></div>
			<div class="m" id="n"><a href="javascript:;" onclick="share(<s:property value="id"/>)">分享</a></div>
			<s:if test="filepath!='false' && label!='false'">
			<div class="m" id="n">
			<a href="<s:url value='download'>                 
                    <s:param name='fileName'  value='filepath'/>    
                 	</s:url>">下载</a>
            </div>
            </s:if>
            </div>
            <!-- 分享 -->
<div id="box_other" class="box<s:property value="id"/>" style="display:none;">
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
    </s:iterator>
<!-- 分享js -->
<script type="text/javascript" id="bdshare_js" data="type=tools" ></script>  
<script type="text/javascript" id="bdshell_js"></script>  
<script type="text/javascript">  
        document.getElementById("bdshell_js").src = "http://share.baidu.com/static/js/shell_v2.js?t=" + new Date().getHours();  
</script>
<s:if test="TolePage>1">
   <s:url id="url_pre" value="user">
         <s:param name="PageNow" value="PageNow-1"></s:param>
   </s:url>
   <s:url id="url_next" value="user">
         <s:param name="PageNow" value="PageNow+1"></s:param>
    </s:url>
    <s:url id="url_now" value="user">
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
    		<span id="s"><a href="user?PageNow=<s:property/>"><s:property/></a></span>
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
</s:else>
   <a name="fabiao"></a>
<div id="user-send" style="display:none">
	<div id="upload">
	<div style="border-bottom:2px dashed #BBBBBB"></div><br/>
	<div style="padding:2px 5px;color:#1A8FC9;font-weight:bold;border-bottom:1px solid #BBBBBB">
		<a href="javascript:;" style="text-decoration:none;border:1px solid #BBBBBB;padding:4px 8px;color:#1A8FC9;border-bottom:none" id="studyshow">
		学习</a>  
		<a href="javascript:;" style="text-decoration:none;border:1px solid #BBBBBB;padding:4px 8px;color:#1A8FC9;border-bottom:none" id="lifeshow">
		Q&A</a>
	</div>
	<form id="study" action="filesupload?id=<s:property value="user.id"/>" style="padding:10px" method="post" enctype="multipart/form-data" onsubmit="return check()">

		<div style="width:630px;color:#312618;font-size:13px;">
		<div>标题：<input type="text" id="load2" name="title" size="20" /></div><br/>
		<div>标签：<input type="text" id="load3" name="label" size="20"/></div><br/>
		<div>上传：<input  name="myFile" id="load5" type="file" size="35" />(选择性上传,允许doc,pdf,ppt,jpg格式文件)</div>
		<div style="color:red;font-size:14px">注意：文件大小10M以内</div><br />
		<div><label>介绍:</label>
			<textarea  onfocus="utongji()" name="text" id="load1"  rows="7" cols="60" style="width:100%"></textarea> 
			<div id="words-t-u" class="words-t" style="float:right;">
    			  共
    			<span id="words-u" class="words" style="color: black;">0</span>
      			/400字
    		</div>
			</div>
		<br/>

		验证码：<input type="text" id="load4" name="checkcode" size="5"/> 
		<img src="images/image.jsp"/><a href="user" style="text-decoration:none;color:red">看不清</a>   
		        <span style="color:red">
			    <s:property value="msg"/>
			    </span>
		<br/><br/>
		<div  style="margin-left:50px;"><input type="image" name="save" src="images/publish.jpg"/></div>
		<br/>
		</div>
	</form>

	<form id="life" action="aqupload" style="padding:10px;display:none" method="post" enctype="multipart/form-data" onsubmit="return check_b();">

		<div style="width:630px;color:#312618;font-size:13px;">
		<div>标签：<input type="text" id="loadb2" name="label" size="20" /></div><br/>
		<div><label>问题:</label>
			<textarea   onfocus="utongji()" name="text" id="load1b"  rows="7" cols="60" style="width: 100%"></textarea> 
			<div id="words-t-u" class="words-t" style="float:right;">
    			  共
    			<span id="words-u" class="words" style="color: black;">0</span>
      			/400字
    		</div>
			</div>
		<br/>

		验证码：<input type="text" id="loadb4" name="checkcode" size="5"/> 
		<img src="images/image.jsp"/><a href="user" style="text-decoration:none;color:red">看不清</a>   
		        <span style="color:red">
			    <s:property value="msg"/>
			    </span>
		<br/><br/>
		<div  style="margin-left:50px;"><input type="image" name="save" src="images/publish.jpg"/></div>
		<br/>
		</div>
		<br/>
		<br/>
	</form>	
	</div>
</div>	
</div>
<div style="clear:both"></div>
	<div id="footer"> 
    <address>
    	CopyRight-xiyoulinux 2006-2013 
    </address>
	</div>
</div>

<div id="logbox" class="lightbox" style="top:10%;left:5%;">
	<span id="idBoxClose" style="float:right;padding:4px 10px;background:#1A8FC9;with:50px;height:20px;cursor:pointer">关闭</span>
	<div style="padding:30px 20px">
	<div style="padding:2px 5px;color:#1A8FC9;font-weight:bold;border-bottom:1px solid #1A8FC9"><a href="#" style="text-decoration:none;border:1px solid #1A8FC9;padding:4px 8px;color:#1A8FC9;border-bottom:none" onclick="msgalert();">
	信息</a>  <a href="#" style="text-decoration:none;border:1px solid #1A8FC9;padding:4px 8px;color:#1A8FC9;border-bottom:none" onclick="countalert();">账号</a></div>
	<div id="alertmsg">
		<br/>
		<form action="updatemsg?id=<s:property value="user.id"/>" method="post" enctype="multipart/form-data" onsubmit="return checkmsg()">
		<span style="padding:5px 10px">用户姓名：</span><input type="text"  id="idBoxTxt4" value="<s:property value="user.name"/>" name="name" style="background: white;border: 1px solid #BBB;height: 30px;"/><span style="color:red">*</span><br/><br/>
		<span style="padding:5px 10px">技术特长：</span><input type="text"  id="idBoxTxt5" value="<s:property value="user.interest"/>" name="interest" style="background: white;border: 1px solid #BBB;height: 30px;"/><br/><br/>
		<span style="padding:5px 10px">自我介绍：</span><input type="text"  id="idBoxTxt6" value="<s:property value="user.introduct"/>" name="introduct" style="background: white;border: 1px solid #BBB;height: 30px;"/><br/><br/>
		<span style="padding:5px 10px">上传头像：</span><input type="file"  id="idBoxTxt7" value="<s:property value="user.headpath"/>" name="headphoto" style="background: white;border: 1px solid #BBB;height: 30px;"></input><br/><br/>
		<input type="image" src="images/tijiao.png" style="padding:10px 10px;float:right"/>
		<input type="hidden" name="oldhead" value="<s:property value="user.headpath"/>"/>
		</form>
	</div>
	<div id="alertcount">
		<br/>
		<span style="padding:5px 10px">旧密码：</span><input type="text"  id="idBoxTxt1"  name="oldpassword" style="background: white;border: 1px solid #BBB;height: 30px;"/><br/><br/>
		<span style="padding:5px 10px">新密码：</span><input type="password"  id="idBoxTxt2"  class="password1" name="newpassword" style="background: white;border: 1px solid #BBB;height: 30px;"/><br/><br/>
		<span style="padding:5px 2px">重复密码：</span><input type="password"  id="idBoxTxt3"  name="password2" style="background: white;border: 1px solid #BBB;height: 30px;"/><br/><br/>
		<span id="tijiao"><input type="image" src="images/tijiao.png" style="padding:10px 10px;float:right" onclick="countupdate(<s:property value="user.id"/>);"/></span>
		<span id="tijiao2"><img src="images/252.gif" style="padding:10px 10px;float:right;"/></span>
	</div>
	</div>
</div>
<script>
(function(){

var ab = new AlertBox("logbox"), lock = false;

function lockup(e){ e.preventDefault(); }

function lockout(e){ e.stopPropagation(); }

ab.onShow = function(){

	if ( lock ) {
		$$E.addEvent( document, "keydown", lockup );
		$$E.addEvent( this.box, "keydown", lockout );
		
		OverLay.show();
	}
}
ab.onClose = function(){

	$$E.removeEvent( document, "keydown", lockup );
	$$E.removeEvent( this.box, "keydown", lockout );
	OverLay.close();
}

$$("idBoxClose").onclick = function(){ ab.close(); }

$$("loginbox").onclick = function(){
	lock = true;
	ab.center = true;
	ab.fixed = true;	
	ab.show();
}
})();

$("#studyshow").click(function(){
		$("#study").show();
		$("#lifeshow").css("background-color","rgb(210, 209, 208)");
		$("#studyshow").css("background-color","#BBBBBB");
		$("#life").hide();
	});
$("#lifeshow").click(function(){
		$("#study").hide();
		$("#lifeshow").css("background-color","#BBBBBB");
		$("#studyshow").css("background-color","rgb(210, 209, 208)");
		$("#life").show();
});
function comment(num){	
	$.ajax({
	    type:"GET",
		url : "comment",
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
				contents+="还没有人评论";
			}else{
		
				$.each(data, function(index,comment){
					contents+="<div class='comment'>";
					contents+="<span class='headpath'><img src='."+comment.headpath+"'></span>";
					if(comment.toid==-1){
						contents+="<span class='username'>"+comment.name+"评论</span>:";
					}else{
						contents+="<span class='username'>"+comment.name+"</span>回复<span class='username'>"+comment.toname+"</span>：";		
					}
					contents+="<br/><div class='contentt'>"+comment.content+"</div><div>";
					contents+="<span class='anser'><a onclick='input("+'"'+comment.name+'",'+num+","+comment.fromid+");' href='#replay"+num+"'>回复</a></span>";
					contents+="<span class='time'>"+comment.commentime+"</span>";
					contents+="<div style='clear:both'></div></div></div>";
				});
				}
				contents+="</div><a name='replay"+num+"'></a>";
				contents+="<div class='ping'><s:if test='#session.xiyoulinuxusername!=null'>";
				contents+="<div class='tjwords'>共<span class='tongjiw-"+num+"'>0</span>/100</div>";
				contents+="<div class='anwser'><textarea  id='text-"+num+"'  onfocus='tongji("+num+")' cols='120'  class='question'></textarea></div>";
				contents+="<div class='located'><span id='send'><input type='button' onclick='submitcom("+num+")'  value='发表评论'/></span></div>";
				contents+="</s:if><s:else>登陆后才能评论！<a href='#' id='loginbox'>登陆</a></s:else><span onclick='putaway("+num+");'>收起评论</span></div>";

				$("#comment-"+num).html(contents);
		}
	}); 
}
</script>
</body>
</html>

