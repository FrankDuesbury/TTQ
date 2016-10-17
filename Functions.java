package Program;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

public class Functions {
	
	int SQuest = 0;
	int sd = 0;
	short CS = 0;
	
	List<ClassQuestions> arquest = new ArrayList<>();
	
	public void getQuestions(){
		//gets all the questions from the text file and puts it into a listbox so that it can be used at any time
		
	    try {
			
			// The location of the file where it gets the questions from
	    	FileReader FR = new FileReader("E:\\Practice\\Eclips\\Testing\\src\\gui\\Questions.txt");
	     	Scanner scan = new Scanner(FR);
   	    	scan.useDelimiter("/");
   	    
			   	 while(scan.hasNext()){

			   	    ClassQuestions CQ = new ClassQuestions();
			   	    
						CQ.setQuestionNumber(Integer.parseInt(scan.next()));
						CQ.setQuestionType(scan.next().charAt(0));
						CQ.setQuestion(scan.next());
						CQ.setQuestionImage(scan.next());
						CQ.setNumberOfAnswers(Integer.parseInt(scan.next()));
						CQ.setNumberOfChoices(Integer.parseInt(scan.next()));
						CQ.CA = new char[CQ.getNumberOfAnswers()];
						CQ.C = new String[CQ.getNumberOfChoices()];
						CQ.setCorrectAnswers(scan.next().toCharArray());
						CQ.setHint(scan.next());
						for(int i = 0; i<CQ.getNumberOfChoices();i++){
							CQ.setChoices(i, scan.next());
						}
						
						arquest.add(CQ);			
						sd++;
					scan.nextLine();	        			
				}
			   	 	scan.close();			   	    
	    }
	    catch(FileNotFoundException ex) {
	        System.out.println("Unable to open file '");                
	    }	
	}	
	
	public void checkChoice(JCheckBox checkbox){		
		/*Checks the state of the checkbox so it knows whether it add one or removes one from total selected  */
		int ANS = arquest.get(SQuest).getNumberOfAnswers();
			
			if(checkbox.isSelected() == true){				
				if (CS == ANS) {					
					
					checkbox.setSelected(false);
					JOptionPane.showMessageDialog(null, "Max Choice Selected");		
					
				}else{CS++;}					
			}else{CS--;}
		}
	
	/**
	 * Create the application.
	 */
}
