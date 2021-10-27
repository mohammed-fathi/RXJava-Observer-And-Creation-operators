package com.example.rxobserverandoperators;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import org.jetbrains.annotations.NotNull;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.observables.ConnectableObservable;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createObservable();
        justObservable();
        fromArrayObservable();
    }
    // Type of Observers
    private void sampleObserver(){
        Observer observer = new Observer() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                Log.d(TAG, "onSubscribe: ");
            }

            @Override
            public void onNext(@NotNull Object o) {
                Log.d(TAG, "onNext: "+o);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.d(TAG, "onError: "+e.getMessage());
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete: ");
            }
        };

    }
    private void singleObserver(){
        SingleObserver observer = new SingleObserver() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onSuccess(@NotNull Object o) {

            }

            @Override
            public void onError(@NonNull Throwable e) {

            }
        };

    }
    private void maybeObserver(){
        MaybeObserver observer = new MaybeObserver() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onSuccess(@NotNull Object o) {

            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };

    }
    private void completableObserver(){
        CompletableObserver observable = new CompletableObserver() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onComplete() {

            }

            @Override
            public void onError(@NonNull Throwable e) {

            }
        };

    }


    // factory operators (Method)
    private void createObservable(){
        Observer observer = new Observer() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                Log.d(TAG, "onSubscribe: ");
            }
            @Override
            public void onNext(@NotNull Object o) {
                Log.d(TAG, "onNext: "+o);
            }
            @Override
            public void onError(@NonNull Throwable e) {
                Log.d(TAG, "onError: "+e.getMessage());
            }
            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete: ");
            }
        };
        Observable observable = Observable.create(new ObservableOnSubscribe<Object>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Object> emitter) throws Throwable {
                for (int i = 0 ; i<5 ; i++){
                    emitter.onNext(i);
                }emitter.onComplete();
            }});
       observable.subscribe(observer);
    }
    private void justObservable(){

        Observable observable = Observable.just(0,1,2,3,4,5,6,7,8,9);
        Observer observer = new Observer() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                Log.d(TAG, "onSubscribe: ");
            }

            @Override
            public void onNext(@NotNull Object o) {
                Log.d(TAG, "onNext: "+o);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.d(TAG, "onError: "+e.getMessage());
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete: ");
            }
        };
        observable.subscribe(observer);
    }
    private void fromArrayObservable(){
        Observer observer = new Observer() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                Log.d(TAG, "onSubscribe: ");
            }
            @Override
            public void onNext(@NotNull Object o) {
                Log.d(TAG, "onNext: "+o);
            }
            @Override
            public void onError(@NonNull Throwable e) {
                Log.d(TAG, "onError: "+e.getMessage());
            }
            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete: ");
            }
        };
        Integer[] list = new Integer[7];
        list[0] = 0;
        list[1] = 1;
        list[2] = 2;
        list[3] = 3;
        list[4] = 4;
        list[5] = 5;
        list[6] = 6;
        Observable observable = Observable.fromArray(list)
                .repeat(3);
        observable.subscribe(observer);
    }

    private void sleep(int i){
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

   // فيروز احمد فتحى محمد غانم
}