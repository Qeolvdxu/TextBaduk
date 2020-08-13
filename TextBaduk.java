import java.util.Arrays;

class TextBaduk {
	public static void main(String[] args) {
		char[] point = new char[100]; 
		Board.clear(point);
		Board.place(point, '0', 6, 7);
		Board.print(point);

	}
}
class Board {
	public static void print(char[] point) {
		int line = 0;
		System.out.print("\u001b[2J");
		System.out.printf("   0  1  2  3  4  5  6  7  8  9\n\n");
		for(int i = 0; i < 10; i++)
		{
			line = i * 10;
			System.out.printf("%d  ",i);
			for (int j = 0; j < 10; j++)
			{
				System.out.printf("%c",point[j+line]);
				if (j < 9)
					System.out.printf("--");
				else
					System.out.printf("\n");
			}
			if (i < 9)
				System.out.printf("   |  |  |  |  |  |  |  |  |  |\n"); //print 9
		}
	}
	public static void place(char[] point, char player, int x, int y) {
		point[(x-1)+((y-1)*10)] = '0';		
	}
	public static void clear(char[] point) {
		Arrays.fill(point, '+');
	}
}
