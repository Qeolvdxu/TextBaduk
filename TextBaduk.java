import java.util.Arrays;
import java.util.Scanner;

class TextBaduk 
{
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in); 
	
		int y = 0;
		int x = 0;
		int prevy;
		int prevx;
		char[] players = {'O', '0'};
		int player = 0;

		Stone [] point = new Stone[100]; 
		for (int i = 0; i < 100; i++)
		{
			point[i] = new Stone();
		}
		Board.init(point);
		while (true)
		{
			Board.print(point, players[player]);
			System.out.printf("%d , %d = %c\n",x,y,point[x+(y*10)].character);
			prevx = x;
			prevy = y;
			do		//Continue to get input until it is valid
	    		{
				x = scanner.nextInt();		
	    			y = scanner.nextInt();		
			} while(x > 99 || x < 0 || y > 99 || y < 0);
			
			if (point[(y*10)+x].character != '+' || point[(y*10)+x] == point[prevx+(prevy*10)]) //check for invalid space space
			{
				System.out.printf("Invalid Space!");
				if (player == 0) //Switch the player on an invalid space so it can be switched back immedialty 
					player = 1;
				else
					player = 0;
			}
			Board.placeStone(point,x,y,players[player]);

			if (player == 0)
				player = 1;
			else
				player = 0;

			Board.checkBoard(point);

		}

	}
}

class Stone 
{ 
	char character = '+';
	int x = 0, y = 0;
	static int libs[][] = new int[4][2];
	public static void initLibs(int xcord, int ycord)
	{
		for (int i = 0; i < 4; i++)
		{
				libs[i][0] = xcord;
				libs[i][1] = ycord;
		}
		libs[0][0]--;
		libs[1][1]--;
		libs[2][0]++;
		libs[3][1]++;
	}	
}

class Board 
{
	public static void print(Stone[] point, char player) 
	{
		int line = 0;
		//System.out.print("\u001b[2J");
		System.out.print("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n");
		System.out.printf("The turn belongs to player %c\n\n",player);
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
	public static void placeStone(Stone[] point, int x, int y, char player)
	{
		point[(y*10)+x].character = player;
	}
	public static void init(Stone[] point)
	{
		for (int i = 0; i < 10; i++)
		{
			for (int j = 0; j < 10; j++)
			{
				point[j+i*10].character = '+';
				point[j+i*10].x = j;
				point[j+i*10].y = i;
				System.out.printf("(%d,%d)",i,j);
				point[j+i*10].initLibs(j,i);
			}
		}
	}
	public static void checkBoard(Stone[] point)
	{
		int x, y, deps;
		for (int j = 0; j < 100; j++)
		{
			deps = 0;	
			for (int i = 0; i < 4; i++)
			{
				x = point[j].libs[i][0]; // Collect x value of nth ordered pair array for the lib
				y = point[j].libs[i][1]; // Collect y value
				System.out.printf("(%d,%d)",x,y);
				if (x < 0 || x > 9 || y < 0 || y > 9) // If the lib if off the board, it is the edge is is a netural dep
					deps++;
				else if(point[x+y*10].character != '+') //If the lib is an enemy stone, add a dep
					deps++;
			}
			System.out.printf("______________________________");
			System.out.printf("dep: %d\n",deps);
			if (deps == 4) // If 4 dependencies are collected than that stone is captured
				point[j].character = 'X';
		}
	}
}
