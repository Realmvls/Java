package com.greenteam;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

class Net {
	// 网的位置随着鼠标指针的移动而移动
	BufferedImage netimage = null;
	int x = 0, y = 0, width, height;
	boolean show;// 是否显示当前网对象

	Net() throws Exception {
		// netimage = ImageIO.read(new File("net09.png"));

		netimage = ImageIO.read(getClass().getResourceAsStream(
				"/images/net09.png"));
		show = false;
		width = netimage.getWidth();
		height = netimage.getHeight();
	}
}