package frames;

import reactors.PFR;
import javax.swing.*;
import java.awt.Font;
import java.awt.event.*;
import java.text.DecimalFormat;

public class ReactorCalcFrame implements ActionListener {
	JTextField a1, b1, c1, d1, FAo, FBo, FCo, FDo, kd, ki, Xresult, FA, FB, FC, FD, volume;
	JLabel header, reactionData, A, plus1, B, arrow, C, plus2, D, FAoLabel, FBoLabel, FCoLabel, FDoLabel;
	JLabel initialValues, kineticValues, KD, KI, Results, Conversion, fa, fb, fc, fd, reactorVolume;
	JButton calc, help;

	// Defining both frames.
	JFrame mainF = new JFrame();
	JFrame helpF = new JFrame();

	public static void main(String[] args) {
		// main method only opens the new frame.
		new ReactorCalcFrame();
	}

	public ReactorCalcFrame() {

		/*---------First set of labels and text fields, reaction information.--------------*/
		header = new JLabel("Calculation of ideal Plug-Flow Reactor (PFR) solving a differential equation");
		header.setBounds(0, 0, 720, 30);
		header.setFont(new Font("Serif", Font.BOLD, 20));
		header.setHorizontalAlignment(JLabel.CENTER);
		mainF.add(header);
		mainF.setTitle("Calculation of Reactor");

		reactionData = new JLabel("Reaction Data:");
		reactionData.setBounds(0, 40, 200, 30);
		reactionData.setFont(new Font("Serif", Font.PLAIN, 18));
		reactionData.setHorizontalAlignment(JLabel.CENTER);
		mainF.add(reactionData);

		a1 = new JTextField();
		a1.setBounds(100, 80, 40, 20);
		A = new JLabel("A");
		A.setBounds(150, 80, 20, 20);
		A.setFont(new Font("Serif", Font.PLAIN, 18));

		plus1 = new JLabel("+");
		plus1.setBounds(190, 80, 20, 20);
		plus1.setFont(new Font("Serif", Font.PLAIN, 18));
		mainF.add(plus1);

		b1 = new JTextField();
		b1.setBounds(220, 80, 40, 20);
		B = new JLabel("B");
		B.setBounds(270, 80, 20, 20);
		B.setFont(new Font("Serif", Font.PLAIN, 18));

		arrow = new JLabel("<----------->");
		arrow.setBounds(290, 80, 170, 20);
		arrow.setFont(new Font("Sans-Serif", Font.PLAIN, 18));
		arrow.setHorizontalAlignment(JLabel.CENTER);
		mainF.add(arrow);

		c1 = new JTextField();
		c1.setBounds(460, 80, 40, 20);
		C = new JLabel("C");
		C.setBounds(510, 80, 20, 20);
		C.setFont(new Font("Serif", Font.PLAIN, 18));

		plus2 = new JLabel("+");
		plus2.setBounds(550, 80, 20, 20);
		plus2.setFont(new Font("Serif", Font.PLAIN, 18));
		mainF.add(plus2);

		d1 = new JTextField();
		d1.setBounds(580, 80, 40, 20);
		D = new JLabel("D");
		D.setBounds(630, 80, 20, 20);
		D.setFont(new Font("Serif", Font.PLAIN, 18));

		mainF.add(a1);
		mainF.add(b1);
		mainF.add(c1);
		mainF.add(d1);
		mainF.add(A);
		mainF.add(B);
		mainF.add(C);
		mainF.add(D);

		/*---------Second set of labels and text fields, initial values.--------------*/

		initialValues = new JLabel("Initial Values:");
		initialValues.setBounds(0, 120, 200, 30);
		initialValues.setFont(new Font("Serif", Font.PLAIN, 18));
		initialValues.setHorizontalAlignment(JLabel.CENTER);
		mainF.add(initialValues);

		FAo = new JTextField();
		FAo.setBounds(130, 160, 50, 20);
		FAoLabel = new JLabel("FAo");
		FAoLabel.setBounds(80, 160, 40, 20);
		FAoLabel.setFont(new Font("Serif", Font.PLAIN, 18));

		FBo = new JTextField();
		FBo.setBounds(250, 160, 50, 20);
		FBoLabel = new JLabel("FBo");
		FBoLabel.setBounds(200, 160, 40, 20);
		FBoLabel.setFont(new Font("Serif", Font.PLAIN, 18));

		FCo = new JTextField();
		FCo.setBounds(490, 160, 50, 20);
		FCoLabel = new JLabel("FCo");
		FCoLabel.setBounds(440, 160, 40, 20);
		FCoLabel.setFont(new Font("Serif", Font.PLAIN, 18));

		FDo = new JTextField();
		FDo.setBounds(610, 160, 50, 20);
		FDoLabel = new JLabel("FDo");
		FDoLabel.setBounds(560, 160, 40, 20);
		FDoLabel.setFont(new Font("Serif", Font.PLAIN, 18));

		mainF.add(FAo);
		mainF.add(FBo);
		mainF.add(FCo);
		mainF.add(FDo);
		mainF.add(FAoLabel);
		mainF.add(FBoLabel);
		mainF.add(FCoLabel);
		mainF.add(FDoLabel);

		/*---------Third set of labels and text fields, kinetic values.--------------*/

		kineticValues = new JLabel("Kinetic Values (speed of reaction):");
		kineticValues.setBounds(0, 200, 300, 30);
		kineticValues.setFont(new Font("Serif", Font.PLAIN, 18));
		kineticValues.setHorizontalAlignment(JLabel.CENTER);
		mainF.add(kineticValues);

		kd = new JTextField();
		kd.setBounds(240, 240, 100, 20);
		KD = new JLabel("Kd (direct reaction)");
		KD.setBounds(80, 240, 150, 20);
		KD.setFont(new Font("Serif", Font.PLAIN, 18));

		ki = new JTextField();
		ki.setBounds(560, 240, 100, 20);
		KI = new JLabel("Ki (inverse reaction)");
		KI.setBounds(400, 240, 150, 20);
		KI.setFont(new Font("Serif", Font.PLAIN, 18));

		mainF.add(kd);
		mainF.add(ki);
		mainF.add(KD);
		mainF.add(KI);

		/*---------Fourth set of labels and text fields, Reactor Volume.--------------*/

		reactorVolume = new JLabel("Reactor Volume (in Liters):");
		reactorVolume.setBounds(0, 300, 300, 30);
		reactorVolume.setFont(new Font("Serif", Font.PLAIN, 18));
		reactorVolume.setHorizontalAlignment(JLabel.CENTER);
		mainF.add(reactorVolume);

		volume = new JTextField();
		volume.setBounds(260, 300, 100, 30);
		mainF.add(volume);

		/*---------Fifth set of labels and text fields, results section.--------------*/

		Xresult = new JTextField();
		Xresult.setBounds(300, 490, 120, 30);
		Xresult.setEditable(false);
		Conversion = new JLabel("Conversion (A)");
		Conversion.setBounds(300, 460, 120, 20);
		Conversion.setFont(new Font("Serif", Font.PLAIN, 18));
		Conversion.setHorizontalAlignment(JLabel.CENTER);
		mainF.add(Xresult);
		mainF.add(Conversion);

		Results = new JLabel("Results:");
		Results.setBounds(0, 420, 200, 30);
		Results.setFont(new Font("Serif", Font.PLAIN, 18));
		Results.setHorizontalAlignment(JLabel.CENTER);
		mainF.add(Results);

		fa = new JLabel("FA");
		fa.setBounds(0, 460, 120, 20);
		fa.setFont(new Font("Serif", Font.PLAIN, 18));
		fa.setHorizontalAlignment(JLabel.CENTER);
		FA = new JTextField();
		FA.setBounds(10, 490, 100, 30);
		FA.setEditable(false);
		FA.setHorizontalAlignment(JTextField.CENTER);

		fb = new JLabel("FB");
		fb.setBounds(120, 460, 120, 20);
		fb.setFont(new Font("Serif", Font.PLAIN, 18));
		fb.setHorizontalAlignment(JLabel.CENTER);
		FB = new JTextField();
		FB.setBounds(120, 490, 100, 30);
		FB.setEditable(false);
		FB.setHorizontalAlignment(JTextField.CENTER);

		fc = new JLabel("FC");
		fc.setBounds(480, 460, 120, 20);
		fc.setFont(new Font("Serif", Font.PLAIN, 18));
		fc.setHorizontalAlignment(JLabel.CENTER);
		FC = new JTextField();
		FC.setBounds(480, 490, 100, 30);
		FC.setEditable(false);
		FC.setHorizontalAlignment(JTextField.CENTER);

		fd = new JLabel("FD");
		fd.setBounds(600, 460, 120, 20);
		fd.setFont(new Font("Serif", Font.PLAIN, 18));
		fd.setHorizontalAlignment(JLabel.CENTER);
		FD = new JTextField();
		FD.setBounds(600, 490, 100, 30);
		FD.setEditable(false);
		FD.setHorizontalAlignment(JTextField.CENTER);

		mainF.add(fa);
		mainF.add(fb);
		mainF.add(fc);
		mainF.add(fd);
		mainF.add(FA);
		mainF.add(FB);
		mainF.add(FC);
		mainF.add(FD);

		/*---------Calculate and Help button.--------------*/

		calc = new JButton("Calculate");
		calc.setBounds(300, 388, 120, 30);

		help = new JButton("Help");
		help.setBounds(320, 428, 80, 20);
		mainF.add(calc);
		mainF.add(help);

		calc.addActionListener(this);
		help.addActionListener(this);

		mainF.setSize(720, 600);
		mainF.setResizable(false);
		mainF.setLayout(null);
		mainF.setLocationRelativeTo(null);
		mainF.setVisible(true);

		/*---------Help frame details.--------------*/

	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == calc) {
			try {
				// this is the code for the calculation when the Calculate button is pressed.

				// capturing the information from the text fields
				double FAO = Double.parseDouble(FAo.getText());
				double FBO = Double.parseDouble(FBo.getText());
				double FCO = Double.parseDouble(FCo.getText());
				double FDO = Double.parseDouble(FDo.getText());

				// creating calculation object of the PFR class using constructor with initial
				// values.
				PFR calculation = new PFR(FAO, FBO, FCO, FDO);

				// setting the kinetic values for reaction speeds
				double KDIRECT = Double.parseDouble(kd.getText());
				double KINVERSE = Double.parseDouble(ki.getText());
				calculation.setKinetics(KDIRECT, KINVERSE);

				// setting the volume of the reactor
				double VOLUME = Double.parseDouble(volume.getText());
				calculation.setVolume(VOLUME);

				// setting the reaction coefficients
				double coeffA = Double.parseDouble(a1.getText());
				double coeffB = Double.parseDouble(b1.getText());
				double coeffC = Double.parseDouble(c1.getText());
				double coeffD = Double.parseDouble(d1.getText());
				calculation.setReactionCoefficients(coeffA, coeffB, coeffC, coeffD);

				// this is the calculation method that solves the ODE
				double[] Flowrates = calculation.getOutputFlowrates();
				double FAout = Flowrates[0];
				double FBout = Flowrates[1];
				double FCout = Flowrates[2];
				double FDout = Flowrates[3];
				double Conversion = (FAO - FAout) / FAO;

				// formatting the output for the text fields
				DecimalFormat numberFormatting = new DecimalFormat("###,###.00");
				DecimalFormat convFormatting = new DecimalFormat("0.00000");

				String FAoutText = numberFormatting.format(FAout);
				String FBoutText = numberFormatting.format(FBout);
				String FCoutText = numberFormatting.format(FCout);
				String FDoutText = numberFormatting.format(FDout);
				String ConversionText = convFormatting.format(Conversion);

				// setting values on the text fields
				Xresult.setText(ConversionText);
				Xresult.setHorizontalAlignment(JTextField.CENTER);

				FA.setText(FAoutText);
				FA.setHorizontalAlignment(JTextField.CENTER);

				FB.setText(FBoutText);
				FB.setHorizontalAlignment(JTextField.CENTER);

				FC.setText(FCoutText);
				FC.setHorizontalAlignment(JTextField.CENTER);

				FD.setText(FDoutText);
				FD.setHorizontalAlignment(JTextField.CENTER);
			} catch (Exception exception) {
				// For any exception, the message dialog will appear. User must enter at least a
				// 0 in the fields.
				JOptionPane.showMessageDialog(null,
						"Calculation error. Please enter positive numbers in the text fields. Enter 0 if not used.",
						"Calculation error", JOptionPane.INFORMATION_MESSAGE);
			}
		} else if (e.getSource() == help) {
			// This is the case when the help button is pressed, showing dialog window with
			// usage information.

			JDialog d = new JDialog(mainF, "Help", true);
			d.setLayout(null);
			JButton OK = new JButton("Close");
			OK.setBounds(150, 220, 80, 30);

			// Action listener when the button is pressed to close the window.
			OK.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					d.setVisible(false);
				}
			});

			// using a non-editable text area to allow selection.
			JTextArea helpText = new JTextArea("Made by Alfredo Escalante.\n\n" + "E-mail: escalantealf@gmail.com\n\n"
					+ "Calculates an ideal Plug-Flow Reactor (PFR) by integrating\n"
					+ "the mass balance equations for a 4 components reaction.\n\n"
					+ "Please enter only positive numbers and click Calculate\n" + "to make the calculation.");

			helpText.setFont(new Font("Serif", Font.PLAIN, 13));
			helpText.setEditable(false);
			helpText.setBounds(25, 25, 330, 180);
			helpText.setVisible(true);

			d.add(OK);
			d.add(helpText);
			d.setSize(400, 300);
			d.setLocationRelativeTo(null);
			d.setVisible(true);
		}

	}
}