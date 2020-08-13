import java.util.Arrays;

class TextBaduk {
	public static void main(String[] args) {
		char[] point = new char[100]; 
		Board.clear(point);
		Board.print(point);

	}
}

class Stone {
	
	public static void create(char[] point, char player, int x, int y) {
		Board.place(point,player,x,y);
		int[][] lib = {{x-1,y},{x+1,y},{x,y-1},{x,y+1}};

		if (point[lib[0][0] + (lib[0][1] * 10)] == 'O')
			System.out.printf("Print1");
		if (point[lib[1][0] + (lib[1][1] * 10)] == 'O')
			System.out.printf("Print2");
		if (point[lib[2][0] + (lib[2][1] * 10)] == 'O')
			System.out.printf("Print3");
		if (point[lib[3][0] + (lib[3][1] * 10)] == 'O')
			System.out.printf("Print4");
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
		Stone foobar = new Stone();
		point[(x)+((y)*10)] = player;		
	}
	public static void clear(char[] point) {
		Arrays.fill(point, '+');
	}
}
