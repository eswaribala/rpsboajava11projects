package demo;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;
import java.util.function.Function;

public class CustomProcessor extends SubmissionPublisher<EngineeringStudent> implements Flow.Processor<Student, EngineeringStudent> {

    private Flow.Subscription subscription;
    private Function<Student, EngineeringStudent> function;

    public CustomProcessor(Function<Student, EngineeringStudent> function) {
        super();
        this.function = function;
    }

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        subscription.request(1);
    }

    @Override
    public void onNext(Student emp) {
        submit((EngineeringStudent) function.apply(emp));
        subscription.request(1);
    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
    }

    @Override
    public void onComplete() {
        System.out.println("Done");
    }

}
