/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sokoban.core;

/**
 *
 * @author fadillarizky
 */
public enum FixedMapElement {
	
	/**
	 * Wall
	 */
	WALL("#"),
	
	/**
	 * Floor
	 */
	FLOOR(" "),
	
	/**
	 * Target where the box should be placed 
	 */
	TARGET(".");
	

	/**
	 * The string representation of the Element
	 */
	private String asciiString;

	/**
	 * Creates a new Element with a string representation
	 * @param asciiString The string representation
	 */
	private FixedMapElement(String asciiString){
		this.asciiString = asciiString;
	}

	@Override
	public String toString(){
		return this.asciiString;
	}

	/**
	 * Returns the Enum field which match with the string in parameters
	 * @param str The string of the enum+
	 * @return The Enum field which match with the string in parameters
	 * @throws IllegalArgumentException Raised if the <tt>str</tt> parameter does not match
	 *           with an element of the Enumeration.
	 */
	public static FixedMapElement fromString(String str) throws IllegalArgumentException{
		for (FixedMapElement element : FixedMapElement.values()) {
			if(element.toString().equals(str))
				return element;
		}
		throw new IllegalArgumentException("The " + str + " value does not match with an element of the map");
	}
	
}
