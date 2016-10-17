package Program;



public class ClassQuestions {

	protected int QN,NOA, NOC;
	protected String Q,QI,H;
	protected String[] C;
	protected char[] CA;
	protected char QT; 
	
		public ClassQuestions(){
			
		}		
		
		int getQuestionNumber(){
			return QN;
		}
		void setQuestionNumber(int i){
			QN = i;
		}
		char getQuestionType(){
			return QT;
		}
		void setQuestionType(char c){
			QT = c;
		}
		String getQuestion(){
			return Q;
		}	
		void setQuestion(String s){
			Q = s;
		}
		String getQuestionImage(){
			return QI;
		}
		void setQuestionImage(String s){
			QI = s;
		}
		int getNumberOfAnswers(){
			return NOA;
		}
		void setNumberOfAnswers(int i){
			NOA = i;
		}
		int getNumberOfChoices(){
			return NOC;
		}
		void setNumberOfChoices(int i){
			NOC = i;
		}
		char[] getCorrectAnswers(){
			return CA;
		}		
		void setCorrectAnswers(char[] C){
			CA = C;
		}
		String getHint(){
			return H;
		}
		void setHint(String s){
			H = s;
		}
		String[] getChoices(){
			return C;
		}
		void setChoices(int i,String s){
			C[i] = s;
		}
	
}


