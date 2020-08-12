import java.util.Arrays;

class TextBaduk {
	public static void main(String[] args) {
		char[] point = new char[100]; 
		Board.clear(point);

		

		Board.print(point);

	}
}
class Board {
	public static void print(char[] point) {
		int line = 0;
		System.out.print("\u001b[2J");
		for(int i = 0; i < 9; i++)
		{
			line = i * 10;
			for (int j = 0; j < 10; j++)
			{
				System.out.printf("%c",point[j+line]);
				if (j < 9)
					System.out.printf("--");
				else
					System.out.printf("\n");
			}
			System.out.printf("|  |  |  |  |  |  |  |  |  |\n"); //print 9
		}
		System.out.println("+--+--+--+--+--+--+--+--+--+"); //print 10
	}
	public static void clear(char[] point) {
		Arrays.fill(point, '+');
	}
}
