package fr.fabcw.Chess;
import java.util.HashMap; // import the HashMap class
import java.util.Scanner;
public class Main
{
	public static void main(String[] args)
	{
		
	//HashMap is used to associate a key (here place on the chess board) and a value(the piece)
	HashMap<String, Piece> p_pose = new HashMap<String, Piece>();
	
	//Two enum,  color and type
	Color color = Color.WHITE;
	Type type = Type.ROOK;
	
	// association for all chess box with new instances object(Piece) 
	p_pose.put("a1",new Piece(type,color));
	p_pose.put("h1",new Piece(type,color));
	
	type = Type.KNIGHT;
	p_pose.put("b1",new Piece(type,color));
	p_pose.put("g1",new Piece(type,color));
	
	type =Type.BISHOP;
	p_pose.put("c1",new Piece(type,color));
	p_pose.put("f1",new Piece(type,color));
	
	type = Type.QUEEN;
	p_pose.put("d1",new Piece(type,color));
	
	type = Type.KING;
	p_pose.put("e1",new Piece(type,color));
	
	type = Type.PAWN;
	p_pose.put("a2",new Piece(type,color));
	p_pose.put("b2",new Piece(type,color));
	p_pose.put("c2",new Piece(type,color));
	p_pose.put("d2",new Piece(type,color));
	p_pose.put("e2",new Piece(type,color));
	p_pose.put("f2",new Piece(type,color));
	p_pose.put("g2",new Piece(type,color));
	p_pose.put("h2",new Piece(type,color));
	
	// Here there are no piece
	p_pose.put("a3", null);
	p_pose.put("b3", null);
	p_pose.put("c3", null);
	p_pose.put("d3", null);
	p_pose.put("e3", null);
	p_pose.put("f3", null);
	p_pose.put("g3", null);
	p_pose.put("h3", null);
	
	p_pose.put("a4", null);
	p_pose.put("b4", null);
	p_pose.put("c4", null);
	p_pose.put("d4", null);
	p_pose.put("e4", null);
	p_pose.put("f4", null);
	p_pose.put("g4", null);
	p_pose.put("h4", null);
	
	p_pose.put("a5", null);
	p_pose.put("b5", null);
	p_pose.put("c5", null);
	p_pose.put("d5", null);
	p_pose.put("e5", null);
	p_pose.put("f5", null);
	p_pose.put("g5", null);
	p_pose.put("h5", null);
	
	p_pose.put("a6", null);
	p_pose.put("b6", null);
	p_pose.put("c6", null);
	p_pose.put("d6", null);
	p_pose.put("e6", null);
	p_pose.put("f6", null);
	p_pose.put("g6", null);
	p_pose.put("h6", null);
	
	color = Color.BLACK;
	type = Type.PAWN;
	p_pose.put("a7",new Piece(type,color));
	p_pose.put("b7",new Piece(type,color));
	p_pose.put("c7",new Piece(type,color));
	p_pose.put("d7",new Piece(type,color));
	p_pose.put("e7",new Piece(type,color));
	p_pose.put("f7",new Piece(type,color));
	p_pose.put("g7",new Piece(type,color));
	p_pose.put("h7",new Piece(type,color));
	
	type = Type.ROOK;
	p_pose.put("a8",new Piece(type,color));
	p_pose.put("h8",new Piece(type,color));
	
	type = Type.KNIGHT;
	p_pose.put("b8",new Piece(type,color));
	p_pose.put("g8",new Piece(type,color));
	
	type =Type.BISHOP;
	p_pose.put("c8",new Piece(type,color));
	p_pose.put("f8",new Piece(type,color));
	
	type = Type.QUEEN;
	p_pose.put("d8",new Piece(type,color));
	
	type = Type.KING;
	p_pose.put("e8",new Piece(type,color));
	//The chessboard is finish
	
	System.out.println("chess game");
	System.out.println("To play, specifie the previous place of your piece.");
	System.out.println("click enter and specifie after the next place");
	
	try (Scanner scan = new Scanner(System.in)) //to have an interaction between player and program
	{
	for(int i = 0; i<50; i++) // (50 represent the number of possible move)
	{
		String pre_place;
		String next_place;
		if (i %2 ==0) //white always starts first so, only when i is pair.
		{
				color = Color.WHITE; // By doing that, just need to copy/taste for black turn
				System.out.println("white turn");
				System.out.println("which piece do you want to move?");
				pre_place = scan.next();
				while (p_pose.get(pre_place)==null) //use to prevent if there are no piece to move here
				{
					System.out.println(" they are no piece here");
					System.out.println("which piece do you want to move?");
					pre_place = scan.next();
				}
				
				while (p_pose.get(pre_place).getColor()!= color) // use to prevent if you not choose a piece with the right color
				{
					System.out.println(" you can't move a black piece during the white turn");
					System.out.println("which piece do you want to move?");
					pre_place = scan.next();
					/*
					 * need to be sure the player will not choose an empty box,
					 * need to use a while loop like before inside a condition in case of
					 * */
					if (p_pose.get(pre_place)==null)
					{
						while (p_pose.get(pre_place)==null) //use to prevent if there are no piece to move here
						{
							System.out.println(" they are no piece here");
							System.out.println("which piece do you want to move?");
							pre_place = scan.next();
						}
						
					}
				}
				
			
				System.out.println("where do you want to move it?");
				next_place = scan.next();
				
				/*
				 *  it' s an obligation to notice this case at first because if we don't do, 
				 *  this provide mistake because of null. with null value, the computer can't
				 *  compare the type or the color because there are no attribute with null.
				 */
				
				if(p_pose.get(next_place) == null  ) //if the box is empty
				{
					p_pose.put(next_place, p_pose.get(pre_place)); //the key next_place take the object of the key pre_place
					p_pose.put(pre_place, null); //the key pre_place become empty
				
				}
				else if (p_pose.get(next_place).getColor()!=color) //if there are an opposite piece
				{
					System.out.println("you took a black " + p_pose.get(next_place).getType());
					p_pose.put(next_place, p_pose.get(pre_place));
					p_pose.put(pre_place, null);
					
				}
				
				else if (p_pose.get(next_place).getColor()==color) // if there are a piece of yours on the next place
				{
					while(p_pose.get(next_place).getColor()==color)// this will force you to choose a correct box with no piece of yours
					{
						System.out.println("you already have a piece here");
						System.out.println("where do you want to move it?");
						next_place = scan.next(); 
						
						//when you choose a good box, there are 2 possibilities, an empty one or with an opposite piece on it
						if(p_pose.get(next_place) == null )
						{
							break; // used to get out of the loop if we choose a good box
						}
						else if (p_pose.get(next_place).getColor()!=color)
						{
							System.out.println("you took a black " + p_pose.get(next_place).getType());
							break;
						}	
					}
					p_pose.put(next_place, p_pose.get(pre_place));
					p_pose.put(pre_place, null);
					
				}	
				}
		if (i %2 ==0) 
		{
			System.out.println("black turn");
			color = Color.BLACK;
				System.out.println("which piece do you want to move?");
				pre_place = scan.next();
				while (p_pose.get(pre_place)==null)
				{
					System.out.println(" they are no piece here");
					System.out.println("which piece do you want to move?");
					pre_place = scan.next();
				}
				
				while (p_pose.get(pre_place).getColor()!= color)
				{
					System.out.println(" you can't move a white piece during the black turn");
					System.out.println("which piece do you want to move?");
					pre_place = scan.next();
					if (p_pose.get(pre_place)==null)
					{
						while (p_pose.get(pre_place)==null) //use to prevent if there are no piece to move here
						{
							System.out.println(" they are no piece here");
							System.out.println("which piece do you want to move?");
							pre_place = scan.next();
						}
						
					}
				}
				
			
				System.out.println("where do you want to move it?");
				next_place = scan.next();
				
				if(p_pose.get(next_place) == null  )
				{
					p_pose.put(next_place, p_pose.get(pre_place));
					p_pose.put(pre_place, null);
				
				}
				else if (p_pose.get(next_place).getColor()!=color)
				{
					System.out.println("you took a white "  + p_pose.get(next_place).getType());
					p_pose.put(next_place, p_pose.get(pre_place));
					p_pose.put(pre_place, null);
					
				}
				
				else if (p_pose.get(next_place).getColor()==color)
				{
					while(p_pose.get(next_place).getColor()==color)
					{
						System.out.println("you already have a piece here");
						System.out.println("where do you want to move it?");
						next_place = scan.next(); 
						if(p_pose.get(next_place) == null )
						{
							break;
						}
						else if (p_pose.get(next_place).getColor()!=color)
						{
							System.out.println("you took a white " + color.name() + p_pose.get(next_place).getType());
							break;
						}	
					}
					p_pose.put(next_place, p_pose.get(pre_place));
					p_pose.put(pre_place, null);
					
				}
		}
	}
	}
	}
}
		
	
	
