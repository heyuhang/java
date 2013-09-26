  var Speed_1 = 10; //速度(毫秒)
    var Space_1 = 20; //每次移动(px)
    var PageWidth_1 = 260 * 2; //翻页宽度
    var interval_1 = 5000; //翻页间隔时间
    var fill_1 = 0; //整体移位
    var MoveLock_1 = false;
    var MoveTimeObj_1;
    var MoveWay_1="right";
    var Comp_1 = 0;
    var AutoPlayObj_1=null;
    function GetObj(objName){if(document.getElementById){return eval('document.getElementById("'+objName+'")')}else{return eval('document.all.'+objName)}}
    function AutoPlay_1(){clearInterval(AutoPlayObj_1);AutoPlayObj_1=setInterval('ISL_GoDown_1();ISL_StopDown_1();',interval_1)}
    function ISL_GoUp_1(){if(MoveLock_1)return;clearInterval(AutoPlayObj_1);MoveLock_1=true;MoveWay_1="left";MoveTimeObj_1=setInterval('ISL_ScrUp_1();',Speed_1);}
    function ISL_StopUp_1(){if(MoveWay_1 == "right"){return};clearInterval(MoveTimeObj_1);if((GetObj('ISL_Cont_1').scrollLeft-fill_1)%PageWidth_1!=0){Comp_1=fill_1-(GetObj('ISL_Cont_1').scrollLeft%PageWidth_1);CompScr_1()}else{MoveLock_1=false}
    AutoPlay_1()}
    function ISL_ScrUp_1(){if(GetObj('ISL_Cont_1').scrollLeft<=0){GetObj('ISL_Cont_1').scrollLeft=GetObj('ISL_Cont_1').scrollLeft+GetObj('List1_1').offsetWidth}
    GetObj('ISL_Cont_1').scrollLeft-=Space_1}
    function ISL_GoDown_1(){clearInterval(MoveTimeObj_1);if(MoveLock_1)return;clearInterval(AutoPlayObj_1);MoveLock_1=true;MoveWay_1="right";ISL_ScrDown_1();MoveTimeObj_1=setInterval('ISL_ScrDown_1()',Speed_1)}
    function ISL_StopDown_1(){if(MoveWay_1 == "left"){return};clearInterval(MoveTimeObj_1);if(GetObj('ISL_Cont_1').scrollLeft%PageWidth_1-(fill_1>=0?fill_1:fill_1+1)!=0){Comp_1=PageWidth_1-GetObj('ISL_Cont_1').scrollLeft%PageWidth_1+fill_1;CompScr_1()}else{MoveLock_1=false}
    AutoPlay_1()}
    function ISL_ScrDown_1(){if(GetObj('ISL_Cont_1').scrollLeft>=GetObj('List1_1').scrollWidth){GetObj('ISL_Cont_1').scrollLeft=GetObj('ISL_Cont_1').scrollLeft-GetObj('List1_1').scrollWidth}
    GetObj('ISL_Cont_1').scrollLeft+=Space_1}
    function CompScr_1(){if(Comp_1==0){MoveLock_1=false;return}
    var num,TempSpeed=Speed_1,TempSpace=Space_1;if(Math.abs(Comp_1)<PageWidth_1/2){TempSpace=Math.round(Math.abs(Comp_1/Space_1));if(TempSpace<1){TempSpace=1}}
    if(Comp_1<0){if(Comp_1<-TempSpace){Comp_1+=TempSpace;num=TempSpace}else{num=-Comp_1;Comp_1=0}
    GetObj('ISL_Cont_1').scrollLeft-=num;setTimeout('CompScr_1()',TempSpeed)}else{if(Comp_1>TempSpace){Comp_1-=TempSpace;num=TempSpace}else{num=Comp_1;Comp_1=0}
    GetObj('ISL_Cont_1').scrollLeft+=num;setTimeout('CompScr_1()',TempSpeed)}}
    function picrun_ini(){
    GetObj("List2_1").innerHTML=GetObj("List1_1").innerHTML;
    GetObj('ISL_Cont_1').scrollLeft=fill_1>=0?fill_1:GetObj('List1_1').scrollWidth-Math.abs(fill_1);
    GetObj("ISL_Cont_1").onmouseover=function(){clearInterval(AutoPlayObj_1)}
    GetObj("ISL_Cont_1").onmouseout=function(){AutoPlay_1()}
    AutoPlay_1();
    }
    
   
    function id(obj){
     return document.getElementById(obj);
    }//欢迎来到站长特效网，我们的网址是www.zzjs.net，很好记，zz站长，js就是js特效，本站收集大量高质量js代码，还有许多广告代码下载。
    var page;
    var mx;
    var md=false;
    var sh=0;
    var en=false;
    window.onload=function(){
     page=id("www_zzjs_net").getElementsByTagName("div");
     if(page.length>0){
      page[0].style.zIndex=2;
     }
     for(i=0;i<page.length;i++){
      page[i].innerHTML+="<span class=\"tip\">"+(i+1)+"/"+page.length+"页 拖拽翻页</span>";
      page[i].id="page"+i;
      page[i].i=i;
      page[i].onmousedown=function(e){
       if(!en){
        if(!e){e=e||window.event;}
        ex=e.pageX?e.pageX:e.x;
        mx=350-ex;
        this.style.cursor="move";
        md=true;
        if(document.all){
         this.setCapture();
        }else{
         window.captureEvents(Event.MOUSEMOVE|Event.MOUSEUP);
        }
       }
      }
      page[i].onmousemove=function(e){
       if(md){
        en=true;
        if(!e){e=e||window.event;}
        ex=e.pageX?e.pageX:e.x;
        this.style.left=ex+mx+"px";
        if(this.offsetLeft<350){
         var cu=(this.i==0)?page.length-1:this.i-1;
         page[sh].style.zIndex=0;
         page[cu].style.zIndex=1;
         this.style.zIndex=2;
         sh=cu;
        }
        if(this.offsetLeft>350){
         var cu=(this.i==page.length-1)?0:this.i+1;
         page[sh].style.zIndex=0;
         page[cu].style.zIndex=1;
         this.style.zIndex=2;
         sh=cu;
        }
       }
      }
      page[i].onmouseup=function(){
       this.style.cursor="default";
       md=false;
       if(this.offsetLeft==350){
        en=false;
       }
       if(document.all){
        this.releaseCapture();
       }else{
        window.releaseEvents(Event.MOUSEMOVE|Event.MOUSEUP);
       }
       flyout(this);
      }
     }
    }//欢迎来到站长特效网，我们的网址是www.zzjs. net，很好记，zz站长，js就是js特效，本站收集大量高质量js代码，还有许多广告代码下载。
    function flyout(obj){
     if(obj.offsetLeft < 350){
      if( (obj.offsetLeft - 10) > 50 ){
       obj.style.left=obj.offsetLeft - 10 + "px";
       window.setTimeout("flyout(id('"+obj.id+"'));",0);
      }else{
       obj.style.left= 50 +"px";
       obj.style.zIndex=0;
       flyin(id(obj.id));
      }
     }
     if(obj.offsetLeft > 350){
      if((obj.offsetLeft + 10) < 650){
       obj.style.left=obj.offsetLeft + 10 + "px";
       window.setTimeout("flyout(id('"+obj.id+"'));",0);
      }else{
       obj.style.left= 650 + "px";
       obj.style.zIndex=0;
       flyin(id(obj.id));
      }
     }
    }
     function flyin(obj){
     if(obj.offsetLeft<350){
      if((obj.offsetLeft + 10) < 350){
       obj.style.left=obj.offsetLeft + 10+"px";
       window.setTimeout("flyin(id('"+obj.id+"'));",0);
      }else{
       obj.style.left= 350 +"px";
       en=false;
      }
     }
     if(obj.offsetLeft>350){
      if((obj.offsetLeft - 10) > 350){
       obj.style.left=obj.offsetLeft - 10 +"px";
       window.setTimeout("flyin(id('"+obj.id+"'));",0);
      }else{
       obj.style.left=350+"px";
       en=false;
      }
     }
    }  