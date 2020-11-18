package fr.fabcw.Chess;

public class Piece
{

	private Type type;
	private Color color;
	
	
	
	public Piece(Type type, Color color) 
	{
		this.type = type;
		this.color = color;
	}



	public Type getType() {
		return type;
	}



	public void setType(Type type) {
		this.type = type;
	}



	public Color getColor() {
		return color;
	}



	public void setColor(Color color) {
		this.color = color;
	}
}


