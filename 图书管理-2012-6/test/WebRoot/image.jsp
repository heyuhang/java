<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ page import="java.awt.*,java.awt.image.*,javax.imageio.*" %>

<%!
	Color getRandColor(int fc,int bc)
	{
		Random random=new Random();
		if(fc>255)
			fc=255;
		if(bc>255)
			bc=255;
		int r=fc+random.nextInt(bc-fc);
		int g=fc+random.nextInt(bc-fc);
		int b=fc+random.nextInt(bc-fc);
		return new Color(r,g,b);
	}
%>
<%
	response.setHeader("Pragma","No-cache");
	response.setHeader("Cache-Control","no-cache");
	response.setDateHeader("Expires",0);
	//内存中创建图像
	int width=60,height=20;
	BufferedImage image=new BufferedImage(width,height,BufferedImage.TYPE_INT_BGR);
	Graphics g=image.getGraphics();
	Random random=new Random();
	g.setColor(getRandColor(200,250));
	g.fillRect(0,0,width,height);
	g.setFont(new Font("Times New Roman",Font.PLAIN,18));
	//随机干扰线
	g.setColor(getRandColor(160,200));
	for(int i=0;i<50;i++)
	{
		int x=random.nextInt(width);
		int y=random.nextInt(height);
		int xl=random.nextInt(width);
		int yl=random.nextInt(height);
		g.drawLine(x,y,x+xl,y+yl);
	}
	//取随机产生的验证码（4位）
	String sRand="";
	for(int i=0;i<4;i++)
	{
		String rand=String.valueOf(random.nextInt(10));
		sRand+=rand;
		//将验证码显示在图像中 
		g.setColor(new Color(20+random.nextInt(110),20+random.nextInt(110),20+random.nextInt(110)));
		//条用函数出来的颜色相同
		g.drawString(rand,13*i+6,16);
	}
	session.setAttribute("rand",sRand);
	g.dispose();  //图像生效
	
	ImageIO.write(image,"JPEG",response.getOutputStream());//输出图像到页面
%>