package demo;

import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

public class CustomStudentSubscriber implements Subscriber<Student> {

    private Subscription subscription;

    private int counter = 0;

    @Override
    public void onSubscribe(Subscription subscription) {
        System.out.println("onSubscribe for CustomStudentSubscriber called");
        this.subscription = subscription;
        this.subscription.request(1); //requesting data from publisher
        System.out.println("onSubscribe for CustomStudentSubscriber requested 1 student");
    }

    @Override
    public void onNext(Student student) {
        System.out.println("Processing Student " + student);
        counter++;
        this.subscription.request(1);
    }

//    @Override
//    public void onNext(Student student) {
//        System.out.println("Processing Student " + student);
//        counter++;
//        if(counter==3) {
//            this.subscription.cancel();
//            return;
//        }
//        this.subscription.request(1);
//    }

    @Override
    public void onError(Throwable e) {
        System.out.println("Some error happened");
        e.printStackTrace();
    }

    @Override
    public void onComplete() {
        System.out.println("All Processing Done");
    }

    public int getCounter() {
        return counter;
    }
}
