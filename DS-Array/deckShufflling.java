public class deckShufflling{
	public static void main(String args[]){
		String[] suits = {"CLUB", "HEART", "SPADE", "DIAMONDS"};
		String[] rank = {"2","3","4", "5","6","7","8","9","10","jack", "queen", "kind","ace"};
		
		int suitLength = suits.length;
		int rankLength = rank.length;
		int deckLength  = suitLength * rankLength ;
		String[] decks = new String[deckLength];
		for(int i=0 ; i < suitLength ; i++){
			for(int j=0 ;j <rankLength;j++){
				decks[suitLength*j+i] = suits[i] +" " +rank[j];
			}
		}
		for(int i=0;i< deckLength;i++){
			System.out.println(decks[i]);
		}
		for(int i=0;i<deckLength;i++){
			int r = (int) random(
		}
	}
}
