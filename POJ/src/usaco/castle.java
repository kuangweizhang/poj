/*
ID: kuangwe4
LANG: JAVA
TASK: castle
 */
package usaco;

import java.awt.Point;
import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

class castle {
	static Point[][][] map;
	static int[][] neighbors;
	static boolean[][] visited;
	static int numberOfRooms = 0;
	static int largestRoom = 0;
	static int m;
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("castle.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("castle.out")));

//		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
//		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(f.readLine());
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		map = new Point[n + 1][m + 1][4];
		neighbors = new int[n + 1][m + 1];
		
		for(int i = 1; i <= n; i++)
		{
			st = new StringTokenizer(f.readLine());
			for(int j = 1; j <= m; j++)
			{
				int walls = Integer.parseInt(st.nextToken());
				boolean south = true;
				boolean east = true;
				boolean north = true;
				boolean west = true;
				if(walls >= 8)
				{
					south = false;
					walls -= 8;
				}
				if(walls >= 4)
				{
					east = false;
					walls -= 4;
				}
				if(walls >= 2)
				{
					north = false;
					walls -= 2;
				}
				if(walls >= 1)
				{
					west = false;
					walls -= 1;
				}
				
				if(south)
				{
					map[i][j][neighbors[i][j]] = new Point(i + 1, j);
					neighbors[i][j]++;
				}
				if(east)
				{
					map[i][j][neighbors[i][j]] = new Point(i, j + 1);
					neighbors[i][j]++;
				}
				if(north)
				{
					map[i][j][neighbors[i][j]] = new Point(i - 1, j);
					neighbors[i][j]++;
				}
				if(west)
				{
					map[i][j][neighbors[i][j]] = new Point(i, j - 1);
					neighbors[i][j]++;
				}
			}
		}
		
		search();
		out.println(numberOfRooms);
		out.println(largestRoom);
		out.flush();
		int largestAfter = 0;
		String wallRemoved = null;
		for(int j = 1; j <= m; j++)
		{
			for(int i = n; i >= 1; i--)
			{
				boolean northwall = false;
				boolean eastwall = false;
			
				for (int indexk = 0; indexk < neighbors[i][j]; indexk++)
				{
					Point neighborPoint = map[i][j][indexk];
					if(neighborPoint.x == i - 1 && neighborPoint.y == j)
					{
						northwall = true;
					}
					if(neighborPoint.x == i && neighborPoint.y == j + 1)
					{
						eastwall = true;
					}
				}
				if (i != 1 && !northwall)
				{
					map[i][j][neighbors[i][j]] = new Point(i - 1, j);
					neighbors[i][j]++;
					
					map[i - 1][j][neighbors[i - 1][j]] = new Point(i,j);
					neighbors[i - 1][j]++;
					search();
					if (largestRoom > largestAfter)
					{
						largestAfter = largestRoom;
						wallRemoved = i + " " + j + " " + "N";
					}
					neighbors[i][j]--;
					neighbors[i - 1][j]--;
				}
				if(j != m && !eastwall)
				{
					map[i][j][neighbors[i][j]] = new Point(i, j + 1);
					neighbors[i][j]++;
					
					map[i][j + 1][neighbors[i][j + 1]] = new Point(i,j);
					neighbors[i][j + 1]++;
					search();
					if (largestRoom > largestAfter)
					{
						largestAfter = largestRoom;
						wallRemoved = i + " " + j + " " + "E";
					}
					neighbors[i][j]--;
					neighbors[i][j + 1]--;
				}
			}
		}
		
		out.println(largestAfter);
		out.println(wallRemoved);
		
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}
	
	public static void search()
	{
		visited = new boolean[n + 1][m + 1];
		numberOfRooms = 0;
		largestRoom = 0;
		for(int i = 1; i <= n; i++)
		{
			for(int j = 1; j <= m; j++)
			{
				if(!visited[i][j])
				{
					numberOfRooms++;
					int roomeSizeCounter = 1;
					visited[i][j] = true;
					if (neighbors[i][j] != 0)
					{
						LinkedList<Point> queue = new LinkedList<Point>();
						queue.add(new Point(i, j));
						while (!queue.isEmpty())
						{
							Point currentPoint = queue.pollFirst();
							for (int indexk = 0; indexk < neighbors[currentPoint.x][currentPoint.y]; indexk++)
							{
								Point neighbor = map[currentPoint.x][currentPoint.y][indexk];
								if (!visited[neighbor.x][neighbor.y])
								{
									visited[neighbor.x][neighbor.y] = true;
									roomeSizeCounter++;
									queue.addLast(neighbor);
								}
							}
						}
					}
					if(roomeSizeCounter > largestRoom)
					{
						largestRoom = roomeSizeCounter;
					}
				}
			}
		}
	}
}