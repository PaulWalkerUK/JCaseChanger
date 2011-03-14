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

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests the ToggleCase class.
 * 
 * @author Paul Walker
 * @version $Revision: 19 $
 */
public class ToggleCaseTest {
	/**
	 * An instance of the class being tested
	 */
	private ToggleCase changerUnderTest;
	
	/**
	 * Sets up an instance of the class being tested before each test
	 */
	@Before
	public void runBeforeEveryTest() {
		changerUnderTest = new ToggleCase();
	}
	
	/**
	 * Throws away the instance the class being tested after each test
	 */
	@After
	public void runAfterEveryTest() {
		changerUnderTest = null;
	}
	
	/**
	 * A fully lower case string should be converted to fully upper case
	 */
	@Test
	public void change_allLowerCase_allUpperCase() {
		String original = "hello world";
		String expected = "HELLO WORLD";
		String actual;
		
		actual = changerUnderTest.change(original);
		assertEquals(expected, actual);
	}
	
	/**
	 * A fully upper case string should be converted to fully lower case
	 */
	@Test
	public void change_allUpperCase_allLowerCase() {
		String original = "HELLO WORLD";
		String expected = "hello world";
		String actual;
		
		actual = changerUnderTest.change(original);
		assertEquals(expected, actual);
	}
	
	/**
	 * A mixed case string should have the case of each character toggled
	 */
	@Test
	public void change_toggleMixedCase_Toggled() {
		String original = "HeLlO WoRlD";
		String expected = "hElLo wOrLd";
		String actual;
		
		actual = changerUnderTest.change(original);
		assertEquals(expected, actual);
	}	
	
	/**
	 * Numbers should not be changed
	 */
	@Test
	public void change_numbers_noChange() {
		String original = "123456789";
		String expected = "123456789";
		String actual;
		
		actual = changerUnderTest.change(original);
		assertEquals(expected, actual);
	}	
	
	/**
	 * The case of alphabetic characters should be toggled, but numbers should
	 * not be changed
	 */
	@Test
	public void change_textWithNumbers_NumbersIgnored() {
		String original = "HeLlO WoRlD123";
		String expected = "hElLo wOrLd123";
		String actual;
		
		actual = changerUnderTest.change(original);
		assertEquals(expected, actual);
	}	
	
	/**
	 * Symbols should not be changed
	 */
	@Test
	public void change_symbols_noChange() {
		String original = "!£$%^&*()";
		String expected = "!£$%^&*()";
		String actual;
		
		actual = changerUnderTest.change(original);
		assertEquals(expected, actual);
	}	
	
	/**
	 * The case of alphabetic characters should be toggled, but symbols should
	 * not be changed
	 */
	@Test
	public void change_textWithsymbols_symbolsIgnored() {
		String original = "hello !£$%^&*() world";
		String expected = "HELLO !£$%^&*() WORLD";
		String actual;
		
		actual = changerUnderTest.change(original);
		assertEquals(expected, actual);
	}
	
	/**
	 * The case of letters in a multi-line string should be toggled, and the 
	 * string should still be multi-line
	 */
	@Test
	public void change_multiLineText_returnsMultiLine() {
		String original = "hello\n" +
				          "world";
		String expected = "HELLO\n" +
			              "WORLD";
		String actual;

		actual = changerUnderTest.change(original);
		assertEquals(expected, actual);
	}
}
