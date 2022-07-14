package com.academy.techcenture.utilities;

import atu.testrecorder.ATUTestRecorder;
import io.cucumber.java.Scenario;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RecordVideo {

    private static ATUTestRecorder recorder;

    public static void startRecording(Scenario scenario){
        DateFormat d = new SimpleDateFormat("yy−mm−dd HH−mm−ss");
        Date dt = new Date();
        try {
            File recordingDirectory = new File(System.getProperty("user.dir") + "/test-videos");
            boolean exists = recordingDirectory.exists();
            if (!exists){
                new File(System.getProperty("user.dir") + "/test-videos").mkdir();
            }
            recorder = new ATUTestRecorder(recordingDirectory.getAbsolutePath() , scenario.getName() +       "_" + d.format(dt), true);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        try {
            recorder.start();
            Thread.sleep(1000);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void stopRecording (){
        try {
            recorder.stop();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
