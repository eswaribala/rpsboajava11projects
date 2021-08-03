package demo;

import java.util.List;
import java.util.concurrent.SubmissionPublisher;

public class ProcessorTestApp {

    public static void main(String[] args) throws InterruptedException {
        // Create End Publisher
        SubmissionPublisher<Student> publisher = new SubmissionPublisher<>();

        // Create Processor
        CustomProcessor transformProcessor = new CustomProcessor(student ->
                new EngineeringStudent(student.getId(), student.getId() + 100, student.getName()));

        //Create End Subscriber
        CustomEngineeringStudentSubscriber subs = new CustomEngineeringStudentSubscriber();

        //Create chain of publisher, processor and subscriber
        publisher.subscribe(transformProcessor); // publisher to processor
        transformProcessor.subscribe(subs); // processor to subscriber

        List<Student> emps = StudentHelper.getStudents();

        // Publish items
        System.out.println("Publishing Items to Subscriber");
        emps.forEach(publisher::submit);

        // Logic to wait for messages processing to finish
        while (emps.size() != subs.getCounter()) {
            Thread.sleep(10);
        }

        // Closing publishers
        publisher.close();
        transformProcessor.close();

        System.out.println("Exiting the app");
    }
}
