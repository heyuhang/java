$(document).ready(function(){
	$('#navigation li').hover(function(){
		$(this).find('.subnav').animate({opacity:1.0,height:'toggle'},500);
		$(this).find('a').addClass("active");
	},function(){
		$(this).find('.subnav').animate({opacity:0,height:'toggle'},500);
		$(this).find('a').removeClass("active");
	});
	
	$("#commentForm").validate();
	
		$("#signupForm").validate({
		rules: {
			username: {
				required: true,
				minlength: 2
			},
			password: {
				required: true,
				minlength: 5
			},
			confirm_password: {
				required: true,
				minlength: 5,
				equalTo: "#password"
			},
			email: {
				required: true,
				email: true
			},
			checkcode: {
				required: true,
				minlength: 4			
			},
			agree: "required"
		},
		messages: {
			username: {
				required: "*请输入用户名",
				minlength: "*您的用户名至少包含两个字符"
			},
			password: {
				required: "*请输入密码",
				minlength: "*密码长度大于5个字符"
			},
			confirm_password: {
				required: "*请输入密码",
				minlength: "*密码长度大于5个字符",
				equalTo: "*请输入和上面相同的密码"
			},
			checkcode: {
				required: "*请输入验证码",
				minlength: "*长度4个字符"			
			},
			email: "*请输入E-mail地址",
		}
	});
});
function down(id){
	$(id).animate({top:1},500);
};
function up(id){
	$(id).animate({top:-35},500);
};
function createXMLHttp(){
    if(window.XMLHttpRequest){
		xmlHttp=new XMLHttpRequest();
	}else{
		xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
}
function checkusername(name){

    createXMLHttp();
    xmlHttp.open("POST","checkusername?username="+name,true); 
    xmlHttp.onreadystatechange=checkCallback;
    xmlHttp.send(null);
}
function checkCallback(){
   	if(xmlHttp.readyState==4){
   	   	
		if(xmlHttp.status==200){
			var msg=xmlHttp.responseText;
			if(msg=="false"){
				alert("用户名已经存在！");
				document.getElementById("username").focus();
			}
		}
   	}
}