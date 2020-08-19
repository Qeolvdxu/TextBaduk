import java.util.Arrays;

class TextBaduk 
{
	public static void main(String[] args) 
	{
		Stone [] point = new Stone[100]; 
		for (int i = 0; i < 100; i++)
		{
			point[i] = new Stone();
		}

		System.out.printf(":%c:",point[4].character);
		Board.print(point);

	}
}

class Stone 
{ 
	char character = '+';

	public static void findLibs(int x,int y) 
	{		
		int[][] lib = {{x-1,y},{x+1,y},{x,y-1},{x,y+1}};
	}
}

class Board 
{

		

	public static void print(Stone[] point) 
	{
		int line = 0;
		System.out.print("\u001b[2J");
		System.out.printf("   0  1  2  3  4  5  6  7  8  9\n\n");
		for(int i = 0; i < 10; i++)
		{
			line = i * 10;
			System.out.printf("%d  ",i);
			for (int j = 0; j < 10; j++)
			{
				System.out.printf("%c",point[j+line].character);
				if (j < 9)
					System.out.printf("--");
				else
					System.out.printf("\n");
			}
			if (i < 9)
				System.out.printf("   |  |  |  |  |  |  |  |  |  |\n"); //print 9
		}
	}
}
