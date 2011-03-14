/*
 * Copyright 2011 Paul Walker <walker.paul@gmail.com>
 * 
 * This file is part of JCaseChanger.
 * 
 * JCaseChanger is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * JCaseChanger is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with JCaseChanger.  If not, see <http://www.gnu.org/licenses/>.
 */

package net.sourceforge.jcasechanger.changer;

/**
 * Provides functionality to toggle the case of text
 * 
 * @author Paul Walker
 * @version $Revision$
 */
public class ToggleCase implements IChanger {

	/**
	 * Creates a basic instance of the class
	 */
	public ToggleCase() {
	}
	
	/**
	 * Toggles the case of the original String. Any lower case letters are
	 * converted to upper case letters. Any upper case letters are converted
	 * to lower case letters. Any other characters are not altered.
	 */
	@Override
	public String change(String original) {
		String converted = "";
		char chr;
		
		for(int i = 0; i < original.length(); i ++) {
			chr = original.charAt(i);
			
			if(Character.isLowerCase(chr))
			    converted += Character.toUpperCase(chr);
			
			else if(Character.isUpperCase(chr))
			    converted += Character.toLowerCase(chr);
			
			else
			    converted += chr;
		}
		return converted;
	}
}