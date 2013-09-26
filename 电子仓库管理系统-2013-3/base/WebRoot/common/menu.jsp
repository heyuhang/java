<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
  <head>
    <title>电子化仓储管理系统</title>
    <meta http-equiv="content-type" content="text/html; charset=utf-8">
    <style type="text/css" media="all">
        a,a:visited {color:#333;text-decoration:none;}
        a:hover {color:#f60;}
        body,td {font:12px "Geneva","宋体", "Arial", "Helvetica",sans-serif; margin:0px; padding:0px; background:#d3e7fc;} 
        ul,li {margin:0;padding:0;list-style:none;}
        .TreeWrap {width:200px;}
        .MenuBox .titBox a,
        .MenuBox .titBox a:visited,
        .MenuBox2 .titBox a,
        .MenuBox2 .titBox a:visited 
        {
            width:200px;
            line-height:29px;
            color:#fff;
            text-align:center;
            background:url(/base/resources/images/ht02.gif) repeat-x;
            display:block;
        }
        .MenuBox2 .txtBox {display:none;}
        .MenuBox2 .txtBox {color:#e00;}
        .MenuBox .txtBox ul li
        {
            line-height:26px;
            color:#000;
            padding-left:75px;
            text-align:left;
            background:url(/base/resources/images/ht05.gif)  no-repeat;
        }
    </style>
    <script type="text/javascript">
    <!--
    function ExChgClsName(Obj,NameA,NameB)
    {
        var Obj=document.getElementById(Obj)?document.getElementById(Obj):Obj;
        Obj.className=Obj.className==NameA?NameB:NameA;
    }
    function showMenu(iNo)
    {
        ExChgClsName("Menu_"+iNo,"MenuBox","MenuBox2");
    }
    -->
    </script>
  </head>

  <body style="overflow:hidden">

  <div class="TreeWrap">

    <div class="MenuBox2" id="Menu_0">
        <div class="titBox"><a href="javascript:showMenu(0);">库存管理</a></div>
        <div class="txtBox">
            <ul>
                <li><a href="../sm/stockIn.jsp" target="content">入库管理</a></li>
                <li><a href="../sm/stockOut.jsp" target="content">出库管理</a></li>
                <li><a href="../sm/deliver.jsp" target="content">送货管理</a></li>
                <li><a href="../sm/check.jsp" target="content">盘点管理</a></li>
            </ul>
       </div>
    </div>

    <div class="MenuBox2" id="Menu_1">
        <div class="titBox"><a href="javascript:showMenu(1);">统计查询</a></div>
        <div class="txtBox">
           <ul>
              <li><a href="../sq/stockInQuery.jsp" target="content">入库查询</a></li>
              <li><a href="../sq/stockOutQuery.jsp" target="content">出库查询</a></li>
              <li><a href="../sq/deliverQuery.jsp" target="content">送货查询</a></li>
              <li><a href="../sq/checkQuery.jsp" target="content">盘点查询</a></li>
              <li><a href="../sq/stockQuery.jsp" target="content">库存查询</a></li>
           </ul>
        </div>
    </div>

    <div class="MenuBox2" id="Menu_2">
        <div class="titBox"><a href="javascript:showMenu(2);">系统管理</a></div>
        <div class="txtBox">
           <ul>
              <li><a href="/base/sort?page=1" target="content">商品分类管理</a></li>
              <li><a href="/base/brand?page=1" target="content">商品品牌管理</a></li>
              <li><a href="/base/goods?page=1" target="content">商品管理</a></li>
              <li><a href="/base/vendor?page=1" target="content">供应商管理</a></li>
              <li><a href="/base/client?page=1" target="content">客户管理</a></li>
              <li><a href="/base/shelf?page=1" target="content">货架管理</a></li>
           </ul>
        </div>
    </div>

    <div class="MenuBox2" id="Menu_3">
        <div class="titBox"><a href="javascript:showMenu(3);">用户管理</a></div>
        <div class="txtBox">
          <ul>
              <li><a href="/base/user?page=1" target="content" method="post">用户管理</a></li>
              
              <li><a href="/base/section?page=1" target="content" method="post">部门管理</a></li>
          </ul>
       </div>
    </div>

  </div>

  </body>
</html>
