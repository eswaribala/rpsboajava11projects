package demo;

import java.util.concurrent.Flow;

public class CustomEngineeringStudentSubscriber implements Flow.Subscriber<EngineeringStudent> {

    private Flow.Subscription subscription;

    private int counter = 0;

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        System.out.println("Subscribed for Engineering Student");
        this.subscription = subscription;
        this.subscription.request(1); //requesting data from publisher
        System.out.println("onSubscribe requested 1 item for Engineering Student");
    }

    @Override
    public void onNext(EngineeringStudent engineeringStudent) {
        System.out.println("Processing Engineering Student " + engineeringStudent);
        counter++;
        this.subscription.request(1);
    }

    @Override
    public void onError(Throwable e) {
        System.out.println("Some error happened in CustomEngineeringStudentSubscriber");
        e.printStackTrace();
    }

    @Override
    public void onComplete() {
        System.out.println("All Processing Done for CustomEngineeringStudentSubscriber");
    }

    public int getCounter() {
        return counter;
    }
}
