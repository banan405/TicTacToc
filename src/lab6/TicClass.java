package lab6;

public class TicClass {
int who=0;
int board[][] = {{10,10,10},{10,10,10},{10,10,10}};

TicClass(){
	
}
	public void Clickboard(int whois, int row, int col) {
	
		board[row][col] = whois;
	

	}
	public int checkWinner() {
		//1 X is has winner 
		//0 o is winner 
		//2 no winner
		
		//row check
		int checkNum = 0 ;
		checkNum = 0 ;
		for(int j=0;j<3;j++) {
			checkNum = 0 ;
			for(int i=0;i<3;i++) {
				
				
				checkNum += board[j][i];
			}
			if(checkNum==0){
				return 0;
			}else if(checkNum==3) {
				return 1;
			}else {
				
			}
			
		}
		//column check
		checkNum = 0 ;
		for(int j=0;j<3;j++) {
			checkNum = 0 ;
			for(int i=0;i<3;i++) {
			
				
				checkNum += board[i][j];
			}
			if(checkNum==0){
				return 0;
			}else if(checkNum==3) {
				return 1;
			}else {
				
			}
			
		}
		
		// . diagonal chek
		checkNum = 0 ;
		checkNum += (board[0][0]+board[1][1]+board[2][2]);
	
		if(checkNum==0){
			return 0;
		}else if(checkNum==3) {
			return 1;
		}else {
			
		}
		// . diagonal chek2
		checkNum = 0 ;
		checkNum += (board[2][0]+board[1][1]+board[0][2]);
	
		if(checkNum==0){
			return 0;
		}else if(checkNum==3) {
			return 1;
		}else {
			
		}
		return 2;
	
	}
}