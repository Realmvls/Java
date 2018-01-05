package com.yunsitech.fish04;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * 鱼池子，里面好多鱼啊
 * @author user
 *	支持鱼的x坐标变动，以至于重新绘画页面的时候
 *	鱼在向左边游动
 */
public class FishPool 
	extends JPanel 
	implements Runnable,MouseListener,MouseMotionListener{
	
	private BufferedImage bgImg;//背景图片
	private int score;//捕鱼的得分
	
	//一些鱼（Fish类型的对象）
	private Fish[] fishes;//多条鱼

	//构造一张网（自定义类型，图片和抓鱼的动作等等）
	private Net net;
	
	public FishPool(){
		//初始化网
		net = new Net();
		//初始化鱼
		fishes = new Fish[20];
		for(int i=1;i<=9;i++){
			fishes[i-1] = new Fish("fish0"+i);
			fishes[i+8] = new Fish("fish0"+i);
		}
		fishes[18] = new Fish("fish13");
		fishes[19] = new Fish("fish14");
		
		//初始化图片(读取磁盘上的图片）
		try {
			bgImg = ImageIO.read(new File("imgs/bg.jpg"));
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//!!!鱼池让鱼自身动起来（Fish内部要自己的改变X轴，以及切换图片）
		//参照鱼池作为线程里面的逻辑
		
		//把自己当作线程给启动
		//(不停的改变与的x坐标，与此同时不同的重绘页面)
		new Thread(this).start();
		
	}
	
	//重写JPanel类中的paint方法
	//paint方法专门用来绘制界面的（原本JFrame中自己会调用）
	public void paint(Graphics g){
		//鱼池（JPanel）注册MouseListener
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		
		//把背景图片和鱼图片给画出来
		g.drawImage(bgImg,0,0,this.getWidth(),this.getHeight(),null);
		
		//试图把20条鱼给画出来
		for(Fish fish : fishes){
			
			g.drawImage(fish.getFishImage(),
					fish.getFishX(),
					fish.getFishY(),
					fish.getFishWidth(),
					fish.getFishHeight(),
					null);
		}
		
		//把捕鱼的网（图片）也给画出来
		if(net.isShow()){
			g.drawImage(net.getNetImg(),
					net.getNetX()-net.getNetWidth()/2,
					net.getNetY()-net.getNetHeight()/2,
					net.getNetWidth(),
					net.getNetHeight(),
					null);
		}
		
		//把分数那个文字给画上去
		//设置后续画字符串的颜色
		g.setColor(Color.WHITE);//r(red)g(green)b(blue)
		//设置大小
		g.setFont(new Font("宋体",Font.BOLD,30));
		g.drawString("分数："+score,30,50);
		
	}
	
	//重写Runnable中的run方法
	public void run()
	{
		//1让所有的鱼动起来（因为每一条鱼就是一个线程）
		for(Fish fish: fishes){
			new Thread(fish).start();
		}
		//2.不停的重绘页面
		while(true){
			this.repaint();
			try {
				Thread.sleep(60);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	//点击的时候，就是捕鱼的过程
	//查看网和鱼坐标关系
	@Override
	public void mousePressed(MouseEvent e) {
		for(Fish fish : fishes){
			if(net.catchFish(fish)){
				fish.disappear();
				//计算分数
				score+=1;
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	//鼠标移动到界面内部
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
//		System.out.println("mouseEntered....");
		net.showNet();
	}

	//鼠标从界面中移出
	@Override
	public void mouseExited(MouseEvent e) {
//		System.out.println("mouseExited....");
		net.hideNet();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		//鼠标在移动，应该让网的图片与鼠标保持同一坐标
		//1.鼠标移动的时候，鼠标的左边如何获取？
		int mx = e.getX();
		int my = e.getY();
		//2.网的图片的x，y与鼠标的x，y保持同步
		net.move(mx,my);
	}
}
