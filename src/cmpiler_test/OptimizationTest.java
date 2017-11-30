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
		static final int SECONDS_IN_30_DAYS = 60*60*24*30;
		static final int SECONDS_IN_30_DAYS_2 = 2592000;
		
		public void arithmetic() {
			int secondsTest = 60*60*24*30;
			
			int x = 60*60;
			int y = 60*60*24;
		}
		
		//NOTE: iMUl only appears when there is a variable reference.
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
