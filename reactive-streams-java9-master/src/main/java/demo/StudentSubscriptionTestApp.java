package demo;

import java.util.List;
import java.util.concurrent.SubmissionPublisher;

public class StudentSubscriptionTestApp {

    public static void main(String[] args) throws InterruptedException {

        // Create Publisher
        SubmissionPublisher<Student> publisher = new SubmissionPublisher<>();

        // Register Subscriber
        CustomStudentSubscriber subs = new CustomStudentSubscriber();
        publisher.subscribe(subs);

        List<Student> students = StudentHelper.getStudents();

        // Publish items
        System.out.println("Publishing Items to Subscriber");
        students.forEach(publisher::submit);

        // logic to wait till processing of all messages are over
        while (students.size() != subs.getCounter()) {
            Thread.sleep(10);
        }
        // close the Publisher
        publisher.close();

        System.out.println("Exiting the app");

    }

}
