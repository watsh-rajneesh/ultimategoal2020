
package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;


@TeleOp(name = "Tele Op", group = "Linear Opmode")

public class Driving extends EverythingConfig {
    private double drive;
    private double strafe;
    private double turning;
    private float rollers;

    public void runOpMode() {
        initializeHardware();
        waitForStart();

        while (opModeIsActive()) {
            drive = gamepad1.left_stick_y;
            strafe = gamepad1.left_stick_x;
            turning = -gamepad1.right_stick_x;
            rollers = gamepad2.left_trigger;

            frontleftdrive.setPower((drive + strafe + turning));
            frontrightdrive.setPower((drive - strafe - turning));
            backleftdrive.setPower((drive - strafe + turning));
            backrightdrive.setPower((drive + strafe - turning));

            toproller.setPower(rollers);
            bottomroller.setPower(rollers);

            if(gamepad2.a) {
                setServo(0.5);
            }

            if(gamepad2.b) {
                setServo(0.49);
            }

            if(gamepad2.y) {
                setServo(0.51);
            }

            telemetry.addData("ServoLeft Position", servoleft.getPosition());
            telemetry.addData("ServoRight Position", servoright.getPosition());
            telemetry.update();
        }
    }
}
