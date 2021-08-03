package com.boa.forexpubsub.utilities;

import java.lang.StackWalker.StackFrame;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StackWalking {

	public static void main(String[] args) {

		new StackWalking().walk();
	}

	private void walk() {

		new Walker1().walk();
	}

	private class Walker1 {

		public void walk() {

			new Walker2().walk();
		}
	}

	private class Walker2 {

		public void walk() {

			new Walker3().walk();
		}
	}

	private class Walker3 {

		public void walk() {
			Method1();
		}

		void Method1() {
			Method2();
		}

		void Method2() {
			Method3();
		}

		void Method3() {

			System.out.println("--- StackTrace with Throwable ---");
			StackTraceElement[] stackTrace = new Throwable().getStackTrace();

			for (StackTraceElement stackTraceElement : stackTrace) {
				System.out.println(stackTraceElement);
			}

			System.out.println("--- Java 9 StackWalker ---");
			StackWalker stackWalker = StackWalker.getInstance(
					Set.of(StackWalker.Option.RETAIN_CLASS_REFERENCE, StackWalker.Option.SHOW_HIDDEN_FRAMES), 16);

			Stream stackStream = StackWalker.getInstance().walk(f -> f);

			// This causes exception!
			// List newStackFrames = stackStream.collect(Collectors.toList());

			System.out.println("--- Walk all StackFrames ---");
			List stacks = walkAllStackframes();
			System.out.println(stacks);

			System.out.println("--- Skip some StackFrames ---");
			List stacksAfterSkip = walkSomeStackframes(3);
			System.out.println(stacksAfterSkip);
			
			System.out.println("--- Limit StackFrames ---");
			List stacksByLimit = walkLimitStackframes(3);
			System.out.println(stacksByLimit);

			System.out.println("--- filter Frame by Class ---");
			final List filterClasses = new ArrayList<>();

			filterClasses.add(StackWalking.class);
			filterClasses.add(Walker2.class);

			System.out.println("--- filter Frame by Class >> get first Matching Frame ---");
			Optional frameByClass = findFrameByClass(filterClasses);
			System.out.println(frameByClass.toString());

			System.out.println("--- filter Frame by Class >> get all Matching Frames ---");
			List framesByClass = findAllFramesByClass(filterClasses);
			System.out.println(framesByClass);

			System.out.println("--- get Caller Class ---");
			Class callerClass = getCallerClass();
			System.out.println(callerClass);
		}

		private List walkAllStackframes() {
			return StackWalker.getInstance()
					.walk(s -> s.map(frame -> "\n" + frame.getClassName() + "/" + frame.getMethodName())
							.collect(Collectors.toList()));
		}

		private List walkSomeStackframes(int numberOfFrames) {
			return StackWalker.getInstance()
					.walk(s -> s.map(frame -> "\n" + frame.getClassName() + "/" + frame.getMethodName())
							.skip(numberOfFrames).collect(Collectors.toList()));
		}
		
		private List walkLimitStackframes(int numberOfFrames) {
			return StackWalker.getInstance()
					.walk(s -> s.map(frame -> "\n" + frame.getClassName() + "/" + frame.getMethodName())
							.limit(numberOfFrames).collect(Collectors.toList()));
		}

		private Optional findFrameByClass(List filterClasses) {
			return StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE)
					.walk(s -> s.filter(f -> filterClasses.contains(f.getDeclaringClass())).findFirst());
		}

		private List findAllFramesByClass(List filterClasses) {
			return StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE).walk(
					s -> s.filter(f -> filterClasses.contains(f.getDeclaringClass())).collect(Collectors.toList()));
		}

		private Class getCallerClass() {
			return StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE).getCallerClass();
		}
	}
}