package Program;
import Program.Functions;

import java.awt.EventQueue;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class Gui extends Functions {
	
	public JFrame frmQact;
	public JLabel lblQuestion_Number,lblQuestion,lblMarkNumAns,lblQuestionImage,lblHint,lblimg1,lblimg2,lblimg3,lblimg4;
	public JCheckBox chkbxChoice1, chkbxChoice2,chkbxChoice3,chkbxChoice4,chkbxChoice5,chkbxChoice6;
	public JButton btnCheckAnswer, btnNextQuestion;
	
	public JFrame frame;

	ArrayList<JCheckBox> CH = new ArrayList<JCheckBox>();
	ArrayList<JLabel> IM = new ArrayList<JLabel>();



	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui window = new Gui();
					window.frmQact.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Gui() {
		initialize();
		getQuestions();		
		ResetForm();
		SetPossions(arquest.get(SQuest));
	}

	
	private void CheckAnswers(char[] ans){
		//Checks if the selected answers are correct 
		int a = 0;
		char[] Selected = new char[ans.length];
		
		for(int i = 0; i < CH.size();i++){
			if(CH.get(i).isSelected() == true)	{ Selected[a++] = CH.get(i).getText().charAt(0);}
		}
		
		int b = 0;
		for(int i = 0;i < ans.length;i++ ){
			if(Selected[i] == ans[i]){
				b++;				
			}
		}

		if(b == ans.length){
			JOptionPane.showMessageDialog(null,"Correct");
			NextQuestion();
		}else{
			JOptionPane.showMessageDialog(null,"Wrong");
				for(int i = 0; i < CH.size();i++){
					CH.get(i).setSelected(false);
				}
				CS = 0;
		}
	}
	
	private  void SetPossions(ClassQuestions QS){

		char[] Letters = "ABCDEF".toCharArray();
		int NC = QS.getNumberOfChoices();
		
		int R = 0;
		
		lblQuestion_Number.setText(Integer.toString(QS.getQuestionNumber()));
		lblMarkNumAns.setText("Select " + QS.getNumberOfAnswers() + (QS.getNumberOfAnswers() ==  1 ?" Answer":" Answers"));
		lblQuestion.setText(("<HTML>" + QS.getQuestion() + "</HTML>"));
		lblQuestionImage.setIcon(new ImageIcon(QS.getQuestionImage()));
		
		for(int i = 0; i < NC;i++){
			CH.get(i).setVisible(true);
			CH.get(i).setText(Letters[i] + " " + QS.getChoices()[i]);
		}
		switch(NC){
		case 4:
			R = -53;
			for(int i = 0; i < NC;i++){				
				CH.get(i).setBounds(6,( R+= 60), 441, 23);
			}	
			break;
		case 5:
			R = -43;
			for(int i = 0; i < NC;i++){				
			CH.get(i).setBounds(6,( R+= 50), 441, 23);
		}	
			break;
		case 6:
			R = -33;
			for(int i = 0; i < NC;i++){				
				CH.get(i).setBounds(6,( R+= 40), 441, 23);
			}
			break;
		}
		

		switch (QS.getQuestionType()) {
		case 'A':	
			R = -33;
			lblQuestionImage.setVisible(false);
			break;
			
		case 'B':
			R = -33;
			lblQuestion.setBounds(51, 21, 200, 56);
			lblQuestionImage.setVisible(true);		
			break;
		case 'C':
			
			int j = 0,y = 6;
			R = 7;
			for(int i = 0; i < NC;i++){
				CH.get(i).setVisible(true);
				CH.get(i).setText(Letters[i] + " " );
			}
			for(int i = 0; i < 2;i++){
				y = -194;
				for(int c = 0; c < 2;c++){		
				CH.get(j).setBounds((y += 200), R, 40, 23);
				IM.get(j).setVisible(true);
				IM.get(j).setIcon(new ImageIcon(QS.getChoices()[j++]));
				}
				R = 127;
				y = 6;
			}
			
			
			break;
		default:
			break;
		}
		
		
	}
	
	private void ResetForm(){
		// Reset the for to a default standard so that it can be set by 
		int a = -33;
		CS = 0;
		for(int i = 0; i < CH.size();i++){
			CH.get(i).setBounds(6, (a += 40), 441, 23);
			CH.get(i).setSelected(false);
			CH.get(i).setVisible(false);
		}
		for(int i = 0; i <IM.size();i++){
			IM.get(i).setVisible(false);
		}
		lblHint.setText("Press For Hint");	
	}
	
	private void NextQuestion(){
		ResetForm();
		SQuest++;
		if(SQuest == sd){
			SQuest = 0;
		}
		SetPossions(arquest.get(SQuest));
	}
	
	private void initialize() {
		
		
		
		frmQact = new JFrame();
		frmQact.setTitle("Theory Test and The Highway Code");
		frmQact.setBounds(100, 100, 746, 435);
		frmQact.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmQact.getContentPane().setLayout(null);
		
		JPanel panQuestion = new JPanel();
		panQuestion.setBounds(10, 11, 479, 90);
		frmQact.getContentPane().add(panQuestion);
		panQuestion.setLayout(null);
		
		lblQuestion_Number = new JLabel("000");
		lblQuestion_Number.setBounds(10, 11, 48, 31);
		lblQuestion_Number.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panQuestion.add(lblQuestion_Number);
		
		lblQuestionImage = 	new JLabel("");
		lblQuestionImage.setIcon(new ImageIcon("E:\\Practice\\Eclips\\Testing\\Resource\\sign-giving-order-national-speed-limit.jpg"));
		lblQuestionImage.setBounds(252, 0, 227, 90);
		panQuestion.add(lblQuestionImage);
		lblQuestionImage.setVerticalAlignment(SwingConstants.TOP);
		
		lblQuestion = new JLabel("Question");
		lblQuestion.setVerticalAlignment(SwingConstants.TOP);
		lblQuestion.setFont(new Font("Arial", Font.PLAIN, 14));
		lblQuestion.setBounds(	51, 21, 400, 56);
		panQuestion.add(lblQuestion);
		
		lblMarkNumAns = new JLabel("Mark 0 Answers");
		lblMarkNumAns.setBounds(51, 5, 116, 14);
		panQuestion.add(lblMarkNumAns);
		
		JPanel panChoicesText = new JPanel();
		panChoicesText.setBounds(10, 110, 479, 239);
		frmQact.getContentPane().add(panChoicesText);
		panChoicesText.setLayout(null);	
		
		lblimg1 = new JLabel("a");
		lblimg1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				chkbxChoice1.doClick();
			}
		});		
		lblimg1.setBounds(46, 7, 160, 110);
		IM.add(lblimg1);
		panChoicesText.add(lblimg1);		
		
		lblimg2 = new JLabel("b");
		lblimg2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				chkbxChoice2.doClick();
			}
		});		
		lblimg2.setBounds(246, 7, 160, 110);
		IM.add(lblimg2);
		panChoicesText.add(lblimg2);		
		
		lblimg3 = new JLabel("c");
		lblimg3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				chkbxChoice3.doClick();
			}
		});		
		lblimg3.setBounds(46, 127, 160, 110);
		
		IM.add(lblimg3);
		panChoicesText.add(lblimg3);
		
		lblimg4 = new JLabel("d");
		lblimg4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				chkbxChoice4.doClick();
			}
		});
		lblimg4.setBounds(246, 127, 160, 110);
		IM.add(lblimg4);
		panChoicesText.add(lblimg4);
		
		chkbxChoice1 = new JCheckBox("C1");
		lblimg1.setLabelFor(chkbxChoice1);
		chkbxChoice1.setBounds(6, 7, 441, 23);
		panChoicesText.add(chkbxChoice1);
		CH.add(chkbxChoice1);
		chkbxChoice1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkChoice(chkbxChoice1);
			}
		});		
		
		chkbxChoice2 = new JCheckBox("C2");
		lblimg2.setLabelFor(chkbxChoice2);
		chkbxChoice2.setBounds(6, 47, 441, 23);
		panChoicesText.add(chkbxChoice2);
		CH.add(chkbxChoice2);
		chkbxChoice2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkChoice(chkbxChoice2);
			}
		});
		
		chkbxChoice3 = new JCheckBox("C3");
		lblimg3.setLabelFor(chkbxChoice3);
		chkbxChoice3.setBounds(6, 87, 441, 23);
		panChoicesText.add(chkbxChoice3);
		CH.add(chkbxChoice3);
		chkbxChoice3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkChoice(chkbxChoice3);
			}
		});
		
		chkbxChoice4 = new JCheckBox("C4");
		lblimg4.setLabelFor(chkbxChoice4);
		chkbxChoice4.setBounds(6, 127, 441, 23);
		panChoicesText.add(chkbxChoice4);
		CH.add(chkbxChoice4);
		chkbxChoice4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkChoice(chkbxChoice4);
			}
		});
		
		chkbxChoice5 = new JCheckBox("C5");
		chkbxChoice5.setBounds(6, 167, 441, 23);
		panChoicesText.add(chkbxChoice5);
		CH.add(chkbxChoice5);
		chkbxChoice5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkChoice(chkbxChoice5);
			}
		});
		
		chkbxChoice6 = new JCheckBox("C6");
		chkbxChoice6.setBounds(6, 207, 441, 23);
		panChoicesText.add(chkbxChoice6);
		CH.add(chkbxChoice6);
		chkbxChoice6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkChoice(chkbxChoice6);
			}
		});
		
		JPanel panHint = new JPanel();
		panHint.setBounds(499, 11, 221, 374);
		frmQact.getContentPane().add(panHint);
		panHint.setLayout(null);		
		lblHint = new JLabel("Press For Hint");
		lblHint.setFont(new Font("Arial", Font.PLAIN, 16));
		lblHint.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				lblHint.setText(("<HTML>" + arquest.get(SQuest).getHint() + "</HTML>"));
			}
		});
		lblHint.setVerticalAlignment(SwingConstants.TOP);
		lblHint.setBounds(10, 11, 201, 352);
		panHint.add(lblHint);
		
		btnNextQuestion = new JButton("Next Question");
		btnNextQuestion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {NextQuestion();}
		});
		btnNextQuestion.setBounds(374, 360, 115, 25);
		frmQact.getContentPane().add(btnNextQuestion);
		
		btnCheckAnswer = new JButton("Check answer");
		btnCheckAnswer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CheckAnswers(arquest.get(SQuest).getCorrectAnswers());
			}
		});
		btnCheckAnswer.setBounds(249, 360, 115, 25);
		frmQact.getContentPane().add(btnCheckAnswer);
	}
	}


