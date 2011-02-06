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

package net.sourceforge.jcasechanger;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

/**
 * Main startup class for JCaseChanger. Toggles the case of each letter for and 
 * String stored on the clipboard. The resulting String is written back to the 
 * clipboard. If anything other than a String is on the clipboard, then it 
 * remains unaltered.
 * 
 * @author Paul Walker
 * @version $Revision$
 */
public class JCaseChanger implements ClipboardOwner {
	
	/**
	 * The system clipboard
	 */
	Clipboard clipboard;
	
	
	/**
	 * Entry point for the app. 
	 * 
	 * @param args not used
	 */
	public static void main(String[] args) {
		new JCaseChanger();
	}
	
	/**
	 * Constructs and controls the main program
	 */
	public JCaseChanger() {
		String input;
		String output;
		
		clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		
		input = getInput();
		
		if (input != null) {
    		output = toggleText(input);
    		SendOutput(output);
		}
	}
	
	/**
	 * Gets text from the clipboard
	 * 
	 * @return the String contents of the clipboard. If the clipboard does not 
	 * store a String, null will be returned. 
	 */
	private String getInput() {
		String txt = null;
		
		Transferable contents = clipboard.getContents(null);
		
		if((contents != null) && (contents.isDataFlavorSupported(DataFlavor.stringFlavor))) {
			try {
				txt = (String)contents.getTransferData(DataFlavor.stringFlavor);
			} 
			
			catch (UnsupportedFlavorException e) {
			} 
			
			catch (IOException e) {
			}
		}
		return txt;
	}

	/**
	 * Toggles the case of every letter in a String.
	 * 
	 * @param input the String to be converted
	 * @return the String after conversion
	 */
	private String toggleText(String input) {
		String converted = "";
		char chr;
		
		for(int i = 0; i < input.length(); i ++) {
			chr = input.charAt(i);
			
			if(Character.isLowerCase(chr))
			    converted += Character.toUpperCase(chr);
			
			else if(Character.isUpperCase(chr))
			    converted += Character.toLowerCase(chr);
			
			else
			    converted += chr;
		}
		return converted;
	}

	/**
	 * Puts the specified String onto the clipboard. The current contents will
	 * be replaced.
	 * 
	 * @param output the String to be written to the clipboard
	 */
	private void SendOutput(String output) {
		StringSelection stringSelection = new StringSelection(output);
	    clipboard.setContents( stringSelection, this );
	}

	/**
	 * No functionality. This is only required because this class implements 
	 * ClipboardOwner
	 */
	@Override
	public void lostOwnership(Clipboard arg0, Transferable arg1) {
	}
}
