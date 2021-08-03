package com.boa.forexpubsub.utilities;

public class ProcessApiDemo {

    public static void main(String[] args) {
        ProcessHandle currentProcessHandleImpl = ProcessHandle.current();

        System.out.println("Native process ID of the process: " + currentProcessHandleImpl.pid()); //Get process Id of current native process
        System.out.println("\nDirect children: " + currentProcessHandleImpl.children()); // Direct children of the process
        System.out.println("\nClass name: " + currentProcessHandleImpl.getClass());       // Class name
        System.out.println("\nAll processes: " + ProcessHandle.allProcesses()); // All current processes
        System.out.println("\nProcess info: " + currentProcessHandleImpl.info());         // Process info
        System.out.println("\nIs process alive: " + currentProcessHandleImpl.isAlive());
        System.out.println("\nProcess's parent " + currentProcessHandleImpl.parent());  // Parent of the process

        //Process snapshot of the current running process with ProcessHandle.Info:
        ProcessHandle.Info processInfo = currentProcessHandleImpl.info();

        System.out.println("\nProcess snapshot of the current running process:");
        System.out.println("User : " + processInfo.user().get());
        System.out.println("Start Time : " + processInfo.startInstant().get());
    }
}