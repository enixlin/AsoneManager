package cn.enixlin.jmrc.asone.manager.ui;

import java.awt.EventQueue;

import javax.script.ScriptException;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.SwingWorker;

import cn.enixlin.jmrc.asone.manager.net.HttpClient;
import cn.enixlin.jmrc.asone.manager.util.JavascriptEngine;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JSeparator;
import javax.swing.JTable;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.BasicHttpContext;

import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Login {

	private JFrame frmAso;
	private JTextField structCode;
	private JTextField userName;
	private JTextField password;
	private JTextField varifyCode;
	private JTextField textField_4;
	private JTable table;
	private CloseableHttpClient httpClient;
	private BasicHttpContext basicHttpContext;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmAso.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.httpClient = new HttpClient();
		frmAso = new JFrame();
		frmAso.setTitle("Asone用户批量生成器");
		frmAso.setBounds(100, 100, 1009, 562);
		frmAso.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAso.getContentPane().setLayout(null);

		JButton btn_login = new JButton("登录");
		btn_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SwingWorker sw = new SwingWorker() {
					@Override
					protected void done() {
						// TODO Auto-generated method stub
						super.done();
						HttpClient client = new HttpClient();

					}

					@Override
					protected Object doInBackground() throws Exception {
						// TODO Auto-generated method stub
						JavascriptEngine je = new JavascriptEngine();
						// String file="test.js";
						// String functionName="show";
						// String[] args={"aa","bb","cc"};
						String file = "libs/md5.js";
						String functionName = "hex_md5";
						String[] args = { "123456Gj" };
						String result = null;
						try {
							result = (String) je.jsRun(file, functionName, args);
							structCode.setText(result);
							System.out.println(je.jsRun(file, functionName, args));
						} catch (NoSuchMethodException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (ScriptException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block

							e.printStackTrace();
						}
						return result;
					}

				};
				sw.execute();

			}
		});
		btn_login.setBounds(275, 111, 84, 29);
		frmAso.getContentPane().add(btn_login);

		structCode = new JTextField();
		structCode.setText("315282495");
		structCode.setBounds(93, 13, 160, 24);
		frmAso.getContentPane().add(structCode);
		structCode.setColumns(10);

		JLabel lblNewLabel = new JLabel("机构代码");
		lblNewLabel.setBounds(14, 16, 72, 18);
		frmAso.getContentPane().add(lblNewLabel);

		JLabel label = new JLabel("用户名称");
		label.setBounds(14, 53, 72, 18);
		frmAso.getContentPane().add(label);

		userName = new JTextField();
		userName.setText("HUIXIN");
		userName.setColumns(10);
		userName.setBounds(93, 50, 160, 24);
		frmAso.getContentPane().add(userName);

		JLabel label_1 = new JLabel("密码");
		label_1.setBounds(14, 87, 72, 18);
		frmAso.getContentPane().add(label_1);

		password = new JTextField();
		password.setText("Hx123456");
		password.setColumns(10);
		password.setBounds(93, 84, 160, 24);
		frmAso.getContentPane().add(password);

		JLabel label_2 = new JLabel("验证码");
		label_2.setBounds(14, 121, 72, 18);
		frmAso.getContentPane().add(label_2);

		varifyCode = new JTextField();
		varifyCode.setColumns(10);
		varifyCode.setBounds(93, 118, 77, 24);
		frmAso.getContentPane().add(varifyCode);

		JLabel label_verify = new JLabel("New label");
		label_verify.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

			}
		});
		label_verify.setBounds(184, 121, 72, 18);
		frmAso.getContentPane().add(label_verify);

		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(773, 485, 190, 20);
		frmAso.getContentPane().add(progressBar);

		JSeparator separator = new JSeparator();
		separator.setBounds(11, 152, 950, 27);
		frmAso.getContentPane().add(separator);

		table = new JTable();
		table.setBounds(14, 165, 952, 304);
		frmAso.getContentPane().add(table);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(SystemColor.activeCaption));
		panel.setBounds(7, 4, 366, 142);
		frmAso.getContentPane().add(panel);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(SystemColor.activeCaption));
		panel_1.setBounds(380, 108, 582, 38);
		frmAso.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JButton button = new JButton("添加");
		button.setBounds(473, 6, 82, 27);
		panel_1.add(button);
		button.setBackground(Color.GREEN);

		JButton btnNewButton = new JButton("打开");
		btnNewButton.setBounds(383, 5, 82, 27);
		panel_1.add(btnNewButton);
		btnNewButton.setFocusPainted(false);
		btnNewButton.setDisplayedMnemonicIndex(0);
		btnNewButton.setBackground(new Color(192, 192, 192));

		textField_4 = new JTextField();
		textField_4.setBounds(115, 5, 255, 24);
		panel_1.add(textField_4);
		textField_4.setColumns(10);

		JLabel label_4 = new JLabel("用户清单文件");
		label_4.setBounds(15, 8, 93, 18);
		panel_1.add(label_4);
	}

	/**
	 * 取网站的验证码
	 * 
	 * @param strUrl
	 * @return
	 */
	public boolean getVerifyCode(String strUrl) {
		httpClient = HttpClients.createDefault();
		basicHttpContext = new BasicHttpContext();
		HttpGet httpGet = new HttpGet(strUrl);
		CloseableHttpResponse response = null;
		try {
			response = httpClient.execute(httpGet, basicHttpContext);
			InputStream inputStream= response.getEntity().getContent();
			
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}
}
