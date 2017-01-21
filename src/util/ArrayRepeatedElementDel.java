package util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 
 * ProjectName：JspModel1Test ClassName：ArrayRepeatedElementDel
 * ClassDescription：This class provide a method repetitionDel() to remove
 * repeated element in an array. 
 * Author：Pancake 
 * CreateTime：2017年1月21日 下午2:08:20
 * 
 * @version
 */
public class ArrayRepeatedElementDel {

	/**
	 * @param aArray: A String array.
	 * @return A String[] array.
	 */
	public static String[] repetitionDel(String[] aArray) {
		if (aArray != null && aArray.length > 0) {
			// array_unique  
		    List<String> list = new LinkedList<String>();  
		    for(int i = 0; i < aArray.length; i++) {  
		        if(!list.contains(aArray[i])) {  
		            list.add(aArray[i]);  
		        }  
		    }  
		    return (String[])list.toArray(new String[list.size()]);
		}
		else {
			return null;
		}

	}
}
