package com.greenteam;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

class Net {
	// ����λ���������ָ����ƶ����ƶ�
	BufferedImage netimage = null;
	int x = 0, y = 0, width, height;
	boolean show;// �Ƿ���ʾ��ǰ������

	Net() throws Exception {
		// netimage = ImageIO.read(new File("net09.png"));

		netimage = ImageIO.read(getClass().getResourceAsStream(
				"/images/net09.png"));
		show = false;
		width = netimage.getWidth();
		height = netimage.getHeight();
	}
}