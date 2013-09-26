
$(document).ready(function() {	
	$("#box").hide();
	$("#updown").css("top",window.screen.availHeight-220+"px");
	$(window).scroll(function() {		
		if($(window).scrollTop() >= 100){
			$('#updown').fadeIn(300); 
		}else{    
			$('#updown').fadeOut(300);    
		}  
	});
	$('#updown .up').click(function(){$('html,body').animate({scrollTop: '0px'}, 800);});
	$('#updown .down').click(function(){$('html,body').animate({scrollTop: document.body.clientHeight+'px'}, 800);});
		$('#navigation li').mousemove(function(){
			
			$(this).find('.subnav').slideDown();;
			$(this).find('a').addClass("active");
		});
		$('#navigation li').mouseleave(function(){			
			$(this).find('.subnav').stop(true,true).slideUp("fast");
			$(this).find('a').removeClass("active");			
			
		});
		$(".login").bind("mouseover",function(){
			$(this).stop().animate({top:1},300);
		});
		$(".login").bind("mouseout",function(){
			$(this).stop().animate({top:-35},500);
		});
});
function floatbox(num){
	var nu=num;

	$("#pageflip"+nu).hover(function() {
			$("#pageflip"+nu+" img , .msg_block"+nu).stop()
				.animate({
					width: '57px', 
					height: '59px'
				}, 500); 
			} , function() {
			$("#pageflip"+nu+" img").stop() 
				.animate({
					width: '20px', 
					height: '22px'
				}, 220);
			$(".msg_block"+nu).stop() 
				.animate({
					width: '20px', 
					height: '20px'
				}, 200);
		});	
	
		$("#trigger"+nu).powerFloat({
		target: $("#floatBox"+nu)	
		});
}
function approve(num){
	$.post("approve",{
		id: num,
	},function(date,textStatus){
		$("#approve"+num).html("<a href='javascript:;'>已赞(<span >"+date+"</span>)</a>");
		
	});
}
function approvezan(num){
	$.post("approvezan",{
		id: num,
	},function(date,textStatus){
		$("#approve"+num).html("<a href='javascript:;'>已赞(<span >"+date+"</span>)</a>");
	});
}
function tongji(num){
	//统计评论字符数
	$("#replay-n-"+num+", #comment-"+num).find("#text-"+num).bind('focus keyup input paste',function(){  //���ü����¼������������������ճ���¼���
 		
		$("#comments , #replay-n-"+num).find(".tongjiw-"+num).text($(this).attr("value").length);  //��ȡ���ۿ��ַ�Ȳ���ӵ�Ԫ����
		
		if($(this).attr("value").length>100){
			$("#comments , #replay-n-"+num).find(".tongjiw-"+num).css('color','red');
		}else{
			$("#comments , #replay-n-"+num).find(".tongjiw-"+num).css('color','black');
		}
	});
}
function utongji(){
	//统计评论字符数
	$("#upload").find("textarea").bind('focus keyup input paste',function(){  //���ü����¼������������������ճ���¼���
 	
		$("#upload").find("#words-u").text($(this).attr("value").length);  //��ȡ���ۿ��ַ�Ȳ���ӵ�Ԫ����
		
		if($(this).attr("value").length>400){
			$("#upload").find("#words-u").css('color','red');
		}else{
			$("#upload").find("#words-u").css('color','black');
		}
	});
}

//知道
function submitans(num){

	var content=document.getElementById("text-"+num).value;
    if(content=="")
    {
    	alert("请输入内容！");
    	return;
    }
 
    addans(num,content);
}
//ajax发送
function support(num,userid,curid){
	if(userid==curid){
		alert("不能支持自己提问");
		return;
	}
	$.post("support",{
		id: num,
	},function(date,textStatus){
		
		$("#support-"+num).html("<a href='javascript:;'>已支持(<span>"+date+"</span>)</a>");
	});	
}
function addans(fileid,content){
	
	$.ajax({
	    type:"GET",
		url : "addans",
		data : {fileid:fileid,content:content},
		dataType : "json",//这里的dataType就是返回回来的数据格式了html,xml,json
		cache: false,//设置是否缓存，默认设置成为true，当需要每次刷新都需要执行数据库操作的话，需要设置成为false
		beforeSend: function(){
			$("#putway-"+fileid).find("#send").html("<img src='./images/load.gif' width='25px' height='25px'/>");
		},
		complete:function(){
			$("#putway-"+fileid).find("#send").html("<input type='button' onclick='submitans("+fileid+")'  value='提交答案'/>");
		},
		success : function(data) {
				
				var contents="";
				$.each(data, function(index,comment){
					contents+="<div class='comment'>";
					contents+="<span class='headpath'><img src='."+comment.headpath+"'></span>";
					contents+="<span class='username'>"+comment.name+"回答</span>:";
					contents+="<br/><div class='contentt'>"+comment.content+"</div><div>";
					contents+="<span class='anser'><a onclick='support("+comment.comid+","+comment.fromid+","+comment.curid+");' >支持(<span id='support-"+comment.comid+"'>"+comment.approvano+"</span>)</a></span>";
					contents+="<span class='time'>"+comment.commentime+"</span>";
					contents+="<div style='clear:both'></div></div></div>";
					
				});
				$("#comm-"+fileid).append(contents);		
			}
		});
}

function putaway(num){
	$("#putway-"+num).animate({opacity:0,height:'toggle'},500);	
}
function shou(){
	$(".msg").animate({opacity:0,height:'toggle'},500);
	
}

//置顶
function settop(num){
	$.post("settop",{
		fileid: num,
	},function(date,textStatus){
		
		alert("成功置顶");
		var cont="<span style='float:right;font-size:15px;color:#BBBBBB;padding:5px 5px' onclick='deltop("+num+");'>取消置顶</span>";
		$("#settop"+num).html(cont);
	});	
}
//取消置顶
function deltop(num){
	$.post("deltop",{
		fileid: num,
	},function(date,textStatus){
		
		alert("成功取消");
		var cont="<span style='float:right;font-size:15px;color:#BBBBBB;padding:5px 5px' onclick='settop("+num+");'>置顶</span>";

		$("#settop"+num).html(cont);
	});	
}
//关注
function addattention(num,name){
	if(name==null || name==""){
		alert("您还没有登录");
		return ;
	}
	$.post("addattention",{
		toid: num,
	},function(date,textStatus){
		alert(date);
		var contents="<span onclick='cancleatt("+num+");'>取消关注</span>";
		$("#guanzhu").html(contents);
	});	
}
//取消关注
function cancleatt(toid){

	$.post("cancleattr",{
		toid:toid,
	},function(date,textStatus){
		alert(date);
		var contents="<span onclick='addattention("+toid+",'"+username+"');'>加他关注</span>";
	
		$("#guanzhu").html(contents);
	});	
}
//message
function message(){
	$("#tishi").animate({opacity:0,height:'toggle'},500);
	$.post("message"
	,function(date,textStatus){
		
		var contents="<div class='msg'>";
		
		$.each(date, function(index,messages){
			contents+="<div style='padding:5px'><img src='."+messages.headpath+"' width='30px' height='30px'/>";
			contents+=messages.name+"<span style='color:#BBB;font-size:13px;'>回复你:</span><div id='replaymsg'>"+messages.message+"</div>";
			contents+="<a href='trends' target='_blank' class='look_msg'>查看</a></div>";
		})
		contents+="<s:if test='size>6'><div style='text-align:center'><a href='trends' target='_blank' style='color:#d14e08'>查看更多</a></div></s:if><a onclick='shou();' href='javascript:;' style='padding:10px;' class='look_msg'>收起</a></div>";
		$("#message").html(contents);
	});	
}
//delete file
function delfile(id){
	$("#tishi").animate({opacity:0,height:'toggle'},500);
	$.post("delfile",{
		fileid:id
	}
	,function(date,textStatus){
		alert(date);		
		$(".del"+id).animate({opacity:0,height:'toggle'},500);		

	});
}
//count
function countupdate(num){
	$("#tijiao").hide();
	$("#tijiao2").show();
	if(!checkcount()){
		$("#tijiao").show();
		$("#tijiao2").hide();
		return ;
	}
	var oldpassword=$("#idBoxTxt1").attr("value");
	var newpassword=$("#idBoxTxt2").attr("value");
	//aajx
	$.post("updatecount",{
		id:num,oldpassword:oldpassword,newpassword:newpassword
	}
	,function(date,textStatus){
		alert(date);		
		$("#tijiao").show();
		$("#tijiao2").hide();	

	});
}
//replay
function replay(no,fileid,toid){
	var content=$("#replay_text"+no).val;
    if(content=="")
    {
    	alert("请输入内容！");
    	return;
    }
	$.post("message"
	,function(date,textStatus){
		
		var contents="<div class='msg'>";
		
		$.each(date, function(index,messages){
			contents+="<div style='padding:5px'><img src='."+messages.headpath+"' width='30px' height='30px'/>";
			contents+=messages.name+"<span style='color:red'>回复你:</span>"+messages.message;
			contents+="<a href='trends' target='_blank' class='look_msg'>查看</a></div>";
		})
		contents+="<s:if test='size>6'><div style='text-align:center'><a href='trends' target='_blank' style='color:#d14e08'>查看更多</a></div></s:if><a onclick='shou();' href='javascript:;' style='padding:10px;' class='look_msg'>收起</a></div>";
		$("#message").html(contents);
	});	
}
//回复动态
function replay(no,fileid,toid){
	 var content=$("#replay_text"+no).val();
	 if(content=="")
	 {
	    	alert("请输入内容！");
	    	return;
	 }
	$.post("addcom",{
		fileid:fileid,toid:toid,content:content
	}
	,function(date,textStatus){
		var content="";
		$.each(date, function(index,comments){			
			content="<div style='padding:4px 5px 4px 20px'>"+comments.name+"回复"+comments.toname+"："+comments.content+"<span style='float:right'>"+comments.commentime+"</span></div>"; 
			
		})
		$("#replay"+no).append(content);
	
	});	
}
//关闭回复
function close_replay(no){
	$.post("delreplay",{
		id:no
	}
	,function(date,textStatus){
		$("#repaly_box"+no).animate({opacity:0,height:'toggle'},500);	

	});	
}
function delall(){
	$.post("delall"
	,function(date,textStatus){
		$("#replay-all").animate({opacity:0,height:'toggle'},500);	

	});	
}

function shou(){
	$(".msg").animate({opacity:0,height:'toggle'},500);
	
}
function share(id){

	$(".box"+id).toggle();
}
function imghover(id){
	$("#cont"+id).find("#boximg"+id).animate({width:50+"%", height:50+"%"},300);
	
}
function imgouthover(id){
	$("#cont"+id).find("#boximg"+id).animate({width:20+"%", height:20+"%"},300);
}


