import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author 
 */
public class Voter extends javax.swing.JFrame implements Runnable{
	
	private static AtomicInteger groupSmith=new AtomicInteger();   //该多播组的Smith选票总数
	private static AtomicInteger localSmith=new AtomicInteger();	//该Voter选民选Smith的票数
	private static AtomicInteger groupJone=new AtomicInteger();   //该多播组的Jone选票总数
	private static AtomicInteger localJone=new AtomicInteger();	//该Voter选民选Jone的票数
	private static MulticastSocket ms;
	 private javax.swing.JButton Bj;
	    private javax.swing.JButton Bs;
	    private javax.swing.JTextField Tgj;
	    private javax.swing.JTextField Tgs;
	    private javax.swing.JTextField Tlj;
	    private javax.swing.JTextField Tls;
	    private javax.swing.JLabel jLabel1;
	    private javax.swing.JLabel jLabel2;
	    private javax.swing.JLabel jLabel3;
	    private javax.swing.JLabel jLabel4;
	public static void updateGroupSmith()
	{
		InetAddress group;
		try {
			group = InetAddress.getByName("225.1.2.3");
			int portNum=8100;
			String str="s";
			byte[] bt=str.getBytes();
			DatagramPacket p=new DatagramPacket(bt,str.length(),group,portNum);
			ms.send(p);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void updateGroupJone()
	{
		InetAddress group;
		try {
			group = InetAddress.getByName("225.1.2.3");
			int portNum=8100;
			String str="j";
			byte[] bt=str.getBytes();
			DatagramPacket p=new DatagramPacket(bt,str.length(),group,portNum);
			ms.send(p);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static String updateLocalSmith()
	{
		localSmith.getAndIncrement();
		String number=Integer.toString(localSmith.intValue());
		return number;
	}
	public static String updateLocalJone()
	{
		localJone.getAndIncrement();
		String number=Integer.toString(localJone.intValue());
		return number;
	}
	public void run()
	{
		int flag=0;
		while(true)
		{
			
			if(groupSmith.intValue()==0&&groupJone.intValue()==0&&flag==0)
			{
		    	
				try {
				InetAddress	group = InetAddress.getByName("225.1.2.3");
					String str="empty";
					byte[] bt=str.getBytes();
					DatagramPacket p=new DatagramPacket(bt,str.length(),group,8100);
					ms.send(p);
					flag++;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
			else
			{
		
				try {
					byte[] bt=new byte[1024];
					String str=null;
					DatagramPacket p=new DatagramPacket(bt,1024);
					ms.receive(p);
					str=new String(p.getData(),0,p.getLength());
					if(str.equals("s"))
					{
						this.groupSmith.getAndIncrement();
						this.Tgs.setText(Integer.toString(this.groupSmith.intValue()));
					}
					if(str.equals("j"))
					{
						this.groupJone.getAndIncrement();
						this.Tgj.setText(Integer.toString(this.groupJone.intValue()));
					}
					if((str.equals("empty")==true)&&((groupSmith.intValue()!=0)||(groupJone.intValue()!=0)))
					{
						InetAddress	group = InetAddress.getByName("225.1.2.3");
						String str1="notEmptysmith="+Integer.toString(this.groupSmith.intValue())+"="+Integer.toString(this.groupJone.intValue());
						byte[] bt1=str1.getBytes();
						DatagramPacket p1=new DatagramPacket(bt1,str1.length(),group,8100);
						ms.send(p1);
					}
					if(str.charAt(0)=='n')
					{
						String[] str1=str.split("=");
						this.groupSmith.set(Integer.parseInt(str1[1]));
						this.groupJone.set(Integer.parseInt(str1[2]));
					
						
						Tgs.setText(str1[1]);
						Tgj.setText(str1[2]);
						
					}
				
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
    public Voter() throws Exception {
    	InetAddress group=InetAddress.getByName("225.1.2.3");
		int portNum=8100;
		ms=new MulticastSocket(portNum);
		
		ms.joinGroup(group);
    	  this.setTitle("多播组选票");
    	  jLabel1 = new javax.swing.JLabel();
          jLabel2 = new javax.swing.JLabel();
          jLabel3 = new javax.swing.JLabel();
          jLabel4 = new javax.swing.JLabel();
          Tgs = new javax.swing.JTextField();
          Tgj = new javax.swing.JTextField();
          Tls = new javax.swing.JTextField();
          Tlj = new javax.swing.JTextField();
          Bs = new javax.swing.JButton();
          Bj = new javax.swing.JButton();

          setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

          jLabel1.setText("groupSmith:");

          jLabel2.setText("groupJone:");

          jLabel3.setText("localSmith:");

          jLabel4.setText("localJone:");

        
          Tgs.setText(Integer.toString(groupSmith.intValue()));
          Tgj.setText(Integer.toString(groupJone.intValue()));
        

          Bs.setText("Smith");
          Bs.addActionListener(new java.awt.event.ActionListener() {
              public void actionPerformed(java.awt.event.ActionEvent evt) {
            	  String number=updateLocalSmith();
                  Tls.setText(number);
                  updateGroupSmith();
              }
          });

          Bj.setText("Jone");
          Bj.addActionListener(new java.awt.event.ActionListener() {
              public void actionPerformed(java.awt.event.ActionEvent evt) {
                String number=updateLocalJone();
                Tlj.setText(number);
                updateGroupJone();
              }
          });

          javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
          getContentPane().setLayout(layout);
          layout.setHorizontalGroup(
              layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(layout.createSequentialGroup()
                  .addGap(34, 34, 34)
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                      .addGroup(layout.createSequentialGroup()
                          .addComponent(jLabel1)
                          .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                          .addComponent(Tgs, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                      .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                          .addComponent(Bs)
                          .addGroup(layout.createSequentialGroup()
                              .addComponent(jLabel3)
                              .addGap(18, 18, 18)
                              .addComponent(Tls, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))))
                  .addGap(18, 18, 18)
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                      .addGroup(layout.createSequentialGroup()
                          .addGap(0, 0, Short.MAX_VALUE)
                          .addComponent(jLabel4)
                          .addGap(10, 10, 10))
                      .addGroup(layout.createSequentialGroup()
                          .addComponent(jLabel2)
                          .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                      .addComponent(Bj)
                      .addComponent(Tgj, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                      .addComponent(Tlj))
                  .addContainerGap(109, Short.MAX_VALUE))
          );
          layout.setVerticalGroup(
              layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(layout.createSequentialGroup()
                  .addGap(85, 85, 85)
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                      .addComponent(jLabel1)
                      .addComponent(jLabel2)
                      .addComponent(Tgs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                      .addComponent(Tgj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                  .addGap(43, 43, 43)
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                      .addComponent(jLabel3)
                      .addComponent(jLabel4)
                      .addComponent(Tls, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                      .addComponent(Tlj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                      .addComponent(Bs)
                      .addComponent(Bj))
                  .addGap(51, 51, 51))
          );


          pack();
    }

  
    public static void main(String args[]) {
      
        
                try {
					Voter v=new Voter();
					v.setVisible(true);
					Thread t=new Thread(v);
					t.start();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    }
    // Variables declaration - do not modify
   
    // End of variables declaration
}
