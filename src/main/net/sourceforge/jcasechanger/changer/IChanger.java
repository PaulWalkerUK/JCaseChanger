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
 * Interface to give the template to all classes that provide functionality to
 * change the case of text.
 * 
 * @author Paul Walker
 * @version $Revision$
 */
public interface IChanger {
	
	/**
	 * Changes to case of a String
	 * 
	 * @param original the String to be changed
	 * @return the string after the case has been changed
	 */
	public String change(String original);
}
