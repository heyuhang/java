<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>visit</title>
<script type="text/javascript" src="js/CJL.0.1.min.js"></script>
<script type="text/javascript" src="js/AlertBox.js"></script>
<script type="text/javascript" src="js/index_ajax.js"></script>
<script type="text/javascript" src="js/addcom.js"></script>
<link rel="shortcut icon" href="./images/settop.gif" type="image/x-icon" />
<link rel="icon" href="./images/settop.gif" type="image/gif" >
<script src="http://ajax.microsoft.com/ajax/jquery/jquery-1.4.4.min.js"></script>
<link href="css/user.css" rel="stylesheet" type="text/css" />
<link href="css/sharebox.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div id="header">
  <div class="toplogo"> </div>
  <div class="top"> 
    <ul>
      <li><a href="login">登陆</a></li>
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
			<div class="publish">
			关注：<s:property value="atteno"/></div>
			<div class="publish">发表：<s:property value="filesize"/></div>
      		<div class="publish"><p>兴趣爱好：</p><s:property value="user.interest"/></div>
      		<div class="publish"><p>自我介绍：</p><s:property value="user.introduct"/></div>
      		<div class="publish">E-MAIL：</p><p><s:property value="user.email"/></div>
      		
      		<s:if test="guanzhu==2">
      		<div id="guanzhu"><span onclick="addattention(<s:property value="user.id" />,'<s:property value="#session['xiyoulinuxusername']" />');">加他关注</span></div>
      		</s:if><s:elseif test="guanzhu==1">
      		<div id="guanzhu"><span onclick="cancleatt(<s:property value="user.id" />);">取消关注</span></div>
      		</s:elseif>
		</div>
	</div>
	</div>
    </div>
</div>
<div id="userright">

	<s:if test="filesize==0">
		<div style="font-weight:bold;color:red">他还么有发表内容</div><br><br>
    </s:if>
    <s:else>
<s:iterator value="filel" status="stat">
    <div id="header1">
	<div class="header2">
	<div class="header3">
			<div id="boxcent">
				<div class="htop">
				<div class="header">
				<a href="visit?toid=<s:property value="userid"/>"><img id="trigger<s:property value="id"/>" rel="floatBox<s:property value="id"/>" src=".<s:property value="user.headpath" />"/>
				</a>
				</div>
                <div class="name" id="name<s:property value="id"/>"><s:property value="title"/></div>
              
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
			<div class="m" id="approve<s:property value="id"/>"><a href="javascript:;" onclick="approve(<s:property value="id"/>);">赞(<span ><s:property value="approve"/></span>)</a></div>
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
   <s:url id="url_pre" value="visit?toid=%{user.id}&">
         <s:param name="PageNow" value="PageNow-1"></s:param>
   </s:url>
   <s:url id="url_next" value="visit?toid=%{user.id}&">
         <s:param name="PageNow" value="PageNow+1"></s:param>
    </s:url>
    <s:url id="url_now" value="visit?toid=%{user.id}&">
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
        <s:url id="url" value="visit">
        	<s:param name="PageNow" value="PageNow"/>
   		</s:url>
   </s:iterator>

	<s:bean name="org.apache.struts2.util.Counter" id="counter">
  		<s:param name="first" value="1" />
  		<s:param name="last" value="TolePage" />
		<s:iterator>
			<s:if test="PageNow!=PageNow-1">
    		<span id="s"><a href="visit?toid=<s:property value="user.id"/>&PageNow=<s:property/>"><s:property/></a></span>
    		</s:if>
    		<s:else>
    			<font color="red"><s:property/></font> 
    		</s:else>
   		</s:iterator>
  	</s:bean>
   		<span id="s"><s:a href="%{url_next}">下一页</s:a></span>
   		当前页:<s:property value="PageNow"/>
   	</div>
</s:if>
    </s:else>	
	
</div>
	<div style="clear:both"></div>
	<div id="footer"> 
    <address>
    	CopyRight-xiyoulinux 2006-2013 
    </address>
	</div>	
</div>
<script type="text/javascript">
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

