<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>    
    <title>页头</title>
  </head>
  
  <body>
<div id="nav"> 
  <div class="top"> 
    <div class="logo"> </div>
    <div class="log"> </div>
    <div class="login" onmousemove="down(this)" onmouseout="up(this)"> 
      <div class="sub" > 
        <ul>
          <li><a href="regist">加入我们</a></li>
        </ul>
      </div>
    </div>
  </div>
  <div class="menu"> 
  <nav>
    <ul id="navigation">
      <li><a href="index">技术汇</a> </li>
      <li><a href="qa">linuxQ&A</a> </li>
      <li><a href="group.html" >关于小组</a></li>
      <li><a href="#">分门别类 </a> 
        <div class="subnav" > 
          <ul>
          <s:iterator value="labels" status="labels">
            <li><a href="sort?label=<s:property value="title"/>" > <s:property value="title"/></a></li>
		  </s:iterator>
          </ul>
        </div>
      </li>
      <s:if test="#session['xiyoulinuxusername']!=null"> 
      <li><a href="user">个人主页</a></li>
      </s:if>
      <li><a href="login">linuxer登陆</a></li>
    </ul>
    </nav>
    <div class="search_form"> 
      <form action="search" method="post">
        <input id="search_term" onclick="if(this.value == 'Search...') this.value='';" onblur="if(this.value.length == 0) this.value='Search...';" value="Search..." name="label" type="text">
        <input class="submit_button" value="Search" type="submit">
      </form>
    </div>
  </div>
</div>
  </body>
</html>
