package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;


public abstract class EverythingConfig extends LinearOpMode {
    protected DcMotor frontleftdrive;
    protected DcMotor frontrightdrive;
    protected DcMotor backleftdrive;
    protected DcMotor backrightdrive;
    protected DcMotor toproller;
    protected DcMotor bottomroller;
    protected Servo servoleft;
    protected Servo servoright;

    public void setServo(double pos) {
        servoleft.setPosition(pos);
        servoright.setPosition(1-pos);
        telemetry.addData("Status", "Servo set to " + pos);
        telemetry.update();
    }

    protected void initializeHardware() {
        //Doing all the hardware mappings
        frontleftdrive = hardwareMap.get(DcMotor.class, "frontleftdrive");
        backrightdrive = hardwareMap.get(DcMotor.class, "backrightdrive");
        backleftdrive = hardwareMap.get(DcMotor.class, "backleftdrive");
        frontrightdrive = hardwareMap.get(DcMotor.class, "frontrightdrive");
        toproller = hardwareMap.get(DcMotor.class, "toproller");
        bottomroller = hardwareMap.get(DcMotor.class, "bottomroller");
        servoleft = hardwareMap.get(Servo.class, "servoleft");
        servoright = hardwareMap.get(Servo.class, "servoright");

        // Telling Driver that Hardware is Configured
        telemetry.addData("Status: ", "Hardware Configured");
        telemetry.update();


        backleftdrive.setDirection(DcMotor.Direction.REVERSE);
        frontrightdrive.setDirection(DcMotor.Direction.REVERSE);
        frontleftdrive.setDirection(DcMotor.Direction.FORWARD);
        backrightdrive.setDirection(DcMotor.Direction.FORWARD);

        // toproller.setDirection(DcMotor.Direction.FORWARD);
        // bottomroller.setDirection(DcMotor.Direction.FORWARD);
        frontleftdrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontrightdrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backleftdrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backrightdrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        telemetry.addData("Status: ", "Hardware Direction Configured");
        telemetry.update();
    }

    protected void forward(int distance) {

        frontleftdrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontrightdrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backleftdrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backrightdrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        frontleftdrive.setTargetPosition(distance * 90);
        frontrightdrive.setTargetPosition(distance * 90);
        backleftdrive.setTargetPosition(distance * 90);
        backrightdrive.setTargetPosition(distance * 90);

        // set motors to run to target encoder position and stop with brakes on.
        frontleftdrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontrightdrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backleftdrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backrightdrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        frontleftdrive.setPower(0.25);
        frontrightdrive.setPower(0.25);
        backleftdrive.setPower(0.25);
        backrightdrive.setPower(0.25);

        while (frontleftdrive.isBusy() && frontrightdrive.isBusy() && backleftdrive.isBusy() && backrightdrive.isBusy()) {
            telemetry.addData("encoder-front-left", frontleftdrive.getCurrentPosition());
            telemetry.addData("encoder-front-right", frontrightdrive.getCurrentPosition());
            telemetry.addData("encoder-back-left", backleftdrive.getCurrentPosition());
            telemetry.addData("encoder-back-right", frontrightdrive.getCurrentPosition());
            telemetry.update();
            idle();
        }

        frontleftdrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontrightdrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backleftdrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backrightdrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    protected void backward(int distance) {
        frontleftdrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontrightdrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backleftdrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backrightdrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        frontleftdrive.setTargetPosition(distance * 90);
        frontrightdrive.setTargetPosition(distance * 90);
        backleftdrive.setTargetPosition(distance * 90);
        backrightdrive.setTargetPosition(distance * 90);

        // set motors to run to target encoder position and stop with brakes on.
        frontleftdrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontrightdrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backleftdrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backrightdrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        frontleftdrive.setPower(-0.25);
        frontrightdrive.setPower(-0.25);
        backleftdrive.setPower(-0.25);
        backrightdrive.setPower(-0.25);

        while (frontleftdrive.isBusy() && frontrightdrive.isBusy() && backleftdrive.isBusy() && backrightdrive.isBusy()) {
            telemetry.addData("encoder-front-left", frontleftdrive.getCurrentPosition());
            telemetry.addData("encoder-front-right", frontrightdrive.getCurrentPosition());
            telemetry.addData("encoder-back-left", backleftdrive.getCurrentPosition());
            telemetry.addData("encoder-back-right", frontrightdrive.getCurrentPosition());
            telemetry.update();
            idle();
        }

        frontleftdrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontrightdrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backleftdrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backrightdrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    protected void turnLeft(int distance) {
        frontleftdrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontrightdrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backleftdrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backrightdrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        frontleftdrive.setTargetPosition(distance * 90);
        frontrightdrive.setTargetPosition(distance * 90);
        backleftdrive.setTargetPosition(distance * 90);
        backrightdrive.setTargetPosition(distance * 90);

        // set motors to run to target encoder position and stop with brakes on.
        frontleftdrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontrightdrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backleftdrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backrightdrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        frontleftdrive.setPower(-0.25);
        frontrightdrive.setPower(0.25);
        backleftdrive.setPower(-0.25);
        backrightdrive.setPower(0.25);

        while (frontleftdrive.isBusy() && frontrightdrive.isBusy() && backleftdrive.isBusy() && backrightdrive.isBusy()) {
            telemetry.addData("encoder-front-left", frontleftdrive.getCurrentPosition());
            telemetry.addData("encoder-front-right", frontrightdrive.getCurrentPosition());
            telemetry.addData("encoder-back-left", backleftdrive.getCurrentPosition());
            telemetry.addData("encoder-back-right", frontrightdrive.getCurrentPosition());
            telemetry.update();
            idle();
        }

        frontleftdrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontrightdrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backleftdrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backrightdrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

    }

    protected void turnRight(int distance) {
        frontleftdrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontrightdrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backleftdrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backrightdrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        frontleftdrive.setTargetPosition(distance * 90);
        frontrightdrive.setTargetPosition(distance * 90);
        backleftdrive.setTargetPosition(distance * 90);
        backrightdrive.setTargetPosition(distance * 90);

        // set motors to run to target encoder position and stop with brakes on.
        frontleftdrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontrightdrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backleftdrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backrightdrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        frontleftdrive.setPower(0.25);
        frontrightdrive.setPower(-0.25);
        backleftdrive.setPower(0.25);
        backrightdrive.setPower(-0.25);

        while (frontleftdrive.isBusy() && frontrightdrive.isBusy() && backleftdrive.isBusy() && backrightdrive.isBusy()) {
            telemetry.addData("encoder-front-left", frontleftdrive.getCurrentPosition());
            telemetry.addData("encoder-front-right", frontrightdrive.getCurrentPosition());
            telemetry.addData("encoder-back-left", backleftdrive.getCurrentPosition());
            telemetry.addData("encoder-back-right", frontrightdrive.getCurrentPosition());
            telemetry.update();
            idle();
        }

        frontleftdrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontrightdrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backleftdrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backrightdrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    protected void strafeRight(int distance) {
        frontleftdrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontrightdrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backleftdrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backrightdrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        frontleftdrive.setTargetPosition(distance * 90);
        frontrightdrive.setTargetPosition(distance * 90);
        backleftdrive.setTargetPosition(distance * 90);
        backrightdrive.setTargetPosition(distance * 90);

        // set motors to run to target encoder position and stop with brakes on.
        frontleftdrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontrightdrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backleftdrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backrightdrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        frontleftdrive.setPower(0.25);
        frontrightdrive.setPower(-0.25);
        backleftdrive.setPower(-0.25);
        backrightdrive.setPower(0.25);

        while (frontleftdrive.isBusy() && frontrightdrive.isBusy() && backleftdrive.isBusy() && backrightdrive.isBusy()) {
            telemetry.addData("encoder-front-left", frontleftdrive.getCurrentPosition());
            telemetry.addData("encoder-front-right", frontrightdrive.getCurrentPosition());
            telemetry.addData("encoder-back-left", backleftdrive.getCurrentPosition());
            telemetry.addData("encoder-back-right", frontrightdrive.getCurrentPosition());
            telemetry.update();
            idle();
        }

        frontleftdrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontrightdrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backleftdrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backrightdrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    protected void strafeLeft(int distance) {
        frontleftdrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontrightdrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backleftdrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backrightdrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        frontleftdrive.setTargetPosition(distance * 90);
        frontrightdrive.setTargetPosition(distance * 90);
        backleftdrive.setTargetPosition(distance * 90);
        backrightdrive.setTargetPosition(distance * 90);

        // set motors to run to target encoder position and stop with brakes on.
        frontleftdrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontrightdrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backleftdrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backrightdrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        frontleftdrive.setPower(-0.25);
        frontrightdrive.setPower(0.25);
        backleftdrive.setPower(0.25);
        backrightdrive.setPower(-0.25);

        while (frontleftdrive.isBusy() && frontrightdrive.isBusy() && backleftdrive.isBusy() && backrightdrive.isBusy()) {
            telemetry.addData("encoder-front-left", frontleftdrive.getCurrentPosition());
            telemetry.addData("encoder-front-right", frontrightdrive.getCurrentPosition());
            telemetry.addData("encoder-back-left", backleftdrive.getCurrentPosition());
            telemetry.addData("encoder-back-right", frontrightdrive.getCurrentPosition());
            telemetry.update();
            idle();
        }

        frontleftdrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontrightdrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backleftdrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backrightdrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }
}