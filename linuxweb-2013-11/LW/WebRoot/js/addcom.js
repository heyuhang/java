//
//增加评论
var toid=-1;
var com=true;
var ment=-1;
function input(name,num,id){
	com=false;
	ment=num;
	toid=id;
    if(navigator.userAgent.indexOf("MSIE")>0) {
    	document.getElementById("text-"+num).value="回复："+name;
    }else{
    	document.getElementById("text-"+num).placeholder="回复："+name;
    }
} 
function submitcom(num){
	var content=$("#text-"+num).val();
    if(com==false && ment!=num){//点击回复，没有回复
    	toid=-1;
    }
    if(content=="")
    {
    	alert("请输入内容！");
    	return;
    }
 
    addcom(num,toid,content);
    toid=-1;
    com=true;
}
//ajax发送
function addcom(fileid,toid,content){
	$.ajax({
	    type:"GET",
		url : "addcom",
		data : {fileid:fileid,toid:toid,content:content},
		dataType : "json",//这里的dataType就是返回回来的数据格式了html,xml,json
		cache: false,//设置是否缓存，默认设置成为true，当需要每次刷新都需要执行数据库操作的话，需要设置成为false
		beforeSend: function(){
			$("#putway-"+fileid).find("#send").html("<img src='./images/load.gif' width='25px' height='25px'/>");
		},
		complete:function(){
			$("#putway-"+fileid).find("#send").html("<input type='button' onclick='submitcom("+fileid+")'  value='发表评论'/>");
		},
		success : function(data) {	
				if(data==""){
					alert("您还没有登录!");
					return ;
				}
				var contents="";
				$.each(data, function(index,comment){
					
					contents+="<div class='comment'>";
					contents+="<span class='headpath'><img src='."+comment.headpath+"'></span>";
					if(comment.toid==-1){
						contents+="<span class='username'>"+comment.name+"评论</span>:";
					}else{
						contents+="<span class='username'>"+comment.name+"</span>回复<span class='username'>"+comment.toname+"</span>：";		
					}
					contents+="<br/><div class='contentt'>"+comment.content+"</div><div>";
					contents+="<span class='anser'><a onclick='input("+'"'+comment.name+'",'+fileid+","+comment.fromid+");' href='#replay"+fileid+"'>回复</a></span>";
					contents+="<span class='time'>"+comment.commentime+"</span>";
					contents+="<div style='clear:both'></div></div></div>";
					
				});
				$("#comm-"+fileid).append(contents);		
			}
		});
}