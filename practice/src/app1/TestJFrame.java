package app1;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class TestJFrame extends JFrame implements ActionListener{
	private JPanel contentPane;
	private JButton button;
	private JLabel label;
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestJFrame frame = new TestJFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	/**
	 * Create the frame.
	 */
	public TestJFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		button = new JButton("\u6309\u94AE");

		button.setBounds(177, 178, 93, 23);
		contentPane.add(button);
		
		label = new JLabel("\u8BA1\u6570");
		label.setBounds(90, 62, 200, 50);
		contentPane.add(label);

		panel = new JPanel();
		panel.setBounds(166, 86, 10, 10);
		contentPane.add(panel);
		//Ϊ��ť�����¼�
		button.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		//����һ���̣߳�����������߼��������µ��߳���ִ��
		//��ִ��actionPerformed������ִ���ߣ�����
		//�ػ�ҳ�棨JFrame�Լ���������������
		
		new Counter(label).start();//�����µ��߳�
	}
}