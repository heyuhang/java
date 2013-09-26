<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=GBK" />
        <title>用户登录</title>
        <link href="/base/resources/css/hottest.css" rel="stylesheet" type="text/css" />
<link rel="shortcut icon" href="./topl.jpg" type="image/x-icon" />
<link rel="icon" href="./topl.jpg" type="image/gif" >
    </head>
    <style>
        body {
            background: url(/base/resources/images/htbg.gif) repeat-x top left;
            margin:0;
			padding:0;
			height:500px;
        }

        .d2 {
            border: 0px;
            background: url(/base/resources/images/htdl.gif) no-repeat;
            font-size:12px;
            font-weight:bold;
            width: 71px;
            height: 25px;
            color: #ffffff;
        }
        input{
        	border:1px solid #d7d8c8;
        	height:23px;
        	padding:3px;
        }
        input:focus{
        	box-shadow: 0px 1px 3px rgba(0, 0, 0, 0.5);
        }
    </style>
    <body>  
        <div id="htdlbg">
          
  <div id="httab"> 
    <form action="login?action=in" method="post" >
      <table width="400" border="0" cellspacing="0" cellpadding="0" height="169" align="center">
        <tr> 
          <td  align="left" height="24" style="color: red; padding-left: 40px">&nbsp;</td>
          <td  align="left" height="24" style="color: red;font-size: 15px; padding-left: 40px;padding-left:2px;">${error}</td>
        </tr>
        <tr> 
          <td width="100" height="40" align="right" style="color:rgb(31, 74, 101);font-size:17px">用户名：</td>
          <td width="300" align="left"> <input type="text" name="username" size="18" id="userName" style="width: 150px" /> 
          </td>
        </tr>
        <tr> 
          <td width="100" height="40" align="right" style="color:rgb(31, 74, 101);font-size:17px">密&nbsp;&nbsp;&nbsp;&nbsp;码：</td>
          <td width="300" align="left"> <input type="password" name="password" size="18" id="pwd" style="width: 150px" /> 
          </td>
        </tr>
        <tr> 
          <td width="100" height="40" align="right" style="color:rgb(31, 74, 101);font-size:17px">验证码：</td>
          <td width="300" align="left"> <input type="text" name="rands" size="4" id="rand" style="width: 70px" />
          <span id="code"><img alt="验证码" src="./image.jsp" onclick="javascript:history.go(0);"/></span>
          <a href="javascript:void" onclick="javascript:window.location.reload();">看不清</a>
          </td>
        </tr>
        <tr> 
          <td height="40" align="left" colspan="2" style="padding-left: 100px;"> 
            <input type="submit" value="登录" class="d2" /> <input type="reset" value="取消" class="d2" /> 
          </td>
        </tr>
        <tr>
          <td height="40" colspan="2" align="center" class="STYLE4"></td>
        </tr>
      </table>
    </form>
  </div>
        </div>
    </body>
</html>

