/**
 * 
 */
package cmpiler_test;

import utils.Debug;

/**
 * Class that experiments with code optimizations in Java
 * @author NeilDG
 *
 */
public class OptimizationTest {


	public class UnoptimizedClass {
		//constant folding example
		static final int length = 25;
		static final int width = 10;
		static final int res = length * width;
	}
	
	public class OptimizedClass {
		static final int res = 250;
	}
	
	public class ConstantArithmetic {
		//static final int SECONDS_IN_30_DAYS = 60*60*24*30;
		//static final int SECONDS_IN_30_DAYS_2 = 2592000;
		
		public void arithmetic() {
			int secondsTest = 60*60*24*30;
			
			int x = 60*60;
			int y = 60*60*24;
		}
		
		public void arithmeticRef() {
			int secondsTest = 60*60*24*30;
			
			int x = 60*60;
			int y = x*24;
		}
		
		
	}
	
	public class BooleanSimplification {
		static final boolean a = false;
		static final boolean b = false;
		
		public void unsimplified() {
			if(!a || !b) {
			   Debug.log("True");
			}
		}
		
		public void simplified() {
			if(!(a && b)) {
				 Debug.log("True");
			}
		}
	}
	
	public class CommonSubexpression {
		
		public void unoptimized() {
			double d = 0.0f;
			double lim = 0.0f;
			double max = 0.0f;
			double sx = 0.0f;
			double sy = 0.0f;
			
			double x = d * (lim / max) * sx;
			double y = d * (lim / max) * sy;
		}
		
		public void optimized() {
			double d = 0.0f;
			double lim = 0.0f;
			double max = 0.0f;
			double sx = 0.0f;
			double sy = 0.0f;
			
			double depth = d * (lim / max);
			double x = depth * sx;
			double y = depth * sy;
		}
	}
	
	public class StringBuilderTest {
		
		public void stringTest1() {
			String str1 = "Kevin Tiyan ";
			String str2 = "Ryan Sexy Beast";
			
			//people argue that you must use StringBuilder for appending strings
			str1 = str1 + str2;
		}
		
		public void stringTest2() {
			//supposedly, each concatenation should trigger the StringBuilder class!
			String longString =  "This course introduces the theories, formal techniques, design, and implementation considerations "
					+ "in the construction of interpreters, compilers, and language translators in general.  "
					+ "Students will get to realize the importance and applications of concepts taught "
					+ "in their previous CS courses, namely, the use of regular expressions and context-free grammars (AUTOMAT)"
					+ ", creating efficient and scalable algorithms (ALGOCOM), understanding the components of a program (OPERSYS)"
					+ ", and practicing professional software development of an interpreter system (SOFENGG, PROSDEV).";
		}
	}
	
	public class DeadCode {
		public void deads() {
			boolean b = false;
			if(b) {
				Debug.log("Hello world.");
			}
		}
	}
	
	public class Operations {
		
		int unoptimized(int i)
		{
		  return i / 2;
		}
		
		int optimized(int i) {
			 return i >> 1;
		}
	}
	
}
