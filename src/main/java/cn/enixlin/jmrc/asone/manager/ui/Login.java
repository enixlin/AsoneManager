package cn.enixlin.jmrc.asone.manager.ui;

import java.awt.EventQueue;

import javax.script.ScriptException;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.SwingWorker;

import cn.enixlin.jmrc.asone.manager.util.JavascriptEngine;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.lang.reflect.Array;

import javax.swing.JTextField;

public class Login {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
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
		frame = new JFrame();
		frame.setBounds(100, 100, 1003, 468);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnRunJavascript = new JButton("run javascript");
		btnRunJavascript.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SwingWorker sw = new SwingWorker() {
					@Override
					protected void done() {
						// TODO Auto-generated method stub
						super.done();

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
							textField.setText(result);
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
		btnRunJavascript.setBounds(121, 339, 167, 29);
		frame.getContentPane().add(btnRunJavascript);

		textField = new JTextField();
		textField.setBounds(88, 116, 200, 50);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
	}
}
